package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.my.quickcash.data.client.ClientData;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientsDatabase;
import pl.my.quickcash.datamanagement.FileManager;

import java.math.BigDecimal;
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
    public void withdrawMoney() {
            checkAccountBalance(getClientKey());
    }

    public BigDecimal getAmount() {
        BigDecimal amountToTransfer = new BigDecimal(amountTextField.getText()).setScale(2, BigDecimal.ROUND_CEILING);
        return amountToTransfer;
    }

    public void checkAccountBalance(ClientKey clientKey) {
        BigDecimal accountBalance = ClientsDatabase.getInstance().get(clientKey).getClientAccounts().getAccountBalance();
        BigDecimal noMoney = new BigDecimal(0.00);
        int result = accountBalance.compareTo(getAmount());

        if(accountBalance.equals(noMoney)) {
            statusLabel.setText("Account Balance equal 0.00 PLN");
        }else if (result == -1) {
            statusLabel.setText("Not enough funds on your account!" + "\n Account Balance: " + accountBalance + " PLN");
        }else {
            updateClientAccountBalance(clientKey, getAmount());
            fileManager.writeDatabaseToFile();
            statusLabel.setText("Transfer completed!");
        }

    }

    public void updateClientAccountBalance(ClientKey clientKey, BigDecimal amount) {
        for(Map.Entry<ClientKey, ClientData> entry : ClientsDatabase.getInstance().entrySet()) {
            if(entry.getKey().equals(clientKey)) {
                entry.getValue().getClientAccounts().setAccountBalance(entry.getValue().getClientAccounts()
                        .getAccountBalance().subtract(amount));
            }
        }
    }
}
