package com.inventory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
	
	Page<Asset> findByName(String name, Pageable pageable);
	
}
