package com.app.repository;
import com.app.entity.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<BankUser, String> { }

