package Bank.transactions.automaticTransactions;

import Bank.transactions.transactionProcessing.AutoTransactionRequest;

import java.io.IOException;

public class AutoDirectDeposit extends AutoTransaction {


    public AutoDirectDeposit(AutoTransactionRequest request) {
        super(request);
    }

    @Override
    public void process() throws IOException {

    }


}
