package com.app.service;

import com.app.idtools.AccountIDGenerator;
import org.springframework.stereotype.Service;


@Service
public class AccountService {
    public static final AccountIDGenerator accountIDGenerator = new AccountIDGenerator();
}
