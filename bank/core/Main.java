package bank.core;

import bank.transactions.base.Deposit;
import bank.transactions.base.Transaction;
import bank.transactions.base.Withdraw;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
       Withdraw withdraw = new Withdraw(500054,"BA33287624147861504");
       withdraw.process();
    }
}