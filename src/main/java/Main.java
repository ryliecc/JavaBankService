import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Client c1 = new Client("Michael", "Meier", 12345);
        Client c2 = new Client("Sandra", "Schmidt", 34567);
        Account michael = new Account("DE12345678901234567890", new BigDecimal("3000"), c1);

        List<Account> allAccounts = new ArrayList<>();
        allAccounts.add(michael);

        BankService bankService = new BankService(allAccounts);
        System.out.println(bankService.createNewAccount(c2));
        System.out.println(allAccounts);

    }
}
