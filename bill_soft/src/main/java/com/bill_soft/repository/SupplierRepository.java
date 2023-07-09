package com.bill_soft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.SupplierDetails;
@Repository
public interface SupplierRepository extends JpaRepository<SupplierDetails,Long> {
    @Query(value="SELECT * FROM supplier_details",nativeQuery=true)
	List<SupplierDetails> getsupplierlistforsuperadmin();

    @Query(value="SELECT * FROM supplier_details where fk_oragnization_id=?1",nativeQuery=true)
	List<SupplierDetails> getsupplierlistfororagnization(Long fkOragnizationId);
  
    @Query(value="SELECT * FROM supplier_details where fk_admin_id=?1",nativeQuery=true)
	List<SupplierDetails> getsupplierlistforadmin(Long fkAdminId);

	
   @Query(value="SELECT * FROM supplier_details where pk_suppplier_id=1?",nativeQuery=true)
   Optional<SupplierDetails> getsuppliereditforsuperadmin(Long id);

   @Query(value="SELECT * FROM supplier_details where pk_suppplier_id=?1 AND fk_oragnization_id=?2",nativeQuery=true)
   Optional<SupplierDetails> getsuppliereditfororagnization(Long id,Long fkOragnizationId);


   @Query(value="SELECT * FROM supplier_details where pk_suppplier_id=?1 AND fk_admin_id=?2",nativeQuery=true)
   Optional<SupplierDetails> getsuppliereditforadmin(Long id,Long fkAdminId);

   @Query(value="SELECT pk_suppplier_id,CONCAT(first_name,\" \",last_name)  as supplier_name",nativeQuery=true)
   List<String> getsupplierdropdownforsuperadmin();

   
   @Query(value="SELECT pk_suppplier_id,CONCAT(first_name,\" \",last_name)  as supplier_name FROM supplier_details where fk_oragnization_id=?1",nativeQuery=true)
    List<String> getsupplierdropdownfororagnization(Long fkOragnizationId);

   @Query(value="SELECT pk_suppplier_id,CONCAT(first_name,\" \",last_name)  as supplier_name FROM supplier_details WHERE fk_admin_id=?1",nativeQuery=true)
   List<String> getsupplierdropdownforadmin(Long fkAdminId);
   
   @Query(value="SELECT * FROM supplier_details WHERE email_id=?1",nativeQuery=true)
SupplierDetails findbyemailid(String emailId);

   

}
