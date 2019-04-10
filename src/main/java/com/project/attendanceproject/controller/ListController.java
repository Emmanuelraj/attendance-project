package com.project.attendanceproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.attendanceproject.dto.AttendanceDTO;
import com.project.attendanceproject.interfaces.AttendanceRepository;

@RestController
public class ListController 
{
	
	
	  @Autowired
     AttendanceRepository attendanceRepo;
	  
	  
	//logger
	  private static final Log logger = LogFactory.getLog(ListController.class);
	  
    /**
     * 
     * @return
     */
	//@GetMapping("/secured/list")
	public List<AttendanceDTO> listFormBackingObject()
	{
		logger.info("listFormBackingObject");
		return attendanceRepo.findAll();
	}
	
	
	@GetMapping("/secured/list")
	public  List<AttendanceDTO>  findById(HttpServletRequest request)
	{
		logger.info(request.getRemoteUser());
		return attendanceRepo.findByUserName(request.getRemoteUser());
	}
	
	
	
	
	
}
