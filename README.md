# **Banking Application**

## **Overview**
This banking application is a **simple banking system** that allows users to create bank accounts, process transactions, and maintain account records. It implements **Object-Oriented Programming (OOP)** principles and ensures transaction integrity through **verification and logging mechanisms**.

## **Developer Skills & Expertise**

### **1. Java & Backend Development**
- **OOP Design skills** - interfaces, polymorphism, and inheritance to create scalable and modular application
- **Multithread Protection** - snowlfake IDs allow for atomic ID generation

---

## **Features**
### **1. User and Account Management**
- Users can be created with a **unique User ID**.
- Users can open **Checking or Savings accounts**.
- Each account is assigned a **unique Account ID**.
- Users can **view their account balance**.

### **2. Unique ID Generation**
- The app uses a **Snowflake ID Generator** to create **unique IDs** for:
  - Users (`USER<ID>`)
  - Accounts (`BA<ID>`)
  - Transactions (`TR<ID>`)

### **3. Transactions**
The app supports the following transaction types:
1. **Deposits:** Users can deposit money into their accounts.
2. **Withdrawals:** Users can withdraw money (subject to minimum balance requirements).
3. **Transfers:** Users can transfer money between accounts.

### **4. Transaction Processing & Verification**
- Transactions go through a **verification process** before being executed.
- The **TransactionVerifier** ensures:
  - Validity of account details.
  - Sufficient balance for withdrawals.
  - Properly formatted transaction amounts (no negative values).
- If a transaction fails, a **failure message** is logged.

### **5. Logging and Record Keeping**
- Transactions are stored in a **Transaction Logger**.
- Both **users and accounts maintain transaction records**.

---

## **How It Works**
1. The **Bank class** manages users and accounts.
2. Users can **create accounts** and request transactions.
3. The **TransactionProcessor** verifies and executes transactions.
4. The **TransactionLogger** records successful and failed transactions.

---

## **Example Usage**
```java
// Create Bank instance
Bank bank = new Bank();

// Create Users
bank.createUser();
User user1 = bank.getUser(1);
bank.createUser();
User user2 = bank.getUser(2);

// Open Accounts
String savings1 = bank.openAccount("Savings", user1);
String checking1 = bank.openAccount("Checking", user1);
String savings2 = bank.openAccount("Savings", user2);
String checking2 = bank.openAccount("Checking", user2);

// Create Transaction Requests
TransactionRequest depositRequest = user1.createTransactionRequest(new int[]{savings1}, 1000, 0);
TransactionRequest withdrawalRequest = user1.createTransactionRequest(new int[]{savings1}, 500, 1);
TransactionRequest transferRequest = user1.createTransactionRequest(new int[]{savings1, checking1}, 300, 2);

// Process Transactions
bank.processTransaction(depositRequest);
bank.processTransaction(withdrawalRequest);
bank.processTransaction(transferRequest);
```

---

## **Future Improvements**
- Implement **user authentication** for security.
- Introduce **interest calculations** for savings accounts.
- Improve **error handling** and provide **detailed logging**.
- Add **multi-threading** support for concurrent transactions.

