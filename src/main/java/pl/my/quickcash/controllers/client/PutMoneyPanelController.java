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

public class PutMoneyPanelController {

    @FXML private TextField amountTextField;
    @FXML private Label statusLabel;

    private static final String UPDATE_CLIENT_ACCOUNT = "ClientAccount.updateClientAccountBalance";
    private static final String SELECT_CLIENT_ACCUNT = "ClientAccount.selectClientAccount";
    private static final String SAVE_TRANSACTION = "ClientTransaction.savePutAndWithdrawMoney";
    private static final String TRANSACTION_TYPE_PUT_MONEY = "Put money";

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
    public void putMoney() {
        ClientAccount client = CommunicationDAO.selectById(SELECT_CLIENT_ACCUNT, getClientKey().getClientKeyId());
        BigDecimal balance = client.getAccountBalance();

        if ((getAmount().compareTo(BigDecimal.ZERO) ==0) || getAmount() == null) {
            statusLabel.setText("Put the amount!");
        } else {
            BigDecimal acctualBalance = balance.add(getAmount());
            client.setAccountBalance(acctualBalance);
            CommunicationDAO.update(UPDATE_CLIENT_ACCOUNT,client);

            ClientTransaction transaction = new ClientTransaction();
            clientTransaction = transaction.createTransactionForPutAndWithdrawMoney(getAmount(),client,TRANSACTION_TYPE_PUT_MONEY);
            saveTransaction(clientTransaction);
            DialogUtils.dialogTransferCompleted();
        }
    }

    public BigDecimal getAmount() {
        BigDecimal amountToTransfer = new BigDecimal(amountTextField.getText()).setScale(2, BigDecimal.ROUND_CEILING);
        return amountToTransfer;
    }

    private void saveTransaction(ClientTransaction clientTransaction) {
        CommunicationDAO.insert(SAVE_TRANSACTION, clientTransaction);
    }
}
