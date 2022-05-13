package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long>{
	public Owner findByPersonName(String name);
}
