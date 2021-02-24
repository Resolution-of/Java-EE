package vadimsConfig.Classes;

import vadimsConfig.Classes.Company_From_Database.CompanyEntityManager;

import javax.ejb.Stateful;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Stateful
public class Companies implements Information{


    ArrayList<Company> list_of_Companies = new ArrayList<Company>();
    public Companies(){};
    public void add(Company com)
    {
        list_of_Companies.add(com);
    }
    public ArrayList<Company> getList()
    {
        try {
            Connection connection;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=UTC&useSSL=false", "root", "Superkillbody12345");
            String select = "Select * from language_company";
            Statement statement3 = connection.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(select);
            while(resultSet3.next())
            {
                Company ob = new Company(resultSet3.getInt("idcompany"), resultSet3.getString("name"),
                        resultSet3.getDouble("price"), resultSet3.getString("way_to_pay"));
                list_of_Companies.add(ob);
            }
            resultSet3.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_of_Companies;
    }
    public void printAll()
    {
        for(Company com : list_of_Companies)
        System.out.println("ID = " + com.getId() + " Name = " + com.getCompanyName() + " Price = " + com.getPrice() + "Way to pay = " + com.getWay_to_pay());

    }
}
