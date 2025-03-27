package Bank.core;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
        String[] accounts = {"BA31132129710571520","BA31132129asdf546993664"};
        bank.createTransaction("USER31131933190651904",accounts,5000, 2);

    }
}