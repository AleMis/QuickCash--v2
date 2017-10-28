package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.ClientAccount;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientTransaction;
import pl.my.quickcash.dialogs.DialogUtils;

import java.math.BigDecimal;

public class WithdrawMoneyPanelController {
    @FXML private TextField amountTextField;
    @FXML private Label statusLabel;

    private static final String UPDATE_CLIENT_ACCOUNT = "ClientAccount.updateClientAccountBalance";
    private static final String SELECT_CLIENT_ACCUNT = "ClientAccount.selectClientAccount";
    private static final String SAVE_TRANSACTION = "ClientTransaction.savePutAndWithdrawMoney";
    private static final String TRANSACTION_TYPE_WITHDRAW_MONEY = "Withdraw money";
    private static final String ACCOUNT_BALANCE_0_PLN = "Account Balance equal PLN 0.00";
    private static final String ACCOUNT_BALANCE = "Account Balance equal PLN ";
    private static final String NOT_ENOUGH_FUNDS = "Not enough funds on your account!";

    private ClientKey clientKey;
    private ClientTransaction clientTransaction;

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

    @FXML
    public void withdrawMoney() {
        checkAccountBalance();
    }

    public BigDecimal getAmount() {
        BigDecimal amountToTransfer = new BigDecimal(amountTextField.getText());
        return amountToTransfer;
    }

    public void checkAccountBalance() {
        ClientAccount client = CommunicationDAO.selectById(SELECT_CLIENT_ACCUNT, getClientKey().getClientKeyId());

        BigDecimal payerBalance = client.getAccountBalance();
        BigDecimal noMoney = new BigDecimal(0.00);

        int result = payerBalance.compareTo(getAmount());

        if(payerBalance.equals(noMoney)) {
            statusLabel.setText(ACCOUNT_BALANCE_0_PLN);
        }else if (result == -1) {
            statusLabel.setText(NOT_ENOUGH_FUNDS + ACCOUNT_BALANCE + payerBalance);
        }else {
            BigDecimal payerAcctualBalance = payerBalance.subtract(getAmount());
            client.setAccountBalance(payerAcctualBalance);
            CommunicationDAO.update(UPDATE_CLIENT_ACCOUNT, client);

            ClientTransaction transaction = new ClientTransaction();
            clientTransaction = transaction.createTransactionForPutAndWithdrawMoney(getAmount(),client, TRANSACTION_TYPE_WITHDRAW_MONEY);
            saveTransaction(clientTransaction);

            DialogUtils.dialogTransferCompleted();
        }
    }

    private void saveTransaction(ClientTransaction clientTransaction) {
        CommunicationDAO.insert(SAVE_TRANSACTION, clientTransaction);
    }
}
