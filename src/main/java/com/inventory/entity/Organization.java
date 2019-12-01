package com.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="organizations")
public class Organization {
	
	@Id
	private Integer id;
	
	private String name;
	private String address;
	
}
