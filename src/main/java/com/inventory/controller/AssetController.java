package com.inventory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.AssetDto;
import com.inventory.entity.Asset;
import com.inventory.service.AssetService;

@RestController
@RequestMapping("/asset")
@Validated
public class AssetController {

	@Autowired
	private AssetService service;

	@PostMapping
	public int registerAsset(@Valid @RequestBody AssetDto assetDto) {
		System.out.println("Registration request recieved for: "+assetDto.getName());
		return service.registerAsset(assetDto);
	}

	@GetMapping("/{name}")
	public List<AssetDto> getAsset(@PathVariable String name) {
		System.out.println("requesting asset:"+name);
		return service.getAsset(name);
	}

	@DeleteMapping("/{assetId}")
	public void deleteAsset(@PathVariable int assetId) {
		service.deleteAsset(assetId);
	}

	@PutMapping("/{assetId}")
	public void editAsset(@PathVariable int assetId, @Valid @RequestBody AssetDto a) {
		System.out.println("Request to edit asset: "+ assetId);
		service.editAsset(assetId, a);
	}

}
