## 📋 Table of Contents
- [Phase 1 Core Infrastructure – Monolith](#phase-1-core-infrastructure--monolith)
- [v1.1.0 Core Functionality](#v110-core-functionality)
- [v1.2.0 Transaction System V2](#v120-transaction-system-v2)
- [v1.3.0 Concurrency Layer](#v130-concurrency-layer)
- [Phase 2 Microservices Infrastructure](#phase-2-microservices-infrastructure)
- [Phase 3 Scalable Distributed System](#phase-3-scalable-distributed-system)

---

## 🔖 Legend

- 🟦 → In Progress  
- 🟨 → Planned  
- ✅ → Completed  

---

# Phase 1 Core Infrastructure – Monolith


## v1.1.0 Core Functionality
### ✅ Step 1 – Account & Transaction Mechanisms  
- Create `BankAccount` types: Checking, Savings  
- Implement base `Transaction`, `Withdraw`, `Deposit`  
### ✅ Step 2 – User Mechanism & Account Ownership  
- Build `User` class and ownership of accounts  
- Link users to accounts and log using `UserLogger`  
### ✅ Step 3 – Transaction Requesting, Verification, and Processing  
- Add `TransactionProcessor` and `TransactionVerifier`  
- Handle edge cases: frozen accounts, overdrafts, invalid IDs  
### ✅ Step 4 – Unique ID Generation (Snowflake ID)  
- Create thread-safe `UniqueIDGenerator` for transactions and users  
### ✅ Step 5 – Persistent Storage Using JSON  
- Implement `JsonLogger<T>` for object logging  
- Write/read accounts, users, and transactions to/from disk  
### ✅ Step 6 – Logging System (for Testing)  
- Add `TransactionLogger`, `UserLogger`, `AccountLogger`
## v1.2.0 Transaction System V2
### ✅ Step 7 - Refactor Transaction logic  
- Implement `Transaction` Logic `(Deposit,Withdraw)` Build Transactions, verification, processing
- Implement `WireTransfer` Build Transfers, verification, and processing pipeline
  - `Transfer Logger`
- Implement `AutoWireTransfer` Build scheduler, processor, and recurring payment logic  
  - `Transfer Scheduler`, `Schedule Log`
## v1.3.0 Concurrency Layer 
### ✅ Step 8 – Multithreading & Concurrency Layer  
- Add account-level locking during transaction/transfer processing
- Add document-level locking for thread safe document editing
- Perform Stress Testing on locking mechanisms
### 🟦 Step 9 – SQL Database Migration (PostgreSQL)  
- Design schema and migrate data from JSON  
- Replace `JsonLogger` with SQL-backed persistence  
### 🟨 Step 10 – Spring Boot API for Transactions  
- Build endpoints for transaction access and testing accounts  
### 🟨 Step 11 – Authentication & Security (JWT + RBAC)  
- Implement login/authentication and role-based permissions  
### 🟨 Step 12 – Multi-User Concurrency & SQL-Level Safety  
- Add SQL transaction blocks and isolation handling  
- Integrate row-level locks and ACID compliance  
# Phase 2 Microservices Infrastructure
# Phase 3 Scalable Distributed System 
