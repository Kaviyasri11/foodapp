package com.foodapp.controller;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.foodapp.models.Cart;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/checkout")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Integer userId = (Integer) session.getAttribute("userId");
        Integer restaurantId = (Integer) session.getAttribute("restaurantId");
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");

        if (userId == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String address = req.getParameter("address");
        String paymentMethod = req.getParameter("paymentMethod");

        double totalAmount = 0;
        for (Cart item : cart) {
            totalAmount += item.getPrice() * item.getQuantity();
        }

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String status = "Confirmed";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp", "root", "Kaviya.1108")) {
            // Save Order

        	String orderSQL ="INSERT INTO `order` (userid, restId, address, paymentMethod, dateTime, status, totalAmount) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(orderSQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.setInt(2, restaurantId);
            ps.setString(3, address);
            ps.setString(4, paymentMethod);
            ps.setString(5, dateTime);
            ps.setString(6, status);
            ps.setDouble(7, totalAmount);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int orderId = 0;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            // Save each item
            String itemSQL = "INSERT INTO `orderitem`(orderId, menuid, quantity, totalPrice) VALUES (?, ?, ?, ?)";
            PreparedStatement itemPs = con.prepareStatement(itemSQL);

            for (Cart item : cart) {
                itemPs.setInt(1, orderId);
                itemPs.setInt(2, item.getItemId());
                itemPs.setInt(3, item.getQuantity());
                itemPs.setDouble(4, item.getTotalPrice());
                itemPs.addBatch();
            }
            itemPs.executeBatch();

            // Clear Cart
            session.removeAttribute("cart");

            // Redirect to confirmation
            resp.sendRedirect("orderSucess.jsp");

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
