package Bank.core;

import java.io.IOException;
import Bank.user.User;

public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
        System.out.println(bank.getUser("USER30405439476727808"));
        System.out.println(bank.getUser("USER30405434879770624"));
        bank.openAccount("Savings", "USER30405439476727808"); // breaks here but calls bank method getUser()




    }
}