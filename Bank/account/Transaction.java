package Bank.account;

public class Transaction<T>{
    private int toAccountNumber;
    private int fromAccountNumber;
    private T transcation;

    public Transaction(int toAccountNumber, int fromAccountNumber, T transcation) {
        this.toAccountNumber = toAccountNumber;
        this.fromAccountNumber = fromAccountNumber;
        this.transcation = transcation;
    }
}
