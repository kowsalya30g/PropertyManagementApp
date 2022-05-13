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
import com.cg.exception.PropertyNotFoundException;
import com.cg.services.PropertyService;


@RestController
@RequestMapping("/property")
public class PropertyController {
		
	     @Autowired
	     private PropertyService propertyService; 
	     
	     @GetMapping("/getAllProperty")
	     public List<Property> getAllProperty() throws PropertyNotFoundException{
	    	 return propertyService.getAllProperty();
	     }

	    @PostMapping("/addProperty")
	  	public String addProperty(@Valid @RequestBody Property property)
	  	{
	  		//Property addedProperty = propertyService.addProperty(property);
	  		//return new ResponseEntity<Property>(addedProperty,HttpStatus.CREATED);
	    	return propertyService.addProperty(property);
	  	}
	    
	      
	     @GetMapping("/findPropertyById/{id}") 
	     public Property findProperty(@PathVariable("id") long id ) throws PropertyNotFoundException{
	  	   return propertyService.findProperty(id);  
	     }
	     
	     @GetMapping("/propertyType/{type}")
	     public List<Property> findPropertyByType(@PathVariable("type") String type ) throws PropertyNotFoundException{
	  	   return propertyService.findPropertyType(type);
	     }
	     
	     @GetMapping("/propertyAvailablity/{purpose}") 
	     public List<Property> findPropertyByAvalability(@PathVariable("purpose") String purpose ) throws PropertyNotFoundException{
	  	   return propertyService.findPropertyAvalability(purpose);
	     }
	     
	     @GetMapping("/propertyPrice/{purpose}/{type}/{price}")
	     public List<Property> findPropertyByPrice(@PathVariable("purpose") String purpose , @PathVariable("type") String type ,@PathVariable("price") double price){
	  	   return propertyService.findPropertyByPrice(purpose,type ,price);
	     }
	     
	     @GetMapping("/propertySortByPrice")
	     public List<Property> getAllPropertySortedByPrice(){
	    	 return propertyService.getAllPropertySortedByPrice();
	     }
	     
	     @GetMapping("/propertySortBySize")
	     public List<Property> getAllPropertySortedBySize(){
	    	 return propertyService.getAllPropertySortedBySize();
	     }
	     
	     @DeleteMapping("/deleteProperty/{id}")
	     public String deleteProperty(@PathVariable("id") long  id) throws PropertyNotFoundException {
	    	 return propertyService.deleteProperty(id);
	     }

    
}