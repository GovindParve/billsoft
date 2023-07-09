package com.bill_soft.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.bean.ProductDetailsBean;
import com.bill_soft.bean.UpdateSaleQuotationBean;
import com.bill_soft.entity.ProductDetails;

@Repository
public interface ProductRepository extends JpaRepository<ProductDetails, Long> {

	@Query(value = "SELECT * FROM product_details", nativeQuery = true)
	List<ProductDetails> getproductlistforsuperadmin();

	@Query(value = "SELECT * FROM product_details where fk_oragnization_id=?1", nativeQuery = true)
	List<ProductDetails> getproductlistfororagnization(Long fkOragnizationId);

	@Query(value = "SELECT * FROM product_details where fk_admin_id=?1", nativeQuery = true)
	List<ProductDetails> getproductlistforadmin(Long fkAdminId);

	@Query(value = "SELECT fk_product_id ,product_name, subcategory_name, quantity from stock WHERE quantity > 0", nativeQuery = true)
	List<String> getproductdropdownlistforsuperadmin();

	@Query(value = "SELECT fk_product_id ,product_name, subcategory_name, quantity from stock WHERE quantity > 0 AND fk_oragnization_id=?1", nativeQuery = true)
	List<String> getproductdropdownlistfororagnization(Long fkOragnizationId);

	@Query(value = "SELECT fk_product_id ,product_name, subcategory_name, quantity from stock WHERE quantity > 0 AND fk_admin_id=?1", nativeQuery = true)
	List<String> getproductdropdownlistforadmin(Long fkAdminId);

	@Query(value = "SELECT new com.bill_soft.bean.ProductDetailsBean(p.productName,p.subcategoryName,p.hsnCode,p.manufactureCompany,p.unit,p.weight,p.mrp,t.taxName,p.cgst,p.sgst,p.igst) FROM ProductDetails p LEFT JOIN TaxDetails t  ON fk_tax_id=t.pkTaxId WHERE fk_category_id=?1 AND fk_subcategory_id=?2 AND pk_product_id=?3")
	List<ProductDetailsBean> getpurchasequotationgridforsuperadmin(Long fkCatId, Long fkSubCatId, Long fkProductId);

	@Query(value = "SELECT new com.bill_soft.bean.ProductDetailsBean(p.productName,p.subcategoryName,p.hsnCode,p.manufactureCompany,p.unit,p.weight,p.mrp,t.taxName,p.cgst,p.sgst,p.igst) FROM ProductDetails p LEFT JOIN TaxDetails t  ON fk_tax_id=t.pkTaxId WHERE fk_category_id=?1 AND fk_subcategory_id=?2 AND pk_product_id=?3 AND fk_oragnization_id=?4")
	List<ProductDetailsBean> getpurchasequotationgridfororagnization(Long fkCatId, Long fkSubCatId, Long fkProductId,
			Long fkOragnizationId);

	@Query(value = "SELECT new com.bill_soft.bean.ProductDetailsBean(p.productName,p.subcategoryName,p.hsnCode,p.manufactureCompany,p.unit,p.weight,p.mrp,t.taxName,p.cgst,p.sgst,p.igst) FROM ProductDetails p LEFT JOIN TaxDetails t  ON fk_tax_id=t.pkTaxId  WHERE fk_category_id=?1 AND fk_subcategory_id=?2 AND pk_product_id=?3 AND p.fkAdminId=?4")
	List<ProductDetailsBean> getpurchasequotationgridforadmin(Long fkCatId, Long fkSubCatId, Long fkProductId,
			Long fkAdminId);

	@Query(value = "SELECT * FROM product_details WHERE product_name=?1", nativeQuery = true)
	ProductDetails findbyproductname(String productName);

	@Query(value = "SELECT * FROM  product_details WHERE pk_product_id=?1", nativeQuery = true)
	List<ProductDetails> getgoodreceivegridforsuperadmin(Long productId);

	@Query(value = "SELECT  * FROM product_details WHERE pk_product_id=?1 AND fk_admin_id=?2", nativeQuery = true)
	List<ProductDetails> getgoodreceivegridforadmin(Long productId, Long fkAdminId);

	@Query(value = "SELECT  * FROM product_details WHERE pk_product_id=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	List<ProductDetails> getgoodreceivegridfororagnization(Long productId, Long fkoragnizationId);

//	@Query(value="SELECT product_name FROM  product_details WHERE product_name=?1",nativeQuery=true)  
//	List<ProductDetails> gerpurchasequotationgridforsuperadmin(String productname);
//
//	@Query(value="SELECT  * FROM product_details WHERE product_name=?1 AND fk_admin_id=?2",nativeQuery=true)
//	List<ProductDetails> gerpurchasequotationgridforadmin(String productname,Long fkAdminId);
//
//	@Query(value="SELECT  * FROM product_details WHERE product_name=?1 AND fk_oragnization_id=?2",nativeQuery=true)
//	List<ProductDetails> gerpurchasequotationgridfororagnization(String productname,Long fkoragnizationId);

	@Query(value = "SELECT product_name FROM  product_details WHERE product_name=?1", nativeQuery = true)
	List<ProductDetails> gerpurchaseordergridforsuperadmin(String productname);

	@Query(value = "SELECT  * FROM product_details WHERE product_name=?1 AND fk_admin_id=?2", nativeQuery = true)
	List<ProductDetails> gerpurchaseordergridforadmin(String productname, Long fkAdminId);

	@Query(value = "SELECT  * FROM product_details WHERE product_name=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	List<ProductDetails> gerpurchaseordergridfororagnization(String productname, Long fkoragnizationId);

	@Query(value = "SELECT product_name FROM  product_details WHERE product_name=?1", nativeQuery = true)
	List<ProductDetails> gerpurchaseordereditgridforsuperadmin(String productname);

	@Query(value = "SELECT  * FROM product_details WHERE product_name=?1 AND fk_admin_id=?2", nativeQuery = true)
	List<ProductDetails> gerpurchaseordereditgridforadmin(String productname, Long fkAdminId);

	@Query(value = "SELECT  * FROM product_details WHERE product_name=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	List<ProductDetails> gerpurchaseordereditgridfororagnization(String productname, Long fkoragnizationId);

	@Query(value = "SELECT product_name FROM  product_details WHERE product_name=?1", nativeQuery = true)
	List<ProductDetails> getbillinggridforsuperadmin(String productname);

	@Query(value = "SELECT  * FROM product_details WHERE product_name=?1 AND fk_admin_id=?2", nativeQuery = true)
	List<ProductDetails> getbillinggridforadmin(String productname, Long fkAdminId);

	@Query(value = "SELECT  * FROM product_details WHERE product_name=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	List<ProductDetails> getbillinggridfororagnization(String productname, Long fkoragnizationId);

	@Query(value = "SELECT product_name FROM  product_details WHERE product_name=?1", nativeQuery = true)
	List<ProductDetails> getbillingeditgridforsuperadmin(String productname);

	@Query(value = "SELECT  * FROM product_details WHERE product_name=?1 AND fk_admin_id=?2", nativeQuery = true)
	List<ProductDetails> getbillingeditgridforadmin(String productname, Long fkAdminId);

	@Query(value = "SELECT  * FROM product_details WHERE product_name=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	List<ProductDetails> getbillingeditgridfororagnization(String productname, Long fkoragnizationId);

	@Query(value = "SELECT product_name FROM  product_details WHERE product_name=?1", nativeQuery = true)
	List<ProductDetails> getsalequotationgridforsuperadmin(String productname);

	@Query(value = "SELECT  * FROM product_details WHERE product_name=?1 AND fk_admin_id=?2", nativeQuery = true)
	List<ProductDetails> getsalequotationgridforadmin(String productname, Long fkAdminId);

	@Query(value = "SELECT  * FROM product_details WHERE product_name=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	List<ProductDetails> getsalequotationgridfororagnization(String productname, Long fkoragnizationId);

	@Query(value = "SELECT * FROM product_details where pk_product_id=?1", nativeQuery = true)
	Optional<ProductDetails> getproducteditforsuperadmin(Long id);

	@Query(value = "SELECT * FROM product_details where pk_product_id=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	Optional<ProductDetails> getproducteditfororagnization(Long id, Long fkOragnizationId);

	@Query(value = "SELECT * FROM product_details where pk_product_id=?1 AND fk_admin_id=?2", nativeQuery = true)
	Optional<ProductDetails> getproducteditforadmin(Long id, Long fkAdminId);

	@Query(value = "SELECT pk_product_id,product_name From product_details where subcategory_name=?1 ", nativeQuery = true)
	List<String> getsubcategorywiseproductdropdownforsuperadmin(String subCategoryName);

	@Query(value = "SELECT pk_product_id,product_name From product_details where subcategory_name=?1 AND fk_admin_id=?2", nativeQuery = true)
	List<String> getsubcategorywiseproductdropdownforadmin(String subCategoryName, Long fkAdminId);

	@Query(value = "SELECT pk_product_id,product_name From product_details where subcategory_name=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	List<String> getsubcategorywiseproductdropdownfororagnization(String subCategoryName, Long fkoragnizationId);

	@Query("from ProductDetails where pkProductId=?1")
	List<ProductDetails> getproductdeatilsforpurchasequotationgridforsuperadmin(Long productId);

	@Query("from ProductDetails where pkProductId=?1 AND fkAdminId=?2")
	List<ProductDetails> getproductdeatilsforpurchasequotationgridforadmin(Long productId, Long fkAdminId);

	@Query("from ProductDetails where pkProductId=?1 AND fkoragnizationId=?2")
	List<ProductDetails> getproductdeatilsforpurchasequotationgridfororagnization(Long productId,
			Long fkOragnizationId);

	@Query(value = "SELECT pk_product_id, product_name from product_details where fk_category_id=?1", nativeQuery = true)
	List<String> getproductdropdownlistforsuperadmincategory(Long categoryId);

	@Query(value = "SELECT pk_product_id, product_name from product_details where fk_subcategory_id =?1", nativeQuery = true)
	List<String> getproductdropdownlistforsuperadminsubcategory(Long subCategoryId);

	@Query(value = "SELECT pk_product_id, product_name from product_details where fk_category_id=?1 AND fk_subcategory_id=?2", nativeQuery = true)
	List<String> getproductdropdownlistforsuperadminboth(Long categoryId, Long subCategoryId);

	@Query(value = "SELECT pk_product_id, product_name from product_details", nativeQuery = true)
	List<String> getproductdropdownlistforsuperadminnofilter();

	@Query(value = "SELECT pk_product_id, product_name from product_details where fk_category_id=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	List<String> getproductdropdownlistfororganizationcategory(Long categoryId, Long fkUserId);

	@Query(value = "SELECT pk_product_id, product_name from product_details where fk_subcategory_id=?1 AND fk_oragnization_id=?2", nativeQuery = true)
	List<String> getproductdropdownlistfororganizationsubcategory(Long subCategoryId, Long fkUserId);

	@Query(value = "SELECT pk_product_id, product_name from product_details where fk_subcategory_id=?2 AND fk_category_id=?1 AND fk_oragnization_id=?3", nativeQuery = true)
	List<String> getproductdropdownlistfororganizationboth(Long categoryId, Long subCategoryId, Long fkUserId);

	@Query(value = "SELECT pk_product_id, product_name from product_details where fk_oragnization_id=?1", nativeQuery = true)
	List<String> getproductdropdownlistfororganizationnofilter(Long fkOrganizationId);

	@Query(value = "SELECT pk_product_id, product_name from product_details where fk_category_id=?1 AND fk_admin_id=?2", nativeQuery = true)
	List<String> getproductdropdownlistforadmincategory(Long categoryId, Long fkAdminId);

	@Query(value = "SELECT pk_product_id, product_name from product_details where fk_subcategory_id=?1 AND fk_admin_id=?2", nativeQuery = true)
	List<String> getproductdropdownlistforadminsubcategory(Long subCategoryId, Long fkAdminId);

	@Query(value = "SELECT pk_product_id, product_name from product_details where fk_category_id=?1 AND fk_subcategory_id=?2 AND fk_admin_id=?3", nativeQuery = true)
	List<String> getproductdropdownlistforadminboth(Long categoryId, Long subCategoryId, Long fkUserId);

	@Query(value = "SELECT pk_product_id, product_name from product_details where fk_admin_id=?1", nativeQuery = true)
	List<String> getproductdropdownlistforadminnofilter(Long fkUserId);
	
	
	////Product Details To Increment the Barcode Number in Good Receive
	@Query(value = "SELECT * FROM product_details where pk_product_id=?1", nativeQuery = true)
	ProductDetails getproductForBarcode(Long id);
	
	@Query("SELECT DISTINCT new com.bill_soft.bean.UpdateSaleQuotationBean(productName,pkProductId,manufactureCompany,hsnCode,salePriceIncludingTax,0d, 1d,unit,sgst,cgst,igst, 0d,saleDiscount,0d,0d,0d,0d,0d,0d,0d) From ProductDetails where pkProductId=?1 AND fkAdminId=?2")
	UpdateSaleQuotationBean getProductDetailsForUpdateSaleQuotation(Long fkProductId, Long fkAdminId);
	
	

}
