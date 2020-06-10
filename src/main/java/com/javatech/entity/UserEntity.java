package com.javatech.entity;

import java.sql.Timestamp;

import com.javatech.anotatiton.Column;
import com.javatech.anotatiton.Table;

@Table("users")
public class UserEntity extends CommonEntity {
	@Column("email")
	private String email;
	@Column("username")
	private String username;
	@Column("password")
	private String password;
	@Column("phone_number")
	private String phoneNumber;
	@Column("address")
	private String address;
	@Column("dob")
	private Timestamp dob;
	@Column("university")
	private String university;
	@Column("role_id")
	private Integer roleId;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
