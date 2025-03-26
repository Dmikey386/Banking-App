package Bank.core;

import java.io.IOException;
import Bank.user.User;

public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();

        // transfer
        String[] accounts = {"BA30708702122082304","BA30708702289854464"};
        bank.createTransaction("USER30708484752277504",accounts,50000,2);

    }
}