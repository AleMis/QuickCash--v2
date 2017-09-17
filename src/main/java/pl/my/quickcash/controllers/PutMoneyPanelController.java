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

public class PutMoneyPanelController {

    private ClientKey clientKey;
    private FileManager fileManager = new FileManager();

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    @FXML
    private Pane putMoneyPane;

    @FXML
    private TextField amountTextField;

    @FXML
    private Label statusLabel;

    @FXML
    private Button putMoneyButton;

    @FXML
    public void putMoney() {
        if (getAmount().equals(0.0) || getAmount().equals(null)) {
            statusLabel.setText("Put the amount!");
        } else {
            updateClientAccountBalance(getClientKey(), getAmount());
            fileManager.writeDatabaseToFile();
            statusLabel.setText("Transfer completed!");
        }
    }

    public Double getAmount() {
        Double amountToTransfer = Double.parseDouble(amountTextField.getText());
        return amountToTransfer;
    }


    public void updateClientAccountBalance(ClientKey clientKey, Double amount) {
        for(Map.Entry<ClientKey, ClientData> entry : ClientsDatabase.getInstance().entrySet()) {
            if(entry.getKey().equals(clientKey)) {
                entry.getValue().getClientAccounts().setAccountBalance(entry.getValue().getClientAccounts().getAccountBalance() - amount);
            }
        }
    }
}
