package com.project.attendanceproject.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.attendanceproject.dto.AttendanceDTO;
import com.project.attendanceproject.interfaces.AttendanceRepository;


@Controller
public class AttendanceController
{
	
	
	
	//logger
	private final Logger log = Logger.getLogger(AttendanceController.class);

	
	
	//Autowired
	@Autowired
	AttendanceRepository  attendanceRepo;
	
	
	/**
	 * 
	 * @param attendanceSignIn
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@GetMapping("/secured/attendanceSignIn")
	public String  signInFormBackingObject(@ModelAttribute("attendanceSignIn")AttendanceDTO attendanceSignIn, BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response  ,Model model)
	{
	        log.info("FormbackingObject method");
	     
		     //set user
		     attendanceSignIn.setUserName(request.getRemoteUser());
		     attendanceSignIn.setStartDate(new Date());
		     attendanceSignIn.setEndDate(new Date());
		      
	    
	     if(attendanceSignIn.getUserName()!= null)
	      {
	    	 
	    	 List<AttendanceDTO>  ls = attendanceRepo.findByUserName(attendanceSignIn.getUserName());
	 	    	 
	    	 
	    	
	    	 
	    	 
	    	 for (AttendanceDTO attendanceDTO : ls) 
	    	  {
	    		   //both date equal means send errorMsg
	    		 
	    		 log.info(attendanceDTO.getEndDate());
	    		 
	    		 log.info(attendanceDTO.getStartDate());
		    		
	    		 
	    		 
	    		   if(attendanceDTO.getStartDate().equals(attendanceDTO.getEndDate()))
				   {
	    			   log.info("equals time start"+attendanceDTO.getStartDate().getTime()+""+attendanceDTO.getEndDate().getTime());
	    			   return "reAttendSignOut";
					}
	    		   
				   
				 /** else
				   {
					  
					  log.info("attendanceSignIn");
					 return "attendanceSignIn";
				   }*/
			  }
	    	 
	    	  return "attendanceSignIn";
	      }
	     else
	     {
	    	 return  "reAttendSignOut";
	     }
	     	     
	}
	
	/**
	 * 
	 * @param attendanceSignIn
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	
	@PostMapping("/secured/attendanceSignIn")
	public String onSubmitAttendanceSignIn(@ModelAttribute("attendanceSignIn")AttendanceDTO attendanceSignIn, BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response  ,Model model)
	  {
		
		        log.info("onSubmitAttendanceSignIn Method");
	            AttendanceDTO dto = new AttendanceDTO();
		  		
				 Date startDate =  new Date();
				 dto.setStartDate(startDate);
				   
			    Date endDate  =  new Date();
			    dto.setEndDate(endDate);
				   
		    /**
		     if(attendanceSignIn.getUserName()!= null )
		      {*/
		    	 
		    	 dto.setUserName(request.getRemoteUser());
			         
				   
				   long duration       =  endDate.getTime() - startDate.getTime();
				  
				   long diffInSeconds  = TimeUnit.MILLISECONDS.toSeconds(duration);
				   
				   long diffInMinutes  = TimeUnit.MILLISECONDS.toMinutes(duration);

				   long diffInHours    = TimeUnit.MILLISECONDS.toHours(duration);
				   
				   long diffInDays     = TimeUnit.MILLISECONDS.toDays(duration);
				   
				   
				   boolean unlock      = false;
				   
				   boolean isPresent   = true;
				   
				   
				   boolean halfDayPresent = false;
				   
				   boolean fullDayPresent = false;
				   
				   
				   String ipAddress = request.getRemoteAddr();
				   
				    //create the attendance Object and set the values in Params contructor
				   AttendanceDTO  attendanceDTO  = new AttendanceDTO(dto.getId(), dto.getUserName(), startDate, endDate, duration, unlock, ipAddress, diffInSeconds, diffInMinutes, diffInHours, diffInDays, isPresent, halfDayPresent, fullDayPresent);
			  
	              dto.setUserName(request.getRemoteUser());
	              //save into D
	              attendanceRepo.save(attendanceDTO);
	              
	              
	              return "errorMsg";
			     /**
	        }
		     else
		     {
		    	 return "errorMsg";
		     }*/
	
	
	  }	
	
	
	
	
	
	
	/**
	 * GetMapping of attendanceSignOut
	 */
	
	@GetMapping("/secured/attendanceSignOut")
	public String formAttendSignOut(@ModelAttribute("attendanceSignOut")AttendanceDTO attendanceSignOut, BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response  ,Model model)
	{
		log.info("formBacking Method signout");
		
		
		//fetch the UserName and their id based on equals of signInTime .equals(endDate)
		 //set user
	     attendanceSignOut.setUserName(request.getRemoteUser());
	   
	     
	     
	   
	     if (attendanceSignOut.getStartDate()!=null || attendanceSignOut.getEndDate()!=null)
	    	
	     {
	    	 return  "reAttendSignOut";
	     }
         		
		 List<AttendanceDTO>  ls = attendanceRepo.findByUserName(attendanceSignOut.getUserName());
		    
		 
		 
		for (AttendanceDTO attendanceDTO : ls) 
		 {
			
			
		      if(attendanceDTO.getStartDate().getTime()==(attendanceDTO.getEndDate().getTime()))
		      {
		    	  log.info("list and id"+attendanceDTO.getId());
		    	  
		    	 List<AttendanceDTO> al = attendanceRepo.findById(attendanceDTO.getId());
		    	  
		    	 
		    	  log.info(al);
		    	  
		    	     for (AttendanceDTO attendanceDTO2 : al) 
		    	     {
		    	    	 
		    	    	 log.info("al"+attendanceDTO2);
		    	    	 
		    	    	  attendanceSignOut.setStartDate(attendanceDTO2.getStartDate());
						
		    	    	  attendanceSignOut.setEndDate(new Date());
		    	     }
		    	     
		    	  return "attendanceSignOut";
		    	  
		      }
		      /**
		      else
		      {
		    	  
		    	  log.info("attendanceSignOut");
		    	  return "redirect:/secured/attendanceSignOut";
		      }*/
		 }

		return "attendanceSignOut";
	}
	

	@PostMapping("/secured/attendanceSignOut")
	public String SignOutOnSubmit(@ModelAttribute("attendanceSignOut")AttendanceDTO attendanceSignOut, BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response  ,Model model)
	{
		
		attendanceSignOut.setUserName(request.getRemoteUser());
		
		log.info("attendanceSignOut onSubmit method"+attendanceSignOut.getUserName());
		
		
		 List<AttendanceDTO>  ls = attendanceRepo.findByUserName(attendanceSignOut.getUserName());
		    
		 
		for (AttendanceDTO attendanceDTO : ls) 
		 {
			
			log.info("inside for Loop"+ls);
			
			 if(attendanceDTO.getStartDate().getTime()==(attendanceDTO.getEndDate().getTime()))
		      {
		    	  log.info("list and id"+attendanceDTO.getId());
		    	  List<AttendanceDTO> al = attendanceRepo.findById(attendanceDTO.getId());
			    	 

		    	  log.info(al);
		    	  
		    	     for (AttendanceDTO attendanceDTO2 : al) 
		    	     {
		    	    	 
		    	    	 log.info("al"+attendanceDTO2);
		    	    	 
		    	    	
		    	    	 
		    	    	  attendanceSignOut.setStartDate(attendanceDTO2.getStartDate());
						
		    	    	  //attendanceSignOut.setEndDate(new Date());
		    	    	  
		    	    	  AttendanceDTO dto = new AttendanceDTO();
		    	    	  
		    	    	  dto.setUserName(attendanceDTO2.getUserName());
		    	    	  
		    	    	  dto.setId(attendanceDTO2.getId());
		    	    	  
		    	    	  long duration     = new Date().getTime()- attendanceDTO2.getStartDate().getTime();
							
						   dto.setStartDate(attendanceDTO2.getStartDate());
						   
						   dto.setEndDate(new Date());
						   
						   dto.setDuration(duration);
						   
						   long diffInSeconds  = TimeUnit.MILLISECONDS.toSeconds(duration);
						   
						   dto.setDiffInSeconds(diffInSeconds);
						   
						   long diffInMinutes  = TimeUnit.MILLISECONDS.toMinutes(duration);

						   dto.setDiffInMinutes(diffInMinutes);
						   
						   long diffInHours    = TimeUnit.MILLISECONDS.toHours(duration);
						   
						   dto.setDiffInHours(diffInHours);
						   
						   long diffInDays     = TimeUnit.MILLISECONDS.toDays(duration);
						   
						   dto.setDiffInDays(diffInDays);
						   
						   boolean unlock      = false;
						   
						   
						   boolean isPresent   = true;
						   
						   dto.setPresent(isPresent);
						   
						   String ipAddress = request.getRemoteAddr();
						   
						   dto.setIpAddress(ipAddress);
		    	    	 
						   boolean fullDayPresent = false;
						   
						   boolean halfDayPresent = false;
		    	    	 //update 
						  
						   if(diffInHours == 4 && (!( diffInHours<=8)))
						   {
							   log.info("HalfDay Present");
							   fullDayPresent = false;
							   halfDayPresent = true;
							   unlock = true;
							   dto.setFullDayPresent(fullDayPresent);
							   dto.setHalfDayPresent(halfDayPresent);
						       dto.setUnlock(unlock);
						   }
		    	    	 
						   else  if(diffInHours >= 4 &&(!( diffInHours<=8) ))
						   {
							   log.info("FullDay Present");
							   fullDayPresent = true;
							    halfDayPresent = false;
							    dto.setFullDayPresent(fullDayPresent);
							    dto.setHalfDayPresent(halfDayPresent);
							     dto.setUnlock(unlock);
						   }
						   
						   else
						   {
							   unlock = false;
							   dto.setUnlock(unlock);
						   }
							   
						       
						       
						       attendanceRepo.save(dto);
		    	     }
		    	     
		    	  return "attendanceSignOut";
		    	  
		      }
			 
		  
		 }
		
		
		
		
		return "attendanceSignOut";
	}
	
	
}