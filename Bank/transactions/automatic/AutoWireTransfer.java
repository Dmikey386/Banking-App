package bank.transactions.automatic;

import java.io.IOException;

public class AutoWireTransfer extends AutoTransaction {
    // automatic wire transfer

    public AutoWireTransfer(AutoTransactionRequest request) {
        super(request);
    }

    @Override
    public void process() throws IOException {

    }
}
