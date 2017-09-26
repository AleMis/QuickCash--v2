package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import pl.my.quickcash.data.client.ClientData;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientsDatabase;
import pl.my.quickcash.datamanagement.FileManager;

import java.math.BigDecimal;
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
        if (getAmount().equals("0.00") || getAmount().equals(null)) {
            statusLabel.setText("Put the amount!");
        } else {
            updateClientAccountBalance(getClientKey(), getAmount());
            fileManager.writeDatabaseToFile();
            statusLabel.setText("Transfer completed!");
        }
    }

    public BigDecimal getAmount() {
        BigDecimal amountToTransfer = new BigDecimal(amountTextField.getText()).setScale(2, BigDecimal.ROUND_CEILING);
        return amountToTransfer;
    }


    public void updateClientAccountBalance(ClientKey clientKey, BigDecimal amount) {
        for(Map.Entry<ClientKey, ClientData> entry : ClientsDatabase.getInstance().entrySet()) {
            if(entry.getKey().equals(clientKey)) {
                entry.getValue().getClientAccounts().setAccountBalance(entry.getValue().getClientAccounts().getAccountBalance().add(amount));
            }
        }
    }
}
