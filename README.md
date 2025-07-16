# 🍽️ Food Delivery Web Application

This is a full-stack **Java-based food delivery system** developed using **Servlets**, **JSP**, and **JDBC**, simulating a real-world food delivery platform like **Swiggy** or **Zomato**. It allows users to register, log in, browse menus, manage a cart, place orders, and enables admins to manage menu items.

---

## 🚀 Features

### 👤 Customer Features
- User registration and login
- Add items to cart with quantity control
- Remove items from cart
- Real-time total price updates
- Checkout with address and payment method
- Order confirmation page

### 🛠️ Admin Features
- Add/Edit/Delete menu items
- View order details

### 🔐 Authentication
- Role-based login system (Admin & Customer)
- Session management

---

## 🧑‍💻 Tech Stack

| Layer       | Technology            |
|-------------|------------------------|
| Frontend    | HTML, CSS, JSP         |
| Backend     | Java Servlets          |
| Database    | MySQL                  |
| JDBC        | Java Database Connectivity |
| Server      | Apache Tomcat          |
| IDE         | Eclipse IDE            |

---

## 📂 Project Structure

### Java Source Code (`src/main/java`)
(default package)
├── launch.java
├── RestaurantLaunch.java

com.foodapp.controller
├── AddToCartServlet.java
├── RemoveFromCartServlet.java
├── RegisterServlet.java
├── LoginServlet.java
├── OrderServlet.java
├── MenuServlet.java
├── MenuLaunch.java
├── HomeServlet.java
├── Servlet1.java

com.foodapp.DAO
├── MenuDAO.java
├── RestaurantDAO.java
├── UserDAO.java

com.foodapp.DAOimpl
├── MenuDAOImp.java
├── RestaurantDAOimpl.java
├── UserDAOimpl.java

com.foodapp.models
├── Cart.java
├── Menu.java
├── Restaurant.java
├── User.java

com.foodapp.util
└── DBConnection.java


### WebApp Resources (`webapp/`)
📁 foodimg/ → Food item images
📁 resimg/ → Resource images (e.g., banners)
📁 META-INF/
📁 WEB-INF/
└── web.xml → Servlet configuration

HTML/JSP Pages:
├── index.html → Landing page
├── register.html → User registration
├── home.html/.jsp → Home after login
├── login.jsp → User login
├── menu.jsp → Menu display (search + pagination)
├── cart.jsp → Shopping cart
├── checkout.jsp → Address & payment
├── orderSuccess.jsp → Order confirmation
├── restaurant.html → Admin page

CSS Files:
├── menustyle.css
├── restaurantstyle.css

## 🛠️ Setup Instructions

### Prerequisites
- Java JDK 8 or above
- Apache Tomcat 9+
- MySQL Server
- Eclipse IDE (or any Java EE IDE)

### Step-by-Step Setup

1. **Clone the project** into your workspace.

2. **Create the MySQL database**:
   ```sql
   CREATE DATABASE foodappdb;
Run on Tomcat:

Import project in Eclipse.

Right-click > Run As > Run on Server (Tomcat).


