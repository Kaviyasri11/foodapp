package com.foodapp.controller;
import java.io.IOException;
import java.io.PrintWriter;

import com.foodapp.DAOimpl.UserDAOimpl;
import com.foodapp.models.User;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/callingregisterServlet")
public class RegisterServlet extends HttpServlet{
	@Override
      protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
     String name=req.getParameter("name");
     String username=req.getParameter("username");
	String password=req.getParameter("password");
	String email=req.getParameter("email");
	String phonenumber=req.getParameter("phonenumber");
	String address=req.getParameter("address");
	String role=req.getParameter("role");
	User u=new User(name,username,password,email,phonenumber,address,role);
	UserDAOimpl edao=new UserDAOimpl();
	edao.addUser(u);
     resp.sendRedirect("index.html");
	}
}

