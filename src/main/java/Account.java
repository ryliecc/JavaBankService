import java.math.BigDecimal;

public class Account {
    String accountNumber;
    BigDecimal balance;
    Client client;

    void depositMoney(BigDecimal money){
        balance = balance.add(money);
    }

    void withdrawMoney(BigDecimal money){
        balance = balance.subtract(money);
    }

}
