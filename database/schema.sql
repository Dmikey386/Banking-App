CREATE TYPE account_type_enum AS ENUM ('Checking','Savings');
CREATE TABLE BankUsers (
    user_id VARCHAR(50) PRIMARY KEY NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    name VARCHAR(50),
    password VARCHAR(50) NOT NULL,
    initialize TIMESTAMP NOT NULL
);
CREATE TABLE Account (
    account_id VARCHAR(50) PRIMARY KEY NOT NULL,
    balance DECIMAL(12,2) NOT NULL,
    account_type account_type_enum NOT NULL,
    nick_name VARCHAR(50),
    initialized TIMESTAMP NOT NULL,
    -- only for checking
    month_limit DECIMAL(12,2) DEFAULT -1.0,
    day_limit DECIMAL(12,2) DEFAULT -1.0,
    month_spending DECIMAL(12,2) DEFAULT 0,
    day_spending DECIMAL(12,2) DEFAULT 0,
    -- only for savings
    txn_limit SMALLINT DEFAULT 6,
    num_txn SMALLINT DEFAULT 0
);


CREATE TYPE account_admin_enum AS ENUM ('Owner','Base');
CREATE TABLE UserAccountJoin (
    account_id VARCHAR (50)  references Account NOT NULL,
    user_id VARCHAR(50) references BankUsers NOT NULL,
    access_lvl account_admin_enum NOT NULL,
    PRIMARY KEY(account_id,user_id),
    CONSTRAINT no_duplicate_tag UNIQUE (account_id, user_id)
);
CREATE TYPE transaction_type_enum AS ENUM('Deposit','Withdraw');
CREATE TABLE Transactions (
    transaction_id VARCHAR(50) PRIMARY KEY NOT NULL,
    amount DECIMAL(12,2) DEFAULT 0.0 NOT NULL,
    account_id VARCHAR(50) references Account NOT NULL,
    txn_type transaction_type_enum NOT NULL,
    approval BOOL DEFAULT False NOT NULL,
    time_stamp TIMESTAMP NOT NULL,
    fail_reason VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE Transfer (
    transfer_id VARCHAR(50) PRIMARY KEY NOT NULL,
    amount DECIMAL(12,2) DEFAULT 0.0 NOT NULL,
    user_id VARCHAR(50) references BankUsers NOT NULL,
    from_account_id VARCHAR(50) references Account NOT NULL,
    to_account_id VARCHAR(50) references Account NOT NULL,
    approval BOOL DEFAULT False NOT NULL,
    recurring BOOL DEFAULT False NOT NULL,
    withdraw_id VARCHAR(50) references Transactions NOT NULL,
    deposit_id VARCHAR(50) references Transactions,
    auto_wire_id VARCHAR(50),
    time_stamp TIMESTAMP NOT NULL,
    fail_reason VARCHAR(255),
    description VARCHAR(255),
    message VARCHAR(255)

);
CREATE TABLE AutoTransfer (
    auto_transfer_id VARCHAR(50) PRIMARY KEY NOT NULL,
    amount DECIMAL(12,2) DEFAULT 0.0 NOT NULL,
    user_id VARCHAR(50) references BankUsers NOT NULL,
    from_account_id VARCHAR(50) references Account NOT NULL,
    to_account_id VARCHAR(50) references Account NOT NULL,
    approval BOOL DEFAULT False NOT NULL,
    consecutive_fails SMALLINT DEFAULT 0 NOT NULL,
    num_txn SMALLINT DEFAULT 0 NOT NULL,
    time_stamp TIMESTAMP NOT NULL,
    next_date TIMESTAMP,
    message VARCHAR(255)
);
