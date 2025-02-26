package com.example.nutech.repository;

import com.example.nutech.entity.Layanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LayananRepository extends JpaRepository<Layanan, Long> {
    @Query("SELECT l FROM Layanan l WHERE l.serviceCode = :serviceCode")
    Layanan findByServiceCode(String serviceCode);
}
