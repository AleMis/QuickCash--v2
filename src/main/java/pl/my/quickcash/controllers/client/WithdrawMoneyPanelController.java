package pl.my.quickcash.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.ClientAccount;
import pl.my.quickcash.data.client.ClientKey;

import java.math.BigDecimal;

public class WithdrawMoneyPanelController {
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
    public void withdrawMoney() {
        checkAccountBalance();
    }

    public BigDecimal getAmount() {
        BigDecimal amountToTransfer = new BigDecimal(amountTextField.getText()).setScale(2, BigDecimal.ROUND_CEILING);
        return amountToTransfer;
    }

    public void checkAccountBalance() {
        ClientAccount payer = (ClientAccount) CommunicationDAO.selectById(SELECT_CLIENT_ACCUNT, getClientKey().getClient_key_id());

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
            CommunicationDAO.update(UPDATE_CLIENT_ACCOUNT, payer);
            statusLabel.setText("Transfer completed!");
        }
    }
}
