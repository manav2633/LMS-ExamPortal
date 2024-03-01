package com.exam.portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.Model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
	Organization findByOrganizationId(int organizationId);

	void deleteByOrganizationId(int organizationId);
}
