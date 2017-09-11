package pl.my.quickcash.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Pane clientLoginPanel;

    private Parent mainView;

    @FXML
    private ClientLoginPanelController clientLoginPanelController;


    public void initialize() {
        clientLoginPanelController.clientKeyProperty().addListener((obs, oldClient, newClient) -> {
            if (newClient == null) {
                borderPane.setCenter(clientLoginPanel);
                borderPane.getScene().getWindow().sizeToScene();
            } else {
                if (mainView == null) {
                    loadClientMainPanel();
                }
                borderPane.setCenter(mainView);
                borderPane.getScene().getWindow().sizeToScene();

            }
        });
    }

    public void loadClientMainPanel() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/fxml/ClientMainPanel.fxml"));
            mainView = loader.load();
            ClientMainPanelController controller = loader.getController();
            controller.clientKeyProperty().bindBidirectional(
                    clientLoginPanelController.clientKeyProperty());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

}
