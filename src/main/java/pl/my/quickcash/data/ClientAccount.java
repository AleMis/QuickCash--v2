package pl.my.quickcash.data;

public class ClientAccount {

    private Double accountBalance;
    private Long accountNumberL;

    public ClientAccount(Double accountBalance, Long accountNumberL) {
        this.accountBalance = accountBalance;
        this.accountNumberL = accountNumberL;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Long getAccountNumberL() {
        return accountNumberL;
    }

    public void setAccountNumberL(Long accountNumberL) {
        this.accountNumberL = accountNumberL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientAccount)) return false;

        ClientAccount that = (ClientAccount) o;

        if (!getAccountBalance().equals(that.getAccountBalance())) return false;
        return getAccountNumberL().equals(that.getAccountNumberL());
    }

    @Override
    public int hashCode() {
        int result = getAccountBalance().hashCode();
        result = 31 * result + getAccountNumberL().hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append(accountBalance);
        print.append("; ");
        print.append(accountNumberL);
        print.append("; ");

        return print.toString();
    }
}
