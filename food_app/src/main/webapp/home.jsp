<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.models.Restaurant, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Food Delivery - Restaurants</title>
  <link rel="stylesheet" href="restaurantstyle.css" />
</head>
<body>
  <div class="navbar">
    <h1>Foodie</h1>
    <nav>
      <a href="callingLoginServlet">Sign in</a>
      <a href="register.html">Sign up</a>
      
    </nav>
  </div>

  <div class="container">
    <%
      List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("allRestaurants");
      for (Restaurant restaurant : restaurants) {
    %>
      <a href="menu?restaurantId=<%=restaurant.getRestaurantId()%>">
        <div class="card">
          <img src="<%=restaurant.getImagePath() %>" alt="<%=restaurant.getName()%>">
          <div class="card-body">
            <h3><%=restaurant.getName() %></h3>
            <p><%=restaurant.getCuisineType() %></p>
            <div class="details">
              <span>⭐ <%=restaurant.getRating() %></span>
              <%
                  java.sql.Timestamp timestamp = restaurant.getDeliveryTime();
                  int minutes = timestamp.toLocalDateTime().getMinute();  // Extract only minutes
              %>
             <span>ETA: <%= minutes %> min</span>
              
            </div>
          </div>
        </div>
      </a>
    <% } %>
  </div>
</body>
</html>
