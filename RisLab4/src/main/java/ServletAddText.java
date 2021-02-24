import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServletAddText extends HttpServlet {
    @Resource(name="jms/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name="jms/Topic")
    private Destination destination;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String[] arr = new String[10];
            Scanner in = new Scanner(System.in);
            int STR_LENGTH = 5;
            Random r = new Random();
            int num = 0;
            for (int i = 0; i < 10; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < STR_LENGTH; j++) {
                    char code = (char) (r.nextInt(94) + 33);
                    builder.append(Character.toString(code));
                }
                num = (int) (Math.random() * (1000) + 10);
                builder.append(num);
                arr[i] = builder.toString();
                sendMessage(arr[i]);
            }
            //sendMessage(str);
            RequestDispatcher rd;
            rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
    }
    private Message createMessage(Session session, Object message) throws JMSException{
        TextMessage tm = session.createTextMessage();
        tm.setText(message.toString());
        return tm;
    }
    private void sendMessage(Object message) throws JMSException
    {
        Connection connection = null;
        Session session = null;
        try{
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(destination);
            messageProducer.send(createMessage(session, message));
        } finally {
            if(session != null)
            {
                try{
                    session.close();
                }
                catch (JMSException e)
                {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if(connection != null)
            {
                connection.close();
            }
        }
    }
}
