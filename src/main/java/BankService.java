import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankService {
    List<Account> allAccounts = new ArrayList<>();

    String createNewAccount(Client client){
        StringBuilder accountId = new StringBuilder("DE");
        Random rand = new Random();
        for(int i = 1; i < 21; i++){
            int random = rand.nextInt(10);
            accountId.append(random);
        }
        String newAccountId = accountId.toString();
        allAccounts.add(new Account(newAccountId, new BigDecimal("0"), client));
        return accountId.toString();
    }

    public BankService(List<Account> allAccounts) {
        this.allAccounts = allAccounts;
    }

    public List<Account> getAllAccounts() {
        return allAccounts;
    }

    public void setAllAccounts(List<Account> allAccounts) {
        this.allAccounts = allAccounts;
    }

    @Override
    public String toString() {
        return "BankService{" +
                "allAccounts=" + allAccounts +
                '}';
    }
}
