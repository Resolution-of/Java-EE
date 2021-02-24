package vadimsConfig.Classes;

import javax.ejb.Stateful;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Stateful
public class PayForYear implements Pay{

    @Override
    public String pay(String nameCompany) {
        try {
            Connection connection;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=UTC&useSSL=false", "root", "Superkillbody12345");
            String select = "Select * from language_company";
            Statement statement3 = connection.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(select);
            Companies com = new Companies();
            while(resultSet3.next())
            {
                Company ob = new Company(resultSet3.getInt("idcompany"), resultSet3.getString("name"),
                        resultSet3.getDouble("price"), resultSet3.getString("way_to_pay"));
                com.add(ob);
            }
            for(Company ob : com.getList())
            {
                if(ob.getCompanyName().equals(nameCompany))
                {
                    double cash;
                    cash = ob.getPrice() * 12;
                    return "Стоимость в год равна: " + cash;
                }
            }
            resultSet3.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Ошибочный ввод. Повторите попытку";
    }
}
