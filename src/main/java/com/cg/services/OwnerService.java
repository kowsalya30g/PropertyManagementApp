package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entities.Owner;
import com.cg.repositories.OwnerRepository;


@Service
public class OwnerService {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public Owner getDocument(long ownerId)
	{
		return ownerRepository.findById(ownerId).get();
	}
	
	public Owner addOwner(Owner owner)
	{
		return ownerRepository.save(owner);
	}
	
	public List<Owner> getAllOwner()
	{
		return ownerRepository.findAll();
	}
	
	public ResponseEntity<Object> deleteOwner(Long ownerId)
	{
		ownerRepository.deleteById(ownerId);
		return new ResponseEntity<Object>("Record deleted successfully", HttpStatus.OK);
	}
	
	public Owner getOwnerById(Long ownerId)
	{
		return ownerRepository.findById(ownerId).get();
	}

}
