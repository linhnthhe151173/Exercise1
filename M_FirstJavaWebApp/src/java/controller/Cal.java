/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Linh
 */
@WebServlet(name = "Cal", urlPatterns = {"/cal"})
public class Cal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        //ax2+bx+c=0
        double x1 = 0, x2 = 0;
        double a = Integer.parseInt(request.getParameter("a"));
        double b = Integer.parseInt(request.getParameter("b"));
        double c = Integer.parseInt(request.getParameter("c"));

        if (a == 0) {
            if (b == 0) {
                response.getWriter().println("No solution");
            } else {
                x1 = x2 = -c / b;
                response.getWriter().println("x = " + x1);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                response.getWriter().println("No solution");
            } else if (delta == 0) {
                x1 = x2 = (-b / (2 * a));
                response.getWriter().println("x = " + x1);
            } else {
                x1 =  ((-b + Math.sqrt(delta)) / (2 * a));
                x2 =  ((-b - Math.sqrt(delta)) / (2 * a));
                response.getWriter().println("x1 = " + x1);
                response.getWriter().println("x2 = " + x2);
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
