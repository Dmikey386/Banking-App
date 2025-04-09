package bank.stresstesting;

import bank.core.Bank;

import java.io.IOException;

public class AccountLockThreadTest {
    public static void main(String[] args) throws IOException {

        // Test User:  USER33601996351078400
        // Test BankAccount: BA35500629078048768

        for (int i = 0; i < 10; i++) {
            if (i%2==0){
                Thread thread = new paymentThread(100,"Withdraw");
                thread.start();
            } else {
                Thread thread = new paymentThread(100, "Deposit");
                thread.start();
            }
        }
    }

    public static class paymentThread extends Thread {
        public static Bank bank = new Bank();
        private double amount;
        private String type;

        public paymentThread(double amount, String type) {
            this.amount = amount;
            this.type = type;
        }

        public void run() {
            try {
                bank.processTransaction(amount,"BA35500629078048768",type); // this is running /printing account balance during the actual thread
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


