package pl.my.quickcash.controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;

import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import pl.my.quickcash.Main;
import pl.my.quickcash.data.ClientKey;
import pl.my.quickcash.data.ClientsDatabase;


public class ClientLoginPanelController {

    private final ObjectProperty<ClientKey> clientKey = new SimpleObjectProperty<>();

    public final ObjectProperty<ClientKey> clientKeyProperty() {
        return this.clientKey;
    }

    public final ClientKey getClientKey() {
        return this.clientKeyProperty().get();
    }

    public final void setClientKey(final ClientKey clientKey) {
        this.clientKeyProperty().set(clientKey);
    }


    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Label statusLabel;

    @FXML
    private void ok() {
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        if (authenticate(login, password)) {
            setClientKey(new ClientKey(login, password));
            statusLabel.setText("Correct");
        } else {
            statusLabel.setText("Incorrect login or password!");
        }
        clearFields();
    }

    @FXML
    private void cancel() {
        setClientKey(null);
        clearFields();
        statusLabel.setText("");
    }

    private boolean authenticate(String login, String password) {
        setClientKey(new ClientKey(login, password));
        return ClientsDatabase.getInstance().containsKey(getClientKey());
    }

    private void clearFields() {
        loginTextField.setText("");
        passwordTextField.setText("");
    }








}
