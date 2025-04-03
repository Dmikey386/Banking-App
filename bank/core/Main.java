package bank.core;


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
       Bank bank = new Bank();
       bank.openAccount("Checking","USER33601996497879040");
       bank.openAccount("Savings","USER33601996497879040");
    }
}