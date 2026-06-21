package com.spring.bioMedical.model;

import javax.persistence.*;

/**
 * User Entity - Matching ORIGINAL database schema
 */
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "confirmation_token")
	private String confirmationToken;
	
	@Column(unique = true, nullable = false)
	private String username; // This is the email address
	
	@Column(columnDefinition = "BIT")
	private Boolean enabled = true;
	
	@Column(name = "first_name")
	private String firstName;
	
	private String gender;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String password; // Plaintext in original project
	
	private String authority; // ROLE_ADMIN, ROLE_DOCTOR, ROLE_USER
	
	private String lastseen;

	// Constructors
	public User() {
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getLastseen() {
		return lastseen;
	}

	public void setLastseen(String lastseen) {
		this.lastseen = lastseen;
	}
}
