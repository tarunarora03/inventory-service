package com.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	
	@Id
	private Integer id;
	private String email;
	private String first_name;
	private String last_name;
	
	@ManyToOne
	private Organization organization;

}
