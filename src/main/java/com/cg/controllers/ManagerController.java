package com.cg.controllers;

import java.time.LocalDate;
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

import com.cg.entities.Buyer;
import com.cg.entities.Maintenance;
import com.cg.entities.Manager;
import com.cg.entities.Owner;
import com.cg.entities.Preference;
import com.cg.entities.Property;
import com.cg.entities.Staff;
import com.cg.entities.Tenant;
import com.cg.exception.CertificationNotFoundException;
import com.cg.exception.PersonNotFoundException;
import com.cg.exception.PropertyNotFoundException;
import com.cg.exception.QualificationNotFoundException;
import com.cg.services.BuyerService;
import com.cg.services.MaintenanceService;
import com.cg.services.ManagerService;
import com.cg.services.OwnerService;
import com.cg.services.PropertyService;
import com.cg.services.StaffService;
import com.cg.services.TenantService;
import com.cg.services.TransactionService;


@RestController

@RequestMapping("/admin")
public class ManagerController {
	
	@Autowired
	private ManagerService mservice;
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired 
	private MaintenanceService maintenanceService;
	
	@Autowired
	private TenantService tenantService;
	
	
	@PostMapping("/addManager")
	public ResponseEntity<Manager> addManagerDetails(@Valid @RequestBody Manager manager)
	{
		Manager savedManager=mservice.addManager(manager);
		return new ResponseEntity<Manager>(savedManager,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllManagers")
	public List<Manager> getAllManagers()
	{
		return mservice.getAll();
	}
	
    @GetMapping("/getManager/{id}")
    public ResponseEntity<Object> getManagerById(@PathVariable("id") long id) throws PersonNotFoundException
    {
		return new ResponseEntity<Object>(mservice.getManagerById(id),HttpStatus.OK);
    }
	
	@DeleteMapping("/delManager/{id}")
	public String deleteManagerById(@PathVariable("id") long id)
	{
		return mservice.deleteManagerInfo(id);
	}
	
	@PutMapping("/updateManagerList")
	public List<Manager> updateManagerList(@RequestBody Manager manager)
	{
		return mservice.updateManagerData(manager);
	}
	
	@RequestMapping("/updateManagerDetails/{id}/{certification}")
	public List<Manager> updateManagerDetails(@PathVariable("id") int id,@PathVariable("certification") String cdertification)
	{
		return mservice.updateManagerCertification(id, cdertification);
	}
	
	@GetMapping("/getManagerDateOfJoining/{id}")
	public String getManagerDateOfJoiningById(@PathVariable("id") long id)
	{
		return mservice.getDateOfJoiningById(id);
	}
	
	@GetMapping("/getManagerByQualification/{qualification}")
	public List<Manager> getManagerByQualification(@PathVariable("qualification") String qualification) 
			throws QualificationNotFoundException
	{
		return mservice.getByQualification(qualification);
	}
	
	@GetMapping("/getManagerByCertification/{certification}")
	public List<Manager> getManagerByCertification(@PathVariable("certification") String certification) 
			throws CertificationNotFoundException
	{
		return mservice.getByCertification(certification);
	}
	
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
	
	@GetMapping("/getStaff/{id}")
    public ResponseEntity<Object> getStaffById(@PathVariable("id") int id) throws PersonNotFoundException
    {
		return new ResponseEntity<>(staffService.getStaffById(id),HttpStatus.OK);
    }
	
	@RequestMapping("updateStaff/{personId}/{isAvailable}")
	public List<Staff> updateStaffAvailability(@PathVariable("personId")  long personId, 
			@PathVariable("isAvailable") boolean isAvailable) throws PersonNotFoundException{
		return staffService.updateStaffAvailability(personId, isAvailable);
	}
	
	@GetMapping("/getAllProperty")
	public List<Property> getAllProperty() throws PropertyNotFoundException
	{
		return propertyService.getAllProperty();
	}
	
     @PostMapping("/addProperty")
  	public ResponseEntity<?> addProperty(@Valid @RequestBody Property property){

  		Object addedProperty = propertyService.addProperty(property);
  		return new ResponseEntity<Object>(addedProperty,HttpStatus.CREATED);
  	}

     @GetMapping("/findProperty/{id}")
     public Property findProperty(@PathVariable("id") long id) throws PropertyNotFoundException {
 	 
    	 return propertyService.findProperty(id);   
   }
     
    
	@GetMapping("/propertyType/{type}")
     
     public ResponseEntity<Object> findPropertyByType(@PathVariable("type") String type )throws PropertyNotFoundException{
   
  	   return (ResponseEntity<Object>) propertyService.findPropertyType(type);
     }
     
     @GetMapping("/propertyAvl/{purpose}")
     public List<Property> findPropertyByAvalability(@PathVariable("purpose") String purpose )throws PropertyNotFoundException{

  	   return propertyService.findPropertyAvalability(purpose);
     }
     
     @GetMapping("/propertyPrice/{purpose}/{type}/{price}")
     public List<Property> findPropertyByPrice(@PathVariable("purpose") String purpose , @PathVariable("type") String type ,@PathVariable("price") double price)throws PropertyNotFoundException{
   
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
     
     @DeleteMapping("/delProperty/{id}")
     public ResponseEntity<?> deleteProperty(@PathVariable("id") long  id) throws PropertyNotFoundException { 	
    	 String output =  propertyService.deleteProperty(id);
    	 return new ResponseEntity<Object>(output,HttpStatus.OK);
     }
     
     @GetMapping("/getPropertyListByCity/{city}")
     public List<Property> getPropertyListByCity(@PathVariable("city") String city) throws PropertyNotFoundException
     {
    	 return buyerService.getPropertyByCity(city);
     }
     
     @PostMapping("/setAppointmentDate/{personId}")
 	public String setAppointmentDate(@PathVariable("personId") long personId, @RequestBody LocalDate date) throws PersonNotFoundException {
 		return buyerService.setAppointmentDate(personId, date); 
 	}
 	
 	@GetMapping("/getAppointmentDateAndTime/{personId}")
 	public String getAppointmentDateAndTime( @PathVariable("personId") long personId) throws PersonNotFoundException {
 		return buyerService.getAppointmentDateAndTime(personId);
 	}
 	
 	@GetMapping("/getPreferences/{personId}")
 	public Preference getPreferences(@PathVariable("personId") long personId) throws PersonNotFoundException {
 		return buyerService.getPreferences(personId);
 	}
 	
 	@GetMapping("/getAllBuyers")
 	public List<Buyer> getAllBuyers(){
 		return buyerService.getAllBuyers();
 	}
 	
 	@DeleteMapping("/deleteBuyer/{personId}")
 	public ResponseEntity<Object> deleteBuyer(@PathVariable("personId") long personId) throws PersonNotFoundException{
 		return buyerService.deleteBuyer(personId);
 	}
 	
 	@PostMapping("/changePreferences/{personId}")
 	public Object changePreferences(@PathVariable("personId") long personId,@RequestBody  Preference preferences) throws PersonNotFoundException{
 		
 		if(!buyerService.buyerExistsOrNot(personId)) return "BuyerId"+" -> "+personId+" : does not exist";
 		
 		return buyerService.changePreferences(personId, preferences);
 		
 	}
 	
 	@PostMapping("/addBuyer")
	public Buyer addBuyer(@RequestBody Buyer buyer)
	{
		return buyerService.addBuyer(buyer);
		
	}
	
 	
 	@GetMapping("/buyProperty/{buyerId}/{propertyId}")
 	public Object buyProperty(@PathVariable("buyerId") long buyerId ,@PathVariable("propertyId") long propertyId) 
 	{
 		return  transactionService.buyProperty(buyerId , propertyId );
 	}
 	
 	@GetMapping("/getBuyer/{propertyId}")
     public ResponseEntity<Object> getBuyerById(@PathVariable("propertyId") int propertyId)
     		throws PersonNotFoundException
     {
 		return new ResponseEntity<>(buyerService.getBuyerById(propertyId),HttpStatus.OK);
     }
	
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
	
}