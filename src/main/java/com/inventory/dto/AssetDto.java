package com.inventory.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AssetDto {

	private Integer id;
	private String name;
	private String brand;
	private String model;
	private String serial_number;
	private String type;
	private Date acquisition;
	private Date warranty_expiration;
	private Boolean retired;
	private Integer cost;

	private Integer ownerId;
	private Integer userId;

}
