package pl.my.quickcash.controllers.client;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.my.quickcash.controllers.modelfx.ClientTransactionFx;
import pl.my.quickcash.controllers.modelfx.ControllFx;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


public class ClientTransactionPanelController {

    @FXML private TextField searchField;
    @FXML private TableView<ClientTransactionFx> tableView;
    @FXML private TableColumn<ClientTransactionFx, BigDecimal> amountColumn;
    @FXML private TableColumn<ClientTransactionFx, LocalDate> dateColumn;
    @FXML private TableColumn<ClientTransactionFx, LocalTime> timeColumn;
    @FXML private TableColumn<ClientTransactionFx, String> typeOfTransactionColumn;
    @FXML private TableColumn<ClientTransactionFx, String> secondPartyAccountNumberColumn;
    @FXML private TableColumn<ClientTransactionFx, String> secondPartyFirstNameColumn;
    @FXML private TableColumn<ClientTransactionFx, String> secondPartyLastNameColumn;

    private ControllFx controllFx;

    public void setControllFx(ControllFx controllFx) {
        this.controllFx = controllFx;
        tableView.setItems(controllFx.getClientTransactionFxObservableList());
        initializeTable(controllFx);
    }

    public void initializeTable(ControllFx controllFx) {
        tableView.setPrefHeight(440);
        tableView.setPrefWidth(1100);
        tableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

        amountColumn.setCellValueFactory(cellData -> cellData.getValue().amountProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().transactionDateProperty());
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().transactionTimeProperty());
        typeOfTransactionColumn.setCellValueFactory(cellData -> cellData.getValue().transactionTypeProperty());
        secondPartyAccountNumberColumn.setCellValueFactory(cellData->cellData.getValue().secondPartyAccountNumberProperty());
        secondPartyFirstNameColumn.setCellValueFactory(cellData->cellData.getValue().secondPartyFirstNameProperty());
        secondPartyLastNameColumn.setCellValueFactory(cellData->cellData.getValue().secondPartyLastNameProperty());

        filtrAndSearch(controllFx);
    }

    private void filtrAndSearch(ControllFx controllFx) {
        FilteredList<ClientTransactionFx> filteredData = new FilteredList<ClientTransactionFx>(controllFx.getClientTransactionFxObservableList(), c -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(transaction -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                if (transaction.getTransactionDate().toString().contains(newValue)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<ClientTransactionFx> sortedData = new SortedList<ClientTransactionFx>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }
}
