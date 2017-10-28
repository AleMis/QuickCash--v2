package pl.my.quickcash.controllers.modelfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;

public class ClientTransactionFx {

    private ObjectProperty<BigDecimal> amount = new SimpleObjectProperty<>();
    private SimpleStringProperty clientAccountNumber = new SimpleStringProperty();
    private SimpleStringProperty secondPartyAccountNumber = new SimpleStringProperty();
    private SimpleStringProperty transactionType = new SimpleStringProperty();
    private ObjectProperty<LocalDate> transactionDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalTime> transactionTime = new SimpleObjectProperty<>();
    private ObjectProperty<BigInteger> clientKeyId = new SimpleObjectProperty<>();
    private ObjectProperty<BigInteger> secondPartyKeyId = new SimpleObjectProperty<>();
    private SimpleStringProperty secondPartyFirstName = new SimpleStringProperty();
    private SimpleStringProperty secondPartyLastName = new SimpleStringProperty();

    public BigDecimal getAmount() {
        return amount.get();
    }

    public ObjectProperty<BigDecimal> amountProperty() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount.set(amount);
    }

    public String getClientAccountNumber() {
        return clientAccountNumber.get();
    }

    public SimpleStringProperty clientAccountNumberProperty() {
        return clientAccountNumber;
    }

    public void setClientAccountNumber(String clientAccountNumber) {
        this.clientAccountNumber.set(clientAccountNumber);
    }

    public String getSecondPartyAccountNumber() {
        return secondPartyAccountNumber.get();
    }

    public SimpleStringProperty secondPartyAccountNumberProperty() {
        return secondPartyAccountNumber;
    }

    public void setSecondPartyAccountNumber(String secondPartyAccountNumber) {
        this.secondPartyAccountNumber.set(secondPartyAccountNumber);
    }

    public String getTransactionType() {
        return transactionType.get();
    }

    public SimpleStringProperty transactionTypeProperty() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType.set(transactionType);
    }

    public LocalDate getTransactionDate() {
        return transactionDate.get();
    }

    public ObjectProperty<LocalDate> transactionDateProperty() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate.set(transactionDate);
    }

    public LocalTime getTransactionTime() {
        return transactionTime.get();
    }

    public ObjectProperty<LocalTime> transactionTimeProperty() {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime.set(transactionTime);
    }

    public BigInteger getClientKeyId() {
        return clientKeyId.get();
    }

    public ObjectProperty<BigInteger> clientKeyIdProperty() {
        return clientKeyId;
    }

    public void setClientKeyId(BigInteger clientKeyId) {
        this.clientKeyId.set(clientKeyId);
    }

    public BigInteger getSecondPartyKeyId() {
        return secondPartyKeyId.get();
    }

    public ObjectProperty<BigInteger> secondPartyKeyIdProperty() {
        return secondPartyKeyId;
    }

    public void setSecondPartyKeyId(BigInteger secondPartyKeyId) {
        this.secondPartyKeyId.set(secondPartyKeyId);
    }

    public String getSecondPartyFirstName() {
        return secondPartyFirstName.get();
    }

    public SimpleStringProperty secondPartyFirstNameProperty() {
        return secondPartyFirstName;
    }

    public void setSecondPartyFirstName(String secondPartyFirstName) {
        this.secondPartyFirstName.set(secondPartyFirstName);
    }

    public String getSecondPartyLastName() {
        return secondPartyLastName.get();
    }

    public SimpleStringProperty secondPartyLastNameProperty() {
        return secondPartyLastName;
    }

    public void setSecondPartyLastName(String secondPartyLastName) {
        this.secondPartyLastName.set(secondPartyLastName);
    }

    @Override
    public String toString() {
        return amount + "; " + clientAccountNumber + "; " + secondPartyAccountNumber + "; " + transactionType +
                "; " + transactionDate + "; " + transactionTime + "; " + clientKeyId + "; " + secondPartyKeyId +
                "; " + secondPartyFirstName + "; " + secondPartyLastName;
    }
}
