package pl.my.quickcash.controllers;
;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import pl.my.quickcash.data.ClientKey;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {

    private Scene scene;

    public LoginController(Scene scene) {
        this.scene = Start.scene;
    }

    public void authenticated(ClientKey clientKey) {
        showClientMainPanel(clientKey);
    }

    public void logout() {
        showClientLoginPanel();
    }


    public void showClientLoginPanel() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientLoginPanel.fxml"));
            scene.setRoot((Parent) loader.load());
            ClientLoginPanelController controller = loader.<ClientLoginPanelController>getController();
            controller.initManager(this);
        }catch(IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showClientMainPanel(ClientKey clientKey) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMainPanel.fxml"));
            Start.scene.setRoot((Parent) loader.load());
            ClientMainPanelController controller = loader.<ClientMainPanelController>getController();
            controller.initSessionID(this,clientKey);
        }catch (IOException ex ) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }








}