package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.GoodReceive;
import com.bill_soft.entity.PurchaseReturn;
@Repository
public interface PurchaseReturnRepository extends JpaRepository<PurchaseReturn,Long>
{
    @Query(value="SELECT pr.bill_no,pr.barcode_number,pr.category_name,pr.product_name,pr.return_quantity,pr.buy_price,pr.tax_percentage,pr.tax_amount,pr.total_amount FROM purchase_return pr where pr.created_date=?1",nativeQuery=true)
	List<Object[]> getdatewisepurchasereturnreportforsuperadmin(String date);

	 @Query(value="SELECT pr.bill_no,pr.barcode_number,pr.category_name,pr.product_name,pr.return_quantity,pr.buy_price,pr.tax_percentage,pr.tax_amount,pr.total_amount FROM purchase_return pr where pr.fk_oragnization_id=?1 AND pr.created_date=?2",nativeQuery=true)
     List<Object[]> getdatewisepurchasereturnreportfororagnization(Long fkOragnizationId, String date);


     @Query(value="SELECT pr.bill_no,pr.barcode_number,pr.category_name,pr.product_name,pr.return_quantity,pr.buy_price,pr.tax_percentage,pr.tax_amount,pr.total_amount FROM purchase_return pr  where pr.fk_admin_id=?1 AND pr.created_date=?2",nativeQuery=true)
	List<Object[]> getdatewisepurchasereturnreportforadmin(Long fkAdminId, String date);

	@Query(value="SELECT pr.bill_no,pr.barcode_number,pr.category_name,pr.product_name,pr.return_quantity,pr.buy_price,pr.tax_percentage,pr.tax_amount,pr.total_amount FROM purchase_return pr where pr.created_date BETWEEN ?1 AND ?2",nativeQuery=true)
	List<Object[]> getrangewisepurchasereturnreportforsuperadmin(String fromDate, String toDate);

	 @Query(value="SELECT pr.bill_no,pr.barcode_number,pr.category_name,pr.product_name,pr.return_quantity,pr.buy_price,pr.tax_percentage,pr.tax_amount,pr.total_amount FROM purchase_return pr where pr.fk_oragnization_id=?1 AND pr.created_date BETWEEN ?2 AND ?3 ",nativeQuery=true)
	List<Object[]> getrangewisepurchasereturnreportfororagnization(Long fkOragnizationId, String fromDate,
			String toDate);

	 @Query(value="SELECT pr.bill_no,pr.barcode_number,pr.category_name,pr.product_name,pr.return_quantity,pr.buy_price,pr.tax_percentage,pr.tax_amount,pr.total_amount FROM purchase_return pr where pr.fk_admin_id=?1 AND pr.created_date BETWEEN ?2 AND ?3 ",nativeQuery=true)
	List<Object[]> getrangewisepurchasereturnreportforadmin(Long fkAdminId, String fromDate, String toDate);

	 @Query(value="SELECT pr.bill_no,pr.barcode_number,pr.category_name,pr.product_name,pr.return_quantity,pr.buy_price,pr.tax_percentage,pr.tax_amount,pr.total_amount FROM purchase_return pr where pr.supplier_name=?1 AND pr.bill_no=?2",nativeQuery=true)
	List<Object[]> getbillnowisepurchasereturnreportforsuperadmin(String supplierName, String billNo);

	@Query(value="SELECT pr.bill_no,pr.barcode_number,pr.category_name,pr.product_name,pr.return_quantity,pr.buy_price,pr.tax_percentage,pr.tax_amount,pr.total_amount FROM purchase_return pr where pr.fk_oragnization_id=?1, pr.supplier_name=?2 AND pr.bill_no=?3",nativeQuery=true)
	List<Object[]> getbillnowisepurchasereturnreportfororagnization(Long fkOragnizationId, String supplierName,
			String billNo);

	@Query(value="SELECT pr.bill_no,pr.barcode_number,pr.category_name,pr.product_name,pr.return_quantity,pr.buy_price,pr.tax_percentage,pr.tax_amount,pr.total_amount FROM purchase_return pr where pr.fk_admin_id=?1, pr.supplier_name=?2 AND pr.bill_no=?3",nativeQuery=true)
	List<Object[]> getbillnowisepurchasereturnreportforadmin(Long fkAdminId, String supplierName, String billNo);
	
	@Query("from GoodReceive where billNo=?1")
	List<GoodReceive> getPurchaseReturnListForSuperAdmin(String billId);
	
	@Query("from GoodReceive where billNo=?1 AND fkAdminId=?2")
	List<GoodReceive> getPurchaseReturnListForAdmin(String billId, Long fkAdminId);
	
	@Query("from GoodReceive where billNo=?1 AND fkoragnizationId=?2")
	List<GoodReceive> getPurchaseReturnListForOrganization(String billId,Long fkOrganizationId);
	
	@Query(value = "SELECT fk_supplier_id ,supplier_name, contact_no from good_receive WHERE fk_admin_id=?1 GROUP BY fk_supplier_id,supplier_name, contact_no ", nativeQuery =true)
	List<String> getGoodReceivePurchaseReturn(Long fkAdminId);
	
	@Query(value =" SELECT bill_no from good_receive where fk_admin_id=?1 AND fk_supplier_id=?2 GROUP BY bill_no", nativeQuery = true)
	List<String> getgoodReceiveBillNoForPurchaseReturn(Long fkAdminId, Long fksupplierId);

	@Query(value = "SELECT sd.pk_suppplier_id, gr.supplier_name, sd.contact_number FROM good_receive as gr INNER JOIN supplier_details sd ON sd.pk_suppplier_id= gr.fk_supplier_id WHERE gr.fk_supplier_id =?1 AND gr.fk_admin_id=?2 GROUP BY pk_suppplier_id", nativeQuery = true)
	List<String> getSupplierDetailsIdWise(Long supplierId, Long fkAdminId);
	

}
