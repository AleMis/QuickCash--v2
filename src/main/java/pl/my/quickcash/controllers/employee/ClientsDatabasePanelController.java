package pl.my.quickcash.controllers.employee;

import com.sun.javafx.scene.control.skin.TableColumnHeader;
import com.sun.javafx.scene.control.skin.VirtualScrollBar;
import com.sun.rowset.internal.Row;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import pl.my.quickcash.controllers.modelfx.ClientDataFx;
import pl.my.quickcash.controllers.modelfx.ClientFx;
import pl.my.quickcash.controllers.modelfx.ClientKeyFx;
import pl.my.quickcash.controllers.modelfx.ControllFx;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.Set;


public class ClientsDatabasePanelController {

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
    }

    public ClientsDatabasePanelController() {
    }



    public void initialize() {
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
    }
}
