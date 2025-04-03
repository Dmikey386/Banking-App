package bank.core;


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
       Bank bank = new Bank();
       //bank.processTransaction(400,"BA33660014635778048","Deposit");
        bank.processTransaction(50,"BA33660014635778048","Withdraw");
        bank.processTransaction(50,"BA33660014635778048","Withdraw");
        bank.processTransaction(50,"BA33660014635778048","Withdraw");
        bank.processTransaction(50,"BA33660014635778048","Withdraw");
        bank.processTransaction(50,"BA33660014635778048","Withdraw");
        bank.processTransaction(50,"BA33660014635778048","Withdraw");
        bank.processTransaction(50,"BA33660014635778048","Withdraw");


    }
}