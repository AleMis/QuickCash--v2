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

public class WithdrawMoneyPanelController {
    private ClientKey clientKey;
    private FileManager fileManager = new FileManager();

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    @FXML
    private TextField amountTextField;

    @FXML
    private Label statusLabel;

    @FXML
    private Button wihdrawMoneyButton;

    @FXML
    public void witdrawMoney() {
        if (getAmount().equals(0.0) || getAmount().equals(null)) {
            statusLabel.setText("Put the amount!");
        } else {
            checkAccountBalance(getClientKey());
            fileManager.writeDatabaseToFile();
        }
    }

    public Double getAmount() {
        Double amountToTransfer = Double.parseDouble(amountTextField.getText());
        return amountToTransfer;
    }

    public void checkAccountBalance(ClientKey clientKey) {
        Double accountBalance = ClientsDatabase.getInstance().get(clientKey).getClientAccounts().getAccountBalance();
        if(accountBalance == 0.0) {
            statusLabel.setText("Account Balance equal 0.0 PLN");
        }else if (accountBalance.equals(getAmount()) || accountBalance < getAmount()) {
            statusLabel.setText("You could transfer only " + accountBalance + " PLN");
        }else {
            updateClientAccountBalance(clientKey, getAmount());
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
}
