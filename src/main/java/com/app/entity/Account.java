package com.app.entity;
import jakarta.persistence.*;
import com.app.enums.AccountType;
import java.util.List;

@Entity
public class Account  {
    @Id
    private String accountID;
    private String nickName;
    private double balance;
    private boolean frozen = false;
    private double monthlyLimit; // default no limit
    private double dayLimit; // default no limit
    private double daySpending;
    private double monthSpending;
    private int monthTxn;
    private int monthTxnLimit;
    private int initializeDate;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    // One account to many
    // transactions
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
    // transfer
    @OneToMany(mappedBy = "account")
    private List<Transfer> transfer;
    // auto transfers
    @OneToMany(mappedBy = "account")
    private List<AutoTransfer> autoTransfer;

    // Join table user-account
    @ManyToMany
    @JoinTable(
            name = "user_account_join",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<BankUser> users;


    public void addUsers(BankUser bankUser) {
        users.add(bankUser);
    }
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}





