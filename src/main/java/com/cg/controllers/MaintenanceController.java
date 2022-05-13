package com.cg.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Maintenance;
import com.cg.services.MaintenanceService;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {
	
	@Autowired
	MaintenanceService maintenanceService;
	
	@GetMapping("getAllMaintenance")
	public List<Maintenance> getAllMaintenance()
	{
		return maintenanceService.getAllMaintenance();
	}
	
	@GetMapping("getMaintenance/{id}")
	public Maintenance getMaintenanceById(@PathVariable("id") long id)
	{
		return maintenanceService.getMaintenanceById(id);
	}
	
	@PostMapping("addMaintenance")
	public ResponseEntity<Maintenance> addMaintenance( @Valid @RequestBody Maintenance maintenance)
	{
		Maintenance savedMaintenance=maintenanceService.addMaintenance(maintenance);
		return new ResponseEntity<Maintenance>(savedMaintenance,HttpStatus.CREATED);
	}
	
	@DeleteMapping("deleteMaintenance/{id}")
	public String deleteMaintenance(@PathVariable("id") long id)
	{
		return maintenanceService.deleteMaintenanceById(id);
	}
	
	@PutMapping("updateMaintenance")
	public Maintenance updateMaintenance(@RequestBody  Maintenance maintenance)
	{
		return maintenanceService.updateMaintenance(maintenance);
	}
	
	@GetMapping("sortMaintenanceByPrice")
	public List<Maintenance> sortMaintenanceByPrice()
	{
		return maintenanceService.sortMaintenanceByPrice();
		
	}
	
	
	

}
