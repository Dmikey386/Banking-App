package com.app.entity;

import jakarta.persistence.*;
import java.util.List;



@Entity
public class BankUser {
    @Id
    @Column(name = "user_id")
    private String userID;
    private String password;
    private String email;
    private String firstName;

    // User Account Sharing
    @ManyToMany
    @JoinTable(
            name = "user_account_join",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private List<Account> accounts;

    // User ID transfer
    @OneToMany(mappedBy = "user")
    private List<Transfer> transfer;
    // UserID autoTransfer
    @OneToMany(mappedBy = "user")
    private List<AutoTransfer> autoTransfer;

    public void addAccount(Account account) {
        accounts.add(account);
    }

}
