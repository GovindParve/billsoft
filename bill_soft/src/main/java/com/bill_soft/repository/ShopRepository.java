package com.bill_soft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.Shop;
@Repository
public interface ShopRepository extends JpaRepository<Shop,Long> {

	
	 @Query(value= "SELECT  fk_admin_id,admin_name,fk_user_id,user_name,fk_organization_id,organization_name,shop_name,shop_address,shop_registration_date,city,gst_no from shop_details where pk_shop_id=?1",nativeQuery=true)
	List<Shop> getListOfShop(Long pkShopId);

	 
	 @Query(value="SELECT * FROM shop_details",nativeQuery=true)
	List<Shop> getshoplistforsuperadmin();

	 @Query(value="SELECT * FROM shop_details where fk_organization_id=?1 ",nativeQuery=true)
	List<Shop> getshoplistfororganization(Long fkOrganizationId);

	 @Query(value="SELECT * FROM shop_details where fk_admin_id=?1 ",nativeQuery=true)
	List<Shop> getshoplistforadmin(Long fkAdminId);

	/*
	 * @Query(value="SELECT shop_name from shop_details ",nativeQuery=true)
	 * List<String> getshopname();
	 */

	 @Query(value="SELECT pk_shop_id,shop_name from shop_details ",nativeQuery=true)
	List<String> getshopdropdownforsuperadmin();

	 @Query(value="SELECT pk_shop_id,shop_name from shop_details where fk_admin_id=?1",nativeQuery=true)
	List<String> getshopdropdownforadmin(Long fkAdminId);

	 @Query(value="SELECT pk_shop_id,shop_name from shop_details where fk_organization_id=?1 ",nativeQuery=true)
	List<String> getshopdropdownfororganization(Long fkOrganizationId);


	 @Query(value="SELECT * from shop_details where pk_shop_id=?1",nativeQuery=true)
	Optional<Shop> editshopdetailsforsuperadmin(Long id);

	 @Query(value="SELECT * from shop_details where pk_shop_id=?1 AND fk_organization_id=?2",nativeQuery=true)
	Optional<Shop> editshopdetailsfororganization(Long id, Long fkOrganizationId);

	 @Query(value="SELECT * from shop_details where pk_shop_id=?1 AND fk_admin_id=?2",nativeQuery=true)
	Optional<Shop> editshopdetailsforadmin(Long id, Long fkAdminId);

@Query(value="SELECT sh.business_type FROM shop_details sh where organization_name=?1",nativeQuery=true)
	List<String> getallbuisnesstypeunderorganization(String username);

@Query(value="SELECT sh.business_type FROM shop_details ",nativeQuery=true)
List<String> getallbuisnesstypeundersuperadmin(String username);

@Query(value="SELECT sh.business_type FROM shop_details sh where admin_name=?1",nativeQuery=true)
List<String> getallbuisnesstypeunderadmin(String username);

@Query(value="SELECT sh.business_type FROM shop_details sh where fk_admin_id=?1",nativeQuery=true)
List<String> getallbuisnesstypeunderadmin(Long fkAdminId);

@Query(value="SELECT * FROM shop_details where pk_shop_id=?1",nativeQuery=true)
Shop selectalldetailsthoughshopid(Long fkShopId);

	//void getListOfShop(Long id);
	
	

}
