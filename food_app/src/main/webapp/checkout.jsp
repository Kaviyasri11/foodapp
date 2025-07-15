<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    if (session.getAttribute("userId") == null) {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Checkout - Foodie</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f1f3f6;
            margin: 0;
            padding: 0;
        }

        .checkout-container {
            max-width: 600px;
            margin: 50px auto;
            background-color: white;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0px 5px 25px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 20px;
            color: #555;
        }

        input[type="text"], select {
            width: 100%;
            padding: 10px 12px;
            margin-top: 8px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 15px;
            box-sizing: border-box;
        }

        button {
            margin-top: 30px;
            width: 100%;
            padding: 12px;
            background-color: #fb641b;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        button:hover {
            background-color: #d65b1e;
        }

        .summary-note {
            margin-top: 15px;
            font-size: 14px;
            color: #888;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="checkout-container">
    <h2>🛒 Checkout</h2>
    <form action="checkout" method="post">
        <label for="address">Delivery Address:</label>
        <input type="text" id="address" name="address" required placeholder="e.g. 123, Gandhi Street, Chennai">

        <label for="paymentMethod">Payment Method:</label>
        <select name="paymentMethod" id="paymentMethod">
            <option value="Cash on Delivery">Cash on Delivery</option>
            <option value="UPI">UPI</option>
            <option value="Credit Card">Credit Card</option>
        </select>

        <button type="submit">Place Order</button>
        <div class="summary-note">You will be redirected after confirming your order.</div>
    </form>
</div>

</body>
</html>
