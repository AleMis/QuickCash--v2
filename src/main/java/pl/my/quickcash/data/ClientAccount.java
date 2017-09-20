package pl.my.quickcash.data;

import java.math.BigDecimal;

public class ClientAccount {

    private BigDecimal accountBalance;
    private String accountNumber;

    public ClientAccount(BigDecimal accountBalance, String accountNumber) {
        this.accountBalance = accountBalance.setScale(2, BigDecimal.ROUND_CEILING);
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

    public void setAccountNumber(String accountNumberL) {
        this.accountNumber = accountNumberL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientAccount)) return false;

        ClientAccount that = (ClientAccount) o;

        if (!getAccountBalance().equals(that.getAccountBalance())) return false;
        return getAccountNumber().equals(that.getAccountNumber());
    }

    @Override
    public int hashCode() {
        int result = getAccountBalance().hashCode();
        result = 31 * result + getAccountNumber().hashCode();
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
