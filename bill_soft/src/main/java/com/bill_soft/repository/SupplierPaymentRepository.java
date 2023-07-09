package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.SupplierPayment;
@Repository
public interface SupplierPaymentRepository extends JpaRepository<SupplierPayment,Long>{

	@Query(value="SELECT * FROM supplier_payment where supplier_name=?1",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportforsuperadmin(String supplierName);

	@Query(value="SELECT * FROM supplier_payment where supplier_name=?1 AND fk_oragnization_id=?2",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportfororganization(String supplierName,Long fkOragnizationId);

	@Query(value="SELECT * FROM supplier_payment where supplier_name=?1 AND fk_admin_id=?2",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportforadmin(String supplierName,Long fkAdminId);

	@Query(value="SELECT * FROM supplier_payment where payment_date=?1",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportdatewiseforsuperadmin(String date);

	@Query(value="SELECT * FROM supplier_payment where payment_date=?1 AND fk_oragnization_id=?2",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportdatewisefororganization(String date, Long fkOragnizationId);


	@Query(value="SELECT * FROM supplier_payment where payment_date=?1 AND fk_admin_id=?2",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportdatewiseforadmin(String date, Long fkAdminId);

	@Query(value="SELECT * FROM supplier_payment where payment_date BETWEEN ?1 AND ?2;",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportdrangewiseforsuperadmin(String Fromdate, String Todate);

	@Query(value="SELECT * FROM supplier_payment where   payment_date BETWEEN ?1 AND ?2 AND  fk_oragnization_id=?3;",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportrangeewisefororganization(String fromdate, String todate,
			Long fkOragnizationId);

	@Query(value="SELECT * FROM supplier_payment where   payment_date BETWEEN ?1 AND ?2 AND  fk_admin_id=?3",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportrangewiseforadmin(String fromdate, String todate, Long fkAdminId);

	@Query(value="SELECT * FROM supplier_payment where   supplier_name =?1 AND bill_no=?2",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportbillnowiseforsuperadmin(String supplierName, String billNo);

	@Query(value="SELECT * FROM supplier_payment where   supplier_name =?1 AND bill_no=?2 AND  fk_oragnization_id=?3",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportbillnowisefororganization(String supplierName, String billNo,
			Long fkOragnizationId);

	@Query(value="SELECT * FROM supplier_payment where   supplier_name =?1 AND bill_no=?2 AND  fk_admin_id=?3",nativeQuery=true)
	List<SupplierPayment> getsupplierpaymentreportbillnowiseforadmin(String supplierName, String billNo,
			Long fkAdminId);

}
