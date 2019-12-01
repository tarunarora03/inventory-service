package com.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.AssetDto;
import com.inventory.service.AssetService;

@RestController
@RequestMapping("/asset")
@Validated
public class AssetController {

	private static final Logger LOG = LoggerFactory.getLogger(AssetController.class);
	
	@Autowired
	private AssetService service;

	@PostMapping
	public int registerAsset(@Valid @RequestBody AssetDto assetDto) {
		LOG.info("Registration request recieved for: {}",assetDto.getName());
		return service.registerAsset(assetDto);
	}

	@GetMapping("/{name}")
	public List<AssetDto> getAsset(@PathVariable String name) {
		LOG.info("requesting asset: {}",name);
		return service.getAsset(name);
	}

	@DeleteMapping("/{assetId}")
	public void deleteAsset(@PathVariable int assetId) {
		LOG.info("Request received to delete Asset id {}",assetId);
		service.deleteAsset(assetId);
	}

	@PutMapping("/{assetId}")
	public void editAsset(@PathVariable int assetId, @Valid @RequestBody AssetDto a) {
		LOG.info("Request to edit asset: {}", assetId);
		service.editAsset(assetId, a);
	}

}
