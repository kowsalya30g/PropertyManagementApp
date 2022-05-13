package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entities.TransactionDetails;

public interface TransactionRepository extends JpaRepository<TransactionDetails, Long> {

}
