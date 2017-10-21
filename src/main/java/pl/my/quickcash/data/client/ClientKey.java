package pl.my.quickcash.data.client;

import java.math.BigInteger;

public class ClientKey {

    private BigInteger client_key_id;
    private String login;
    private String password;

    public ClientKey(BigInteger client_key_id, String login, String password) {
        this.client_key_id = client_key_id;
        this.login = login;
        this.password = password;
    }

    public ClientKey(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public ClientKey(){
    }

    public String getLogin() {
        return login;
    }

    public BigInteger getClient_key_id() {
        return client_key_id;
    }

    public void setClient_key_id(BigInteger client_key_id) {
        this.client_key_id = client_key_id;
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

        if (!client_key_id.equals(clientKey.client_key_id)) return false;
        if (!login.equals(clientKey.login)) return false;
        return password.equals(clientKey.password);
    }

    @Override
    public int hashCode() {
        int result = client_key_id.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append(client_key_id);
        print.append("; ");
        print.append(login);
        print.append("; ");
        print.append(password);
        print.append("; ");
        return print.toString();
    }
}

