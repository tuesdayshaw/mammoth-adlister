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
 * Created by canidmars on 6/15/17.
 */

@WebServlet(name = "EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        System.out.println(id);
        Ad ad = DaoFactory.getAdsDao().findById(id);

        request.setAttribute("ad", ad);

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        long id = Long.parseLong(request.getParameter("id"));

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("category");

        User user = (User) request.getSession().getAttribute("user");

        Ad updatedAd = new Ad(
                id,
                user.getId(),
                title,
                description,
                category
        );

        request.setAttribute("ad", updatedAd);


        if (title.isEmpty() || description.isEmpty() || category.isEmpty()) {
            request.setAttribute("ad", updatedAd);
            request.getRequestDispatcher("/WEB-INF/ads/profile.jsp")
                    .forward(request, response);
            return;
        }

        DaoFactory.getAdsDao().edit(updatedAd);
        response.sendRedirect("/ads");
    }
}
