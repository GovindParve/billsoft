package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bill_soft.bean.SaleInvoiceGridBean;
import com.bill_soft.bean.SaleQuotationGrid;
import com.bill_soft.bean.SalesBean;
import com.bill_soft.bean.UpdateSaleQuotationBean;
import com.bill_soft.entity.SaleQuotation;

@Repository
public interface SaleQuotationRepository extends JpaRepository<SaleQuotation, Long> {

	///// Get Data by pkSaleQuotationId for the update Sale Quotation///
	@Query("SELECT new com.bill_soft.bean.UpdateSaleQuotationBean(s.saleQuotationNo, s.barcodeNo, s.productName,s.fkProductId,s.company,s.hsnorsac,s.salePriceIncludingTax,s.salePriceExcludingTax,s.quantity,s.unit,s.sgst,s.cgst,s.igst,s.taxAmount,s.discount,s.discountAmount, s.totalExcludingTax,s.totalAmount,s.grossTotal,s.labourExpense,s.transportExpense,s.labourTaxAmount) From SaleQuotation s where pkSaleQuatationId=?1")
	UpdateSaleQuotationBean getSaleQuotationById(Long pkSaleQuotationId);

	// Get all PKSALeQuotationId to Delete data in Updation of Sale Quotation
	@Query("Select pkSaleQuatationId From SaleQuotation where saleQuotationNo=?1")
	List<Long> getAllPkSaleQuotationId(String saleQuotationId);

	// Get all PKSALeQuotationId to Delete data in Updation of Sale Quotation
	@Modifying
	@Transactional
	@Query(value = "Update sale_quotation SET `status`='Deactive' where pk_sale_quatation_id=?1", nativeQuery = true)
	void getSaleQuotatationDeactiveForUpdate(Long pksaleQuotationId);

	@Query("select pkSaleQuatationId , saleQuotationNo from SaleQuotation where fkAdminId=?1 GROUP BY saleQuotationNo")
	List<String> getSaleQuotationNumberList(Long fk_admin_Id);

	@Query("SELECT saleQuotationNo from SaleQuotation WHERE fkAdminId=?1 ORDER BY saleQuotationNo DESC")
	List<String> getLastEnteredSQNumberForAdmin(Long fkAdminId);

	@Query("SELECT new com.bill_soft.bean.SaleInvoiceGridBean(s.barcodeNo, b.productName, s.fkProductId, s.company, gr.hsnsac, s.salePriceIncludingTax, s.salePriceExcludingTax, b.availableQuantity, s.quantity, s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount, s.totalExcludingTax, s.totalAmount, s.grossTotal, s.quotationDate, s.customerName, s.contactNo, s.address, s.gstNo, s.emailId) FROM SaleQuotation s JOIN Stock b ON s.fkProductId = b.fkProductId JOIN GoodReceive gr on b.fkProductId=gr.fkProductId WHERE s.saleQuotationNo=?1 AND status='Active' GROUP BY s.fkProductId")
	List<SaleInvoiceGridBean> getsaleInvoicegridforsuperadmin(String sqNumber);

	@Query("SELECT new com.bill_soft.bean.SaleInvoiceGridBean(s.barcodeNo, b.productName, s.fkProductId, s.company, gr.hsnsac, s.salePriceIncludingTax, s.salePriceExcludingTax, b.availableQuantity, s.quantity, s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount, s.totalExcludingTax, s.totalAmount, s.grossTotal, s.quotationDate, s.customerName, s.contactNo,  s.address, s.gstNo, s.emailId) FROM SaleQuotation s JOIN Stock b ON s.fkProductId = b.fkProductId JOIN GoodReceive gr on b.fkProductId=gr.fkProductId WHERE s.saleQuotationNo=?1 AND s.fkAdminId=?2 AND status='Active' GROUP BY s.fkProductId")
	List<SaleInvoiceGridBean> getsaleInvoicegridforadmin(String sqNumber, Long fkAdminId);

	@Query("SELECT new com.bill_soft.bean.SaleInvoiceGridBean(s.barcodeNo, b.productName, s.fkProductId, s.company, gr.hsnsac, s.salePriceIncludingTax, s.salePriceExcludingTax, b.availableQuantity, s.quantity, s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount, s.totalExcludingTax, s.totalAmount, s.grossTotal, s.quotationDate, s.customerName, s.contactNo,  s.address, s.gstNo, s.emailId) FROM SaleQuotation s JOIN Stock b ON s.fkProductId = b.fkProductId JOIN GoodReceive gr on b.fkProductId=gr.fkProductId WHERE s.saleQuotationNo=?1 AND s.fkoragnizationId=?2 AND status='Active' GROUP BY s.fkProductId")
	List<SaleInvoiceGridBean> getsaleInvoicegridfororagnization(String sqNumber, Long fkoragnizationId);

	/// Methods to GET data in Sale Quotation Grid
	@Query("SELECT DISTINCT  new com.bill_soft.bean.SaleQuotationGrid(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN BarcodeNoWiseStock b ON s.fkProductId = b.fkProductId WHERE s.barcodeNo=?1 GROUP BY s.fkProductId")
	List<SaleQuotationGrid> getsalequotationgridforsuperadmin(String barcodNo);

	@Query("SELECT DISTINCT  new com.bill_soft.bean.SaleQuotationGrid(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN BarcodeNoWiseStock b ON s.fkProductId = b.fkProductId WHERE s.barcodeNo=?1 AND s.fkAdminId=?2 GROUP BY s.fkProductId")
	List<SaleQuotationGrid> getsalequotationgridforadmin(String barcodNo, Long fkAdminId);

	@Query("SELECT DISTINCT  new com.bill_soft.bean.SaleQuotationGrid(s.pkGoodReceiveId, s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN BarcodeNoWiseStock b ON s.fkProductId = b.fkProductId WHERE s.barcodeNo=?1 AND s.fkoragnizationId=?2 GROUP BY s.fkProductId")
	List<SaleQuotationGrid> getsalequotationgridfororagnization(String barcodNo, Long fkoragnizationId);

	////// Query to Get data in Update Sale Quotation Grid/////////
	@Query(" FROM SaleQuotation a where saleQuotationNo=?1 AND fkAdminId=?2 AND status='Active'")
	List<SaleQuotation> getGridForSaleQuotationRepository(String quotationNumber, Long fkUserId);

	@Query("from SaleQuotation where saleQuotationNo=?1 AND status='Active'")
	List<SaleQuotation> getSaleQuotationDetailsIdWiseForSuperadmin(String sqNumber);

	@Query("from SaleQuotation where fkAdminId=?1 AND saleQuotationNo=?2 AND status='Active'")
	List<SaleQuotation> getSaleQuotationDetailsIdWiseForAdmin(Long fkAdminId, String sqNumber);

	@Query("from SaleQuotation where fkAdminId=?1 AND saleQuotationNo=?2 AND status='Active'")
	List<SaleQuotation> getSaleQuotationDetailsIdWiseForOrganisation(Long fkOrgId, String sqNumber);

	/// Methods to GET data in Sale Quotation Grid
	@Query("SELECT DISTINCT new com.bill_soft.bean.SalesBean(s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN BarcodeNoWiseStock b ON s.fkProductId = b.fkProductId WHERE s.barcodeNo=?1 GROUP BY s.fkProductId")
	List<SalesBean> getsalequotationUpdategridforsuperadmin(String barcodNo);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SalesBean(s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN BarcodeNoWiseStock b ON s.fkProductId = b.fkProductId WHERE s.barcodeNo=?1 AND s.fkAdminId=?2 GROUP BY s.fkProductId")
	List<SalesBean> getsalequotationUpdategridforadmin(String barcodNo, Long fkAdminId);

	@Query("SELECT DISTINCT new com.bill_soft.bean.SalesBean(s.barcodeNo, s.productName, s.fkProductId, s.company, s.hsnsac, s.salePrice, b.availableQuantity,s.unit, s.sgst, s.cgst, s.igst, s.taxAmount, s.discount, s.discountAmount,s.totalExcludingTax, s.totalAmount, s.grossTotal) FROM GoodReceive s JOIN BarcodeNoWiseStock b ON s.fkProductId = b.fkProductId WHERE s.barcodeNo=?1 AND s.fkoragnizationId=?2 GROUP BY s.fkProductId")
	List<SalesBean> getsalequotationUpdategridfororagnization(String barcodNo, Long fkoragnizationId);

}
