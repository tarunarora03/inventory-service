package com.inventory.service;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inventory.dto.AssetDto;

@SpringBootTest
public class AssetServiceTest {

	@Autowired
	private AssetService service;
	
	@Test
	void testService() {
		
		//register Asset
		AssetDto dto = new AssetDto();
		dto.setName("someAssetName");
		dto.setBrand("someBrand");
		dto.setModel("someModel");
		dto.setRetired(true);
		dto.setSerial_number("12-12-32453");
		dto.setAcquisition(new Date());
		dto.setWarranty_expiration(new Date());
		dto.setOwnerId(7);
		dto.setUserId(28);
		dto.setType("storage");
		dto.setCost(1000);
		
		service.registerAsset(dto);
		
		//retrieve Asset
		List<AssetDto> assets = service.getAsset("someAssetName", 0, 5, "id");
		Assertions.assertEquals(1, assets.size());
		Assertions.assertTrue(assets.get(0).getRetired());
		Assertions.assertEquals("someAssetName", assets.get(0).getName());
		Assertions.assertEquals("someBrand", assets.get(0).getBrand());
		Assertions.assertEquals("someModel", assets.get(0).getModel());
		Assertions.assertEquals("12-12-32453", assets.get(0).getSerial_number());
		
		//delete Asset
		service.deleteAsset(assets.get(0).getId());
		assets = service.getAsset("someAssetName", 0, 5, "id");
		Assertions.assertEquals(0, assets.size());
		
	}
}
