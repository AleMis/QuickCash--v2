package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.my.quickcash.controllers.general.Start;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.*;
import pl.my.quickcash.dialogs.DialogUtils;

import java.io.IOException;
import java.math.BigDecimal;

public class MakeTransferPanelController {

    @FXML private TextField accountNumberTextField;
    @FXML private TextField amountTextField;
    @FXML private Label statusLabel;

    private static final String UPDATE_CLIENT_ACCOUNT = "ClientAccount.updateClientAccountBalance";
    private static final String SELECT_CLIENT_ACCOUNT_BY_ACCOUNT_NUMBER = "ClientAccount.selectClientAccountByAccountNumber";
    private static final String SELECT_CLIENT_PERSONAL_DATA_BY_ID = "ClientPersonalData.selectClientPersonalData";
    private static final String SELECT_CLIENT_ACCOUNT = "ClientAccount.selectClientAccount";
    private static final String SAVE_TRANSACTION = "ClientTransaction.saveTransfer";
    private static final String TRANSACTION_TYPE_TRANSFER_TO_SECOND_PARTY = "Transfer to second party";
    private static final String INCORRECT_ACCOUNT_NUMBER = "Incorrect account number, please try again!";
    private static final String ACCOUNT_BALANCE_0_PLN = "Account Balance equal PLN 0.00";
    private static final String ACCOUNT_BALANCE = "Account Balance equal PLN ";
    private static final String NOT_ENOUGH_FUNDS = "Not enough funds on your account!";

    private UpdateAccountBalance  updateAccountBalance = new UpdateAccountBalance();
    private ClientKey clientKey;
    private ClientTransaction clientTransaction;
    private ClientMainPanelController clientMainPanelController;

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    public ClientTransaction getClientTransaction() {
        return clientTransaction;
    }

    public void setClientTransaction(ClientTransaction clientTransaction) {
        this.clientTransaction = clientTransaction;
    }

    public void initialize() {

    }

    @FXML
    public void makeTransfer() {
        if(!checkAccountNumber()) {
                statusLabel.setText(INCORRECT_ACCOUNT_NUMBER);
         }else {
              checkAccountBalance();
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
        ClientAccount clientAccount = CommunicationDAO.selectByObject(SELECT_CLIENT_ACCOUNT_BY_ACCOUNT_NUMBER, getAccountNumber());
        boolean check = false;
        if(clientAccount.getAccountNumber() != null) {
            check = true;
        }
        return check;
    }

    public void checkAccountBalance() {
        ClientAccount client = CommunicationDAO.selectById(SELECT_CLIENT_ACCOUNT, getClientKey().getClientKeyId());
        ClientAccount secondParty = CommunicationDAO.selectByObject(SELECT_CLIENT_ACCOUNT_BY_ACCOUNT_NUMBER, getAccountNumber());

        BigDecimal clientBalance = client.getAccountBalance();
        BigDecimal secondPartyBalance = secondParty.getAccountBalance();

        BigDecimal noMoney = new BigDecimal(0.00);

        int result = clientBalance.compareTo(getAmountToTransfer());

        if(clientBalance.equals(noMoney)) {
            statusLabel.setText(ACCOUNT_BALANCE_0_PLN);
        }else if (result == -1) {
            statusLabel.setText(NOT_ENOUGH_FUNDS + "/n" + ACCOUNT_BALANCE +  clientBalance);
        }else if(client.getAccountNumber().equals(accountNumberTextField.getText())) {
            DialogUtils.dialogTheSameAccountNumber();
        }else {
            BigDecimal clientAcctualBalance = clientBalance.subtract(getAmountToTransfer());
            client.setAccountBalance(clientAcctualBalance);
            CommunicationDAO.update(UPDATE_CLIENT_ACCOUNT, client);

            BigDecimal secondPartyAcctualBalance = secondPartyBalance.add(getAmountToTransfer());
            secondParty.setAccountBalance(secondPartyAcctualBalance);
            CommunicationDAO.update(UPDATE_CLIENT_ACCOUNT,secondParty);

            ClientPersonalData receiverPersonalData = CommunicationDAO.selectById(SELECT_CLIENT_PERSONAL_DATA_BY_ID,secondParty.getClientKeyId());

            ClientTransaction transaction = new ClientTransaction();
            clientTransaction = transaction.createTransactionForTransfer(getAmountToTransfer(), client, secondParty, TRANSACTION_TYPE_TRANSFER_TO_SECOND_PARTY, receiverPersonalData);
            saveTransaction(clientTransaction);
            updateAccountBalance.updateAccountBalance(getClientKey());
            DialogUtils.dialogTransferCompleted();

        }
    }

    private void saveTransaction(ClientTransaction clientTransaction) {
        CommunicationDAO.insert(SAVE_TRANSACTION, clientTransaction);
    }
}
