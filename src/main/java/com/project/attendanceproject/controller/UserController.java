package com.project.attendanceproject.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.attendanceproject.dto.Role;
import com.project.attendanceproject.dto.User;
import com.project.attendanceproject.interfaces.UserRepositories;

@Controller
public class UserController 
{
	
	
		@Autowired
		private UserRepositories userJpaRepository;
		
		
		
		@GetMapping("/register")
		public String  register(@ModelAttribute("user")User user, BindingResult bindingResult)
		{
			
			
			return "register";
		}
	
	
	
	
	
		
		@ModelAttribute
		public void commonObjectMethod(Model model)
		{
			model.addAttribute("headerMsg", new Date());
		}
	




		@PostMapping("/registerForm")
		public String onSubmitRegisterForm( @Valid User userValid,@ModelAttribute("user")User user,BindingResult bindingResult, Model model)throws Exception
		{
			
			String out ="";
			try
			{
				Role role = new Role();
				role.setRole(user.getRole());
				Set<Role> roleList = new HashSet<Role>();
				roleList.add(role);
				user.setRoles(roleList);
				
				
				
				
					if(bindingResult.hasErrors() || (!user.getPassword().equals(user.getConfirmPassword())))
						{
					          System.out.println("bindingResult errors");
					          out= "register";
						}
					else
						{
						      model.addAttribute(userValid);
							  userJpaRepository.save(user);
							  out= "login";
						}		
			        }
			
			      catch(Exception e)
			          {
				         e.printStackTrace();
			          }
			
			return out;
			
		}
		
		
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/secured/loginAdmin")
		public String loginAdmin(HttpServletRequest request)
		{
			
			
			System.out.println("loggerAdmin Method called");
			
			
			return "homeAdmin";
		}
		
		
		
		@PreAuthorize("hasRole('ROLE_USER')")
		@GetMapping("/secured/loginUser")
		public String loginUser(HttpServletRequest request)
		{
			request.getRemoteUser();
			
			
			System.out.println("loggerUser method called");
			
			
			
			return "homeUser";
		}
		
		
		
		









	

}
