import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
        //имя topic, на который подписан бин
        mappedName="jms/Topic",
        name = "Topic")
public class MessageDrivenBeen implements MessageListener {


    //метод, вызываемый при получении нового сообщения
    @Override
    public void onMessage(Message msg) {
        try {
            TextMessage message = (TextMessage)msg;
            //считываем свойство из соответствующего поля, заданное вручную в consumer
            System.out.println("FROM MDB - client type IS " + message.getStringProperty("clientType"));
            for(int i =0;i<10;i++) {
                System.out.println((i+1) + " - " + message.getText());
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}
