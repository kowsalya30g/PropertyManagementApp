 package com.cg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;



@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private MyAuthenticationProvider myauthprovider;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(myauthprovider);
		
		// auth.inMemoryAuthentication().withUser("shubham").password( getpasswordEncoder.encode("shubham") ).roles("ADMIN");
	
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic();
		
	
		
		http.authorizeHttpRequests().antMatchers("/signup/**").authenticated().and().csrf().disable();
		http.authorizeHttpRequests().antMatchers("/owner/**").authenticated().and().csrf().disable();
		http.authorizeHttpRequests().antMatchers("/manager/**").authenticated().and().csrf().disable();
		http.authorizeHttpRequests().antMatchers("/property/**").authenticated().and().csrf().disable();
		http.authorizeHttpRequests().antMatchers("/staff/**").authenticated().and().csrf().disable();
		http.authorizeHttpRequests().antMatchers("/tenant/**").authenticated().and().csrf().disable();
		http.authorizeHttpRequests().antMatchers("/buyer/**").authenticated().and().csrf().disable();
		http.authorizeHttpRequests().antMatchers("/maintenance/**").authenticated().and().csrf().disable();
		
		http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
		
	}
	
	@Bean
	public BCryptPasswordEncoder getpasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
}













//http.formLogin();
//http.authorizeRequests().anyRequest().authenticated();

//http.authorizeRequests().
//antMatchers("/signup/**").hasAnyRole("ADMIN");






















/*
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * 
 * //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
 * InMemoryUserDetailsManager userDetailsService = new
 * InMemoryUserDetailsManager();
 * 
 * UserDetails user=
 * User.withUsername("shubham").password(getpasswordEncoder.encode("shubham"))
 * .authorities("read").build();
 * 
 * userDetailsService.createUser(user);
 * 
 * 
 * 
 * auth.userDetailsService(userDetailsService);
 * //.passwordEncoder(getpasswordEncoder);
 * 
 * }
 */
