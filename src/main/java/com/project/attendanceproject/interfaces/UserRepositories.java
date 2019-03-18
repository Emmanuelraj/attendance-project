package com.project.attendanceproject.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.attendanceproject.dto.User;


/**
 * 
 * @author Emmanuel Raj
 *
 */
@Repository
public interface UserRepositories  extends JpaRepository<User, Integer> 
{

	Optional<User> findByUsername(String username);

	}
