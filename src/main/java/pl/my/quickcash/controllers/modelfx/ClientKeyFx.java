package pl.my.quickcash.controllers.modelfx;

import javafx.beans.property.SimpleStringProperty;

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

    @Override
    public String toString() {
        return login.get() + "" + password.get();
    }
}
