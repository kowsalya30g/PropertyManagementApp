package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Maintenance;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance,Long>{

}
