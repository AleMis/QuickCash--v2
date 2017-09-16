package pl.my.quickcash.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Start {

    public static Scene scene;

    public Start() {
      Start.scene = new Scene(new StackPane());
    }

    public void showStarterPanel() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/StarterPanel.fxml"));
            Start.scene.setRoot((Parent) loader.load());
            StarterPanelController controller = loader.<StarterPanelController>getController();
            controller.runAsClient();
            controller.runAsAdmin();
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
