package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (username.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("error", "All fields are required");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        User user = new User(username, email, password);

        long id = DaoFactory.getUsersDao().insert(user);
        request.getSession().setAttribute("user", user);
        System.out.println(id);
        response.sendRedirect("/profile");


    }
}

