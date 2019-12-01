package com.inventory.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
	
	Page<Asset> findByName(String name, Pageable pageable);
	
//	List<Asset> findByName(String name);
}
