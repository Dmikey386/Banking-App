SELECT * FROM BankUsers;
SELECT * FROM Account;
SELECT
    u.name AS user_name,
    a.account_id,
    a.account_type,
    j.access_lvl
FROM BankUsers u
         JOIN UserAccountJoin j ON u.user_id = j.user_id
         JOIN Account a ON j.account_id = a.account_id;


SELECT
    t.transaction_id,
    t.txn_type,
    t.amount,
    t.account_id,
    a.account_type,
    t.description
FROM Transactions t
         JOIN Account a ON t.account_id = a.account_id;


SELECT
    tr.transfer_id,
    tr.amount,
    u.name AS user_name,
    tr.from_account_id,
    tr.to_account_id,
    tr.withdraw_id,
    tr.deposit_id,
    tr.description
FROM Transfer tr
         JOIN BankUsers u ON tr.user_id = u.user_id;




SELECT
    at.auto_transfer_id,
    u.name AS user_name,
    at.amount,
    at.from_account_id,
    at.to_account_id,
    at.consecutive_fails,
    at.num_txn,
    at.next_date
FROM AutoTransfer at
         JOIN BankUsers u ON at.user_id = u.user_id;


SELECT
    a.account_id,
    a.account_type,
    j.access_lvl
FROM Account a
         JOIN UserAccountJoin j ON a.account_id = j.account_id
         JOIN BankUsers u ON u.user_id = j.user_id
WHERE u.name = 'Alice' AND j.access_lvl = 'Owner';

SELECT
    a.account_id,
    a.balance,
    COUNT(t.transaction_id) AS num_txns
FROM Account a
         LEFT JOIN Transactions t ON a.account_id = t.account_id
GROUP BY a.account_id, a.balance;
