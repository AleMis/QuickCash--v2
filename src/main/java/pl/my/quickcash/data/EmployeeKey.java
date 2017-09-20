package pl.my.quickcash.data;

public class EmployeeKey {

    private String login;
    private String password;

    public EmployeeKey(String login, String password) {
        this.login = login;
        this.password = password;
    }

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

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append(login);
        print.append("; ");
        print.append(password);
        print.append("; ");

        return print.toString();
    }
}
