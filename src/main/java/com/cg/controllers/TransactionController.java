package com.cg.controllers;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Property;
import com.cg.entities.TransactionDetails;
import com.cg.services.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	
	
	@GetMapping("/transaction/getAllProperties")
	public List<Property> getAllProperties()
	{
		 return transactionService.getAllProperty();
		
	}
	

	
	@GetMapping("/transaction/getAllTransactionDetails")
	public List<TransactionDetails> getAllTransactionDetails()
	{
		return transactionService.getAllTransactionDetails();
	}
	
	
	@GetMapping("/transaction/getFile")
	public String getFile() throws Exception
	{
		
       
			FileWriter fw=new FileWriter("D:/Capgemini_Intern_Docs/TransactionDetails3.txt",true);
			
			List<TransactionDetails> alltransactions=new ArrayList<TransactionDetails>();
			
			transactionService.getAllTransactionDetails().forEach(et -> {
				
				alltransactions.add(et);
				
			});
			
			for(int i=0;i<alltransactions.size();i++)
			{
				String buyer=alltransactions.get(i).getBuyerName();
				String tenant=alltransactions.get(i).getTenantName();
				double prize   =alltransactions.get(i).getAmmount();
				String owner=  alltransactions.get(i).getOwnerName();
				String property=alltransactions.get(i).getPropertyName();
				long transactionId= alltransactions.get(i).getTransactionId();
				
			    String details=	"TransactionId : "+transactionId+": -> "+"buyer :"+buyer+"\n"+"tenant :"+tenant+"\n"+"prize :"+prize+"\n"+
			                     "owner :"+owner+"\n"+"propertyName :"+property+"\n"+"\n"+"-------";
			    
			    fw.write(details);
				
				
				
			}
			
			fw.close();
			
		    return "file created on your disk : "+"(D:/Capgemini_Intern_Docs/TransactionDetails3.txt)";
	    
	}
	

}