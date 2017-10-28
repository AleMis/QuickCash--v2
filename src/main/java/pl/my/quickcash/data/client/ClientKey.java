package pl.my.quickcash.data.client;

import java.math.BigInteger;

public class ClientKey {

    private BigInteger clientKeyId;
    private String login;
    private String password;

    public ClientKey(BigInteger clientKeyId, String login, String password) {
        this.clientKeyId = clientKeyId;
        this.login = login;
        this.password = password;
    }

    public ClientKey(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public ClientKey(){
    }

    public BigInteger getClientKeyId() {
        return clientKeyId;
    }

    public void setClientKeyId(BigInteger clientKeyId) {
        this.clientKeyId = clientKeyId;
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

        ClientKey clientKey = (ClientKey) o;

        if (!clientKeyId.equals(clientKey.clientKeyId)) return false;
        if (!login.equals(clientKey.login)) return false;
        return password.equals(clientKey.password);
    }

    @Override
    public int hashCode() {
        int result = clientKeyId.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append(clientKeyId);
        print.append("; ");
        print.append(login);
        print.append("; ");
        print.append(password);
        print.append("; ");
        return print.toString();
    }
}

