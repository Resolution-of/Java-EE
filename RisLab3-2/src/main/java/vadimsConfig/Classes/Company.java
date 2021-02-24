package vadimsConfig.Classes;


import javax.ejb.Stateful;

@Stateful
public class Company {

    private int id;
    private String companyName;
    private Double price;
    private String way_to_pay;

    public Company(){};
    public Company(int id, String companyName, Double price, String way_to_pay)
    {
        this.id = id;
        this.companyName = companyName;
        this.price = price;
        this.way_to_pay = way_to_pay;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public String getWay_to_pay() {
        return way_to_pay;
    }

    public void setWay_to_pay(String way_to_pay) {
        this.way_to_pay = way_to_pay;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
