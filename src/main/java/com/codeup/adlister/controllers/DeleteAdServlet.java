package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by canidmars on 6/16/17.
 */

@WebServlet(name = "DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        long id = Long.parseLong(request.getParameter("id"));
        System.out.println(id);
        Ad ad = DaoFactory.getAdsDao().findById(id);


        DaoFactory.getAdsDao().delete(ad);
        response.sendRedirect("/profile");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
