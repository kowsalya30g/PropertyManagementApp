package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entities.Manager;
import com.cg.exception.CertificationNotFoundException;
import com.cg.exception.PersonNotFoundException;
import com.cg.exception.QualificationNotFoundException;
import com.cg.repositories.ManagerRepository;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	public Manager addManager(Manager manager)
	{
		return managerRepository.save(manager);
	}
	
	public List<Manager> getAll()
	{
		return managerRepository.findAll();
	}
	
	public ResponseEntity<Object> getManagerById(long id) throws PersonNotFoundException
	{
		if(!managerRepository.existsById(id))
		
			throw new PersonNotFoundException("Person not found!!");
		
		
		return new ResponseEntity<Object>(managerRepository.findById(id).get(),HttpStatus.OK);
	}
	
	public String deleteManagerInfo(long id)
	{
		managerRepository.deleteById(id);
		return "Information Deleted Successfully";
	}
	
	public List<Manager> updateManagerData(Manager manager)
	{
		managerRepository.save(manager);
		return managerRepository.findAll();
	}
	
	public List<Manager> updateManagerCertification(long id, String certification)
	{
		Manager manager=managerRepository.findById(id).get();
		manager.setCertification(certification);
		managerRepository.save(manager);
		return managerRepository.findAll();
	}
	
	public String getDateOfJoiningById(long id)
	{
		return managerRepository.findById(id).get().getDateOfJoining();
	}
	
	public List<Manager> getByQualification(String qualification) throws QualificationNotFoundException
	{
		List<Manager> list=(List<Manager>) managerRepository.findByQualification(qualification);
		if(list.isEmpty())
			throw new QualificationNotFoundException("No such qualification found!!");
		
		return list;
	}
	
	public List<Manager> getByCertification(String certification) throws CertificationNotFoundException
	{
		List<Manager> list=(List<Manager>) managerRepository.findByCertification(certification);
		if(list.isEmpty())
			throw new CertificationNotFoundException("No such certification found!!");
		
		return list;
	}
 }
