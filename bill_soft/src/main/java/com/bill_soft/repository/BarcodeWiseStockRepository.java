package com.bill_soft.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bill_soft.entity.BarcodeNoWiseStock;

@Repository
public interface BarcodeWiseStockRepository extends JpaRepository<BarcodeNoWiseStock,Long> {

	@Query("FROM BarcodeNoWiseStock")
	List<BarcodeNoWiseStock> getallbarcodestock();
	
	//@Query("SELECT new com.bill_soft.bean.BarcodeNoWiseStockBean(pkBarcodeStockId, barcodeNoWiseStock) From BarcodeNoWiseStock where fkAdminId=?1 ORDER BY barcodeNoWiseStock DESC")
	@Query(value = "SELECT barcode_no FROM barcode_no_wise_stock WHERE fk_admin_id=?1 ORDER BY barcode_no DESC LIMIT 1", nativeQuery= true)
	String getLastEnteredBarcode(Long fkAdminId);
	
	
	////Queries To Get Barcode Number List for the Stock Reports Barcode Number Wise Dropdown///////////
	
	@Query("SELECT pkBarcodeStockId, barcodeNo FROM BarcodeNoWiseStock ")
	List<String> getBarcodeListForSuperadmin();
	
	@Query("SELECT pkBarcodeStockId, barcodeNo FROM BarcodeNoWiseStock WHERE fkoragnizationId=?1")
	List<String> getBarcodeListForOrganisation(Long fkOrganisationId);
	
	@Query("SELECT pkBarcodeStockId, barcodeNo FROM BarcodeNoWiseStock WHERE fkAdminId=?1")
	List<String> getBarcodeListForAdmin(Long fkAdminId);
	
	@Modifying
	@Transactional
	@Query(value= "UPDATE barcode_no_wise_stock set available_quantity=?1 where barcode_no=?2 ", nativeQuery= true)
	void updatebarcodeWiseStock(Double availableQuantity, String barcodeNo);

	
}
