package vadimsConfig.Classes.Company_From_Database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class CompanyEntityManager {
    private EntityManager em;

    public void addInfo(String nameCompany, double Price, String Way_to_Pay)
    {
        LanguageCompanyEntity com = new LanguageCompanyEntity();
        com.setIdcompany(4);
        com.setName(nameCompany);
        com.setPrice(Price);
        com.setWayToPay(Way_to_Pay);
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("javax.persistence.jdbc.user", "root");
        properties.put("javax.persistence.jdbc.password", "Superkillbody12345");
        properties.put("javax.persistence.jdbc.url”", "jdbc:mysql://localhost:3306/user?useSSL=false");
        properties.put("javax.persistence.jdbc.driver" , "com.mysql.jdbc.Driver");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("company", properties);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(com);
        em.getTransaction().commit();
        em.close();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
