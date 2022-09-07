package com.dojo.reactjava.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="userName")
	@Size(min=2, max=30, message="Username must be between 2-30 characters long.")
	private String userName;
	
	@Column(name="firstName")
	@Size(min=2, max=255, message="First name must be between 2-255 characters long.")
	private String firstName;
	
	@Column(name="lastName")
	@Size(min=2, max=255, message="Last name must be between 2-255 characters long.")
	private String lastName;
	
	@Column(name="email", unique=true)
	@Email(message="Please enter a valid email address.")
	private String email;
	
	@Column(name="password")
	@Size(min=8, max=255, message="Password must be at least 8 characters long.")
	private String password;
	
	@Transient
	@Size(min=8, max=255, message="Confirm password must be at least 8 characters long.")
	private String confirmPassword;
	
	@Column(name="created_at", updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@Column(name="updated_at")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

//    @Override
//    public String toString() {
//        return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
//                + lastName + ", email=" + email + ", created_at=" + createdAt + ", updated_at=" + updatedAt + "]";
//    }
	
	public User() {
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}