package Bank.transactions.automaticTransactions;

import Bank.transactions.transactionProcessing.AutoTransactionRequest;

import java.io.IOException;

public class AutoPayment extends AutoTransaction {

    public AutoPayment(AutoTransactionRequest request) {
        super(request);
    }

    @Override
    public void process() throws IOException {
    }
}
