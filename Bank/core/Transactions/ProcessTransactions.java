package Bank.core.Transactions;


import Bank.account.BankAccount;
import Bank.account.Transaction;
import Bank.account.User;

public class ProcessTransactions<T> {
    private Transaction transaction;
    private User user;

    // Constructor
    public ProcessTransactions(Transaction transaction,User user) {
        this.transaction = transaction;
        this.user = user;
    }

    // check for valid transaction
    // validate Users bank account withdrawal/transfer/deposit
    // validate if recipient account is valid if transfer

    // minium amounts
    // what account restrictions

    // Send transaction
    public void processTransaction(){
        int transactionType = transaction.getTransactionType();
        int depositAccID = transaction.getdepositAccount();
        int withdrawAccID = transaction.getwithdrawAccount();
        double amount = transaction.getAmount();



        switch(transactionType){
            case 0:
                Deposit deposit = new Deposit(user.getAccount(depositAccID),amount);
                deposit.process();
                break;
            case 1:
                Withdraw withdraw = new Withdraw(user.getAccount(withdrawAccID),amount);
                withdraw.process();
                break;
            case 2:
                WireTransfer transfer = new WireTransfer(user.getAccount(depositAccID),user.getAccount(withdrawAccID),amount);
                transfer.process();
                break;
            default:
                System.out.println("Unknown transaction type");
                break;
        }
    }
}
