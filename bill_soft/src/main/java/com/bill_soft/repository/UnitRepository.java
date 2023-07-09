package com.bill_soft.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.UnitDetails;

@Repository
public interface UnitRepository  extends JpaRepository<UnitDetails ,Long>{

	@Query(value="SELECT * FROM unit_details",nativeQuery=true)
	List<UnitDetails> getunitdetailsforsuperadmin();

	@Query(value=" SELECT * FROM unit_details where fk_admin_id=?1",nativeQuery=true)
	List<UnitDetails> getunitdetailsforadmin(Long fkAdminId);

	@Query(value=" SELECT * FROM unit_details where fk_oragnization_id=?1",nativeQuery=true)
	List<UnitDetails> getunitdetailsfororganization(Long fkOrganizationId);
	
	@Query(value="SELECT pk_unit_id,unit_name FROM unit_details",nativeQuery=true)
	List<String> getunitdropdownforsuperadmin();
	
	@Query(value="SELECT pk_unit_id,unit_name FROM unit_details where fk_admin_id=?1",nativeQuery=true)
	List<String> getunitdropdownforadmin(Long fkAdminId);

	@Query(value="SELECT pk_unit_id,unit_name FROM unit_details where fk_organization_id=?1",nativeQuery=true)
	List<String> getunitdropdownfororagnization(Long fkOragnizationId);

	@Query(value="SELECT * FROM unit_details where pk_unit_id=?1",nativeQuery=true)
	Optional<UnitDetails> getuniteditforsuperadmin(Long id);

	@Query(value="SELECT * FROM unit_details where pk_unit_id=?1 AND fk_admin_id=?2",nativeQuery=true)
	Optional<UnitDetails> getuniteditforadmin(Long id,Long fkAdminId);

	
	@Query(value="SELECT * FROM unit_details where pk_unit_id=?1 AND fk_organization_id=?2",nativeQuery=true)
	Optional<UnitDetails> getuniteditfororagnization(Long id,Long fkOragnizationId);
	
	
	@Query(value="SELECT unitName From UnitDetails Where unitName=?1 and fkAdminId=?2")
	List<String> getUnitbyName(String unitName, Long fkADminId);
	
	
	
	
	

}
