package vadimsConfig.Servlet;

import vadimsConfig.Classes.Company_From_Database.CompanyEntityManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletAddNewCompany extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CompanyEntityManager ob1 = new CompanyEntityManager();
        String nameCompany = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String way_to_pay = req.getParameter("wayToPay");
        ob1.addInfo(nameCompany, price, way_to_pay);
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("table.jsp");
        rd.forward(req, resp);
    }
}
