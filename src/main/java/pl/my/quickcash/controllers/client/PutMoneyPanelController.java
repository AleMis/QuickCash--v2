package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.ClientAccount;
import pl.my.quickcash.data.client.ClientKey;
import java.math.BigDecimal;

public class PutMoneyPanelController {

    @FXML private TextField amountTextField;
    @FXML private Label statusLabel;

    private static final String UPDATE_CLIENT_ACCOUNT = "ClientAccount.updateClientAccountBalance";
    private static final String SELECT_CLIENT_ACCUNT = "ClientAccount.selectClientAccount";

    private ClientKey clientKey;

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    @FXML
    public void putMoney() {
        ClientAccount account = CommunicationDAO.selectById(SELECT_CLIENT_ACCUNT, getClientKey().getClient_key_id());

        BigDecimal balance = account.getAccountBalance();

        if ((getAmount().compareTo(BigDecimal.ZERO) ==0) || getAmount().equals(null)) {
            statusLabel.setText("Put the amount!");
        } else {
            BigDecimal acctualBalance = balance.add(getAmount()).setScale(2, BigDecimal.ROUND_CEILING);
            account.setAccountBalance(acctualBalance);
            CommunicationDAO.update(UPDATE_CLIENT_ACCOUNT,account);
            statusLabel.setText("Transfer completed!");
        }
    }

    public BigDecimal getAmount() {
        BigDecimal amountToTransfer = new BigDecimal(amountTextField.getText()).setScale(2, BigDecimal.ROUND_CEILING);
        return amountToTransfer;
    }
}
