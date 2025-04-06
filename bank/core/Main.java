package bank.core;


import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
        bank.processTransaction(1000,"BA34729031848951808","Deposit");
        bank.processTransferRequest("USER33601996351078400",
                "BA34729031848951808",
                "BA34729031672791040",500);
    }
}