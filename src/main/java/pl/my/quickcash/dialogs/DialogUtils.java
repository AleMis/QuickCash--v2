package pl.my.quickcash.dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialogUtils {

    public static Optional<ButtonType> confirmationDialogForContactDetailsSaving() {
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

    public static Optional<ButtonType> confirmationDialogForContactDetails() {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Changes in contact details");
        confirmationAlert.setHeaderText("Allow for changes in contact details?");
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        return result;
    }


    public static Optional<ButtonType> confirmationDialogForAddingNewClient() {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Adding New Client");
        confirmationAlert.setHeaderText("Do you want to add new client?");
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        return result;
    }

    public static void dialogNewClienAdded() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Adding New Client");
        informationAlert.setHeaderText("New client was add!");
        informationAlert.showAndWait();
    }

    public static void dialogCheckPersonalInformation() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Adding New Client");
        informationAlert.setHeaderText("You have to fill in all fields with personal information!");
        informationAlert.showAndWait();
    }

    public static void dialogCheckContactDetails() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Adding New Client");
        informationAlert.setHeaderText("You have to fill contact details!");
        informationAlert.setContentText("Select check box if Contact Details are the same ase registered data.");
        informationAlert.showAndWait();
    }

    public static void dialogCheckClientAccountDetails() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Adding New Client");
        informationAlert.setHeaderText("You have to generate Client's Account Details!");
        informationAlert.setContentText("Click the button to generate Client's Account Details in Client Account Details Lap");
        informationAlert.showAndWait();
    }
}
