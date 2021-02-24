package vadimsConfig.Servlet;


import vadimsConfig.Classes.Companies;
import vadimsConfig.Classes.Information;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ServletTable extends HttpServlet {

    @EJB
    Information com;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            request.setAttribute("users",com.getList());
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("table.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
    }
}
