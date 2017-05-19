package com.parth.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	public void setId(int id) {
		this.id = id;
	}

	private String email;
	
	private int   mobile;
	
	@Lob
	private byte[] icard;
	
	@Column(length=1)
	private String role;
	private String password;
	 

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	public Users(int id, String name, String email, int mobile, byte[] icard) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.icard = icard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public byte[] getIcard() {
		return icard;
	}

	public void setIcard(byte[] icard) {
		this.icard = icard;
	}

	public int getId() {
		return id;
	}
	

	
}
