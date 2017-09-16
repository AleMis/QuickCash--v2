package pl.my.quickcash.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import pl.my.quickcash.data.ClientKey;
import pl.my.quickcash.data.ClientsDatabase;

public class ClientLoginPanelController {

    @FXML
    private Pane clientLoginPanel;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label statusLabel;


    public void initialize() {

    }

    public void initManager(final LoginController loginController) {

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ClientKey clientKey = authorize();
                if (clientKey != null) {
                    loginController.authenticated(clientKey);
                }else {
                    statusLabel.setText("Incorrect login or password!");
                }
            }
        });
    }


    private ClientKey authorize() {
        ClientKey clientKey = new ClientKey(loginTextField.getText(), passwordTextField.getText());
        if (ClientsDatabase.getInstance().containsKey(clientKey)) {
            return clientKey;
        } else {
            return null;
        }
    }

}