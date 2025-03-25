package Bank.core;

import java.io.IOException;
import Bank.user.User;

public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();

        User user = bank.userLogger.getObject("USER30405439476727808");
        System.out.println(user.getUserID());

    }
}