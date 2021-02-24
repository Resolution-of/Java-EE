package Classes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

// Аннотации managed bean компонента
@ManagedBean (name="Main") // определение managed bean и его наименования
@SessionScoped             // определение времени жизни - сессия
public class Main
{
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* Метод простейшей авторизации.
     * Выполняется проверка имени и пароля пользователя.
     * Результат проверки - наименование страницы перехода
     */
    public String checkLogin(){
        if (login.equalsIgnoreCase("alex") && password.equalsIgnoreCase("qwerty")){
            return "loginsuccess?faces-redirect=true";
        } else {
            return "loginfailed?faces-redirect=true";
        }
    }
}
