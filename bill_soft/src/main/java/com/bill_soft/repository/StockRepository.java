package com.bill_soft.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bill_soft.entity.BarcodeNoWiseStock;
import com.bill_soft.entity.GoodReceive;
import com.bill_soft.entity.PurchaseReturn;
import com.bill_soft.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
	
	@Query(value = "SELECT s.available_quantity FROM stock s,good_receive g where g.fk_product_id=s.fk_product_id", nativeQuery = true)
	Double getexistquantity(Long PkGoodReceiveId);

	@Query(value = "SELECT s.available_quantity FROM stock s where s.fk_product_id=?1 GROUP BY s.fk_product_id", nativeQuery = true)
	Double getstockquantity(Long productId);

	@Query(value = "UPDATE available_quantity  FROM Stock ", nativeQuery = true)
	void updatestock(Long stockid);

	@Query(value = "select s.product_name FROM stock s , good_receive g where g.fk_product_id=s.fk_product_id", nativeQuery = true)
	Stock getproductnameforsingleentry();

	@Query("from Stock")
	List<Stock> getAllStockentry();

	@Modifying
	@Transactional
	@Query(value = "UPDATE  Stock s SET s.availableQuantity=s.availableQuantity - :availableQuantity ,s.updateDate=s.updateDate - :updateDate WHERE s.fkProductId=:fkProductId")
	void updateavailablequantity(@Param(value = "availableQuantity") Double availableQuantity,
			@Param(value = "updateDate") String updateDate, @Param(value = "fkProductId") Long fkProductId);

	@Query(value = "SELECT s.pk_stock_id FROM stock s WHERE s.fk_product_id=?1 GROUP BY fk_product_id ", nativeQuery = true)
	Long getstockid(Long fkproductId);

	@Query("FROM Stock")
	List<Stock> getcurrentstockreportforsuperadmin();

	@Query("FROM Stock")
	List<Stock> getcurrentstockreportfororagnization(Long fkOragnizationId);

	@Query("FROM Stock")
	List<Stock> getcurrentstockreportforadmin(Long fkAdminId);

	@Query(value = "SELECT * FROM stock", nativeQuery = true)
	List<Stock> downloadcurrentstockreportexcelforsuperadmin();

	@Query(value = "SELECT * FROM stock WHERE fk_oragnization_id=?1", nativeQuery = true)
	List<Stock> downloadcurrentstockreportexcelfororagnization(Long fkOragnizationId);

	@Query(value = "SELECT * FROM stock WHERE fk_admin_id=?1", nativeQuery = true)
	List<Stock> downloadcurrentstockreportexcelforadmin(Long fkAdminId);

	
	
	//////Category Wise Stock////////
	@Query("FROM Stock ")
	List<Stock> getcategorywisestockreportforsuperadmin(String fkUserId);
	
	@Query("FROM Stock WHERE fkcategoryId=?1")
	List<Stock> getcategorywisestockreportforsuperadmin(String fkUserId, Long fkCategoryId);
	
	
	@Query("FROM Stock WHERE fk_admin_id=?1 ")
	List<Stock> getcategorywisestockreportforadmin(Long fkAdminId);
	
	@Query("FROM Stock WHERE fk_admin_id=?1 AND fkcategoryId=?2")
	List<Stock> getcategorywisestockreportforadmin(Long fkAdminId, Long fkCategoryId);
	

	@Query( "FROM Stock WHERE fk_organization_id=?1")
	List<Stock> getcategorywisestockreportfororganization(Long fkOrganizationId);
	
	@Query( "FROM Stock WHERE fk_organization_id=?1 AND fkcategoryId=?2")
	List<Stock> getcategorywisestockreportfororganization(Long fkOrganizationId, Long fkCategoryId);

	/////////////////////

	@Query(value = "SELECT * FROM stock WHERE category_name=?1", nativeQuery = true)
	List<Stock> downloadcategorywisestockreportexcelforsuperadmin(String categoryName);

	@Query(value = "SELECT * FROM stock WHERE fk_organization_id=?1 AND fk_category_name=?2", nativeQuery = true)
	List<Stock> downloadcategorywisestockreportexcelfororagnization(Long fkOragnizationId, String categoryName);

	@Query(value = "SELECT * FROM stock WHERE fk_admin_id=?1 AND category_name=?2", nativeQuery = true)
	List<Stock> downloadcategorywisestockreportexcelforadmin(Long fkAdminId, String categoryName);

	@Query(value = "SELECT * FROM stock WHERE category_name=?1", nativeQuery = true)
	List<Stock> downloadcategorywisestockreportpdfforsuperadmin(String categoryName);

	@Query(value = "SELECT * FROM stock WHERE fk_organization_id=?1 AND category_name=?2", nativeQuery = true)
	List<Stock> downloadcategorywisestockreportpdffororagnization(Long fkOragnizationId, String categoryName);

	@Query(value = "SELECT * FROM stock WHERE fk_admin_id=?1 AND category_name=?2", nativeQuery = true)
	List<Stock> downloadcategorywisestockreportpdfforadmin(Long fkAdminId, String categoryName);

	/////////////////Barcode Based Inventory //////////////////////
	
	@Query("FROM BarcodeNoWiseStock ")
	List<BarcodeNoWiseStock> getbarcodenowisestockreportforsuperadmin();
	
	@Query("FROM BarcodeNoWiseStock Where barcodeNo=?1")
	List<BarcodeNoWiseStock> getbarcodenowisestockreportforsuperadmin(String barcodeNo);
	
	
	@Query("FROM BarcodeNoWiseStock WHERE fkoragnizationId=?1 ")
	List<BarcodeNoWiseStock> getbarcodenowisestockreportfororagnization(Long fkOragnizationId);
	
	@Query("FROM BarcodeNoWiseStock WHERE fkoragnizationId=?1 AND barcodeNo=?2 ")
	List<BarcodeNoWiseStock> getbarcodenowisestockreportfororagnization(Long fkOragnizationId, String barcodeNo);

	
	@Query("FROM BarcodeNoWiseStock where fkAdminId=?1 ")
	List<BarcodeNoWiseStock> getbarcodenowisestockreportforadmin(Long fkAdminId);
	
	@Query("FROM BarcodeNoWiseStock where fkAdminId=?1 AND barcodeNo=?2")
	List<BarcodeNoWiseStock> getbarcodenowisestockreportforadmin(Long fkAdminId, String barcodeNo);
	
	///////////Category Dropdown For Stock Trnasfer/////////////
	
	@Query("SELECT DISTINCT fkcategoryId, categoryName FROM Stock Where fkGodownId=?1")
	List<String> getCategoryListForStockForSuperAdmin(Long fkGodownId);
	
	@Query("SELECT DISTINCT fkcategoryId, categoryName FROM Stock Where fkGodownId=?1 AND fkAdminId=?2")
	List<String> getCategoryListForStockAdmin(Long fkGodownId, Long fkAdminId);
	
	@Query("SELECT DISTINCT fkcategoryId, categoryName FROM Stock Where fkGodownId=?1 AND fkoragnizationId=?2")
	List<String> getCategoryListForStockOrganization(Long fkGodownId, Long fkOrganizationId);
	
	/// Queries For Product List in  Stock Transfer///
	
	@Query("SELECT DISTINCT fkProductId, productName FROM Stock Where fkGodownId=?1 AND fkcategoryId=?2")
	List<String> getProductListForStockForSuperAdmin(Long fkGodownId, Long fkcategoryId);
	
	@Query("SELECT DISTINCT fkProductId, productName FROM Stock Where fkGodownId=?1 AND fkAdminId=?2 AND fkcategoryId=?3")
	List<String> getProductListForStockAdmin(Long fkGodownId, Long fkAdminId, Long fkcategoryId);
	
	@Query("SELECT DISTINCT fkProductId, productName FROM Stock Where fkGodownId=?1 AND fkoragnizationId=?2 AND fkcategoryId=3")
	List<String> getProductListForStockOrganization(Long fkGodownId, Long fkOrganizationId, Long fkcategoryId);
	
	/////Queries For Low Stock Report////
	
	@Query("From Stock Where availableQuantity<?1")
	List<Stock> getLowStockReportForSuperAdmin(Double quantity);
	
	@Query("From Stock Where availableQuantity<?1 AND fkoragnizationId=?2")
	List<Stock> getLowStockReportForOrganisation(Double quantity,Long fkOrganisation);
	
	@Query("From Stock Where availableQuantity<?1 AND fkAdminId=?2")
	List<Stock> getLowStockReportForAdmin(Double quantity, Long fkAdminId);
	
	//////////////Extras/////////////
	@Query(value = "SELECT * FROM stock WHERE barcode_no=?1", nativeQuery = true)
	List<Stock> getbarcodenowisestockreportfororagnization(String barcodeNo);
	
	
	

}
