package pl.my.quickcash.controllers.employee;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.my.quickcash.controllers.modelfx.ClientDataFx;
import pl.my.quickcash.controllers.modelfx.ClientKeyFx;
import pl.my.quickcash.controllers.modelfx.ControllFx;


public class ClientsDatabasePanel2Controller {

    @FXML private TableView<?> tableView;
    @FXML private TableColumn<ClientKeyFx, String> loginColumn;
    @FXML private TableColumn<ClientKeyFx, String> passwordColumn;
    @FXML private TableColumn<ClientDataFx, String> firstNameColumn;
    @FXML private TableColumn<ClientDataFx, String> lastNameColumn;
    @FXML private TableColumn<ClientDataFx, String> countryColumn;

    private ControllFx controllFx;

    public ControllFx getControllFx() {
        return controllFx;
    }

    public void setControllFx(ControllFx controllFx) {

        this.controllFx = controllFx;

        tableView.setItems(controllFx.getDatabaseFx());
    }

    public ClientsDatabasePanel2Controller() {
    }

    public void initialize() {
        loginColumn.setCellValueFactory(cellData -> cellData.getValue().loginProperty());
        passwordColumn.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
    }

}
