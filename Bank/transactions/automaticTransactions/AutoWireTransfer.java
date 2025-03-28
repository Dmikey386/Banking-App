package Bank.transactions.automaticTransactions;

import Bank.transactions.transactionProcessing.automatic.AutoTransactionRequest;

import java.io.IOException;

public class AutoWireTransfer extends AutoTransaction{
    // automatic wire transfer

    public AutoWireTransfer(AutoTransactionRequest request) {
        super(request);
    }

    @Override
    public void process() throws IOException {

    }
}
