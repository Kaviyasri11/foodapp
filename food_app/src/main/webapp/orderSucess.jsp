<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Success</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f1f3f6;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .success-box {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }

        .success-box h2 {
            color: green;
            margin-bottom: 20px;
        }

        .success-box a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            padding: 10px 25px;
            background-color: #2874f0;
            color: white;
            border-radius: 6px;
        }

        .success-box a:hover {
            background-color: #1a5ad9;
        }
    </style>
</head>
<body>
    <div class="success-box">
        <h2>✅ Your Order Has Been Placed Successfully!</h2>
        <p>Thank you for ordering with Foodie 🍽️</p>
        <a href="restaurant">Back to Home</a>
    </div>
</body>
</html>
