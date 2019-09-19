package com.ntu.crossprograming.labOne.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalcServlet")
public class MainServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(MainServlet.class);
    private static final Integer CONST_VALUE = 1927;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Started server");
        logger.info("Located in calc page");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        Integer a = 0;
        Integer b = 0;
        Integer c = 0;
        Integer d = 0;
        Boolean error = false;
        String firstParam = req.getParameter("a");
        String secondParam = req.getParameter("b");
        try {
            a = Integer.parseInt(firstParam);
            b = Integer.parseInt(secondParam);
        } catch (NumberFormatException e) {
            logger.error(e);
            error = true;
        }
        if (error) {
            printWriter.println("error");
        } else {
            c = a * b;
            d = c + CONST_VALUE;
            printWriter.println("product is : " + c);
            printWriter.println("product with const value : " + d);
        }
    }
}
