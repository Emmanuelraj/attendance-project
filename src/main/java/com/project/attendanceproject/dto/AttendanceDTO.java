package com.project.attendanceproject.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Required;



@Entity
@Table(name="attendance")
public class AttendanceDTO 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@NotEmpty
	private String userName;
	

	//@NotEmpty
	private Date startDate;
	

	//@NotEmpty
	private Date endDate;
		

	//@NotEmpty
	private long duration;
		

	//@NotEmpty
	private boolean unlock;
		

	//@NotEmpty
	private String ipAddress;
	

	//@NotEmpty
	private long diffInSeconds;
	

	//@NotEmpty
	private long diffInMinutes;
	

	//@NotEmpty
	private long diffInHours;
	

	//@NotEmpty
	private long diffInDays;


	//@NotEmpty
	private  boolean isPresent;
	

	//@NotEmpty
	private  boolean halfDayPresent;
	

	//@NotEmpty
	private  boolean fullDayPresent;
	
	
	
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the duration
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(long duration) {
		this.duration = duration;
	}

	/**
	 * @return the diffInSeconds
	 */
	public long getDiffInSeconds() {
		return diffInSeconds;
	}

	/**
	 * @param diffInSeconds the diffInSeconds to set
	 */
	public void setDiffInSeconds(long diffInSeconds) {
		this.diffInSeconds = diffInSeconds;
	}

	/**
	 * @return the diffInMinutes
	 */
	public long getDiffInMinutes() {
		return diffInMinutes;
	}

	/**
	 * @param diffInMinutes the diffInMinutes to set
	 */
	public void setDiffInMinutes(long diffInMinutes) {
		this.diffInMinutes = diffInMinutes;
	}

	/**
	 * @return the diffInHours
	 */
	public long getDiffInHours() {
		return diffInHours;
	}

	/**
	 * @param diffInHours the diffInHours to set
	 */
	public void setDiffInHours(long diffInHours) {
		this.diffInHours = diffInHours;
	}

	/**
	 * @return the diffInDays
	 */
	public long getDiffInDays() {
		return diffInDays;
	}

	/**
	 * @param diffInDays the diffInDays to set
	 */
	public void setDiffInDays(long diffInDays) {
		this.diffInDays = diffInDays;
	}

	
	
	
	/**
	 * @return the unlock
	 */
	public boolean isUnlock() {
		return unlock;
	}

	/**
	 * @param unlock the unlock to set
	 */
	public void setUnlock(boolean unlock) {
		this.unlock = unlock;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}


	


	/**
	 * @return the isPresent
	 */
	public boolean isPresent() {
		return isPresent;
	}

	/**
	 * @param isPresent the isPresent to set
	 */
	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	/**
	 * @return the halfDayPresent
	 */
	public boolean isHalfDayPresent() {
		return halfDayPresent;
	}

	/**
	 * @param halfDayPresent the halfDayPresent to set
	 */
	public void setHalfDayPresent(boolean halfDayPresent) {
		this.halfDayPresent = halfDayPresent;
	}

	/**
	 * @return the fullDayPresent
	 */
	public boolean isFullDayPresent() {
		return fullDayPresent;
	}

	/**
	 * @param fullDayPresent the fullDayPresent to set
	 */
	public void setFullDayPresent(boolean fullDayPresent) {
		this.fullDayPresent = fullDayPresent;
	}

	

	/**
	 * @param id
	 * @param userName
	 * @param startDate
	 * @param endDate
	 * @param duration
	 * @param unlock
	 * @param ipAddress
	 * @param diffInSeconds
	 * @param diffInMinutes
	 * @param diffInHours
	 * @param diffInDays
	 * @param isPresent
	 * @param halfDayPresent
	 * @param fullDayPresent
	 */
	public AttendanceDTO(int id, String userName, Date startDate, Date endDate, long duration, boolean unlock,
			String ipAddress, long diffInSeconds, long diffInMinutes, long diffInHours, long diffInDays,
			boolean isPresent, boolean halfDayPresent, boolean fullDayPresent) {
		super();
		this.id = id;
		this.userName = userName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.unlock = unlock;
		this.ipAddress = ipAddress;
		this.diffInSeconds = diffInSeconds;
		this.diffInMinutes = diffInMinutes;
		this.diffInHours = diffInHours;
		this.diffInDays = diffInDays;
		this.isPresent = isPresent;
		this.halfDayPresent = halfDayPresent;
		this.fullDayPresent = fullDayPresent;
	}

	public AttendanceDTO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AttendanceDTO [id=" + id + ", userName=" + userName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", duration=" + duration + ", unlock=" + unlock + ", ipAddress=" + ipAddress
				+ ", diffInSeconds=" + diffInSeconds + ", diffInMinutes=" + diffInMinutes + ", diffInHours="
				+ diffInHours + ", diffInDays=" + diffInDays + ", isPresent=" + isPresent + ", halfDayPresent="
				+ halfDayPresent + ", fullDayPresent=" + fullDayPresent + "]";
	}
	
	
	
	
	

}
