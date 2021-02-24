package vadimsConfig.Classes.Company_From_Database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "language_company", schema = "user")
public class LanguageCompanyEntity {
    private int idcompany;
    private String name;
    private Double price;
    private String wayToPay;

    @Id
    @Column(name = "idcompany", nullable = false)
    public int getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(int idcompany) {
        this.idcompany = idcompany;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "way_to_pay", nullable = true, length = 45)
    public String getWayToPay() {
        return wayToPay;
    }

    public void setWayToPay(String wayToPay) {
        this.wayToPay = wayToPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageCompanyEntity that = (LanguageCompanyEntity) o;
        return idcompany == that.idcompany &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(wayToPay, that.wayToPay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcompany, name, price, wayToPay);
    }
}
