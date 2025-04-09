# Phase 1 Core Infrastructure – Monolith
### ✅`v1.1.0 Core Functionality`
### ✅`v1.2.0 Transaction System V2`
### ✅`v1.3.0 Concurrency Layer`
###  🟦`v1.4.0 Database Layer`
### - Build Database
- Design Schema/Create ERD Diagram
- Create User, Account Tables  & ENUM
- Create UserAccountJoinTable  & ENUM
- Create Transaction Table  & ENUM
- Create Transfer Table 
- Create AutoTransfer Table 
### - SpringBOOT 
- Annotate POJOs as @Entity with @Table mappings
- Map ENUMs using @Enumerated(EnumType.STRING)
- Add @Id, @Column, and @JoinColumn where appropriate 
- Implement @OneToMany, @ManyToOne, @ManyToMany relationships 
- Configure spring.datasource in application.properties or yml 
- Add JPA Repositories for each entity Create DTOs & mappers if needed 
- Write service-layer integration tests using H2 or Postgres test container
### - DB lvl concurrency layer
- Design transaction isolation strategy (READ COMMITTED, REPEATABLE READ)
- Use FOR UPDATE in critical balance/transfer queries 
- Implement atomic updates using SQL WHERE clauses to prevent lost updates 
- Handle deadlocks and retries gracefully in service layer 
- Ensure safe balance updates using check-then-set logic 
- Add unique constraint guards (e.g., prevent double transfers by transaction ID)
- Introduce transaction rollbacks (@Transactional in Spring + DB rollback)
- Document locking behavior per table (e.g., Account, Transaction)

### 🟨`v1.2.0 Transaction System V3`
### 🟨 `v1.5.0 – Authentication Layer`

# Phase 2 Microservices Infrastructure
# Phase 3 Scalable Distributed System 
