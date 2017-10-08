package pl.my.quickcash.controllers.modelfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;

public class ClientAccountFx {

    private ObjectProperty<BigDecimal> accountBalance = new SimpleObjectProperty<>();
    private SimpleStringProperty accountNumber = new SimpleStringProperty();


    public BigDecimal getAccountBalance() {
        return accountBalance.get();
    }

    public ObjectProperty<BigDecimal> accountBalanceProperty() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance.set(accountBalance);
    }

    public String getAccountNumber() {
        return accountNumber.get();
    }

    public SimpleStringProperty accountNumberProperty() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.set(accountNumber);
    }

    @Override
    public String toString() {
        return accountBalance + "" + accountNumber;
    }
}
