package com.spring.bioMedical.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Appointment Entity - Matching ORIGINAL database schema
 */
@Entity
@Table(name = "app")
public class App {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String name;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String email;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String date;
	
	@Column(nullable = false, length = 100)
	private String time;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp regtime;

	// Constructors
	public App() {
		this.regtime = new Timestamp(System.currentTimeMillis());
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getRegtime() {
		return regtime;
	}

	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}
}
