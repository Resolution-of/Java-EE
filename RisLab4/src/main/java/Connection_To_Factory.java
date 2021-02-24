import javax.annotation.Resource;
import javax.jms.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Connection_To_Factory {
    @Resource(name="jms/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name="jms/Topic")
    private Destination destination;

    private String[] arr = new String[10];
    public void addString() {
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
            System.out.println(arr[i]);
        }
    }

    public void sendString() {
        try {
            //создаем подключение
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            //добавим в JMS сообщение собственное свойство в поле сообщения со свойствами
            message.setStringProperty("clientType", "web clien");

            addString();
            for(int i =0;i<10;i++)
            {
                message.setText(arr[i]);
                producer.send(message);
            }

            session.close();
            connection.close();

        } catch (JMSException ex) {
            System.err.println("Sending message error");
            ex.printStackTrace();
        }
    }
}
