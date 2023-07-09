package com.bill_soft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

	@Query(value = "SELECT * FROM subcategory_details where fk_oragnization_id=?1", nativeQuery = true)
	List<SubCategory> getsubcategorylistfororgnization(Long fkOragnizationId);

	@Query(value = "SELECT * FROM subcategory_details ", nativeQuery = true)
	List<SubCategory> getsubcategorylistforsuperadmin();

	@Query(value = "SELECT * FROM subcategory_details where fk_admin_id=?1", nativeQuery = true)
	List<SubCategory> getsubcategorylistforadmin(Long fkAdminId);

	@Query(value = "SELECT * FROM subcategory_details where pk_subcategory_id=?1", nativeQuery = true)
	Optional<SubCategory> getsubcategoryeditforsuperadmin(Long id);

	@Query(value = "SELECT * FROM subcategory_details where pk_subcategory_id=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	Optional<SubCategory> getsubcategoryeditfororagnization(Long id, Long fkOragnizationId);

	@Query(value = "SELECT * FROM subcategory_details where pk_subcategory_id=?1 AND fk_admin_id=?2", nativeQuery = true)
	Optional<SubCategory> getsubcategoryeditforadmin(Long id, Long fkAdminId);

	@Query(value = "SELECT pk_subcategory_id,subcategory_name FROM subcategory_details", nativeQuery = true)
	List<String> getsubcategorydropdownlistforsuperadmin();

	@Query(value = "SELECT pk_subcategory_id,subcategory_name FROM subcategory_details where fk_admin_id=?1", nativeQuery = true)
	List<String> getsubcategorydropdownlistforadmin(Long fkAdminId);

	@Query(value = "SELECT pk_subcategory_id,subcategory_name FROM subcategory_details where fk_oragnization_id=?1", nativeQuery = true)
	List<String> getsubcategorydropdownlistfororagnization(Long fkOragnizationId);

	@Query(value = "SELECT pk_subcategory_id,subcategory_name FROM subcategory_details WHERE fk_category_id=?1 GROUP BY pk_subcategory_id", nativeQuery = true)
	List<String> getcategorywisesubcategorydropdownforsuperadminIdWise(Long categoryId);

	@Query(value = "SELECT pk_subcategory_id,subcategory_name FROM subcategory_details WHERE fk_category_id=?1 AND fk_admin_id=?2 GROUP BY pk_subcategory_id", nativeQuery = true)
	List<String> getcategorywisesubcategorydropdownforadminIdWise(Long categoryId, Long fkAdminId);

	@Query(value = "SELECT pk_subcategory_id,subcategory_name FROM subcategory_details WHERE fk_category_id=?1 AND fk_oragnization_id=?2 GROUP BY pk_subcategory_id", nativeQuery = true)
	List<String> getcategorywisesubcategorydropdownfororagnizationIdWise(Long categoryId, Long fkoragnizationId);

	@Query(value = "SELECT pk_subcategory_id, subcategory_name from subcategory_details", nativeQuery = true)
	List<String> getsubcategorydropdownlistforsuperadminPurchaseFilter();
	
	@Query(value = "SELECT pk_subcategory_id, subcategory_name from subcategory_details WHERE fk_category_id=?1", nativeQuery = true)
	List<String> getsubcategorydropdownlistforsuperadminPurchaseFilterCatId(Long categoryId);
	
	@Query(value = "SELECT pk_subcategory_id, subcategory_name from subcategory_details WHERE fk_admin_id=?1", nativeQuery = true)
	List<String> getsubcategorydropdownlistforadminPurchaseFilter(Long fkAdminId);
	
	@Query(value="SELECT pk_subcategory_id, subcategory_name from subcategory_details WHERE fk_admin_id=?1 AND fk_category_id =?2", nativeQuery = true)
	List<String> getsubcategorydropdownlistforadminPurchaseFilterCatId(Long fkAdminId,Long categoryId);
	
	@Query(value = "SELECT pk_subcategory_id, subcategory_name from subcategory_details WHERE fk_oragnization_id=?1", nativeQuery = true)
	List<String> getsubcategorydropdownlistfororagnizationPurchaseFilter(Long fkOrganizationId);
	
	@Query(value = "SELECT pk_subcategory_id, subcategory_name from subcategory_details WHERE fk_oragnization_id=?1 AND fk_category_id=?2", nativeQuery = true)
	List<String> getsubcategorydropdownlistfororagnizationPurchaseFilterCatId(Long fkOrganizationId, Long categoryId);
	
	///////////////////////////Removable/////////////////////////////
	@Query(value = "SELECT pk_subcategory_id,subcategory_name FROM subcategory_details WHERE category_name=?1", nativeQuery = true)
	List<String> getcategorywisesubcategorydropdownforsuperadmin(String categoryName);

	@Query(value = "SELECT pk_subcategory_id,subcategory_name FROM subcategory_details WHERE category_name=?1 AND fk_admin_id=?2", nativeQuery = true)
	List<String> getcategorywisesubcategorydropdownforadmin(String categoryName, Long fkAdminId);

	@Query(value = "SELECT pk_subcategory_id,subcategory_name FROM subcategory_details WHERE category_name=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	List<String> getcategorywisesubcategorydropdownfororagnization(String categoryName, Long fkoragnizationId);

}
