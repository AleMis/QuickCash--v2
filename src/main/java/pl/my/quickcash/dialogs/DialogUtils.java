package pl.my.quickcash.dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialogUtils {

    public static Optional<ButtonType> confirmationDialogForContactDetails() {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Changes in contact details");
        confirmationAlert.setHeaderText("Do you want to save changes?");
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        return result;
    }

    public static Optional<ButtonType> confirmationDialogForCloseApp() {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Closing application");
        confirmationAlert.setHeaderText("Do you want to close Quick Cash Application?");
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        return result;
    }


    public static void dialogAboutApplication() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("About");
        informationAlert.setHeaderText("QuickCash Appliaction 1.0");
        informationAlert.setContentText("Application is developing by JavaSzaman!");
        informationAlert.showAndWait();
    }
}
