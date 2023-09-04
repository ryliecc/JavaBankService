import java.math.BigDecimal;
import java.util.*;

public class BankService {
    Map<String, Account> allAccounts;

    String createNewAccount(Client client){
        StringBuilder accountId = new StringBuilder("DE");
        Random rand = new Random();
        for(int i = 1; i < 21; i++){
            int random = rand.nextInt(10);
            accountId.append(random);
        }
        String newAccountId = accountId.toString();
        allAccounts.put(newAccountId, new Account(newAccountId, new BigDecimal("0"), client));
        return newAccountId;
    }

    String createNewAccount(Map<Integer, Client> clients){
        StringBuilder accountId = new StringBuilder("DE");
        Random rand = new Random();
        for(int i = 1; i < 21; i++){
            int random = rand.nextInt(10);
            accountId.append(random);
        }
        String newAccountId = accountId.toString();
        allAccounts.put(newAccountId, new Account(newAccountId, new BigDecimal("0"), clients));
        return newAccountId;
    }

    void transferMoney(String sendingAccountId, String receivingAccountId, BigDecimal money){
        Account sendingAccount = allAccounts.get(sendingAccountId);
        Account receivingAccount = allAccounts.get(receivingAccountId);
        sendingAccount.withdrawMoney(money);
        receivingAccount.depositMoney(money);
    }

    public BankService(Map<String, Account> allAccounts) {
        this.allAccounts = allAccounts;
    }

    public Map<String, Account> getAllAccounts() {
        return allAccounts;
    }

    public void setAllAccounts(Map<String, Account> allAccounts) {
        this.allAccounts = allAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankService that = (BankService) o;
        return Objects.equals(allAccounts, that.allAccounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allAccounts);
    }

    @Override
    public String toString() {
        return "BankService{" +
                "allAccounts=" + allAccounts +
                '}';
    }
}
