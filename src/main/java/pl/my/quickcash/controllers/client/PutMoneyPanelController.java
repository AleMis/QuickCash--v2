package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import pl.my.quickcash.dao.MyBatisConnectionFactory;
import pl.my.quickcash.dao.clients.ClientAccountDAO;
import pl.my.quickcash.data.client.ClientAccount;
import pl.my.quickcash.data.client.ClientData;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientsDatabase;
import pl.my.quickcash.datamanagement.FileManager;

import java.math.BigDecimal;
import java.util.Map;

public class PutMoneyPanelController {

    @FXML private Pane putMoneyPane;
    @FXML private TextField amountTextField;
    @FXML private Label statusLabel;
    @FXML private Button putMoneyButton;

    private ClientKey clientKey;
    private FileManager fileManager = new FileManager();

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
