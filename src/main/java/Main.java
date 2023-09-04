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

        Map<String, Account> allAccounts = new HashMap<>();
        allAccounts.put(String.valueOf(c1.customerId()), michael);
        allAccounts.put(String.valueOf(c2.customerId()), max);

        BankService bankService = new BankService(allAccounts);
        System.out.println(bankService.createNewAccount(c2));
        System.out.println(allAccounts);

        bankService.transferMoney("DE12345678901234567890", "DE37253826382638254016", new BigDecimal("200"));
        System.out.println(michael);
        System.out.println(max);

        Client c4 = new Client("Sarah", "Hufnagel", 25283);
        Client c5 = new Client("Lisa", "Schmied", 25183);
        Map<Integer, Client> sarahAndLisa = new HashMap<>();
        sarahAndLisa.put(c4.customerId(), c4);
        sarahAndLisa.put(c5.customerId(), c5);
        Account sharedSarahAndLisa = new Account("DE36291638263919352739", new BigDecimal("3712.23"), sarahAndLisa);

    }
}
