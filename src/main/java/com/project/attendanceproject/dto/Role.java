package com.project.attendanceproject.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="role")
public class Role 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="role_id")
	private int roleId;
	@NotNull
	@NotEmpty
	private String  role;
	
	
	
	
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @param roleId
	 * @param role
	 */
	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	public Role() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	

}
