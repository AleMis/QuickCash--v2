package pl.my.quickcash.controllers.modelfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import pl.my.quickcash.data.client.ClientKey;

public class ClientKeyFx {

    private SimpleStringProperty login = new SimpleStringProperty();
    private SimpleStringProperty password = new SimpleStringProperty();

    public String getLogin() {
        return login.get();
    }

    public SimpleStringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
