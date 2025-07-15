package com.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet{
	 protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	    {
		 //getting name from the request object 
		 HttpSession session=req.getSession();
		 String name=(String) session.getAttribute("name");
		
		 PrintWriter out=resp.getWriter();
		 //out.println("Hi "+name+" Contact the admin (redirect)"); 
		 out.println("Hi "+name+" Contact the admin (session)"); 
	    }
}
