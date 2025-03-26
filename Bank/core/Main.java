package Bank.core;

import java.io.IOException;
import Bank.user.User;

public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();

        // transfer
        String[] accounts = {"BA30708702289854464","BA307087022342344464"};
        bank.createTransaction("USER30708484903272448",accounts,5000,2);

    }
}