package com.project.attendanceproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;




@EnableGlobalMethodSecurity(prePostEnabled= true,securedEnabled=true)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	
	
	@Autowired
	private   UserService userDetails;
	/**
	 * */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{

		http.csrf().disable();
		   http .authorizeRequests()
		    .antMatchers("**/secured/**").authenticated()
		    .anyRequest().fullyAuthenticated()
		    .and()
		    .formLogin().permitAll();
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
	   auth.userDetailsService(userDetails)
	       .passwordEncoder(new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword)
			{
				
			    if(rawPassword.toString().equals(encodedPassword))
			    {
			        System.out.println(rawPassword);	
			    	return true;
			    }
			    else			    	
			    {
			    	
			    	System.out.println("false");
			        return false;
			    }
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return rawPassword.toString();
			}
		});
	
	}

}
