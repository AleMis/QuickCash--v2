package pl.my.quickcash.controllers.general;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.my.quickcash.controllers.client.ClientLoginPanelController;
import pl.my.quickcash.controllers.client.ClientMainPanelController;
import pl.my.quickcash.controllers.employee.EmployeeLoginPanelController;
import pl.my.quickcash.controllers.employee.EmployeeMainPanelController;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.employee.EmployeeKey;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {

    private static final String EMPLOYEE_MAIN_PANEL_FXML = "/fxml/EmployeeMainPanel.fxml";
    private static final String EMPLOYEE_LOGIN_PANEL_FXML = "/fxml/EmployeeLoginPanel.fxml";
    private static final String CLIENT_MAIN_PANEL_FXML = "/fxml/ClientMainPanel.fxml";
    private static final String CLIENT_LOGIN_PANEL_FXML = "/fxml/ClientLoginPanel.fxml";

    private Scene scene;
    private Stage stage;

    public LoginController(Scene scene, Stage stage) {
        this.scene = Start.scene;
        this.stage = stage;
    }

    public void clientAuthenticated(ClientKey clientKey) {
        showClientMainPanel(clientKey, stage);
    }

    public void employeeAuthenticated(EmployeeKey employeeKey) {
        showEmployeeMainPanel(employeeKey, stage);
    }

    public void logout() {
        showClientLoginPanel(stage);
    }


    public void showClientLoginPanel(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(CLIENT_LOGIN_PANEL_FXML));
            scene.setRoot((Parent) loader.load());
            ClientLoginPanelController controller = loader.<ClientLoginPanelController>getController();
                controller.initClientKey(this);
            stage.setHeight(220.0);
            stage.setWidth(420.0);
        }catch(IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showClientMainPanel(ClientKey clientKey, Stage stage) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(CLIENT_MAIN_PANEL_FXML));
            Start.scene.setRoot((Parent) loader.load());
            ClientMainPanelController controller = loader.<ClientMainPanelController>getController();
            controller.setClientKey(clientKey);
            controller.initSession();
            stage.setHeight(450.0);
            stage.setWidth(700.0);
        }catch (IOException ex ) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showEmployeeLoginPanel(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(EMPLOYEE_LOGIN_PANEL_FXML));
            scene.setRoot((Parent) loader.load());
            EmployeeLoginPanelController controller = loader.<EmployeeLoginPanelController>getController();
            controller.initEmployeeKey(this);
            stage.setHeight(220.0);
            stage.setWidth(420.0);
        }catch(IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showEmployeeMainPanel(EmployeeKey employeeKey, Stage stage) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(EMPLOYEE_MAIN_PANEL_FXML));
            Start.scene.setRoot((Parent) loader.load());
            EmployeeMainPanelController controller = loader.<EmployeeMainPanelController>getController();
            controller.setEmployeeKey(employeeKey);
            controller.initSession();
            stage.setHeight(450.0);
            stage.setWidth(700.0);
        }catch (IOException ex ) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}