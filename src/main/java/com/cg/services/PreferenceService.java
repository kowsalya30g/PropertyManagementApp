package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Preference;
import com.cg.repositories.PreferenceRepository;

@Service
public class PreferenceService {

	@Autowired
	private PreferenceRepository preferenceRepository;
	
	public Preference addPreferences(Preference preference)
	{
		return preferenceRepository.save(preference);
	}
	
	public List<Preference> getMaintenance()
	{
		return preferenceRepository.findAll();
	}
}
