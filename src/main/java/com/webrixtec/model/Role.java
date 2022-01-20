package com.webrixtec.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
    
    

}
