import java.math.BigDecimal;
import java.math.RoundingMode;
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

    String createNewAccount(List<Client> clients){
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

    public List<String> splitAccount(String accountId){
        Account sharedAccount = allAccounts.get(accountId);
        List<Client> owners = sharedAccount.owners;

        BigDecimal amountOwners = BigDecimal.valueOf(owners.size());
        BigDecimal moneyEach = sharedAccount.balance.divide(amountOwners).setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal moneyWithdrawn = moneyEach.multiply(amountOwners);
        sharedAccount.withdrawMoney(moneyWithdrawn);

        List<String> newAccountIds = new ArrayList<>();

        for(int i = 0; i < owners.size(); i++){
            Client owner = owners.get(i);
            String newAccountId = createNewAccount(owner);
            Account newAccount = allAccounts.get(newAccountId);
            newAccount.depositMoney(moneyEach);
            newAccountIds.add(newAccountId);
        }
        return newAccountIds;
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
