package pl.my.quickcash.controllers.employee;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.my.quickcash.controllers.general.StarterPanelController;
import pl.my.quickcash.controllers.modelfx.ControllFx;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.employee.EmployeeData;
import pl.my.quickcash.data.employee.EmployeeKey;
import pl.my.quickcash.dialogs.DialogUtils;

import java.io.IOException;
import java.util.Optional;

public class EmployeeMainPanelController {

    private static final String ADD_CLIENT_FXML = "/fxml/AddClientPanel.fxml";
    private static final String SHOW_CLIENTS_DATABASE_FXML = "/fxml/ClientsDatabasePanel.fxml";
    private static final String REMOVE_CLIENT = "/fxml/RemoveClientPanel.fxml";
    private static final String SELECT_EMPLOYEE_BY_ID = "EmployeeData.selectEmployeeData";

    private EmployeeKey employeeKey;

    public EmployeeKey getEmployeeKey() {
        return employeeKey;
    }

    public void setEmployeeKey(EmployeeKey employeeKey) {
        this.employeeKey = employeeKey;
    }

    private ControllFx controllFx = new ControllFx();

    @FXML private BorderPane employeeBorderPane;
    @FXML private Label employeeNameLabel;
    @FXML private Label employeePositionLabel;

    public void initSession() {
        EmployeeData employeeData = CommunicationDAO.selectById(SELECT_EMPLOYEE_BY_ID,getEmployeeKey().getEmployeeKeyId());
        employeeNameLabel.setText(employeeData.getFirstName() + " " + employeeData.getLastName());
        employeePositionLabel.setText(employeeData.getPosition());
        setModena();
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
            controller.disableClientAccountDetailsTextFields();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @FXML
    public void initRemoveClient() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(REMOVE_CLIENT));
        try {
            employeeBorderPane.setCenter(loader.load());
            RemoveClientPanelController controller = loader.<RemoveClientPanelController>getController();
            controller.disableFields();
        }catch (Exception e) {
            e.getStackTrace();
        }
    }

    @FXML
    public void initShowClientsDatabase() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(SHOW_CLIENTS_DATABASE_FXML));
        Stage stage = new Stage();
        Pane pane = loader.load();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        controllFx.initDatabase();
        ClientsDatabasePanelController controller = loader.getController();
        controller.setControllFx(controllFx);
    }

    @FXML
    public void setCaspian() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }

    @FXML
    public void setModena() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }

    @FXML
    public void about() {
        DialogUtils.dialogAboutApplication();
    }

    @FXML
    public void logout(){
        StarterPanelController.backToStarterPanel();
    }
}
