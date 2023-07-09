package com.bill_soft.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {

	@Query(value="SELECT purchase_order_number FROM purchase_order GROUP BY purchase_order_number",nativeQuery=true)
	List<String> getpurchaseordernumberdropdownforsuperadmin();
	
	@Query(value="SELECT purchase_order_number FROM purchase_order where fk_admin_id=?1 GROUP BY purchase_order_number",nativeQuery=true)
	List<String> getpurchaseordernumberdropdownforadmin(Long fkAdminId);
	
	@Query(value="SELECT purchase_order_number FROM purchase_order where fk_oragnization_id=?1 GROUP BY purchase_order_number",nativeQuery=true)
	List<String> getpurchaseordernumberdropdownforOragnization(Long fkoragnizationId);
	
	@Query(value="SELECT * FROM purchase_order where purchase_order_number=?1 ",nativeQuery=true)
	List<PurchaseOrder> getpurchaseorderNumberdetailsbyquotationnumberforsuperadmin(Long ordernumber);
	
	@Query(value="SELECT * FROM purchase_order where purchase_order_number=?1 and fk_admin_id=?2 ",nativeQuery=true)
	List<PurchaseOrder> getpurchaseorderNumberdetailsbyquotationnumberforadmin(Long ordernumber, Long fkAdminId);
	
	@Query(value="SELECT * FROM purchase_order where purchase_order_number=?1 and fk_oragnization_id=?2 " ,nativeQuery=true)
	List<PurchaseOrder> getpurchaseorderNumberdetailsbyquotationnumberforOragnization(Long ordernumber,
			Long fkoragnizationId);
	
	@Query(value = "SELECT * FROM purchase_order" , nativeQuery=true)
	List<PurchaseOrder> getPurchaseOrderListForSuperAdmin();
	
	@Query(value="SELECT * FROM purchase_order where fk_admin_id =?1" , nativeQuery=true)
	List<PurchaseOrder> getPurchaseOrderListForAdmin(Long fkAdminId);
	
	@Query(value="SELECT * FROM purchase_order where fk_oragnization_id =?1" , nativeQuery=true)
	List<PurchaseOrder> getPurchaseOrderListForOrganization(Long fkOrganizationId);
	
	@Query(value="SELECT purchase_order_number FROM purchase_order WHERE fk_admin_id =?1 ORDER BY purchase_order_number", nativeQuery=true)
	List<String> getOrderNumber(Long fkAdminId);
	
	@Query(value = "SELECT purchaseOrderNumber FROM PurchaseOrder WHERE fkAdminId=?1 AND fkSupplierId=?2 GROUP BY purchaseOrderNumber")
	List<String> getPurchaseOrderNumberList(Long fkAdminId, Long supplierId);


}
