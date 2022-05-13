package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long>{

}
