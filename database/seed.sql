-- Insert Users
INSERT INTO BankUsers (user_id, email, phone, name, password, initialize)
VALUES
    ('U1001', 'alice@example.com', '1234567890', 'Alice', 'securepass123', CURRENT_TIMESTAMP),
    ('U1002', 'bob@example.com', '0987654321', 'Bob', 'strongpass456', CURRENT_TIMESTAMP);

-- Insert Accounts
INSERT INTO Account (account_id, balance, account_type, initialized)
VALUES
    ('A2001', 1000.00, 'Checking', CURRENT_TIMESTAMP),
    ('A2002', 5000.00, 'Savings', CURRENT_TIMESTAMP);

-- Link Users to Accounts (Ownership & Access)
INSERT INTO UserAccountJoin (account_id, user_id, access_lvl)
VALUES
    ('A2001', 'U1001', 'Owner'),
    ('A2002', 'U1001', 'Owner'),
    ('A2002', 'U1002', 'Base');

-- Insert Transactions
INSERT INTO Transactions (transaction_id, amount, account_id, txn_type, approval, time_stamp, description)
VALUES
    ('T3001', 1000.00, 'A2001', 'Deposit', TRUE, CURRENT_TIMESTAMP, 'Initial deposit to checking'),
    ('T3002', 200.00, 'A2002', 'Withdraw', TRUE, CURRENT_TIMESTAMP, 'Emergency fund withdrawal');

-- Insert Transfer (internal: withdraw + deposit)
INSERT INTO Transactions (transaction_id, amount, account_id, txn_type, approval, time_stamp, description)
VALUES
    ('T3003', 300.00, 'A2001', 'Withdraw', TRUE, CURRENT_TIMESTAMP, 'Transfer out to savings'),
    ('T3004', 300.00, 'A2002', 'Deposit', TRUE, CURRENT_TIMESTAMP, 'Transfer in from checking');

INSERT INTO Transfer (
    transfer_id, amount, user_id, from_account_id, to_account_id,
    approval, recurring, withdraw_id, deposit_id, time_stamp, description
)
VALUES
    ('TR4001', 300.00, 'U1001', 'A2001', 'A2002', TRUE, FALSE, 'T3003', 'T3004', CURRENT_TIMESTAMP, 'Internal transfer from Alice checking to savings');

-- Insert AutoTransfer (scheduled transfer setup)
INSERT INTO AutoTransfer (
    auto_transfer_id, amount, user_id, from_account_id, to_account_id,
    approval, consecutive_fails, num_txn, time_stamp, next_date
)
VALUES
    ('AT5001', 150.00, 'U1001', 'A2001', 'A2002', TRUE, 0, 0, CURRENT_TIMESTAMP, CURRENT_DATE + INTERVAL '30 days');

