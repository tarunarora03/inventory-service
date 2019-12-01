package com.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.AssetDto;
import com.inventory.entity.Asset;
import com.inventory.entity.Organization;
import com.inventory.entity.User;
import com.inventory.repository.AssetRepository;
import com.inventory.repository.OrganizationRepository;
import com.inventory.repository.UserRepository;
import com.inventory.util.RecordNotFoundException;

@Service
public class AssetService {

	@Autowired
	private AssetRepository assetRepository;
	
	@Autowired
	private OrganizationRepository orgRepo;
	
	@Autowired
	private UserRepository userRepo;
	 
	@Autowired
	private ModelMapper mapper;
	
	public int registerAsset(AssetDto a) {
		Asset asset = new Asset();
		mapper.map(a, asset);
		
		if(a.getUserId() != null) {  
			Optional<User> user = userRepo.findById(a.getUserId());
			if(user.isPresent())
				asset.setUser(user.get());
		}	

		Optional<Organization> organization = orgRepo.findById(a.getOwnerId());
		if(organization.isPresent()) {
			asset.setOrganization(organization.get());
			return assetRepository.saveAndFlush(asset).getId();
		} else {
			throw new RecordNotFoundException("No Organization Id found for Org Id",a.getOwnerId());
		}
		
	}

	public List<AssetDto> getAsset(String name) {
		List<Asset> assets = assetRepository.findByName(name);
		List<AssetDto> response = new ArrayList<>();
		for (Asset a : assets) {
			AssetDto dto = new AssetDto();
			mapper.map(a, dto);
			response.add(dto);
		}
		return response;
	}
	
	public void deleteAsset(int assetId) {
		Asset a = searchAsset(assetId);
		if (a != null)
			assetRepository.delete(a);
		else 
			throw new RecordNotFoundException("No Record found for",assetId);
	}
	
	public void editAsset(int assetId, AssetDto dto) {
		
		Asset a = searchAsset(assetId);
		if (a != null) {
			dto.setId(a.getId());
			mapper.map(dto, a);
			
			if(dto.getUserId() != null) {  
				Optional<User> user = userRepo.findById(dto.getUserId());
				if(user.isPresent())
					a.setUser(user.get());
			}	

			Optional<Organization> organization = orgRepo.findById(dto.getOwnerId());
			if(organization.isPresent()) {
				a.setOrganization(organization.get());
			} else {
				throw new RecordNotFoundException("No Organization Id found for Org Id",dto.getOwnerId());
			}

			assetRepository.save(a);
		}
	}

	private Asset searchAsset(int assetId) {
		Optional<Asset> a = assetRepository.findById(assetId);
		return a.isPresent() ? a.get() : null;
	}
}
