<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.models.Menu, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
  <title>Restaurant Menu</title>
  <link rel="stylesheet" href="menustyle.css" />
</head>
<body>

<h2 class="menu-title">Our Menu</h2>
<div class="menu-grid">
<%
 List<Menu> menus = (List<Menu>) request.getAttribute("allMenuByrestaurant");
 if (menus != null) {
   for (Menu menu : menus) {
%>
  <div class="menu-card">
    <img src="<%=menu.getImagePath()%>" alt="<%=menu.getItemName()%>">
    <div class="menu-details">
      <h3><%=menu.getItemName()%></h3>
      <p><%=menu.getDescription()%></p>
      <div>
        Price: ₹<%=menu.getPrice()%><br>
        Rating: ⭐<%=menu.getRatings()%>
      </div>
    </div>

    <form action="addToCart" method="post">
      <input type="hidden" name="itemId" value="<%=menu.getMenuId()%>">
      <input type="hidden" name="itemName" value="<%=menu.getItemName()%>">
      <input type="hidden" name="price" value="<%=menu.getPrice()%>">
      <input type="hidden" name="quantity" value="1">
      <input type="hidden" name="imagePath" value="<%=menu.getImagePath()%>">
      <input type="hidden" name="description" value="<%=menu.getDescription()%>">

      <button type="submit">Add to Cart</button>
    </form>
  </div>
<%
   }
 } else {
%>
  <p>No menu available for this restaurant.</p>
<%
 }
%>
</div>

</body>
</html>
