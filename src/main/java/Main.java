import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        Client c1 = new Client("Michael", "Meier", 12345);
        Client c2 = new Client("Sandra", "Schmidt", 34567);
        Client c3 = new Client("Max", "Mustermann", 45678);
        Account michael = new Account("DE12345678901234567890", new BigDecimal("3000"), c1);
        Account max = new Account("DE37253826382638254016", new BigDecimal("18653.43"), c3);

        Map<String, Account> allAccounts = new HashMap();
        allAccounts.put("DE12345678901234567890", michael);
        allAccounts.put("DE37253826382638254016", max);

        BankService bankService = new BankService(allAccounts);
        System.out.println(bankService.createNewAccount(c2));
        System.out.println(allAccounts);

        bankService.transferMoney("DE12345678901234567890", "DE37253826382638254016", new BigDecimal("200"));
        System.out.println(michael);
        System.out.println(max);

    }
}
