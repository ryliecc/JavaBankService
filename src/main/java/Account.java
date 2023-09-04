import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    String accountId;
    BigDecimal balance;
    Client client;

    void depositMoney(BigDecimal money){
        balance = balance.add(money);
    }

    void withdrawMoney(BigDecimal money){
        balance = balance.subtract(money);
    }

    public Account(String accountNumber, BigDecimal balance, Client client) {
        this.accountId = accountNumber;
        this.balance = balance;
        this.client = client;
    }

    public String getAccountNumber() {
        return accountId;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountId = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) && Objects.equals(balance, account.balance) && Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, balance, client);
    }
}
