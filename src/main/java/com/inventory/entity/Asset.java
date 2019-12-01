package com.inventory.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import lombok.Data;

@Data
@Entity
@TypeDef(
	    name = "pgsql_enum",
	    typeClass =AssetType.class
	)

@Table(name="assets")
public class Asset {

	public static enum asset_type {storage, network, compute};
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String brand;
	private String model;
	private String serial_number;
	
	@Enumerated(EnumType.STRING)
	@Type( type = "pgsql_enum" )
	private asset_type type;
	
	private Date acquisition;
	private Date warranty_expiration;

	@ManyToOne
	@JoinColumn(name="owner_id")
	private Organization organization;
	@ManyToOne
	private User user;
	private Boolean retired;
	private Integer cost;


}
