import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        Client c1 = new Client("Michael", "Meier", 12345);
        Client c2 = new Client("Sandra", "Schmidt", 34567);
        Client c3 = new Client("Max", "Mustermann", 45678);
        Account michael = new Account("DE12345678901234567890", new BigDecimal("3000"), c1);
        Account max = new Account("DE37253826382638254016", new BigDecimal("18653.43"), c3);

        Map<String, Account> allAccounts = new HashMap<>();
        allAccounts.put(michael.accountId, michael);
        allAccounts.put(max.accountId, max);

        BankService bankService = new BankService(allAccounts);
        System.out.println(bankService.createNewAccount(c2));
        System.out.println(allAccounts);

        bankService.transferMoney("DE12345678901234567890", "DE37253826382638254016", new BigDecimal("200"));
        System.out.println(michael);
        System.out.println(max);

        Client c4 = new Client("Sarah", "Hufnagel", 25283);
        Client c5 = new Client("Lisa", "Schmied", 25183);
        List<Client> sarahAndLisa = new ArrayList<>();
        sarahAndLisa.add(c4);
        sarahAndLisa.add(c5);
        bankService.createNewAccount(sarahAndLisa);
        System.out.println(allAccounts);

        Account lisaAndSarah = new Account("DE32583538429354926382", new BigDecimal("200.09"), sarahAndLisa);
        allAccounts.put(lisaAndSarah.accountId, lisaAndSarah);

        System.out.println(bankService.splitAccount(lisaAndSarah.accountId));
        System.out.println(allAccounts);

    }
}
