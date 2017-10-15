package pl.my.quickcash.controllers.general;
;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientLoginPanel.fxml"));
            scene.setRoot((Parent) loader.load());
            ClientLoginPanelController controller = loader.<ClientLoginPanelController>getController();
                controller.initClientKey(this);
            stage.setHeight(250.0);
            stage.setWidth(400.0);
        }catch(IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showClientMainPanel(ClientKey clientKey, Stage stage) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMainPanel.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EmployeeLoginPanel.fxml"));
            scene.setRoot((Parent) loader.load());
            EmployeeLoginPanelController controller = loader.<EmployeeLoginPanelController>getController();
            controller.initEmployeeKey(this);
            stage.setHeight(250.0);
            stage.setWidth(400.0);
        }catch(IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showEmployeeMainPanel(EmployeeKey employeeKey, Stage stage) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EmployeeMainPanel.fxml"));
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