package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.ClientAccount;
import pl.my.quickcash.data.client.ClientKey;
import java.math.BigDecimal;

public class MakeTransferPanelController {

    @FXML private TextField accountNumberTextField;
    @FXML private TextField amountTextField;
    @FXML private Label statusLabel;

    private static final String UPDATE_CLIENT_ACCOUNT = "ClientAccount.updateClientAccountBalance";
    private static final String SELECT_CLIENT_ACCOUNT_BY_ACCOUNT_NUMBER = "ClientAccount.selectClientAccountByAccountNumber";
    private static final String SELECT_CLIENT_ACCUNT = "ClientAccount.selectClientAccount";

    private ClientKey clientKey;
    private ClientMainPanelController clientMainPanelController;

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    public void initialize() {

    }

    @FXML
    public void makeTransfer() {
        if(!checkAccountNumber()) {
                statusLabel.setText("Incorrect account number, please try again!");
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
        ClientAccount clientAccount = (ClientAccount) CommunicationDAO.selectByObject(SELECT_CLIENT_ACCOUNT_BY_ACCOUNT_NUMBER, getAccountNumber());
        boolean check = false;
        if(!clientAccount.getAccountNumber().equals(null)) {
            check = true;
        }
        return check;
    }

    public void checkAccountBalance() {
        ClientAccount payer = (ClientAccount) CommunicationDAO.selectById(SELECT_CLIENT_ACCUNT, getClientKey().getClient_key_id());
        ClientAccount reciever = (ClientAccount) CommunicationDAO.selectByObject(SELECT_CLIENT_ACCOUNT_BY_ACCOUNT_NUMBER, getAccountNumber());

        BigDecimal payerBalance = payer.getAccountBalance();
        BigDecimal recieverBalance = reciever.getAccountBalance();

        BigDecimal noMoney = new BigDecimal(0.00);

        int result = payerBalance.compareTo(getAmountToTransfer());

        if(payerBalance.equals(noMoney)) {
            statusLabel.setText("Account Balance equal 0.00 PLN");
        }else if (result == -1) {
            statusLabel.setText("Not enough funds on your account!" + "\n Account Balance: " + payerBalance + " PLN");
        }else {
            BigDecimal payerAcctualBalance = payerBalance.subtract(getAmountToTransfer());
            payer.setAccountBalance(payerAcctualBalance);
            CommunicationDAO.update(UPDATE_CLIENT_ACCOUNT, payer);

            BigDecimal recieverAcctualBalance = recieverBalance.add(getAmountToTransfer());
            reciever.setAccountBalance(recieverAcctualBalance);
            CommunicationDAO.update(UPDATE_CLIENT_ACCOUNT,reciever);

            statusLabel.setText("Transfer completed!");
        }
    }
}
