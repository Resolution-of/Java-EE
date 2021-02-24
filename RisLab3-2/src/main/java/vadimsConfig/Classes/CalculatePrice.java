package vadimsConfig.Classes;

import javax.ejb.Stateful;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Stateful
public class CalculatePrice implements SmallestPrice{
    public CalculatePrice(){}
    @Override
    public String getPrice() {
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
            double value = 0.0, min = 100000000.0;
            String companyName = "";
            for(Company ob : com.getList())
            {
                value = ob.getPrice();
                if(value < min)
                {
                    min = value;
                    companyName = ob.getCompanyName();
                }
            }
            resultSet3.close();
            connection.close();
            return "Самый дешёвый курс: " + companyName + ". Стоимость: " + min;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Ошибочный ввод. Повторите попытку";
    }
}
