package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.models.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/removeFromCart")
public class RemoveFromCartServlet extends HttpServlet {
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        int itemId = Integer.parseInt(req.getParameter("itemId"));
	        HttpSession session = req.getSession();
	        List<Cart> cart = (List<Cart>) session.getAttribute("cart");

	        if (cart != null) {
	            cart.removeIf(item -> item.getItemId() == itemId);
	        }

	        session.setAttribute("cart", cart);
	        resp.sendRedirect("cart.jsp");
	    }
	}

