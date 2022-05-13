package com.cg.security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.cg.repositories.UserRepository;


@Component
public class MyAuthenticationProvider implements AuthenticationProvider  {
	
	@Autowired
	UserRepository urepos;

	@Override
	public Authentication authenticate(Authentication authentication) throws BadCredentialsException {
		
		
		Map<String , String> storedCredentials = new HashMap<String , String>();
		
		urepos.findAll().stream().forEach( user -> {
			
			storedCredentials.put(user.getName(), user.getPassword());
			
		   });
		
		
		String username=authentication.getName();
		
		String password=authentication.getCredentials().toString();
		
		int find=0;
		
		for(Map.Entry eu : storedCredentials.entrySet())
		{
				if(eu.getKey().equals(username) && eu.getValue().equals(password))
				{
					
					find=1;	
				}
			
		}
		if(find==0)
		{
			
			    throw new BadCredentialsException(password);
			    
		}
		else
		{
			   return new UsernamePasswordAuthenticationToken(username, password , Arrays.asList());
		}
		
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
		
	}

}
