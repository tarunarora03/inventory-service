package com.inventory.controller;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.inventory.dto.AssetDto;
import com.inventory.service.AssetService;

@WebMvcTest(AssetController.class)
public class AssetControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private AssetService service;
	
	@Test
	public void testRegistration() throws Exception {
		List<AssetDto> list = new ArrayList<>();
		AssetDto dto = new AssetDto();
		dto.setName("someAssetName");
		dto.setBrand("someBrand");
		dto.setModel("someModel");
		dto.setRetired(true);
		dto.setSerial_number("12-12-32453");
		list.add(dto);
		when(service.getAsset("someAsset", 0, 5, "id")).thenReturn(list);
		MvcResult response = mvc.perform(get("/asset/someAsset").contentType(APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		JSONArray jsonArr = new JSONArray(response.getResponse().getContentAsString());
		Assertions.assertEquals(1, jsonArr.length());
		Assertions.assertTrue(jsonArr.getJSONObject(0).getBoolean("retired"));
		Assertions.assertEquals("someAssetName", jsonArr.getJSONObject(0).getString("name"));
		Assertions.assertEquals("someBrand", jsonArr.getJSONObject(0).getString("brand"));
		Assertions.assertEquals("someModel", jsonArr.getJSONObject(0).getString("model"));
		Assertions.assertEquals("12-12-32453", jsonArr.getJSONObject(0).getString("serial_number"));
	}
	
}
