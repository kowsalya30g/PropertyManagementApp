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

import com.cg.entities.Property;
import com.cg.entities.Tenant;
import com.cg.services.PropertyService;
import com.cg.services.TenantService;
import com.cg.services.TransactionService;


@RestController
@RequestMapping("/tenant")
public class TenantController {
	
	@Autowired
	private TenantService tenantService;
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private TransactionService transactionService;

	@GetMapping("/getProperty/{tenantId}")
	public Tenant getProperty(@PathVariable("tenantId") Long tenantId)
	{
		
		return tenantService.getProperty(tenantId);
		
	}

	@PostMapping("/addTenant")
	public String addTenant( @RequestBody Tenant tenant)
	{
		return tenantService.addTenant(tenant);
		//return new ResponseEntity<Tenant>(savedTenant,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllTenant")
	public List<Tenant> getAllTenant()
	{
		return tenantService.getAllTenant();
	}
	
	@DeleteMapping("/deleteTenant/{TenantId}")
	public ResponseEntity<Object> deleteTenant(@PathVariable("TenantId") Long TenantId)
	{
		return tenantService.deleteTenant(TenantId);
	}
	
	@GetMapping("/getTenantById/{TenantId}")
	public Tenant getTenanyById(@PathVariable("TenantId") Long tenantId)
	{
		return tenantService.getTenantById(tenantId);
	}
	
	@GetMapping("/getAllProperty")
	public List<Property> getAllProperty()
	{
	     return propertyService.getAllProperty();
	}
	
	
	
//	@GetMapping("/rentProperty/{tenantId}/{propertyId}")
//	public Object buyProperty(@PathVariable("tenantId") long tenantId ,@PathVariable("propertyId") long propertyId) 
//	{
//		return  transactionService.rentProperty(tenantId , propertyId );
//	}
	
	@GetMapping("/rentProperty/{tenantId}/{propertyId}")
	public Object buyProperty(@PathVariable("tenantId") long tenantId ,@PathVariable("propertyId") long propertyId) 
	{
		return  transactionService.rentProperty(tenantId , propertyId );
	}
	
}
