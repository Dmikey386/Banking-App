package com.app.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class AutoTransfer {
    @Id
    @Column(name = "auto_transfer_id")
    private String AutoTransferID;
    private double amount;
    private String message;
    private boolean approval;
    private Integer numFailures;
    private Integer numTransactions;
    private LocalDate nextDate;
    private LocalDateTime timestamp;

    // Many AutoTransfers per
    //User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private BankUser user;
    // to Account
    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account toAccount;
    // from Account
    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;

}