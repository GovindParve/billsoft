package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.bean.SaleReturnGridBean;
import com.bill_soft.entity.SaleReturn;

@Repository
public interface SaleReturnRepository extends JpaRepository<SaleReturn,Long>{

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.return_date=?1",nativeQuery=true)
	List<Object[]> getdatewisesalereturnreportforsuperadmin(String date);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.fk_oragnization_id=?1 AND s.return_date=?2",nativeQuery=true)
	List<Object[]> getdatewisesalereturnreportfororagnization(Long fkOragnizationId, String date);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.fk_admin_id=?1 AND s.return_date=?2",nativeQuery=true)
	List<Object[]> getdatewisesalereturnreportforadmin(Long fkAdminId, String date);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.return_date BETWEEN ?1 AND ?2",nativeQuery=true)
	List<Object[]> getrangewisesalereturnreportforsuperadmin(String fromDate, String toDate);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.fk_oragnization_id=?1 AND s.return_date BETWEEN ?2 AND ?3",nativeQuery=true)
	List<Object[]> getrangewisesalereturnreportfororagnization(Long fkOragnizationId, String fromDate, String toDate);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.fk_admin_id=?1 AND s.return_date BETWEEN ?2 AND ?3",nativeQuery=true)
	List<Object[]> getrangewisesalereturnreportforadmin(Long fkAdminId, String fromDate, String toDate);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.category_name=?1",nativeQuery=true)
	List<Object[]> getcategorywisesalereturnreportforsuperadmin(String categoryName);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.fk_oragnization_id=?1 AND s.category_name=?2",nativeQuery=true)
	List<Object[]> getcategorywisesalereturnreportfororagnization(Long fkOragnizationId, String categoryName);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.fk_admin_id=?1 AND s.category_name=?2",nativeQuery=true)
	List<Object[]> getcategorywisesalereturnreportforadmin(Long fkAdminId, String categoryName);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.bill_no=?1",nativeQuery=true)
	List<Object[]> getbillnowisesalereturnreportforsuperadmin(String billNo);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.fk_oragnization_id=?1 AND s.bill_no=?2",nativeQuery=true)
	List<Object[]> getbillnowisesalereturnreportfororagnization(Long fkOragnizationId, String billNo);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.fk_admin_id=?1 AND s.bill_no=?2",nativeQuery=true)
	List<Object[]> getbillnowisesalereturnreportforadmin(Long fkAdminId, String billNo);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.barcode_no=?1",nativeQuery=true)
	List<Object[]> getbarcodenonowisesalereturnreportforsuperadmin(String barcodeNo);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.fk_oragnization_id=?1 AND s.barcode_no=?2",nativeQuery=true)
	List<Object[]> getbarcodenowisesalereturnreportfororagnization(Long fkOragnizationId, String barcodeNo);

	@Query(value="SELECT s.bill_no,s.barcode_no,s.category_name,s.product_name,s.return_quantity,s.sale_price_including_tax,s.sale_price_excluding_tax,s.tax_percentage,s.tax_amount,s.discount,s.return_total FROM sale_return s WHERE s.fk_admin_id=?1 AND s.barcode_no=?2",nativeQuery=true)
	List<Object[]> getbarcodenowisesalereturnreportforadmin(Long fkAdminId, String barcodeNo);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SaleReturnGridBean( a.saleQuotationNo, a.companyName, a.customerName, a.contactNo, a.emailId, a.address, a.gstNo, a.billNo, a.billDate, a.barcodeNo, a.customerType, a.paymentMode, a.salePriceIncludingtax, a.salePriceExcludingTax, a.quantity, a.weight, a.unit, a.discount, a.discountAmount, a.cgst, a.sgst, a.igst, a.taxPercentage, a.taxAmount, a.totalExcludingTax, a.totalAmount, a.grossTotal, a.labourExpense, a.transportExpense, a.gstExpense, a.batchno, a.manufacturingDate, a.expiryDate, a.creditAmount, a.fkCatId, a.categoryName, a.fkSubCatId, a.subCategoryName, a.fkProductId, a.productName, a.fkShopId, a.shopName, a.fkAdminId, a.adminName, a.fkOragnizationId, a.oragnizationName, a.createdBy, a.createdDate, 0d) FROM BillDetails a WHERE a.billNo=?1 AND a.fkAdminId=?2")
	List<SaleReturnGridBean>getsalereturngrid(Long invoiceNumber, Long fkAdminId);

		
}
