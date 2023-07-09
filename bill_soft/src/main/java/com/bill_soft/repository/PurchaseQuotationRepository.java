package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.PurchaseQuotation;
@Repository
public interface PurchaseQuotationRepository extends JpaRepository<PurchaseQuotation,Long>{

	@Query(value="SELECT quotation_number FROM purchase_quotation GROUP BY quotation_number",nativeQuery=true)
	List<String> getpurchasequotationnumberdropdownforsuperadmin();
	
	@Query(value="SELECT quotation_number FROM purchase_quotation where fk_admin_id=?1 GROUP BY quotation_number",nativeQuery=true)
	List<String> getpurchasequotationnumberdropdownforadmin(Long fkAdminId);
	
	@Query(value="SELECT quotation_number FROM purchase_quotation where fk_oragnization_id=?1 GROUP BY quotation_number",nativeQuery=true)
	List<String> getpurchasequotationnumberdropdownforOragnization(Long fkoragnizationId);
	
	@Query(value="SELECT * FROM purchase_quotation where quotation_number=?1 ",nativeQuery=true)
	List<PurchaseQuotation> getpurchasequotationnumberdetailsbyquotationnumberforsuperadmin(Long quotationnumber);
	
	@Query(value="SELECT * FROM purchase_quotation where quotation_number=?1 and fk_admin_id=?2 ",nativeQuery=true)
	List<PurchaseQuotation> getpurchasequotationnumberdetailsbyquotationnumberforadmin(Long quotationnumber, Long fkAdminId);
	
	@Query(value="SELECT * FROM purchase_quotation where quotation_number=?1 and fk_oragnization_id=?2 " ,nativeQuery=true)
	List<PurchaseQuotation> getpurchasequotationnumberdetailsbyquotationnumberforOragnization(Long quotationnumber,Long fkoragnizationId);
	
	@Query(value="SELECT quotation_number FROM purchase_quotation WHERE fk_admin_id =?1 ORDER BY quotation_number", nativeQuery=true)
	List<String> getQuotationNumber(Long fkAdminId);
	
	@Query("SELECT quotationNumber from PurchaseQuotation where fkSupplierId=?1 GROUP BY quotationNumber")
	List<String> getPurchaseQuotationNumberForSuperAdmin(Long supplierId);
	
	@Query("SELECT quotationNumber from PurchaseQuotation where fkSupplierId=?1 AND fkAdminId=?2 GROUP BY quotationNumber")
	List<String> getPurchaseQuotationNumberForAdmin(Long supplierId,Long fkAdminId);
	
	@Query("SELECT quotationNumber from PurchaseQuotation where fkSupplierId=?1 AND fkoragnizationId=?2 GROUP BY quotationNumber")
	List<String> getPurchaseQuotationNumberForOrganization(Long supplierId,Long fkOrganizationId);
	
	@Query("from PurchaseQuotation where quotationNumber=?1 AND fkAdminId=?2")
	List<PurchaseQuotation> getPurchaseOrderGrid(Long pqNumber,Long fkUserId);
	
	@Query(value = "SELECT fk_supplier_id, supplier_name FROM purchase_quotation WHERE quotation_number=?1 GROUP BY fk_supplier_id", nativeQuery = true)
	List<String> getSupplierDetailsForPurchaseOrderForSuperadmin(Long purchaseOrderId);

	@Query(value = "SELECT fk_supplier_id, supplier_name FROM purchase_quotation WHERE quotation_number =?1 AND fk_oragnization_id=?2 GROUP BY fk_supplier_id", nativeQuery = true)
	List<String> getSupplierDetailsForPurchaseOrderForOrganization(Long purchaseOrderId, Long fkOrganizationId);

	@Query("SELECT fkSupplierId, supplierName FROM PurchaseOrder WHERE purchaseOrderNumber=?1 GROUP BY fkSupplierId")
	List<String> getSupplierDetailsForPurchaseOrderForAdmin(Long purchaseOrderId);

	 

}
