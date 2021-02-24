package vadimsConfig.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            RequestDispatcher rd;
            rd = req.getRequestDispatcher("add.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
    }
}
