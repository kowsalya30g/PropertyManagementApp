package com.cg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Staff;
import com.cg.exception.PersonNotFoundException;
import com.cg.services.StaffService;


@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	
	@PostMapping("addStaff")
	public String addStaff(@RequestBody Staff staff) {
		return staffService.addStaff(staff);
	}
	
	@GetMapping("getAllStaff")
	public List<Staff> getAllStaff() {
		return staffService.getAllStaff();
	}
	
	@DeleteMapping("/deleteStaff/{personId}")
	public ResponseEntity<Object> deleteStaff(@PathVariable("personId")  long personId) throws PersonNotFoundException{
		return staffService.deleteStaff(personId);
	}
	
	@GetMapping("/getStaffAssignedTasks/{personId}")
	public List<String> getStaffAssignedTasks(@PathVariable("personId") long personId) throws PersonNotFoundException {
		return staffService.getServices(personId);
	}
	
	@GetMapping("/getStaffAvailability/{personId}")
	public boolean getStaffAvailabilityStatus(@PathVariable("personId") long personId) throws PersonNotFoundException {
		return staffService.getStaffAvailabilityStatus(personId);
	}
	
	@GetMapping("/getStaff/{personId}")
    public ResponseEntity<Object> getStaffById(@PathVariable("personId") long personId)
    		throws PersonNotFoundException
    {
		return new ResponseEntity<>(staffService.getStaffById(personId),HttpStatus.OK);
    }
	
	@RequestMapping("updateStaff/{personId}/{isAvailable}")
	public List<Staff> updateStaffAvailability(@PathVariable("personId")  long personId, 
			@PathVariable("isAvailable") boolean isAvailable) throws PersonNotFoundException{
		return staffService.updateStaffAvailability(personId, isAvailable);
	}

}
