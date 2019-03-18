package com.project.attendanceproject.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.attendanceproject.dto.AttendanceDTO;

/**
 * 
 * @author Emmanuel Raj
 *
 */
@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceDTO, Integer>
{
	List<AttendanceDTO> findByUserName(String userName);
	
	
	List<AttendanceDTO> findById(int id);
	
}
