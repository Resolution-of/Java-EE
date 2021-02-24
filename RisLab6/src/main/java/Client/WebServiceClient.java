package Client;
// нужно, чтобы получить wsdl описание и через него
// дотянуться до самого веб-сервиса
import Server.Search;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/RisLab6?wsdl");
        QName qname = new QName("http://Server/", "SearchInDatabaseService");
        Service service = Service.create(url, qname);
        Search search = service.getPort(Search.class);
        boolean Menu = true;
        while(Menu) {
            Scanner in = new Scanner(System.in);
            System.out.println("\n1. Поиск должности сотрудника по ФИО\n2. Поиск сотрудников по должности\n3. Выход\nВыберите: ");
            int choice = in.nextInt();
            if (choice == 1) {
                System.out.println("Введите имя: ");
                String Name = in.next();
                System.out.println("Введите фамилию: ");
                String Surname = in.next();
                System.out.println(search.searchFIO(Name, Surname));
            } else if (choice == 2) {
                System.out.println("Введите должность: ");
                String Post = in.next();
                System.out.println(search.searchPost(Post));
            }
            else if(choice == 3)
            {
                Menu = false;
            }
        }
    }
}
