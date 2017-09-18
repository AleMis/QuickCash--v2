package pl.my.quickcash.controllers;
;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.my.quickcash.data.ClientKey;

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

    public void authenticated(ClientKey clientKey) {
        showClientMainPanel(clientKey, stage);
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








}