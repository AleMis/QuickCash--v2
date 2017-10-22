package pl.my.quickcash.controllers.employee;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import pl.my.quickcash.Main;
import pl.my.quickcash.controllers.general.LoginController;
import pl.my.quickcash.controllers.general.Start;
import pl.my.quickcash.controllers.general.StarterPanelController;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.employee.EmployeeKey;

import java.io.IOException;

public class EmployeeLoginPanelController {

    private static final String SELECT_EMPLOYEE_KEY = "EmployeeKey.selectEmployeeKey";

    @FXML private TextField loginTextField;
    @FXML private TextField passwordField;
    @FXML private Button loginButton;
    @FXML private Label statusLabel;

    public void initEmployeeKey(LoginController loginController) {
        passwordField.cacheProperty();
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EmployeeKey employeeKey = authorize();
                if (employeeKey != null) {
                    loginController.employeeAuthenticated(employeeKey);
                }else {
                    statusLabel.setText("Incorrect login or password!");
                }
            }
        });
    }

    private EmployeeKey authorize() {
        EmployeeKey employeeKey = null;
        String login = null;
        String password = null;

        try {
            employeeKey = CommunicationDAO.selectByString(SELECT_EMPLOYEE_KEY, loginTextField.getText());
            login = employeeKey.getLogin();
            password = employeeKey.getPassword();
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            if (login == null) {
                return null;
            }else if(!(login == null) && !(password.equals(passwordField.getText()))) {
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
