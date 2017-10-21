package pl.my.quickcash.data.client;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ClientAccount {

    private BigDecimal accountBalance;
    private String accountNumber;
    private BigInteger client_key_id;

    public ClientAccount(BigDecimal accountBalance, String accountNumber, BigInteger client_key_id) {
        this.accountBalance = accountBalance.setScale(2, BigDecimal.ROUND_CEILING);
        this.accountNumber = accountNumber;
        this.client_key_id = client_key_id;
    }

    public ClientAccount(BigDecimal accountBalance, String accountNumber) {
        this.accountBalance = accountBalance.setScale(2, BigDecimal.ROUND_CEILING);
        this.accountNumber = accountNumber;
    }

    public BigInteger getClient_key_id() {
        return client_key_id;
    }

    public void setClient_key_id(BigInteger client_key_id) {
        this.client_key_id = client_key_id;
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

    public void setAccountNumber(String accountNumberL) {
        this.accountNumber = accountNumberL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientAccount that = (ClientAccount) o;

        if (!accountBalance.equals(that.accountBalance)) return false;
        if (!accountNumber.equals(that.accountNumber)) return false;
        return client_key_id.equals(that.client_key_id);
    }

    @Override
    public int hashCode() {
        int result = accountBalance.hashCode();
        result = 31 * result + accountNumber.hashCode();
        result = 31 * result + client_key_id.hashCode();
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
