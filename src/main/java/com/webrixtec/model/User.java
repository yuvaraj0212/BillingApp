package com.webrixtec.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User")
public class User {




		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    private String userName;
	    private String phone;
	
		@NotNull(message = "email must not be empty")
	    private String email;
		 private Date date;
		@NotNull(message = "password must not be empty")
	    private String password;

	    @ManyToMany(cascade=CascadeType.ALL)
	    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles;
	    
	    
	    
		public Long getId() {
			return id;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

		 public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}

		

	    
	    
}
