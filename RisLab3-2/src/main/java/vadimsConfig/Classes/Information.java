package vadimsConfig.Classes;



import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface Information {
    void add(Company com);
    ArrayList<Company> getList();
}
