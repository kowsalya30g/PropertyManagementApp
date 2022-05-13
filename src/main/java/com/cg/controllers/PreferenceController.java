package com.cg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Preference;
import com.cg.services.PreferenceService;

@RestController
public class PreferenceController {

	@Autowired
	private PreferenceService preferenceService;
	
	@PostMapping("/addPreferences")
	public ResponseEntity<Preference> addPreferences(@RequestBody Preference preference)
	{
		Preference savedPreference=preferenceService.addPreferences(preference);
		return new ResponseEntity<Preference>(savedPreference,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllPreferences")
	public List<Preference> getMaintenance()
	{
		return preferenceService.getMaintenance();
	}
}
