package bank.stresstesting;

import bank.core.Bank;

import java.io.IOException;

public class ThreadSafetyStressTest {
    public static void main(String[] args) throws IOException {

        String user1 = "USER35523979439505408";
        String acc1 = "BA35524208133931008";
        String acc2 = "BA35500629078048768";

        for (int i = 0 ; i < 10 ; i++) {
            if (i%3==0){
                Thread thread = new paymentThread(100,acc1,"Deposit");
                thread.start();
            } else if (i%2==0){
                Thread thread = new paymentThread(100,acc2,"Withdraw");
                thread.start();
            } else{
                Thread thread = new transferThread(user1,acc2,acc1,100);
                thread.start();
            }
        }
    }

    public static class transferThread extends Thread {
        public static Bank bank = Bank.getInstance();
        private double amount;
        private String userID;
        private String toAccountID;
        private String fromAccountID;

        public transferThread(String userID, String toAccountID, String fromAccountID, double amount) {
            this.userID = userID;
            this.toAccountID = toAccountID;
            this.fromAccountID = fromAccountID;
            this.amount = amount;
        }

        public void run(){
            try {
                bank.processTransferRequest(userID,fromAccountID,toAccountID,amount);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class paymentThread extends Thread {
        public static Bank bank = Bank.getInstance();
        private String accountID;
        private double amount;
        private String type;

        public paymentThread(double amount, String accountID, String type) {
            this.amount = amount;
            this.type = type;
            this.accountID = accountID;
        }

        public void run() {
            try {
                bank.processTransaction(amount,accountID,type); // this is running /printing account balance during the actual thread
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


