/**
 * 
 */
package com.project.attendanceproject.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.attendanceproject.dto.CustomUserDetails;
import com.project.attendanceproject.dto.User;
import com.project.attendanceproject.interfaces.UserRepositories;

/**
 * @author Emmanuel Raj
 *
 */

@Service
public class UserService  implements UserDetailsService
{

	
	
	
	
	
	@Autowired
	private UserRepositories userRepo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		// TODO Auto-generated method stub
		
		
		
		Optional <User> optionalUserList = userRepo.findByUsername(username);
		
		
		
		if(optionalUserList.isPresent())
		{
                  return new CustomUserDetails(optionalUserList.get());
		}
		
		
		else
		{
			throw new UsernameNotFoundException(username);
		}
		
	}
	
	
	

}
