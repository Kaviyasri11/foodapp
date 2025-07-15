<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.foodapp.models.Cart" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 30px;
            background: #f8f9fa;
        }
        .cart-container {
            max-width: 800px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 16px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }
        .cart-item {
            display: flex;
            margin-bottom: 20px;
            align-items: center;
            border-bottom: 1px solid #ddd;
            padding-bottom: 15px;
        }
        .cart-item img {
            width: 100px;
            height: 100px;
            object-fit: cover;
            border-radius: 10px;
            margin-right: 20px;
        }
        .item-details {
            flex-grow: 1;
        }
        .item-name {
            font-size: 18px;
            font-weight: bold;
        }
        .item-description {
            font-size: 14px;
            color: #777;
            margin: 5px 0;
        }
        .quantity-controls {
            display: flex;
            align-items: center;
            margin-top: 8px;
        }
        .quantity-controls form {
            margin: 0 5px;
        }
        .quantity-controls button {
            padding: 5px 10px;
            font-size: 16px;
            cursor: pointer;
        }
        .item-price {
            font-weight: bold;
            color: #444;
            margin-top: 8px;
        }
        .total {
            text-align: right;
            font-size: 20px;
            margin-top: 20px;
            font-weight: bold;
        }
        .actions {
            display: flex;
            justify-content: space-between;
            margin-top: 30px;
        }
        .actions form button {
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 8px;
            border: none;
            cursor: pointer;
        }
        .add-more {
            background: #007bff;
            color: white;
        }
        .checkout {
            background: green;
            color: white;
        }
        .remove-button {
            background: red;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 6px;
            margin-top: 10px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="cart-container">
    <h2>Your Cart</h2>

    <%
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");
        double grandTotal = 0;
        Integer restaurantId = (Integer) session.getAttribute("restaurantId");

        if (cart == null || cart.isEmpty()) {
    %>
        <p>Your cart is empty.</p>
    <%
        } else {
            for (Cart item : cart) {
                double itemTotal = item.getPrice() * item.getQuantity();
                grandTotal += itemTotal;
    %>
        <div class="cart-item">
            <img src="<%=item.getImagePath()%>" alt="<%=item.getItemName()%>">
            <div class="item-details">
                <div class="item-name"><%= item.getItemName() %></div>
                <div class="item-description"><%= item.getDescription() %></div>

                <div class="quantity-controls">
                    <!-- Decrease Quantity -->
                    <form action="addToCart" method="post">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <input type="hidden" name="itemName" value="<%= item.getItemName() %>">
                        <input type="hidden" name="price" value="<%= item.getPrice() %>">
                        <input type="hidden" name="quantity" value="-1">
                        <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                        <button type="submit">−</button>
                    </form>

                    <span><%= item.getQuantity() %></span>

                    <!-- Increase Quantity -->
                    <form action="addToCart" method="post">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <input type="hidden" name="itemName" value="<%= item.getItemName() %>">
                        <input type="hidden" name="price" value="<%= item.getPrice() %>">
                        <input type="hidden" name="quantity" value="1">
                        <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                        <button type="submit">+</button>
                    </form>
                </div>

                <div class="item-price">₹ <%= itemTotal %></div>

                <!-- Remove Button -->
                <form action="removeFromCart" method="post">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <button class="remove-button" type="submit">Remove</button>
                </form>
            </div>
        </div>
    <%
            }
    %>
        <div class="total">
            Total: ₹ <%= grandTotal %>
        </div>

        <div class="actions">
            <% if (restaurantId != null) { %>
            <!-- Add More Items -->
            <form action="menu" method="get">
                <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                <button type="submit" class="add-more">➕ Add More Items</button>
            </form>
            <% } %>

            <!-- Proceed to Checkout -->
            <form action="checkout.jsp" method="post">
                <button type="submit" class="checkout">Proceed to Checkout</button>
            </form>
        </div>

    <%
        }
    %>
</div>
</body>
</html>
