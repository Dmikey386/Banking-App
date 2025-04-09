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


## ✅ `v1.1.0 Core Functionality`
### Step – Account & Transaction Mechanisms  
- Create `BankAccount` types: Checking, Savings  
- Implement base `Transaction`, `Withdraw`, `Deposit`  
### Step – User Mechanism & Account Ownership  
- Build `User` class and ownership of accounts  
- Link users to accounts and log using `UserLogger`  
### Step – Transaction Requesting, Verification, and Processing  
- Add `TransactionProcessor` and `TransactionVerifier`  
- Handle edge cases: frozen accounts, overdrafts, invalid IDs  
### Step – Unique ID Generation (Snowflake ID)  
- Create thread-safe `UniqueIDGenerator` for transactions and users  
### Step – Persistent Storage Using JSON  
- Implement `JsonLogger<T>` for object logging  
- Write/read accounts, users, and transactions to/from disk  
### Step – Logging System (for Testing)  
- Add `TransactionLogger`, `UserLogger`, `AccountLogger`
## ✅ `v1.2.0 Transaction System V2`
### Step - Refactor Transaction logic  
- Implement `Transaction` Logic `(Deposit,Withdraw)` Build Transactions, verification, processing
- Implement `WireTransfer` Build Transfers, verification, and processing pipeline
  - `Transfer Logger`
- Implement `AutoWireTransfer` Build scheduler, processor, and recurring payment logic  
  - `Transfer Scheduler`, `Schedule Log`
## ✅ `v1.3.0 Java-LvL Concurrency Layer`
### Step – Multithreading & Concurrency Layer
## 🟦 `v1.4.0 Database Layer`
### 🟦 Step - Migrate to SQL
- Desing DB Schema 
- Create DB Tables 
- Transition POJOs into DB schema
### 🟦 Step - SpringBoot API endpoints between Database
- create API endpoints
### 🟦 Step - DB-lvl concurrency
- Design DB concurrency locks 
- Stress Test Concurrency locks
## 🟨`v1.2.0 Transaction System V3`
## 🟨 `v1.5.0 – Authentication Layer`

# Phase 2 Microservices Infrastructure
# Phase 3 Scalable Distributed System 

