package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

public class WithdrawMoneyPanelController {
    @FXML private TextField amountTextField;
    @FXML private Label statusLabel;
    @FXML private Button wihdrawMoneyButton;

    private ClientKey clientKey;

    public ClientKey getClientKey() {
        return clientKey;
    }

    public void setClientKey(ClientKey clientKey) {
        this.clientKey = clientKey;
    }

    @FXML
    public void withdrawMoney() {
        checkAccountBalance();
    }

    public BigDecimal getAmount() {
        BigDecimal amountToTransfer = new BigDecimal(amountTextField.getText()).setScale(2, BigDecimal.ROUND_CEILING);
        return amountToTransfer;
    }

    public void checkAccountBalance() {
        ClientAccountDAO clientAccountDAO = new ClientAccountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        ClientAccount payer = clientAccountDAO.selectClientAccount(getClientKey().getClient_key_id());

        BigDecimal payerBalance = payer.getAccountBalance();
        BigDecimal noMoney = new BigDecimal(0.00);

        int result = payerBalance.compareTo(getAmount());

        if(payerBalance.equals(noMoney)) {
            statusLabel.setText("Account Balance equal 0.00 PLN");
        }else if (result == -1) {
            statusLabel.setText("Not enough funds on your account!" + "\n Account Balance: " + payerBalance + " PLN");
        }else {
            BigDecimal payerAcctualBalance = payerBalance.subtract(getAmount());
            payer.setAccountBalance(payerAcctualBalance);
            clientAccountDAO.updateClientAccountBalance(payer);

            statusLabel.setText("Transfer completed!");
        }
    }
}
