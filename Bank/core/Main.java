package Bank.core;

import java.io.IOException;
import Bank.user.User;

public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
        String[] bankaccounts = {"BA30672670655774720"};
        bank.createTransaction("USER30671767273996288",bankaccounts,10000,0);








    }
}