package com.cg.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Buyer;
import com.cg.entities.Property;
import com.cg.entities.Tenant;
import com.cg.entities.TransactionDetails;
import com.cg.repositories.BuyerRepository;
import com.cg.repositories.TenantRepository;
import com.cg.repositories.TransactionRepository;

@Service
public class TransactionService {
	
	
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	BuyerService buyerService;
	
	@Autowired
	BuyerRepository buyerRepository;
	
	@Autowired
	TenantRepository tenantRepository;
	
	
	public Object buyProperty(long buyerId ,long propertyId) 
	{
	
	Property property= propertyService.getAllProperty().stream().filter(eachProperty ->
	eachProperty.getSellOrRent().equals("forSale") && eachProperty.getPropertyId()==propertyId).findAny().get();
	                                       
	if(property == null) return "This property is not for buy";
	
	//Property property= (Property) propertyService.findProperty(propertyId).getBody();
	
	Buyer buyer=buyerRepository.findById(buyerId).get();
	
	if(buyer==null)  return "This buyerId is not exist";
	
	buyer.setProperty(property);
	
	if(!property.getSellOrRent().equals("sold") && !property.getSellOrRent().equals("Rented") )
	{
	
			
		TransactionDetails transactionDetails=new TransactionDetails();
		transactionDetails.setPropertyName(property.getPropertyName());
		transactionDetails.setAmmount(property.getPrice());
		transactionDetails.setBuyerName(buyer.getPersonName());
		transactionDetails.setOwnerName(property.getOwner().getPersonName());
		transactionDetails.setProperty(property);
		String buydate=LocalDate.now().toString();
		transactionDetails.setTransactionDate(buydate);
		
		
		propertyService.setPropertySold(propertyId, "sold");
	
	
	    return transactionRepository.save(transactionDetails);
	
	}
	
	    return "its already sold";
	
	}
	
	/*public Object rentProperty(long tenantId ,long propertyId) 
	{
		Property property;
		
		try {
			
	       property= propertyService.getAllProperty().stream().filter(eachProperty ->
	       eachProperty.getSellOrRent().equals("forRent") && eachProperty.getPropertyId()==propertyId).findAny().get();
	       
	       }
		
		catch (Exception exception){
			
			return "propertyId does not exist";
			
	}
		
	if(property == null) return "This property is not for rent";
	
	Tenant tenant=tenantRepository.findById(tenantId).get();
	
	if(tenant==null)  return "This tenantId is not exist";
	
	tenant.setProperty(property);
	
	if(!property.getSellOrRent().equals("sold") && !property.getSellOrRent().equals("Rented"))
	{
	
				
			TransactionDetails transactionDetails=new TransactionDetails();
			transactionDetails.setPropertyName(property.getPropertyName());
			transactionDetails.setAmmount(property.getPrice());
			transactionDetails.setTenantName(tenant.getPersonName());
			transactionDetails.setOwnerName(property.getOwner().getPersonName());
			transactionDetails.setProperty(property);
			String buydate=LocalDate.now().toString();
			transactionDetails.setTransactionDate(buydate);
			
			
			propertyService.setPropertySold(propertyId, "Rented");
			
			return transactionRepository.save(transactionDetails);
			
			}
			return "its already sold or Rented";
			
	
    }*/
	public Object rentProperty(long tenantId ,long propertyId) 
	{
		Property property;
		
		try {
			
	       property= propertyService.getAllProperty().stream().filter(eachProperty ->
	       eachProperty.getSellOrRent().equals("forRent") && eachProperty.getPropertyId()==propertyId).findAny().get();
	       
	       }
		
		catch (Exception exception){
			
			return "propertyId does not exist";
			
	}
		
	if(property == null) return "This property is not for rent";
	
	Tenant tenant=tenantRepository.findById(tenantId).get();
	
	if(tenant==null)  return "This tenantId is not exist";
	
	tenant.setProperty(property);
	
	if(!property.getSellOrRent().equals("sold") && !property.getSellOrRent().equals("Rented"))
	{
	
				
			TransactionDetails transactionDetails=new TransactionDetails();
			transactionDetails.setPropertyName(property.getPropertyName());
			transactionDetails.setAmmount(property.getPrice());
			transactionDetails.setTenantName(tenant.getPersonName());
			transactionDetails.setOwnerName(property.getOwner().getPersonName());
			transactionDetails.setProperty(property);
			String buydate=LocalDate.now().toString();
			transactionDetails.setTransactionDate(buydate);
			
			
			propertyService.setPropertySold(propertyId, "Rented");
			
			return transactionRepository.save(transactionDetails);
			
			}
			return "its already sold or Rented";
			
	
    }
	
	public List<Property> getAllProperty()
	{
		return propertyService.getAllProperty().stream().filter(f -> f.getSellOrRent().
				equals("forSale")).collect(Collectors.toList());
	}
	
	public List<TransactionDetails> getAllTransactionDetails()
	{
		return transactionRepository.findAll();
	}
	
	public double getAllMoney()
	{
		return transactionRepository.findAll().stream().map(tr -> tr.getAmmount()).reduce(Double :: sum).get();
	}
	
	public double getAllRentMoney()
	{
		return transactionRepository.findAll().stream().filter(tf -> tf.getTenantName()!=null).map(tr -> tr.getAmmount()).reduce(Double :: sum).get();
	}
	
	

}
