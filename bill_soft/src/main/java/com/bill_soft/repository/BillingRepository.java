package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.bean.SaleInvoiceGridBean;
import com.bill_soft.bean.SaleReportBean;
import com.bill_soft.entity.BillDetails;

@Repository
public interface BillingRepository extends JpaRepository<BillDetails, Long> {

	@Query(value = "SELECT * FROM bill_details ", nativeQuery = true)
	List<BillDetails> getbillingeditgridforsuperadmin();

	@Query(value = "SELECT * FROM bill_details where fk_admin_id=?1", nativeQuery = true)
	List<BillDetails> getbillingeditgridforadmin(Long fkAdminId);

	@Query(value = "SELECT * FROM bill_details where fk_oragnization_id=?1", nativeQuery = true)
	List<BillDetails> getbillingeditgridfororagnization(Long fkoragnizationId);

	@Query(value = "SELECT * FROM bill_details ORDER BY bill_no DESC LIMIT 1 ", nativeQuery = true)
	BillDetails findlastbillnoforpdf();

	@Query(value = "SELECT * FROM bill_details b WHERE b.bill_no=?1 ", nativeQuery = true)
	List<BillDetails> findbybillNo(Long billNo);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE b.category_name=?1 AND b.bill_date BETWEEN ?2 AND ?3 ", nativeQuery = true)
	List<Object[]> getcategorywisesalereportforsuperadmin(String categoryName, String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE  b.fk_oragnization_id=?1 AND b.category_name=?2 AND b.bill_date BETWEEN ?3 AND ?4 ", nativeQuery = true)
	List<Object[]> getcategorywisesalereportfororagnization(Long fkOragnizationId, String categoryName, String fromDate,
			String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE  b.fk_admin_id=?1 AND b.category_name=?2 AND b.bill_date BETWEEN ?3 AND ?4 ", nativeQuery = true)
	List<Object[]> getcategorywisesalereportforadmin(Long fkAdminId, String categoryName, String fromDate,
			String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE b.product_name=?1 ", nativeQuery = true)
	List<Object[]> getproductwisesalereportforsuperadmin(String productName);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE b.fk_oragnization_id=?1 AND b.product_name=?2 ", nativeQuery = true)
	List<Object[]> getproductwisesalereportfororagnization(Long fkOragnizationId, String productName);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE b.fk_admin_id=?1 AND b.product_name=?2 ", nativeQuery = true)
	List<Object[]> getproductwisesalereportforadmin(Long fkAdminId, String productName);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE b.bill_date=?1 ", nativeQuery = true)
	List<Object[]> getsingledatewisesalereportforsuperadmin(String date);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE b.fk_oragnization_id=?1 AND b.bill_date=?2 ", nativeQuery = true)
	List<Object[]> getsingledatewisesalereportfororagnization(Long fkOragnizationId, String date);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE b.fk_admin_id=?1 AND b.bill_date=?2 ", nativeQuery = true)
	List<Object[]> getsingledatewisesalereportforadmin(Long fkAdminId, String date);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE b.bill_date BETWEEN ?1 AND ?2 ", nativeQuery = true)
	List<Object[]> getrangewisesalereportforsuperadmin(String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE  b.fk_oragnization_id=?1 AND b.bill_date BETWEEN ?2 AND ?3 ", nativeQuery = true)
	List<Object[]> getrangewisesalereportfororagnization(Long fkOragnizationId, String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE  b.fk_admin_id=?1  AND b.bill_date BETWEEN ?2 AND ?3 ", nativeQuery = true)
	List<Object[]> getrangewisesalereportforadmin(Long fkAdminId, String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE b.bill_date BETWEEN ?1 AND ?2 ", nativeQuery = true)
	List<Object[]> getuserwisesalereportforsuperadmin(String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE  b.fk_oragnization_id=?1 AND b.bill_date BETWEEN ?2 AND ?3 ", nativeQuery = true)
	List<Object[]> getuserwisesalereportfororagnization(Long fkOragnizationId, String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE  b.fk_admin_id=?1  AND b.bill_date BETWEEN ?2 AND ?3 ", nativeQuery = true)
	List<Object[]> getuserewisesalereportforadmin(Long fkAdminId, String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE b.bill_date BETWEEN ?1 AND ?2 ", nativeQuery = true)
	List<Object[]> getbillwisesalereportforsuperadmin(String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE  b.fk_oragnization_id=?1 AND b.bill_date BETWEEN ?2 AND ?3 ", nativeQuery = true)
	List<Object[]> getbillwisesalereportfororagnization(Long fkOragnizationId, String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE  b.fk_admin_id=?1  AND b.bill_date BETWEEN ?2 AND ?3 ", nativeQuery = true)
	List<Object[]> getbillwisesalereportforadmin(Long fkAdminId, String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE  b.payment_mode=?1  AND b.bill_date BETWEEN ?2 AND ?3 ", nativeQuery = true)
	List<Object[]> getpaymentmodewisesalereportforsuperadmin(String paymentMode, String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE  b.fk_oragnization_id=?1 AND b.payment_mode=?2  AND b.bill_date BETWEEN ?3 AND ?4 ", nativeQuery = true)
	List<Object[]> getpaymentmodewisesalereportfororagnization(Long fkOragnizationId, String paymentMode,
			String fromDate, String toDate);

	@Query(value = "SELECT b.bill_no,b.barcode_no,b.category_name,b.subcategory_name,b.product_name,b.quantity,p.buy_price,b.sale_price_including_tax,b.sale_price_excluding_tax,b.tax_percentage,b.discount,b.discount_amount,b.total_excluding_tax ,b.total_amount,b.bill_date FROM bill_details b INNER JOIN product_details p ON b.fk_product_id=p.pk_product_id WHERE  b.fk_admin_id=?1 AND b.payment_mode=?2 AND b.bill_date BETWEEN ?3 AND ?4 ", nativeQuery = true)
	List<Object[]> getpaymentmodewisesalereportforadmin(Long fkAdminId, String paymentMode, String fromDate,
			String toDate);

	@Query(value = "FROM BillDetails where paymentMode=credit AND billDate=?1 ", nativeQuery = true)
	List<SaleReportBean> getdatewisecreditcustomersalereportforsuperadmin(String date);

	@Query(value = "FROM BillDetails where paymentMode=credit AND billDate=?2 AND fkOragnizationId=?1")
	List<SaleReportBean> getdatewisecreditcustomersalereportfororagnization(Long fkOragnizationId, String date);

	@Query(value = "FROM BillDetails where paymentMode=credit AND billDate=?2 AND fkAdminId=?1")
	List<SaleReportBean> getdatewisecreditcustomersalereportreportforadmin(Long fkAdminId, String date);

	@Query(value = "SELECT DISTINCT bill_no from bill_details WHERE fk_admin_id=?1 ORDER BY bill_no", nativeQuery = true)
	List<String> getLastSINumber(Long fkAdminId);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SaleInvoiceGridBean(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity, 1d, s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN Stock b ON s.fkProductId = b.fkProductId WHERE s.fkProductId=?1 GROUP BY s.fkProductId")
	List<SaleInvoiceGridBean> getsaleInvoicegridforsuperadmin(Long productId);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SaleInvoiceGridBean(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity, 1d, s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN Stock b ON s.fkProductId = b.fkProductId WHERE s.fkProductId=?1 AND s.fkAdminId=?2 GROUP BY s.fkProductId")
	List<SaleInvoiceGridBean> getsaleInvoicegridforadmin(Long productId, Long fkAdminId);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SaleInvoiceGridBean(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity, 1d, s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN Stock b ON s.fkProductId = b.fkProductId WHERE s.fkProductId=?1 AND s.fkoragnizationId=?2 GROUP BY s.fkProductId")
	List<SaleInvoiceGridBean> getsaleInvoicegridfororagnization(Long productId, Long fkoragnizationId);

	/// Methods to GEt data in Sale Invoice Grid
	@Query("SELECT DISTINCT new com.bill_soft.bean.SaleInvoiceGridBean(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN BarcodeNoWiseStock b ON s.fkProductId = b.fkProductId WHERE s.barcodeNo=?1 GROUP BY s.fkProductId")
	List<SaleInvoiceGridBean> getsaleinvoicegridforsuperadmin(String barcodNo);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SaleInvoiceGridBean(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN BarcodeNoWiseStock b ON s.fkProductId = b.fkProductId WHERE s.barcodeNo=?1 AND s.fkAdminId=?2 GROUP BY s.fkProductId")
	List<SaleInvoiceGridBean> getsaleinvoicegridforadmin(String barcodNo, Long fkAdminId);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SaleInvoiceGridBean(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN BarcodeNoWiseStock b ON s.fkProductId = b.fkProductId WHERE s.barcodeNo=?1 AND s.fkoragnizationId=?2 GROUP BY s.fkProductId")
	List<SaleInvoiceGridBean> getsaleinvoicegridfororagnization(String barcodNo, Long fkoragnizationId);
	
	@Query("SELECT pkBillId , billNo from BillDetails where fkAdminId=?1 GROUP BY billNo")
	List<String> getSaleInoviceListName(Long fkAdminId);
	
	//// To Get the Credit Customer List For Cashbook///////
	
	@Query("SELECT DISTINCT contactNo, customerName FROM BillDetails WHERE creditAmount>0")
	List<String> getCreditCustomerListForSuperadmin();
	
	@Query("SELECT DISTINCT contactNo, customerName FROM BillDetails WHERE creditAmount>0 AND fkAdminId=?1")
	List<String> getCreditCustomerListForadmin(Long fkAdminId);
	
	@Query("SELECT DISTINCT contactNo, customerName FROM BillDetails WHERE creditAmount>0 AND fkOragnizationId=?1")
	List<String> getCreditCustomerListForOrganization(Long fkOrganizationId);
	
	@Query("SELECT DISTINCT billNo FROM BillDetails Where contactNo=?1")
	List<String>getCreditCustomerBillNo(String contactNo);
	
	///////To Get Credit Details For CashBook by Bill No
	
	@Query("SELECT DISTINCT billNo, grossTotal, creditAmount From BillDetails Where billNo=?1")
	List<String> getCreditDetailsForSuperadmin(Long billNo);
	
	@Query("SELECT DISTINCT billNo, grossTotal, creditAmount From BillDetails Where billNo=?2 AND fkAdminId=?1")
	List<String> getCreditDetailsForAdmin(Long fkAdminId, Long billNo);
	
	@Query("SELECT DISTINCT billNo, grossTotal, creditAmount From BillDetails Where billNo=?2 AND fkOragnizationId=?1")
	List<String> getCreditDetailsForOrganization(Long fkOrganizationId, Long billNo);
}
