package pl.my.quickcash.controllers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class StarterPanelController {

    @FXML
    private Pane starterPane;

    @FXML
    private Button clientButton;

    @FXML
    private Button adminButton;

    @FXML
    private Button cancelButton;


    private void initialize() {

    }

    public void runAsClient() {
        clientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                LoginController controller = new LoginController(Start.scene);
                controller.showClientLoginPanel();
            }
        });
    }

    public void runAsAdmin() {
        adminButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
    }




}





