package pl.my.quickcash.controllers.general;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import pl.my.quickcash.dialogs.DialogUtils;

import java.util.Optional;

public class StarterPanelController {

    @FXML private Button clientButton;
    @FXML private Button employeeButton;
    @FXML private Button cancelButton;

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

    public void runAsEmployee(Stage stage) {
        employeeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginController controller = new LoginController(Start.scene, stage);
                controller.showEmployeeLoginPanel(stage);

            }
        });
    }

    @FXML
    public void closeApplication() {
        Optional<ButtonType> result = DialogUtils.confirmationDialogForCloseApp();
        if(result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }
}





