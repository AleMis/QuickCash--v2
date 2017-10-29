package pl.my.quickcash.controllers.general;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Start {

    private static final String STARTER_PANEL_FXML = "/fxml/StarterPanel.fxml";

    public static Scene scene;
    public Start() {
      Start.scene = new Scene(new StackPane());
    }

    public void showStarterPanel(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(STARTER_PANEL_FXML));
            Start.scene.setRoot((Parent) loader.load());
            StarterPanelController controller = loader.<StarterPanelController>getController();
            controller.runAsClient(stage);
            controller.runAsEmployee(stage);
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
