package pl.my.quickcash.controllers.employee;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.my.quickcash.controllers.modelfx.ClientFx;
import pl.my.quickcash.controllers.modelfx.ControllFx;

import java.math.BigDecimal;
import java.math.BigInteger;


public class ClientsDatabasePanelController {

    @FXML private TextField searchField;
    @FXML private TableView<ClientFx> tableView;
    @FXML private TableColumn<ClientFx, String> loginColumn;
    @FXML private TableColumn<ClientFx, String> passwordColumn;
    @FXML private TableColumn<ClientFx, String> firstNameColumn;
    @FXML private TableColumn<ClientFx, String> lastNameColumn;
    @FXML private TableColumn<ClientFx, String> peselColumn;
    @FXML private TableColumn<ClientFx, String> idNumberColumn;
    @FXML private TableColumn<ClientFx, String> countryColumn;
    @FXML private TableColumn<ClientFx, String> voivodeshipColumn;
    @FXML private TableColumn<ClientFx, String> cityColumn;
    @FXML private TableColumn<ClientFx, String> streetColumn;
    @FXML private TableColumn<ClientFx, String> buildingNumberColumn;
    @FXML private TableColumn<ClientFx, String> flatNumberColumn;
    @FXML private TableColumn<ClientFx, String> countryCDColumn;
    @FXML private TableColumn<ClientFx, String> voivodeshipCDColumn;
    @FXML private TableColumn<ClientFx, String> cityCDColumn;
    @FXML private TableColumn<ClientFx, String> streetCDColumn;
    @FXML private TableColumn<ClientFx, String> buildingNumberCD;
    @FXML private TableColumn<ClientFx, String> flatNumberCD;
    @FXML private TableColumn<ClientFx, BigDecimal> accountBalanceColumn;
    @FXML private TableColumn<ClientFx, String> accountNumberColumn;

    private ControllFx controllFx;

    public void setControllFx(ControllFx controllFx) {
        this.controllFx = controllFx;
        tableView.setItems(controllFx.getClientsObservableFxList());
        initialize(controllFx);
    }

    public ClientsDatabasePanelController() {
    }


    public void initialize(ControllFx controllFx) {
        tableView.setPrefHeight(520);
        tableView.setPrefWidth(1200);
        tableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

        loginColumn.setCellValueFactory(cellData -> cellData.getValue().clientKeyFxProperty().getValue().loginProperty());
        passwordColumn.setCellValueFactory(cellData -> cellData.getValue().clientKeyFxProperty().getValue().passwordProperty());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().personalDataProperty().getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().personalDataProperty().getValue().lastNameProperty());
        peselColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().personalDataProperty().getValue().peselProperty());
        idNumberColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().personalDataProperty().getValue().idCardProperty());
        countryColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().personalDataProperty().getValue().countryProperty());
        voivodeshipColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().personalDataProperty().getValue().voivodeshipProperty());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().personalDataProperty().getValue().cityProperty());
        streetColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().personalDataProperty().getValue().streetProperty());
        buildingNumberColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().personalDataProperty().getValue().buildingNumberProperty());
        flatNumberColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().personalDataProperty().getValue().flatNumberProperty());
        countryCDColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().contactDetailsProperty().getValue().countryCDProperty());
        voivodeshipCDColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().contactDetailsProperty().getValue().voivodeshipCDProperty());
        cityCDColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().contactDetailsProperty().getValue().cityCDProperty());
        streetCDColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().contactDetailsProperty().getValue().streetCDProperty());
        buildingNumberCD.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().contactDetailsProperty().getValue().buildingNumberCDProperty());
        flatNumberCD.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().contactDetailsProperty().getValue().flatNumberCDProperty());
        accountBalanceColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().clientAccountsProperty().getValue().accountBalanceProperty());
        accountNumberColumn.setCellValueFactory(cellData -> cellData.getValue().clientDataFxProperty().getValue().clientAccountsProperty().getValue().accountNumberProperty());

        filtrAndSearch(controllFx);
    }

   private void filtrAndSearch(ControllFx controllFx) {
        FilteredList<ClientFx> filteredData = new FilteredList<ClientFx>(controllFx.getClientsObservableFxList(), c -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(client -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                if (client.getClientDataFx().getPersonalData().getPesel().contains(newValue)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<ClientFx> sortedData = new SortedList<ClientFx>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }
}
