package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.DAOimpl.RestaurantDAOimpl;
import com.foodapp.models.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/restaurant")

public class HomeServlet extends HttpServlet {
  protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException ,IOException
  {
	 System.out.println("hi");
	 RestaurantDAOimpl daoimpl=new RestaurantDAOimpl();
	 List<Restaurant> allRestaurants=daoimpl.getAllRestaurant();
	 for(Restaurant restaurant:allRestaurants)
	 {
		 System.out.println(restaurant);
	 }
	 //name for get attribute -first second value
	 req.setAttribute("allRestaurants", allRestaurants);
	 RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
	 rd.forward(req, resp);
  }
}
