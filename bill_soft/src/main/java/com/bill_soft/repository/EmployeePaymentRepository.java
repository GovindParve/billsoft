package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.CustomerPayment;
import com.bill_soft.entity.EmployeePayment;

@Repository
public interface EmployeePaymentRepository extends JpaRepository<EmployeePayment ,Long>{

	@Query(value="SELECT * FROM employee_payment WHERE payment_date=?1",nativeQuery=true)
	List<EmployeePayment> getemployeepaymentreportdatewiseforsuperadmin(String date);

	
	@Query(value="SELECT * FROM employee_payment WHERE payment_date=?1 AND fk_oragnization_id=?2",nativeQuery=true)
	List<EmployeePayment> getcustomerpaymentreportbillnowisefororganization(String date, Long fkOragnizationId);


	@Query(value="SELECT * FROM employee_payment WHERE payment_date=?1 AND fk_admin_id=?2",nativeQuery=true)
	List<EmployeePayment> getcustomerpaymentreportbillnowiseforadmin(String date, Long fkAdminId);

	
   
	

	@Query(value="SELECT * FROM employee_payment where employee_name=?1 AND payment_date BETWEEN ?2 AND ?3;",nativeQuery=true)
    List<EmployeePayment> getemployeepaymentreportrangewiseforsuperadmin(String employeeName, String fromdate,
			String todate);

	@Query(value="SELECT * FROM employee_payment where employee_name=?1 AND payment_date BETWEEN ?2 AND ?3 AND fk_oragnization_id=?4;",nativeQuery=true)
	List<EmployeePayment> getemployeepaymentreportrangewisefororganization(String employeeName, String fromdate,
			String todate, Long fkOragnizationId);

	@Query(value="SELECT * FROM employee_payment where employee_name=?1 AND payment_date BETWEEN ?2 AND ?3 AND fk_admin_id=?4;",nativeQuery=true)
	List<EmployeePayment> getemployeepaymentreportrangewiseforadmin(String employeeName, String fromdate, String todate,
			Long fkAdminId);

}
