package bank.transactions.auto;

import bank.transactions.wiretrasfer.WireTransfer;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoWireTransfer extends WireTransfer {
    private String rate;
    private String nextDate;
    private int consecutiveFailures = 0;
    private int numTransfers = 0;

    public AutoWireTransfer(Builder builder) {
            super(builder);
            this.rate = builder.rate;
            this.nextDate = builder.nextDate;

    }
    public void setNextDate() {
        LocalDate lastDate = LocalDate.parse(this.nextDate);
        LocalDate newDate;
        switch (rate){
            case "Yearly" : newDate = lastDate.plusYears(1); break;
            case "Monthly" : newDate = lastDate.plusMonths(1); break;
            case "Weekly" : newDate = lastDate.plusWeeks(1); break;
            case "Daily" : newDate = lastDate.plusDays(1); break;
            default: newDate = lastDate;
        }
        this.nextDate = newDate.toString();
    }
    public void setNumTransfers(int numTransfers) {
        this.numTransfers = numTransfers;
    }
    public void setConsecutiveFailures(int consecutiveFailures) {
        this.consecutiveFailures = consecutiveFailures;
    }
    public void incrementConsecutiveFailures() {
        this.consecutiveFailures++;
    }
    public void resetConsecutiveFailures() {
        this.consecutiveFailures = 0;
    }
    public void incrementNumTransfers() {
        numTransfers++;
    }
    //getters
    public String getNextDate() {
        return nextDate;
    }
    public int getConsecutiveFailures() {
        return consecutiveFailures;
    }
    public int getNumTransfers() {
        return numTransfers;
    }
    public String getRate() {
        return rate;
    }

    public static class Builder extends WireTransfer.Builder<Builder> {
        private String rate;
        private String nextDate;

        public Builder rate(String rate) {
            this.rate = rate;
            return this;
        }

        public Builder nextDate(String nextDate) {
            this.nextDate = nextDate;
            return this;
        }

        @Override
        public AutoWireTransfer build() {
            return new AutoWireTransfer(this);
        }
    }

}
