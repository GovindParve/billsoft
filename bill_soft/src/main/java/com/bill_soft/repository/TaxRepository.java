package com.bill_soft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.TaxDetails;

@Repository
public interface TaxRepository extends JpaRepository<TaxDetails,Long> {

	@Query(value="SELECT * FROM tax_details",nativeQuery=true)
	List<TaxDetails> gettaxlistforsuperadmin();

	@Query(value="SELECT * FROM tax_details where fk_oragnization_id=?1",nativeQuery=true)
	List<TaxDetails> gettaxlistfororagnization(Long fkOragnizationId);

	@Query(value="SELECT * FROM tax_details where fk_admin_id=?1",nativeQuery=true)
	List<TaxDetails> gettaxlistforadmin(Long fkAdminId);

	@Query(value="SELECT * FROM tax_details",nativeQuery=true)
	Optional<TaxDetails> gettaxeditforsuperadmin();

	@Query(value="SELECT * FROM tax_details where fk_admin_id=?1",nativeQuery=true)
	Optional<TaxDetails> gettaxeditforadmin(Long fkAdminId);
     
	@Query(value=" SELECT pk_tax_id,percentage FROM tax_details",nativeQuery=true)
	List<String> gettaxdropdownforsuperadmin();

	@Query(value=" SELECT pk_tax_id,percentage FROM tax_details where fk_oragnization_id=?1",nativeQuery=true)
	List<String> gettaxdropdownfororagnization(Long fkOragnizationId);
  
	@Query(value=" SELECT pk_tax_id,percentage FROM tax_details where fk_admin_id=?1",nativeQuery=true)
	List<String> gettaxdropdownforadmin(Long fkAdminId);

	@Query(value="SELECT * FROM tax_details where fk_oragnization_id=?1",nativeQuery=true)
	Optional<TaxDetails> gettaxeditfororagnization(Long fkOragnizationId);

}
