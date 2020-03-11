package com.cts.project.userservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="stockuser")
public class User implements Serializable{

	private static final long serialVersionUID = -8190036218121292271L;
	@Id
	@GeneratedValue
	private Integer id;
	private String fullName;
	private String email;
	private long phoneNumber;
	private String userName;
	private String password;
	@Transient
	private String registerStatus;
	private long code;
	private Boolean active=false;
	private String role="ROLE_USER";

	public User() {

	}

	
	


	public User(Integer id, String fullName, String email, long phoneNumber, String userName, String password,
			String registerStatus, long code, Boolean active, String role) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.registerStatus = registerStatus;
		this.code = code;
		this.active = active;
		this.role = role;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(String registerStatus) {
		this.registerStatus = registerStatus;
	}
	
    
	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	

	public Boolean getActive() {
		return active;
	}





	public void setActive(Boolean active) {
		this.active = active;
	}





	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", userName="
				+ userName + ", password=" + password + ",active=" + active + "]";
	}
	
}
