package com.app.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transfer {
    @Id
    @Column(name ="transfer_id")
    private String wireID;
    private double amount;
    private boolean approval;
    private boolean recurring;
    private LocalDateTime timestamp;
    private String failureReason;
    private String message;

    // many transfers per
    //User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private BankUser user;
    // to_accounts
    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account toAccount;
    // from_accounts
    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;

    // Match Deposit ID
    @OneToOne
    @JoinColumn(name="deposit_id")
    private Transaction deposit;
    // Match Withdraw ID
    @OneToOne
    @JoinColumn(name="withdraw_id")
    private Transaction withdraw;




}
