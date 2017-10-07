package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.my.quickcash.data.client.ClientData;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientsDatabase;
import pl.my.quickcash.datamanagement.FileManager;

import java.math.BigDecimal;
import java.util.Map;

public class MakeTransferPanelController {

    private ClientKey clientKey;
    private FileManager fileManager = new FileManager();
    private ClientMainPanelController clientMainPanelController;



    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

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
        if(!checkAccountNumber()) {
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

    public BigDecimal getAmountToTransfer() {
        BigDecimal amountToTransfer = new BigDecimal(amountTextField.getText()).setScale(2, BigDecimal.ROUND_CEILING);
        return amountToTransfer;
    }

    public boolean checkAccountNumber() {
        boolean check = false;
        String accountNumberToCheck = getAccountNumber();
        for(Map.Entry<ClientKey, ClientData> entry : ClientsDatabase.getInstance().entrySet()) {
            if(entry.getValue().getClientAccounts().getAccountNumber().equals(accountNumberToCheck)) {
                check = true;
            }
        }
        return check;
    }

    public void checkAccountBalance(ClientKey clientKey) {
        BigDecimal accountBalance = ClientsDatabase.getInstance().get(clientKey).getClientAccounts().getAccountBalance();
        BigDecimal noMoney = new BigDecimal(0.00);
        int result = accountBalance.compareTo(getAmountToTransfer());

        if(accountBalance.equals(noMoney)) {
            statusLabel.setText("Account Balance equal 0.00 PLN");
        }else if (result == -1) {
            statusLabel.setText("Not enough funds on your account!" + "\n Account Balance: " + accountBalance + " PLN");
        }else {
            updateClientAccountBalance(clientKey, getAmountToTransfer());
            updateSecondPartyAccountBalance(getAccountNumber(), getAmountToTransfer());
            statusLabel.setText("Transfer completed!");
        }
    }

    public void updateClientAccountBalance(ClientKey clientKey, BigDecimal amount) {
        for(Map.Entry<ClientKey, ClientData> entry : ClientsDatabase.getInstance().entrySet()) {
            if(entry.getKey().equals(clientKey)) {
                entry.getValue().getClientAccounts().setAccountBalance(entry.getValue()
                        .getClientAccounts().getAccountBalance().subtract(amount));
            }
        }
    }

    public void updateSecondPartyAccountBalance(String accountNumber, BigDecimal amount) {
        for(Map.Entry<ClientKey, ClientData> entry : ClientsDatabase.getInstance().entrySet()) {
            if(entry.getValue().getClientAccounts().getAccountNumber().equals(accountNumber)) {
                entry.getValue().getClientAccounts().setAccountBalance(entry.getValue()
                        .getClientAccounts().getAccountBalance().add(amount));
            }
        }
    }



}
