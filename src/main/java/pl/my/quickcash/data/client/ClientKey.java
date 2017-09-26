package pl.my.quickcash.data.client;

public class ClientKey {
    private String login;
    private String password;

    public ClientKey(String login, String password) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientKey)) return false;

        ClientKey clientKey = (ClientKey) o;

        if (!getLogin().equals(clientKey.getLogin())) return false;
        return getPassword().equals(clientKey.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
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

