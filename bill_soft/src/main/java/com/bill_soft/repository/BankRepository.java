package com.bill_soft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.BankDetails;

@Repository
public interface BankRepository extends JpaRepository<BankDetails,Long>
{

	@Query(value="SELECT * FROM bank_details",nativeQuery=true)
	List<BankDetails> getbanklistforsuperadmin();

	@Query(value="SELECT * FROM bank_details WHERE fk_oragnization_id=?1",nativeQuery=true)
	List<BankDetails> getbanklistfororganization(Long fkOrganizationId);

	@Query(value="SELECT * FROM bank_details WHERE fk_admin_id=?1",nativeQuery=true)
	List<BankDetails> getbanklistforadmin(Long fkAdminId);

	@Query(value="SELECT * FROM bank_details where pk_bank_id=?1",nativeQuery=true)
	Optional<BankDetails> getbankeditlistforsuperadmin(Long id);

	@Query(value="SELECT * FROM bank_details where pk_bank_id=?1 AND fk_organization_id=?2",nativeQuery=true)
	Optional<BankDetails> getbankeditlistfororganization(Long id, Long fkOrganizationId);

	@Query(value="SELECT * FROM bank_details where pk_bank_id=?1 AND fk_admin_id=?2",nativeQuery=true)
	Optional<BankDetails> getbankeditlistforadmin(Long id, Long fkAdminId);



}
