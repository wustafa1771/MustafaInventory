package com.smartin.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User{

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "usersid")
	  private long UserId;

	  @Column(name = "name")
	  private String userName;

	  @Column(name = "surname")
	  private String userSurname;

	  @Column(name = "role")
	  private String userRole;


	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String isUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [id=" + UserId + ", userName=" + userName + ", userSurname=" + userSurname + ", userRole=" + userRole
				+ "]";
	}

	public User(String userName, String userSurname, String userRole) {
		super();
		this.userName = userName;
		this.userSurname = userSurname;
		this.userRole = userRole;
	}


	public User() {
	}
	  
	  
}
