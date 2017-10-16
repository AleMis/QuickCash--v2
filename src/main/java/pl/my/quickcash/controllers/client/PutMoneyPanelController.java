package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import pl.my.quickcash.dao.MyBatisConnectionFactory;
import pl.my.quickcash.dao.clients.ClientAccountDAO;
import pl.my.quickcash.data.client.ClientAccount;
import pl.my.quickcash.data.client.ClientKey;
import java.math.BigDecimal;

public class PutMoneyPanelController {

    @FXML private TextField amountTextField;
    @FXML private Label statusLabel;

    private ClientKey clientKey;

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    @FXML
    public void putMoney() {
        ClientAccountDAO clientAccountDAO = new ClientAccountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        ClientAccount account = clientAccountDAO.selectClientAccount(getClientKey().getClient_key_id());
        BigDecimal balance = account.getAccountBalance();

        if (getAmount().equals("0.00") || getAmount().equals(null)) {
            statusLabel.setText("Put the amount!");
        } else {
            BigDecimal acctualBalance = balance.add(getAmount()).setScale(2, BigDecimal.ROUND_CEILING);
            account.setAccountBalance(acctualBalance);
            clientAccountDAO.updateClientAccountBalance(account);
            statusLabel.setText("Transfer completed!");
        }
    }

    public BigDecimal getAmount() {
        BigDecimal amountToTransfer = new BigDecimal(amountTextField.getText()).setScale(2, BigDecimal.ROUND_CEILING);
        return amountToTransfer;
    }
}
