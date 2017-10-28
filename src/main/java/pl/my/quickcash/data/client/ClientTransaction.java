package pl.my.quickcash.data.client;

import pl.my.quickcash.dao.CommunicationDAO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ClientTransaction {

    private static final String SELECT_CLIENT_TRANSACTIONS = "ClientTransaction.selectAll";

    private BigDecimal amount;
    private String clientAccountNumber;
    private String secondPartyAccountNumber;
    private String transactionType;
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private BigInteger clientKeyId;
    private BigInteger secondPartyKeyId;
    private String secondPartyFirstName;
    private String secondPartyLastName;

    private static List<ClientTransaction> list = new ArrayList<>();

    public ClientTransaction(BigDecimal amount, String clientAccountNumber, String secondPartyAccountNumber, String transactionType, LocalDate transactionDate, LocalTime transactionTime, BigInteger clientKeyId, BigInteger secondPartyKeyId, String secondPartyFirstName, String secondPartyLastName) {
        this.amount = amount;
        this.clientAccountNumber = clientAccountNumber;
        this.secondPartyAccountNumber = secondPartyAccountNumber;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.clientKeyId = clientKeyId;
        this.secondPartyKeyId = secondPartyKeyId;
        this.secondPartyFirstName = secondPartyFirstName;
        this.secondPartyLastName = secondPartyLastName;
    }

    public ClientTransaction() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getClientAccountNumber() {
        return clientAccountNumber;
    }

    public void setClientAccountNumber(String clientAccountNumber) {
        this.clientAccountNumber = clientAccountNumber;
    }

    public String getSecondPartyAccountNumber() {
        return secondPartyAccountNumber;
    }

    public void setSecondPartyAccountNumber(String secondPartyAccountNumber) {
        this.secondPartyAccountNumber = secondPartyAccountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public BigInteger getClientKeyId() {
        return clientKeyId;
    }

    public void setClientKeyId(BigInteger clientKeyId) {
        this.clientKeyId = clientKeyId;
    }

    public BigInteger getSecondPartyKeyId() {
        return secondPartyKeyId;
    }

    public void setSecondPartyKeyId(BigInteger secondPartyKeyId) {
        this.secondPartyKeyId = secondPartyKeyId;
    }

    public String getSecondPartyFirstName() {
        return secondPartyFirstName;
    }

    public void setSecondPartyFirstName(String secondPartyFirstName) {
        this.secondPartyFirstName = secondPartyFirstName;
    }

    public String getSecondPartyLastName() {
        return secondPartyLastName;
    }

    public void setSecondPartyLastName(String secondPartyLastName) {
        this.secondPartyLastName = secondPartyLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientTransaction that = (ClientTransaction) o;

        if (!amount.equals(that.amount)) return false;
        if (!clientAccountNumber.equals(that.clientAccountNumber)) return false;
        if (!secondPartyAccountNumber.equals(that.secondPartyAccountNumber)) return false;
        if (!transactionType.equals(that.transactionType)) return false;
        if (!transactionDate.equals(that.transactionDate)) return false;
        if (!transactionTime.equals(that.transactionTime)) return false;
        if (!clientKeyId.equals(that.clientKeyId)) return false;
        if (!secondPartyKeyId.equals(that.secondPartyKeyId)) return false;
        if (!secondPartyFirstName.equals(that.secondPartyFirstName)) return false;
        return secondPartyLastName.equals(that.secondPartyLastName);
    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + clientAccountNumber.hashCode();
        result = 31 * result + secondPartyAccountNumber.hashCode();
        result = 31 * result + transactionType.hashCode();
        result = 31 * result + transactionDate.hashCode();
        result = 31 * result + transactionTime.hashCode();
        result = 31 * result + clientKeyId.hashCode();
        result = 31 * result + secondPartyKeyId.hashCode();
        result = 31 * result + secondPartyFirstName.hashCode();
        result = 31 * result + secondPartyLastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(amount);
        sb.append("; ");
        sb.append(clientAccountNumber);
        sb.append("; ");
        sb.append(secondPartyAccountNumber);
        sb.append("; ");
        sb.append(transactionType);
        sb.append("; ");
        sb.append(transactionDate);
        sb.append("; ");
        sb.append(transactionTime);
        sb.append("; ");
        sb.append(clientKeyId);
        sb.append("; ");
        sb.append(secondPartyKeyId);
        sb.append("; ");
        sb.append(secondPartyFirstName);
        sb.append("; ");
        sb.append(secondPartyLastName);
        sb.append("; ");
        return sb.toString();
    }

    public ClientTransaction createTransactionForTransfer(BigDecimal amount, ClientAccount client, ClientAccount secondParty, String transactionType, ClientPersonalData receiverPersonalData) {
        ClientTransaction clientTransaction = new ClientTransaction(
                amount,
                client.getAccountNumber(),
                secondParty.getAccountNumber(),
                transactionType,
                LocalDate.now(),
                LocalTime.now(),
                client.getClientKeyId(),
                secondParty.getClientKeyId(),
                receiverPersonalData.getFirstName(),
                receiverPersonalData.getLastName());
        return clientTransaction;
    }
    public ClientTransaction createTransactionForPutAndWithdrawMoney(BigDecimal amount, ClientAccount client, String transactionType) {
        ClientTransaction clientTransaction = new ClientTransaction(
                amount,
                client.getAccountNumber(),
                "-",
                transactionType,
                LocalDate.now(),
                LocalTime.now(),
                client.getClientKeyId(),
                new BigInteger("0"),
                "-",
                "-");
        return clientTransaction;
    }

    public static List<ClientTransaction> createClientTransaction(ClientKey clientKey) {
        list =   CommunicationDAO.selectListById(SELECT_CLIENT_TRANSACTIONS, clientKey.getClientKeyId());
        return list;
    }



}
