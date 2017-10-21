package pl.my.quickcash.data.employee;

import java.math.BigInteger;

public class EmployeeKey {

    private BigInteger employee_key_id;
    private String login;
    private String password;

    public EmployeeKey(BigInteger employee_key_id, String login, String password) {
        this.employee_key_id = employee_key_id;
        this.login = login;
        this.password = password;
    }

    public EmployeeKey(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public EmployeeKey() {
    }

    public BigInteger getEmployee_key_id() {
        return employee_key_id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeKey that = (EmployeeKey) o;

        if (!employee_key_id.equals(that.employee_key_id)) return false;
        if (!login.equals(that.login)) return false;
        return password.equals(that.password);
    }

    @Override
    public int hashCode() {
        int result = employee_key_id.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append(employee_key_id);
        print.append("; ");
        print.append(login);
        print.append("; ");
        print.append(password);
        print.append("; ");
        return print.toString();
    }
}
