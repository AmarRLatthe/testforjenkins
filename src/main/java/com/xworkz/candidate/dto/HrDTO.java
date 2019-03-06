package com.xworkz.candidate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hr")
public class HrDTO {

	public HrDTO() {
		System.out.println("Hr ...........");
	}
	
	@Id
	private String userId;
	private String password;
	private String phoneNumber;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "HrDTO [userId=" + userId + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}
}
