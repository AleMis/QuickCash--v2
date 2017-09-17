package pl.my.quickcash.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import pl.my.quickcash.data.ClientData;
import pl.my.quickcash.data.ClientKey;
import pl.my.quickcash.data.ClientsDatabase;
import pl.my.quickcash.dataloading.FileManager;

import java.util.Map;

public class MakeTransferPanelController {

    private ClientKey clientKey;
    private FileManager fileManager = new FileManager();

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    @FXML
    private Pane makeTransferPane;

    @FXML
    private TextField accountNumberTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private Label statusLabel;


    public void initialize() {

    }

    @FXML
    public void makeTransfer() {
        ClientKey clientKey = getClientKey();
        if(checkAccountNumber()) {
                statusLabel.setText("Incorrect account number, please try again!");
         }else {
              checkAccountBalance(clientKey);
              fileManager.writeDatabaseToFile();
         }

    }

    public String getAccountNumber() {
        String accountNumber = accountNumberTextField.getText();
        return accountNumber;
    }

    public Double getAmountToTransfer() {
        Double amountToTransfer = Double.parseDouble(amountTextField.getText());
        return amountToTransfer;
    }

    public boolean checkAccountNumber() {
        boolean check = false;
        String accountNumberToCheck = getAccountNumber();
        for(Map.Entry<ClientKey, ClientData> entry : ClientsDatabase.getInstance().entrySet()) {
            if(entry.getValue().getClientAccounts().getAccountBalance().equals(accountNumberToCheck)) {
                check = true;
            }
        }
        return check;
    }

    public void checkAccountBalance(ClientKey clientKey) {
        Double accountBalance = ClientsDatabase.getInstance().get(clientKey).getClientAccounts().getAccountBalance();
        if(accountBalance == 0.0) {
            statusLabel.setText("Account Balance equal 0.0 PLN");
        }else if (accountBalance.equals(getAmountToTransfer()) || accountBalance < getAmountToTransfer()) {
                statusLabel.setText("You could transfer only " + accountBalance + " PLN");
        }else {
            updateClientAccountBalance(clientKey, getAmountToTransfer());
            updateSecondPartyAccountBalance(getAccountNumber(), getAmountToTransfer());
            statusLabel.setText("Transfer completed!");
        }

    }

    public void updateClientAccountBalance(ClientKey clientKey, Double amount) {
        for(Map.Entry<ClientKey, ClientData> entry : ClientsDatabase.getInstance().entrySet()) {
            if(entry.getKey().equals(clientKey)) {
                entry.getValue().getClientAccounts().setAccountBalance(entry.getValue().getClientAccounts().getAccountBalance() - amount);
            }
        }
    }

    public void updateSecondPartyAccountBalance(String accountNumber, Double amount) {
        for(Map.Entry<ClientKey, ClientData> entry : ClientsDatabase.getInstance().entrySet()) {
            if(entry.getValue().getClientAccounts().getAccountNumber().equals(accountNumber)) {
                entry.getValue().getClientAccounts().setAccountBalance(entry.getValue().getClientAccounts().getAccountBalance() + amount);
            }
        }
    }



}
