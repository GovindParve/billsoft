package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.bean.SaleQuotationGrid;
import com.bill_soft.bean.SalesBean;
import com.bill_soft.bean.SupplierWisePurchaseReport;
import com.bill_soft.entity.GoodReceive;
import com.bill_soft.entity.PurchaseReturn;

@Repository
public interface GoodReceiveRepository extends JpaRepository<GoodReceive, Long> {

	@Query(value = "SELECT new com.bill_soft.bean.SupplierWisePurchaseReport(g.billNo,g.supplierName,g.categoryName,g.subCategoryName,g.productName,g.barcodeNo,g.size,g.hsnsac,g.quantity,pr.returnQuantity,s.availableQuantity,b.quantity as soldQuantity) FROM GoodReceive g INNER JOIN PurchaseReturn pr ON g.fkProductId=pr.fkProductId INNER JOIN Stock s ON g.fkProductId=s.fkProductId INNER JOIN BillDetails b ON g.fkProductId=b.fkProductId WHERE supplierName=?1", nativeQuery = true)
	List<SupplierWisePurchaseReport> getsupplierwisepurchasereportforsuperadmin(String supplierName);

	@Query(value = "SELECT new com.bill_soft.bean.SupplierWisePurchaseReport(g.billNo,g.supplierName,g.categoryName,g.subCategoryName,g.productName,g.barcodeNo,g.size,g.hsnsac,g.quantity,pr.returnQuantity,s.availableQuantity,b.quantity as soldQuantity) FROM GoodReceive g INNER JOIN PurchaseReturn pr ON g.fkProductId=pr.fkProductId INNER JOIN Stock s ON g.fkProductId=s.fkProductId INNER JOIN BillDetails b ON g.fkProductId=b.fkProductId WHERE supplierName=?1 AND fkOragnizationId=?2", nativeQuery = true)

	List<SupplierWisePurchaseReport> getsupplierwisepurchasereportfororagnization(String supplierName,
			Long fkOragnizationId);

	@Query(value = "SELECT new com.bill_soft.bean.SupplierWisePurchaseReport(g.billNo,g.supplierName,g.categoryName,g.subCategoryName,g.productName,g.barcodeNo,g.size,g.hsnsac,g.quantity,pr.returnQuantity,s.availableQuantity,b.quantity as soldQuantity) FROM GoodReceive g INNER JOIN PurchaseReturn pr ON g.fkProductId=pr.fkProductId INNER JOIN Stock s ON g.fkProductId=s.fkProductId INNER JOIN BillDetails b ON g.fkProductId=b.fkProductId WHERE g.supplierName=?1 AND g.fkAdminId=?2")
	List<SupplierWisePurchaseReport> getsupplierwisepurchasereportforadmin(String supplierName, Long fkAdminId);
	// void saveAll(List<Object> list);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.created_date=?1 ", nativeQuery = true)
	List<Object[]> getsingledatewisepurchasereportforsuperadmin(String date);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE fk_oragnization_id=?1 AND  g.created_date=?2", nativeQuery = true)
	List<Object[]> getsingledatewisepurchasereportfororagnization(Long fkOragnizationId, String date);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE fk_admin_id=?1 AND  g.created_date=?2", nativeQuery = true)
	List<Object[]> getsingledatewisepurchasereportforadmin(Long fkAdminId, String date);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE  g.created_date BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Object[]> getrangewisepurchasereportforsuperadmin(String fromDate, String toDate);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.fk_oragnization_id=?1 AND  g.created_date BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Object[]> getrangewisepurchasereportfororagnization(Long fkOragnizationId, String fromDate, String toDate);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.fk_admin_id=?1 AND  g.created_date BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Object[]> getrangewisepurchasereportforadmin(Long fkAdminId, String fromDate, String toDate);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.category_name=?1", nativeQuery = true)
	List<Object[]> getcategorywisepurchasereportforsuperadmin(String category);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.fk_oragnization_id=?1 AND g.category_name=?2", nativeQuery = true)
	List<Object[]> getcategorywisepurchasereportfororagnization(Long fkOragnizationId, String category);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.fk_admin_id=?1 AND g.category_name=?2", nativeQuery = true)
	List<Object[]> getcategorywisepurchasereportforadmin(Long fkAdminId, String category);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.product_name=?1", nativeQuery = true)
	List<Object[]> getproductwisepurchasereportforsuperadmin(String productName);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.fk_oragnization_id=?1 AND g.product_name=?2", nativeQuery = true)
	List<Object[]> getproductwisepurchasereportfororagnization(Long fkOragnizationId, String productName);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.fk_admin_id=?1 AND g.product_name=?2", nativeQuery = true)
	List<Object[]> getproductwisepurchasereportforadmin(Long fkAdminId, String productName);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.bill_no=?1", nativeQuery = true)
	List<Object[]> getbillNowisepurchasereportforsuperadmin(String billNo);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.fk_oragnization_id=?1 AND g.bill_no=?2", nativeQuery = true)
	List<Object[]> getbillNowisepurchasereportfororagnization(Long fkOragnizationId, String billNo);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.fk_admin_id=?1 AND g.bill_no=?2", nativeQuery = true)
	List<Object[]> getbillNowisepurchasereportforadmin(Long fkAdminId, String billNo);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.barcode_number=?1", nativeQuery = true)
	List<Object[]> getbarcodeNowisepurchasereportforsuperadmin(String barcodeNo);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE  g.fk_oragnization_id=?1 AND g.barcode_number=?2", nativeQuery = true)
	List<Object[]> getbarcodeNowisepurchasereportfororagnization(Long fkOragnizationId, String barcodeNo);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE  g.fk_admin_id=?1 AND g.barcode_number=?2", nativeQuery = true)
	List<Object[]> getbarcodeNowisepurchasereportforadmin(Long fkAdminId, String barcodeNo);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE  g.created_date BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Object[]> getexpensewisepurchasereportforsuperadmin(String fromDate, String toDate);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.fk_oragnization_id=?1 AND  g.created_date BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Object[]> getexpensewisepurchasereportfororagnization(Long fkOragnizationId, String fromDate, String toDate);

	@Query(value = "SELECT g.bill_no,g.supplier_name,g.category_name,g.subcategory_name,g.product_name,g.hsn_or_sac,g.quantity,pr.return_quantity,s.available_quantity,b.quantity as sold_quantity  FROM good_receive g INNER JOIN purchase_return pr ON g.fk_product_id=pr.fk_product_id INNER JOIN stock s ON g.fk_product_id=s.fk_product_id  INNER JOIN bill_details b ON g.fk_product_id=b.fk_product_id WHERE g.fk_admin_id=?1 AND  g.created_date BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Object[]> getexpensewisepurchasereportforadmin(Long fkAdminId, String fromDate, String toDate);


	 @Query("SELECT DISTINCT new com.bill_soft.bean.SaleQuotationGrid(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN Stock b ON s.fkProductId = b.fkProductId WHERE s.fkProductId=?1 GROUP BY s.fkProductId") 
	 List<SaleQuotationGrid> getsalequotationgridforsuperadmin(Long productId);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SaleQuotationGrid(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN Stock b ON s.fkProductId = b.fkProductId WHERE s.fkProductId=?1 AND s.fkAdminId=?2 GROUP BY s.fkProductId") 
	List<SaleQuotationGrid> getsalequotationgridforadmin(Long productId, Long fkAdminId);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SaleQuotationGrid(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN Stock b ON s.fkProductId = b.fkProductId WHERE s.fkProductId=?1 AND s.fkoragnizationId=?2 GROUP BY s.fkProductId")
	List<SaleQuotationGrid> getsalequotationgridfororagnization(Long productId, Long fkoragnizationId);

	@Query(value = "SELECT bill_no FROM good_receive WHERE fk_admin_id=?1 GROUP BY bill_no ", nativeQuery = true)
	List<String> getGoodReceiveNumberList(Long fkAdminId);
	
	@Query(value = "SELECT good_receive_number FROM good_receive WHERE fk_admin_id=?1 GROUP BY good_receive_number ", nativeQuery = true)
	List<String> getGoodReceiveNumberListForStock(Long fkAdminId);
	
	@Query(value = "SELECT pk_good_receive_id, good_receive_number FROM good_receive where fk_admin_id=?1 ORDER BY good_receive_number DESC LIMIT 1", nativeQuery = true)
	List<String> getGoodReceiveNumber(Long fkAdminId);
	
	/////Queries To Get Data in Billing Grid ///////
	
	@Query(value= "SELECT g.pk_good_receive_id, g.barcode_number, g.batch_no, pd.product_name, g.company, g.hsn_or_sac , pd.sale_price_including_tax , st.available_quantity, g.unit, g.cgst, g.sgst, g.igst, g.tax_amount, g.discount, g.discount_amount, g.total_amount  from good_receive as g INNER JOIN stock st on g.fk_product_id=st.fk_product_id INNER JOIN product_details pd ON g.fk_product_id=pd.pk_product_id where g.fk_product_id= ?1", nativeQuery = true)
	List<String> getProductsInBillingGridbyProductIdForSuperAdmin(Long fkProductId);
	
	@Query(value= "SELECT g.pk_good_receive_id, g.barcode_number, g.batch_no, pd.product_name, g.company, g.hsn_or_sac , pd.sale_price_including_tax , st.available_quantity, g.unit, g.cgst, g.sgst, g.igst, g.tax_amount, g.discount, g.discount_amount, g.total_amount  from good_receive as g INNER JOIN stock st on g.fk_product_id=st.fk_product_id INNER JOIN product_details pd ON g.fk_product_id=pd.pk_product_id where g.fk_product_id=?1 AND g.fk_oragnization_id =?2", nativeQuery = true)
	List<String> getProductsInBillingGridbyProductIdForOrganization(Long fkProductId, Long fkOrganizationId);
	
	@Query(value= "SELECT g.pk_good_receive_id, g.barcode_number, g.batch_no, pd.product_name, g.company, g.hsn_or_sac , pd.sale_price_including_tax , st.available_quantity, g.unit, g.cgst, g.sgst, g.igst, g.tax_amount, g.discount, g.discount_amount, g.total_amount  from good_receive as g INNER JOIN stock st on g.fk_product_id=st.fk_product_id INNER JOIN product_details pd ON g.fk_product_id=pd.pk_product_id where g.fk_product_id=?1 AND g.fk_admin_id=?2", nativeQuery = true)
	List<String> getProductsInBillingGridbyProductIdForAdmin(Long fkProductId, Long fkAdminId);
	
	
	////Queries To Get Data For CashBook Through GoodReceive////
	
	
	////To Get Supplier List Whose Payment in Remaining///
	@Query("SELECT DISTINCT fkSupplierId, supplierName FROM GoodReceive Where supplierUnPaidAmt>0")
	List<String> getSupplierListForCashBookSuperAdmin();
	
	@Query("SELECT DISTINCT fkSupplierId, supplierName FROM GoodReceive Where supplierUnPaidAmt>0 AND fkAdminId=?1")
	List<String> getSupplierListForCashBookAdmin(Long fkAdminId);
	
	@Query("SELECT DISTINCT fkSupplierId, supplierName FROM GoodReceive Where supplierUnPaidAmt>0 AND fkoragnizationId=?1")
	List<String> getSupplierListForCashBookOrganization(Long fkOrganizationId);
	
	////Get Bill No for the Supplier Cashbook to Get Data in Dropdown
	
	@Query("SELECT DISTINCT billNo FROM GoodReceive Where fkSupplierId=?1 AND supplierUnPaidAmt>0 ")
	List<String> getbillNoListForCashBookSuperAdmin(Long fkSupplierId);
	
	@Query("SELECT DISTINCT billNo FROM GoodReceive Where fkAdminId=?1 AND fkSupplierId=?2 AND supplierUnPaidAmt>0")
	List<String> getbillNoListForCashBookAdmin(Long fkAdminId, Long fkSupplierId);
	
	@Query("SELECT DISTINCT billNo FROM GoodReceive Where fkoragnizationId=?1 AND fkSupplierId=?2 AND supplierUnPaidAmt>0")
	List<String> getbillNoListForCashBookOrganization(Long fkOrganizationId, Long fkSupplierId);
	
	
	////////Get Update Sale Quotation Grid By Product Id///////
	
	@Query("SELECT DISTINCT new com.bill_soft.bean.SalesBean(s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN Stock b ON s.fkProductId = b.fkProductId WHERE s.fkProductId=?1 GROUP BY s.fkProductId") 
	 List<SalesBean> getupdatesalequotationgridforsuperadmin(Long productId);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SalesBean(s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN Stock b ON s.fkProductId = b.fkProductId WHERE s.fkProductId=?1 AND s.fkAdminId=?2 GROUP BY s.fkProductId") 
	List<SalesBean> getupdatesalequotationgridforadmin(Long productId, Long fkAdminId);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SalesBean(s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN Stock b ON s.fkProductId = b.fkProductId WHERE s.fkProductId=?1 AND s.fkoragnizationId=?2 GROUP BY s.fkProductId")
	List<SalesBean> getsaleupdatequotationgridfororagnization(Long productId, Long fkoragnizationId);
	
	@Query(value = "SELECT * FROM purchase_return  WHERE created_date BETWEEN ?2 AND ?3 ", nativeQuery = true)
	List<PurchaseReturn> getpurchasereturnbetweentwodate(String fromDate, String toDate);

	////Supplier Wise Stock Inventory////
	
	@Query(value ="FROM GoodReceive WHERE createdDate BETWEEN ?1 AND ?2 AND fkSupplierId=?3")
	List<GoodReceive> getSupplierWiseStockReportForSuperadmin(String fromDate, String toDate, Long supplierId);
	
	@Query(value ="FROM GoodReceive WHERE createdDate BETWEEN ?2 AND ?3 AND fkSupplierId=?4 AND fkoragnizationId=?1")
	List<GoodReceive> getSupplierWiseStockReportForOrganisation(Long fkOrganisationId, String fromDate, String toDate, Long supplierId);
	
	@Query(value ="FROM GoodReceive WHERE createdDate BETWEEN ?2 AND ?3 AND fkSupplierId=?4 AND fkAdminId=?1")
	List<GoodReceive> getSupplierWiseStockReportForAdmin(Long fkAdminId, String fromDate, String toDate, Long supplierId);
	
	////Query for Invoice based inventory////
	
	@Query("FROM GoodReceive WHERE goodReceiveNumber=?1")
	List<GoodReceive> getInvoicewisepurchasereportforsuperadmin(Long goodReceiveNumber);
	
	@Query("FROM GoodReceive WHERE goodReceiveNumber=?1 AND fkoragnizationId=?2")
	List<GoodReceive> getInvoicewisepurchasereportfororganisation(Long goodReceiveNumber, Long fkOrganisationId);
	
	@Query("FROM GoodReceive WHERE goodReceiveNumber=?1 AND fkAdminId=?2")
	List<GoodReceive> getInvoicewisepurchasereportforadmin(Long goodReceiveNumber, Long fkAdminId);
	
	
	@Query("FROM GoodReceive ")
	List<GoodReceive> getInvoicewisepurchasereportforsuperadmin();
	
	@Query("FROM GoodReceive WHERE fkoragnizationId=?1")
	List<GoodReceive> getInvoicewisepurchasereportfororganisation( Long fkOrganisationId);
	
	@Query("FROM GoodReceive WHERE fkAdminId=?1")
	List<GoodReceive> getInvoicewisepurchasereportforadmin( Long fkAdminId);
	
	
	////Queries For Supplier List For Stock Reports
	
	@Query("SELECT fkSupplierId, supplierName From GoodReceive GROUP BY supplierName")
	List<String> getSupplierListForStockReportsSuperadmin();
	
	@Query("SELECT fkSupplierId, supplierName From GoodReceive WHERE fkoragnizationId=?1 GROUP BY supplierName")
	List<String> getSupplierListForStockReportsOrganisation(Long fkOragnizationId);
	
	@Query("SELECT fkSupplierId, supplierName From GoodReceive WHERE fkAdminId=?1 GROUP BY supplierName")
	List<String> getSupplierListForStockReportsAdmin(Long fkAdminId);
	
	
	
	
	
	
}
