package com.exam.portal.Repository;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.exam.portal.Model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
	Organization findByOrganizationId(int organizationId);

	@Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM register_organization WHERE organization_id IN(?1)")
    void delOrg(List<Integer> organizationId);
}
