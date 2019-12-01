package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

}
