package com.cg.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Manager;
import com.cg.exception.CertificationNotFoundException;
import com.cg.exception.QualificationNotFoundException;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long>{
	
    public List<Manager> findByQualification(String qualification) throws QualificationNotFoundException;
	
	public List<Manager> findByCertification(String certification) throws CertificationNotFoundException;

	
}
