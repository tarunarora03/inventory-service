package com.inventory.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AssetDto {

	private Integer id;
	@NotEmpty(message = "asset name cannot be null")
	private String name;
	@NotEmpty(message = "asset brand cannot be null")
	private String brand;
	@NotEmpty(message = "asset model cannot be null")
	private String model;
	@NotEmpty(message = "asset serial number cannot be null")
	private String serial_number;
	@NotEmpty(message = "asset type cannot be null")
	private String type;
	private Date acquisition;
	private Date warranty_expiration;
	@NotNull(message = "asset name cannot be null")
	private Boolean retired;
	private Integer cost;

	private Integer ownerId;
	private Integer userId;

}
