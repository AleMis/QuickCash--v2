package pl.my.quickcash.controllers.employee;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import pl.my.quickcash.controllers.client.MakeTransferPanelController;
import pl.my.quickcash.data.EmployeeKey;
import pl.my.quickcash.data.EmployeesDatabase;
import pl.my.quickcash.dialogs.DialogUtils;

import java.util.Optional;

public class EmployeeMainPanelController {

    private static final String ADD_CLIENT_FXML = "/fxml/AddClientPanel.fxml";



    private EmployeeKey employeeKey;

    public EmployeeKey getEmployeeKey() {
        return employeeKey;
    }

    public void setEmployeeKey(EmployeeKey employeeKey) {
        this.employeeKey = employeeKey;
    }

    @FXML
    private BorderPane employeeBorderPane;

    @FXML
    private Label employeeNameLabel;

    @FXML
    private Label employeePositionLabel;

    public void initSession() {
        employeeNameLabel.setText(EmployeesDatabase.getInstance().get(getEmployeeKey()).getFirstName() + " "
                                + EmployeesDatabase.getInstance().get(getEmployeeKey()).getLastName());
        employeePositionLabel.setText(EmployeesDatabase.getInstance().get(getEmployeeKey()).getPosition());
    }

    public void closeApplication() {
        Optional<ButtonType> result = DialogUtils.confirmationDialogForCloseApp();
        if(result.get()==ButtonType.OK){
            Platform.exit();
            System.exit(0);
        }
    }

    @FXML
    public void initAddNewClient() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADD_CLIENT_FXML));
        try {
            employeeBorderPane.setCenter(loader.load());
            AddClientPanelController controller = loader.<AddClientPanelController>getController();
            controller.setEmployeeKey(getEmployeeKey());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void setCaspian() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }

    public void setModena() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }

    public void about() {
        DialogUtils.dialogAboutApplication();
    }


}
