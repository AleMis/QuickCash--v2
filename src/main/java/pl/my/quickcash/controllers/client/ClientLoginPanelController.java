package pl.my.quickcash.controllers.client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.my.quickcash.controllers.general.LoginController;
import pl.my.quickcash.controllers.general.StarterPanelController;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.password_security.SecurePassword;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class ClientLoginPanelController {

    private static final String GET_CLIENT_KEY_BY_LOGIN = "ClientKey.selectClientKey";
    private static final String INCORRECT_LOGIN_AND_PASSWORD = "Incorrect login or password!";

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
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
                if (clientKey != null) {
                    loginController.clientAuthenticated(clientKey);
                }else {
                    statusLabel.setText(INCORRECT_LOGIN_AND_PASSWORD);
                }
            }
        });
    }

    private ClientKey authorize() throws GeneralSecurityException {
        ClientKey clientKey = null;
        String password = null;

        clientKey = CommunicationDAO.selectByString(GET_CLIENT_KEY_BY_LOGIN, loginTextField.getText());
        if(clientKey == null) {
            return null;
        }else {
            password = clientKey.getPassword();
            if (!SecurePassword.validatePassword(passwordField.getText(), password)) {
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