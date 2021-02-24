package vadimsConfig.Servlet;


import vadimsConfig.Classes.CalculatePrice;
import vadimsConfig.Classes.Companies;
import vadimsConfig.Classes.Information;
import vadimsConfig.Classes.SmallestPrice;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletPrice extends HttpServlet {
    @EJB
    SmallestPrice price;

    @EJB
    Information com;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",com.getList());
        String answer = price.getPrice();
        req.getSession().setAttribute("price", answer);
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("table.jsp");
        rd.forward(req, resp);
    }
}
