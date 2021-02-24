package vadimsConfig.Servlet;

import vadimsConfig.Classes.Companies;
import vadimsConfig.Classes.Information;
import vadimsConfig.Classes.Pay;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletYearPay extends HttpServlet {

    @EJB
    Pay cash;
    @EJB
    Information com;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",com.getList());
        String answer = cash.pay(req.getParameter("name"));
        req.getSession().setAttribute("answer", answer);
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("table.jsp");
        rd.forward(req, resp);
    }
}
