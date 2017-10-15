package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.my.quickcash.dao.MyBatisConnectionFactory;
import pl.my.quickcash.dao.clients.ClientAccountDAO;
import pl.my.quickcash.data.client.ClientAccount;
import pl.my.quickcash.data.client.ClientData;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientsDatabase;
import pl.my.quickcash.datamanagement.FileManager;

import java.math.BigDecimal;
import java.util.Map;

public class MakeTransferPanelController {

    @FXML private TextField accountNumberTextField;
    @FXML private TextField amountTextField;
    @FXML private Label statusLabel;

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
        ClientAccountDAO clientAccountDAO = new ClientAccountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        ClientAccount clientAccount = clientAccountDAO.selectClientAccountByAccountNumber(getAccountNumber());
        boolean check = false;
        if(!clientAccount.getAccountNumber().equals(null)) {
            check = true;
        }
        return check;
    }

    public void checkAccountBalance() {
        ClientAccountDAO clientAccountDAO = new ClientAccountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        ClientAccount payer = clientAccountDAO.selectClientAccount(getClientKey().getClient_key_id());
        ClientAccount reciever = clientAccountDAO.selectClientAccountByAccountNumber(getAccountNumber());

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
            clientAccountDAO.updateClientAccountBalance(payer);

            BigDecimal recieverAcctualBalance = recieverBalance.add(getAmountToTransfer());
            reciever.setAccountBalance(recieverAcctualBalance);
            clientAccountDAO.updateClientAccountBalance(reciever);

            statusLabel.setText("Transfer completed!");
        }
    }
}
