package pl.my.quickcash.controllers.client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.my.quickcash.controllers.general.LoginController;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.dao.MyBatisConnectionFactory;
import pl.my.quickcash.dao.ClientKeyDAO;
import pl.my.quickcash.data.client.ClientKey;

public class ClientLoginPanelController {

    private static final String SELECT_ALL_CLIENT_KEY = "ClientKey.selectAllClientKey";
    private static final String INSERT_CLIENT_KEY = "ClientKey.insertClientKey";
    private static final String GET_CLIENT_KEY_BY_LOGIN = "ClientKey.selectClientKey";

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
            ClientKey clientKey = (ClientKey) CommunicationDAO.selectByString(GET_CLIENT_KEY_BY_LOGIN, login);
            return clientKey;
        } else {
            return null;
        }
    }

}