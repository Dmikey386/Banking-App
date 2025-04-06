package bank.core;


import java.io.IOException;
import java.time.LocalDate;



public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
//        bank.processTransaction(1000,"BA33660014472200192","Deposit");
//        bank.processTransaction(1000,"BA33660014635778048","Deposit");
//        bank.processTransaction(1000,"BA34706550115270656","Deposit");
//        bank.scheduleRecurringTransfer("USER33601996497879040",
//                "BA33660014472200192",
//                "BA34344782029389824",
//                500,
//                "Monthly",
//                LocalDate.now().toString());
//
//        bank.scheduleRecurringTransfer("USER33601996497879040",
//                "BA33660014635778048",
//                "BA34344782239105024",
//                500,
//                "Weekly",
//                LocalDate.now().toString());
//
//        bank.scheduleRecurringTransfer("USER33601996497879040",
//                "BA34706550115270656",
//                "BA34706549934915584",
//                500,
//                "Daily",
//                LocalDate.now().toString());
   bank.processRecurringPayments();
    }
}