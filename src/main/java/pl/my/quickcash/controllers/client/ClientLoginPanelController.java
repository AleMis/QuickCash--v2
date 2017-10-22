package pl.my.quickcash.controllers.client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.my.quickcash.Main;
import pl.my.quickcash.controllers.general.LoginController;
import pl.my.quickcash.controllers.general.Start;
import pl.my.quickcash.controllers.general.StarterPanelController;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.password_security.SecurePassword;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class ClientLoginPanelController {

    private static final String GET_CLIENT_KEY_BY_LOGIN = "ClientKey.selectClientKey";

    @FXML private TextField loginTextField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Label statusLabel;


    public void initialize() {
    }

    public void initClientKey(final LoginController loginController) {
        passwordField.cacheProperty();
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ClientKey clientKey = null;
                try {
                    clientKey = authorize();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                if (clientKey != null) {
                    loginController.clientAuthenticated(clientKey);
                }else {
                    statusLabel.setText("Incorrect login or password!");
                }
            }
        });
    }

    private ClientKey authorize() throws InvalidKeySpecException, NoSuchAlgorithmException {
        ClientKey clientKey = null;
        String password = null;
        String login = null;
        try {
            clientKey = CommunicationDAO.selectByString(GET_CLIENT_KEY_BY_LOGIN, loginTextField.getText());
            login = clientKey.getLogin();
            password = clientKey.getPassword();
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            if (login == null) {
                return null;
            } else if (!(login == null) && !SecurePassword.validatePassword(passwordField.getText(), password)){
                return null;
            } else {
                return clientKey;
            }
        }
    }

    @FXML
    public void cancel() throws IOException {
        StarterPanelController.backToStarterPanel();
    }
}