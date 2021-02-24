package Server;
import javax.jws.WebService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebService(endpointInterface = "Server.Search")
public class SearchInDatabase implements Search{
    @Override
    public String searchFIO(String name, String surname) {
        try {
            Connection connection;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "Superkillbody12345");
            String select = "Select * from employees";
            Statement statement3 = connection.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(select);
            while(resultSet3.next())
            {
                String Name = resultSet3.getString("name");
                String Surname = resultSet3.getString("surname");
                String post = resultSet3.getString("post");
                if(Name.equals(name) && Surname.equals(surname))
                {
                    return "Выбранный вами сотрудник занимает должность: " + post + "\n";
                }
            }
            resultSet3.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Данный сотрудник в реестре отсутствует\n";
    }

    @Override
    public String searchPost(String post) {
        try {
            Connection connection;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "Superkillbody12345");
            String select = "Select * from employees";
            Statement statement3 = connection.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(select);
            while(resultSet3.next())
            {
                String Name = resultSet3.getString("name");
                String Surname = resultSet3.getString("surname");
                String Post = resultSet3.getString("post");
                if(Post.equals(post))
                {
                    return "Выбранную вами должность занимает: " + Name + " " + Surname + "\n";
                }
            }
            resultSet3.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Выбранную вами должность никто не занимает\n";
    }
}
