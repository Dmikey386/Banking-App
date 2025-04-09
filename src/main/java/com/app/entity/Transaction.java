package com.app.entity;
import java.time.LocalDateTime;

import com.app.enums.TransactionType;
import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @Column(name = "transaction_id")
    private String txnID;
    private double amount;
    private LocalDateTime timestamp;
    private boolean approval = false;
    private String failureReason;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    // many transactions per account
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;




}
