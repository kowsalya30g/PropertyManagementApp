package com.cg.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Maintenance;
import com.cg.repositories.MaintenanceRepository;

@Service
public class MaintenanceService {
	
	@Autowired
	MaintenanceRepository maintenanceRepository;
	
	public List<Maintenance> getAllMaintenance()
	{
		return maintenanceRepository.findAll();
	}
	
	public Maintenance getMaintenanceById(long id)
	{
		return maintenanceRepository.findById(id).get();
	}
	
	public Maintenance addMaintenance( Maintenance maintenance)
	{
		return maintenanceRepository.save(maintenance);
	}
	
	public String deleteMaintenanceById(long id)
	{
		maintenanceRepository.deleteById(id);
		return "deleted";
	}
	
	public Maintenance updateMaintenance(Maintenance maintenance)
	{
		if(maintenanceRepository.existsById(maintenance.getId()))
		{
			maintenanceRepository.deleteById(maintenance.getId());
		}
		
		return maintenanceRepository.save(maintenance);
	}
	
	public List<Maintenance> sortMaintenanceByPrice()
	{
		return maintenanceRepository.findAll().stream().sorted(Comparator.comparing(Maintenance :: getPrice)).
				collect(Collectors.toList());
	}
	

}
