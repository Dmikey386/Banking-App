package bank.core;


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
       Bank bank = new Bank();
       bank.processTransaction(505,"BA33287624147861504","Deposit");
    }
}