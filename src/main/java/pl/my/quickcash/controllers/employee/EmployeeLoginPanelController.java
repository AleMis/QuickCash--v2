package pl.my.quickcash.controllers.employee;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.my.quickcash.controllers.general.LoginController;
import pl.my.quickcash.controllers.general.StarterPanelController;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.employee.EmployeeKey;
import pl.my.quickcash.password_security.SecurePassword;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class EmployeeLoginPanelController {

    private static final String SELECT_EMPLOYEE_KEY = "EmployeeKey.selectEmployeeKey";
    private static final String INCORRECT_LOGIN_AND_PASSWORD = "Incorrect login or password!";

    @FXML private TextField loginTextField;
    @FXML private TextField passwordField;
    @FXML private Button loginButton;
    @FXML private Label statusLabel;

    public void initEmployeeKey(LoginController loginController) {
        passwordField.cacheProperty();
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EmployeeKey employeeKey = null;
                try {
                    employeeKey = authorize();
                }  catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
                if (employeeKey != null) {
                    loginController.employeeAuthenticated(employeeKey);
                }else {
                    statusLabel.setText(INCORRECT_LOGIN_AND_PASSWORD);
                }
            }
        });
    }

    private EmployeeKey authorize() throws GeneralSecurityException {
        EmployeeKey employeeKey = null;
        String password = null;

        employeeKey = CommunicationDAO.selectByString(SELECT_EMPLOYEE_KEY, loginTextField.getText());
        if(employeeKey == null) {
            return null;
        }else {
            password = employeeKey.getPassword();
            if (!SecurePassword.validatePassword(passwordField.getText(), password)) {
                return null;
            } else {
                return employeeKey;
            }
        }
    }

    @FXML
    public void cancel() throws IOException {
        StarterPanelController.backToStarterPanel();
    }
}
