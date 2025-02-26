package com.example.nutech.repository;

import com.example.nutech.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    @Query("SELECT b FROM Balance b WHERE b.user.id = :userId")
    Balance findByUserId(Long userId);
}
