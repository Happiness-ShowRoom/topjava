package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealList;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(MealServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.debug("generating MealTO list");
        request.setAttribute("list", MealsUtil.getFilteredWithExcess(MealList.getMealList(), LocalTime.of(0, 0), LocalTime.of(23, 0), 2000));
        log.debug("forwarding MealTO list to meals.jsp");
        request.getRequestDispatcher("/meals.jsp").forward(request,response);
    }
}
