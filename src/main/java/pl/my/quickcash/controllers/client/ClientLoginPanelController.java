package pl.my.quickcash.controllers.client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.my.quickcash.controllers.general.LoginController;
import pl.my.quickcash.dao.MyBatisConnectionFactory;
import pl.my.quickcash.dao.clients.ClientKeyDAO;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientsDatabase;
import pl.my.quickcash.data.employee.EmployeeKey;

public class ClientLoginPanelController {

    @FXML private TextField loginTextField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Button cancelButton;
    @FXML private Label statusLabel;

    public void initialize() {
    }

    public void initClientKey(final LoginController loginController) {
        passwordField.cacheProperty();
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ClientKey clientKey = authorize();
                if (clientKey != null) {
                    loginController.clientAuthenticated(clientKey);
                }else {
                    statusLabel.setText("Incorrect login or password!");
                }
            }
        });
    }

    private ClientKey authorize() {
        ClientKeyDAO clientKeyDAO = new ClientKeyDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        String login = clientKeyDAO.getLoginFromMySQL(loginTextField.getText());
        String password = clientKeyDAO.getPasswordFromMySQL(passwordField.getText());

        if (!login.equals(null) && !password.equals(null)) {
            ClientKey clientKey = clientKeyDAO.getClientKey(login);
            return clientKey;
        } else {
            return null;
        }
    }

}