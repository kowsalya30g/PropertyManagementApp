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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Owner;
import com.cg.services.OwnerService;


@RestController
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@GetMapping("/getAllOwner")
	public List<Owner> getAllOwner()
	{
		return ownerService.getAllOwner();
	}
	
	@DeleteMapping("/deleteOwner/{ownerId}")
	public ResponseEntity<Object> deleteOwner(@PathVariable("ownerId") Long ownerId)
	{
		return ownerService.deleteOwner(ownerId);
	}
	
	@GetMapping("/getOwnerById/{ownerId}")
	public Owner getOwnerById(@PathVariable("ownerId") Long ownerId)
	{
		return ownerService.getOwnerById(ownerId);
	}
	
	@PostMapping("/addOwner")
	public ResponseEntity<Owner> addOwner(@Valid @RequestBody Owner owner)
	{
		Owner savedOwner= ownerService.addOwner(owner);
		return new ResponseEntity<Owner>(savedOwner,HttpStatus.CREATED);
	}

}

