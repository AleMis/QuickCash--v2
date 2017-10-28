package pl.my.quickcash.data.client;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ClientAccount {

    private BigDecimal accountBalance;
    private String accountNumber;
    private BigInteger clientKeyId;

    public ClientAccount(BigDecimal accountBalance, String accountNumber, BigInteger clientKeyId) {
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        this.clientKeyId = clientKeyId;
    }

    public ClientAccount(BigDecimal accountBalance, String accountNumber) {
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigInteger getClientKeyId() {
        return clientKeyId;
    }

    public void setClientKeyId(BigInteger clientKeyId) {
        this.clientKeyId = clientKeyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientAccount that = (ClientAccount) o;

        if (!accountBalance.equals(that.accountBalance)) return false;
        if (!accountNumber.equals(that.accountNumber)) return false;
        return clientKeyId.equals(that.clientKeyId);
    }

    @Override
    public int hashCode() {
        int result = accountBalance.hashCode();
        result = 31 * result + accountNumber.hashCode();
        result = 31 * result + clientKeyId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append(accountBalance);
        print.append("; ");
        print.append(accountNumber);
        print.append("; ");
        return print.toString();
    }
}
