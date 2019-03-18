package com.project.attendanceproject.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
 
/**
 * 
 * @author Emmanuel Raj
 *
 */


@Entity
@Table(name="user")
public class User 
{
	
	
	
	


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@NotNull
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@NotEmpty
	private String username;
	
	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	@NotEmpty
	private String password;
	
	@Transient
	@NotEmpty
	private String confirmPassword;
	
	
	

    @NotNull
    @NotEmpty
	@Transient
	private String role;
	
	
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	
	
	
	
	
	 
	/**
 	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}




	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}




	public int getUserId() {
		return userId;
	}




	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}




	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}




	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}




	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}




	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}




	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}




	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}




	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}




	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}




	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}




	



	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}




	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}




	/**
	 * @param userId
	 * @param email
	 * @param username
	 * @param name
	 * @param password
	 * @param confirmPassword
	 * @param createdBy
	 * @param role
	 */
	public User(int userId, String email, String username, String name, String password, String confirmPassword,
			 String role,Set<Role> roles) {
		super();
		this.userId = userId;
		this.email = email;
		this.username = username;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		
		this.role = role;
		this.roles = roles;
	}

	
	//Copy constructor
	public User(User u) {
		super();
		this.userId = u.userId;
		this.email = u.email;
		this.username = u.username;
		this.name = u.name;
		this.password = u.password;
		this.confirmPassword = u.confirmPassword;
		this.role = u.role;
		this.roles= u.roles;
	}

	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
