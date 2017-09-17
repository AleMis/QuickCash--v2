package pl.my.quickcash.controllers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StarterPanelController {



    @FXML
    private Button clientButton;

    @FXML
    private Button adminButton;

    @FXML
    private Button cancelButton;


    private void initialize() {

    }

    public void runAsClient(Stage stage) {
        clientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                LoginController controller = new LoginController(Start.scene, stage);
                controller.showClientLoginPanel(stage);
            }
        });
    }

    public void runAsAdmin(Stage stage) {
        adminButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
    }




}





