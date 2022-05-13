package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entities.Buyer;
import com.cg.entities.Property;
import com.cg.entities.TransactionDetails;
import com.cg.repositories.BuyerRepository;
import com.cg.repositories.PropertyRepository;
import com.cg.repositories.TransactionRepository;
import com.cg.services.BuyerService;
import com.cg.services.PropertyService;
import com.cg.services.TransactionService;

@SpringBootTest
public class TestTransactions {
	
	@Mock
	PropertyRepository propertyRepos;
	
	@InjectMocks
	PropertyService propertyService;
	
	@Mock
	TransactionRepository transactionRepos;
	
	@InjectMocks
	TransactionService transactionService;
	
	@Mock
	BuyerRepository buyerRepos;
	
	@InjectMocks
	BuyerService buyerService;
	
	@Mock
	Property property;
	
	@Test
	public void testBuyProperty()
	{
		
		Property property=new Property();
		long id=1;
		property.setPropertyId(id);
		property.setPropertyName("property1");
		
		
		when(propertyRepos.save(property)).thenReturn(property);
		
		propertyRepos.save(property);
		
		System.out.println(propertyRepos.save(property));
		
		when(propertyRepos.getById(id)).thenReturn(property);
		
		assertEquals(property, propertyRepos.getById(id));
		
	
	}

}