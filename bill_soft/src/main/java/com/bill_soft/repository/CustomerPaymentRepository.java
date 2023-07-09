package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.CustomerPayment;
@Repository
public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment,Long>{

	@Query(value="SELECT * FROM customer_payment WHERE customer_name=?1",nativeQuery=true)
	List<CustomerPayment> getcustomerpaymentreportcustomernamewiseforsuperadmin( String customerName);

	@Query(value="SELECT * FROM customer_payment WHERE customer_name=?1 AND fk_oragnization_id=?2",nativeQuery=true)
	List<CustomerPayment> getcustomerpaymentreportcustomernamewisefororganization(String customerName,
			Long fkOragnizationId);

	@Query(value="SELECT * FROM customer_payment WHERE customer_name=?1 AND fk_admin_id=?2",nativeQuery=true)
	List<CustomerPayment> getcustomerpaymentreportcustomernamewiseforadmin(
			String customerName, Long fkAdminId);

	
	@Query(value="SELECT * FROM customer_payment WHERE payment_date=?1",nativeQuery=true)
	List<CustomerPayment> getcustomerpaymentreportdateewiseforsuperadmin(String date);

	@Query(value="SELECT * FROM customer_payment WHERE payment_date=?1 AND fk_oragnization_id=?2",nativeQuery=true)
	List<CustomerPayment> getcustomerpaymentreportdatewisefororganization(String date, Long fkOragnizationId);

	@Query(value="SELECT * FROM customer_payment WHERE payment_date=?1 AND fk_admin_id=?2",nativeQuery=true)
	List<CustomerPayment> getcustomerpaymentreportdatewiseforadmin(String date, Long fkAdminId);

	@Query(value="SELECT * FROM customer_payment where payment_date BETWEEN ?1 AND ?2;",nativeQuery=true)
	List<CustomerPayment> getcustomerpaymentreportrangewiseforsuperadmin(String fromdate, String todate);
	
@Query(value="SELECT * FROM customer_payment where  payment_date BETWEEN ?1 AND ?2 AND  fk_oragnization_id=?3",nativeQuery=true)
	List<CustomerPayment> getcustomerpaymentreportrangewisefororganization(String Fromdate, String Todate,
			Long fkOragnizationId);
@Query(value="SELECT * FROM customer_payment where  payment_date BETWEEN ?1 AND ?2 AND  fk_admin_id=?3",nativeQuery=true)
List<CustomerPayment> getcustomerpaymentreportrangewiseforadmin(String fromdate, String todate, Long fkAdminId);

@Query(value="SELECT * FROM customer_payment where  customer_name =?1 AND bill_no=?2",nativeQuery=true)
List<CustomerPayment> getcustomerpaymentreportbillnowiseforsuperadmin(String customerName, String billNo);

@Query(value="SELECT * FROM customer_payment where  customer_name =?1 AND bill_no=?2 AND  fk_oragnization_id=?3",nativeQuery=true)
List<CustomerPayment> getcustomerpaymentreportbillnowisefororganization(String customerName, String billNo,
		Long fkOragnizationId);

@Query(value="SELECT * FROM customer_payment where  customer_name =?1 AND bill_no=?2 AND  fk_admin_id=?3",nativeQuery=true)
List<CustomerPayment> getcustomerpaymentreportbillnowiseforadmin(String customerName, String billNo, Long fkAdminId);




	
}
