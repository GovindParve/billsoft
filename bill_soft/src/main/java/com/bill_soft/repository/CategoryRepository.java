package com.bill_soft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

	@Query(value="SELECT * FROM category_details",nativeQuery=true)
	List<Category> getcategorylistforsuperadmin();
	
	@Query(value="SELECT * FROM category_details where fk_oragnization_id=?1",nativeQuery=true)
	List<Category> getcategorylistfororagnization(Long fkOragnizationId);
	
	@Query(value="SELECT * FROM category_details where fk_admin_id=?1",nativeQuery=true)
	List<Category> getcategorylistforadmin(Long fkAdminId);

	@Query(value="SELECT * FROM category_details where pk_category_id=?1",nativeQuery=true)
	Optional<Category> getcategoryeditforsuperadmin(Long id);
	
	@Query(value="SELECT * FROM category_details where fk_oragnization_id=?1 AND pk_category_id=?2",nativeQuery=true)
	Optional<Category> getcategoryeditfororagnization(Long fkOragnizationId,Long id);
	
	@Query(value="SELECT * FROM category_details where fk_admin_id=?1 AND pk_category_id=?2 ",nativeQuery=true)
	Optional<Category> getcategoryeditforadmin(Long fkAdminId,Long id);

    @Query(value="SELECT pk_category_id,category_name FROM category_details",nativeQuery=true)
	List<String> getcategorydropdownforsuperadmin();
    
    @Query(value="SELECT pk_category_id,category_name FROM category_details where fk_oragnization_id=?1",nativeQuery=true)
   	List<String> getcategorydropdownfororagnization(Long fkOragnizationId);
    
    @Query(value="SELECT pk_category_id,category_name FROM category_details where fk_admin_id=?1",nativeQuery=true)
   	List<String> getcategorydropdownforadmin(Long fkAdminId);

    
}
