package com.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.foodapp.DAOimpl.UserDAOimpl;
import com.foodapp.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/callingLoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDAOimpl userDao = new UserDAOimpl();
    private Map<String, Integer> loginAttempts = new HashMap<>();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("name");
        String password = req.getParameter("password");

        List<User> userList = userDao.getAllUsers();
        User matchedUser = null;

        // Check if username exists
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                matchedUser = user;
                break;
            }
        }

        if (matchedUser != null) {
            int attemptsLeft = loginAttempts.getOrDefault(username, 3);

            if (attemptsLeft == 1) {
                out.println("<h3 style='color:crimson; text-align:center;'>🚫 Your account is blocked. Please contact the admin.</h3>");
                return;
            }

            if (matchedUser.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("name", matchedUser.getName());
                session.setAttribute("userId", matchedUser.getUserId()); // ✅ Set userId in session
                loginAttempts.remove(username);

                out.println("<h2 style='text-align:center; color:green;'>✅ Welcome " + matchedUser.getName() + "!</h2>");

                resp.sendRedirect("restaurant");
            } else {
                attemptsLeft--;
                loginAttempts.put(username, attemptsLeft);

                out.println("<h3 style='color:red; text-align:center;'>❌ Incorrect password. " + attemptsLeft + " attempt(s) left.</h3>");
                RequestDispatcher rd = req.getRequestDispatcher("index.html");
                rd.include(req, resp);
            }
        } else {
            out.println("<h3 style='color:orangered; text-align:center;'>⚠️ Username not found. Please register first.</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, resp);
        }
    }
}
