package vadimsConfig.Classes;

import javax.ejb.Local;

@Local
public interface Pay {
    String pay(String nameCompany);
}
