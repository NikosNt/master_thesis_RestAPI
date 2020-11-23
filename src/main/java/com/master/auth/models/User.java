package com.master.auth.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	//@Size(max = 20)
	private String username;

	@NotBlank
	//@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	//@Size(max = 120)
	private String password;

	private String fname;//edw egw
	private String lname;
	private String coordinatex;
	private String coordinatey;


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String password, String fname, String lname, String coordinatex, String coordinatey) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.fname = fname;//edw egw
		this.lname = lname;
		this.coordinatex = coordinatex;
		this.coordinatey = coordinatey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {//edw egw
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCoordinatex() {
		return coordinatex;
	}

	public void setCoordinatex(String coordinatex) {
		this.coordinatex = coordinatex;
	}

	public String getCoordinatey() {
		return coordinatey;
	}

	public void setCoordinatey(String coordinatey) {
		this.coordinatey = coordinatey;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
