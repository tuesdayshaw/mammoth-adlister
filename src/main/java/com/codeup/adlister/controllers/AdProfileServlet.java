package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by canidmars on 6/14/17.
 */

@WebServlet(name = "controllers.AdProfileServlet", urlPatterns = "/ads/profile")
public class AdProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        System.out.println(id);
        Ad ad = DaoFactory.getAdsDao().findById(id);

        request.getSession().setAttribute("ad", ad);

        request.getRequestDispatcher("/WEB-INF/ads/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }

}
