package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.foodapp.models.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        String itemName = req.getParameter("itemName");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity")); // Can be negative too (for decrement)
        String imagePath = req.getParameter("imagePath");
        String description = req.getParameter("description");
        HttpSession session = req.getSession();
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        boolean found = false;

        Iterator<Cart> iterator = cart.iterator();
        while (iterator.hasNext()) {
            Cart item = iterator.next();
            if (item.getItemId() == itemId) {
                int newQuantity = item.getQuantity() + quantity;

                if (newQuantity <= 0) {
                    iterator.remove(); // ✅ Remove item if quantity is zero or less
                } else {
                    item.setQuantity(newQuantity); // ✅ Update quantity
                }

                found = true;
                break;
            }
        }

        if (!found && quantity > 0) {
            cart.add(new Cart(itemId, itemName, price, quantity,imagePath, description)); // ✅ Add only if quantity > 0
        }

        session.setAttribute("cart", cart);
        resp.sendRedirect("cart.jsp"); // ✅ Show cart after adding/updating
    }
}
