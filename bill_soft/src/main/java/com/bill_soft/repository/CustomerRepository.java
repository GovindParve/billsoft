package com.bill_soft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.CustomerDetails;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails,Long>{

	@Query(value="SELECT * FROM customer_details WHERE email_id=?1",nativeQuery=true)
	CustomerDetails findbyemailid(String emailId);

	@Query(value="SELECT * FROM customer_details",nativeQuery=true)
	List<CustomerDetails> getcustomerlistforsuperadmin();

	@Query(value="SELECT * FROM customer_details where fk_oragnization_id=?1",nativeQuery=true)
	List<CustomerDetails> getcustomerlistfororagnization(Long fkOragnizationId);

	@Query(value="SELECT * FROM customer_details where fk_admin_id=?1",nativeQuery=true)
	List<CustomerDetails> getcustomerlistforadmin(Long fkAdminId);

	
	@Query(value="SELECT * FROM customer_details where pk_customer_id=?1",nativeQuery=true)
	Optional<CustomerDetails> getcustomereditlistforsuperadmin(Long id);

	@Query(value="SELECT * FROM customer_details where pk_customer_id=?1 AND fk_oragnization_id=?2",nativeQuery=true)
	Optional<CustomerDetails> getcustomerlistfororagnization(Long id, Long fkOragnizationId);

	@Query(value="SELECT * FROM customer_details where pk_customer_id=?1 AND fk_admin_id=?2",nativeQuery=true)
	Optional<CustomerDetails> getcustomerlistforadmin(Long id, Long fkAdminId);

	@Query(value=" SELECT pk_customer_id,CONCAT(first_name,\" \",last_name) as customer_name FROM customer_details",nativeQuery=true)
	List<String> getcustomerdropdownlistforsuperadmin();

	@Query(value=" SELECT pk_customer_id,CONCAT(first_name,\" \",last_name) as customer_name FROM customer_details WHERE fk_oragnization_id=?1 ",nativeQuery=true)
	List<String> getcustomerdropdownlistfororagnization(Long fkOragnizationId);

	@Query(value=" SELECT pk_customer_id,CONCAT(first_name,\" \",last_name) as customer_name FROM customer_details WHERE fk_admin_id=?1 ",nativeQuery=true)
	List<String> getcustomerdropdownlistforadmin(Long fkAdminId);

	@Query(value = "SELECT * FROM customer_details WHERE pk_customer_id=?1", nativeQuery = true)
	CustomerDetails getcustomerlistforsuperadminIdWise(Long customerId);

	@Query(value = "SELECT * FROM customer_details where fk_oragnization_id=?1 AND pk_customer_id=?2", nativeQuery = true)
	CustomerDetails getcustomerlistfororagnizationIdWise(Long fkOragnizationId, Long customerId);

	@Query(value = "SELECT * FROM customer_details where fk_admin_id=?1 AND pk_customer_id=?2", nativeQuery = true)
	CustomerDetails getcustomerlistforadminIdWise(Long fkAdminId, Long customerId);
	
	


}
