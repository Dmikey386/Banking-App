package bank.core;


import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = Bank.getInstance();
        bank.openAccount("Checking","USER35523979439505408");
    }
}