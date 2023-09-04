import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class Account {
    String accountId;
    BigDecimal balance;
    Map<Integer, Client> owners;
    Client owner;


    void depositMoney(BigDecimal money){
        balance = balance.add(money);
    }

    void withdrawMoney(BigDecimal money){
        balance = balance.subtract(money);
    }

    public Account(String accountId, BigDecimal balance, Client owner) {
        this.accountId = accountId;
        this.balance = balance;
        this.owner = owner;
    }

    public Account(String accountId, BigDecimal balance, Map<Integer, Client> owners) {
        this.accountId = accountId;
        this.balance = balance;
        this.owners = owners;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Map<Integer, Client> getOwner() {
        return owners;
    }

    public void setOwner(Map<Integer, Client> owner) {
        this.owners = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) && Objects.equals(balance, account.balance) && Objects.equals(owner, account.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, balance, owner);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", client=" + owner +
                '}';
    }
}
