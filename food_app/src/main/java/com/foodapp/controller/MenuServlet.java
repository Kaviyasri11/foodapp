package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.DAOimpl.MenuDAOimp;
import com.foodapp.models.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//client to menuservlet to menuimpl to database
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
  protected void service (HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException 
  {
	 int resId=Integer.parseInt(req.getParameter("restaurantId"));
	 MenuDAOimp daoImpl=new MenuDAOimp();
	 List<Menu >allMenuByRestaurant= daoImpl.getMenuById1(resId);
	 for(Menu menu:allMenuByRestaurant)
	 {
		System.out.println(menu); 
	 }
	 req.getSession().setAttribute("restaurantId", resId);
	 req.setAttribute("allMenuByrestaurant", allMenuByRestaurant);
	 RequestDispatcher rd= req.getRequestDispatcher("menu.jsp");
	 rd.forward(req, resp);
  }
}

