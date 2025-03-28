package bank.core;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
        String[] accounts = {"BA31437963686576129","BA31437963518803968"};
        bank.createTransaction("USER31437727773753344",accounts,10000,2);

    }
}