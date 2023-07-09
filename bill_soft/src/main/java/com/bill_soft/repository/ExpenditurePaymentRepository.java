package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.ExpenditurePayment;

@Repository
public interface ExpenditurePaymentRepository extends JpaRepository<ExpenditurePayment,Long>{

	@Query(value="SELECT * FROM expenditure_payment WHERE payment_date=?1",nativeQuery=true)
	List<ExpenditurePayment> getexpenditurepaymentreportdatewiseforsuperadmin(String date);

	@Query(value="SELECT * FROM expenditure_payment WHERE payment_date=?1 AND fk_oragnization_id=?2",nativeQuery=true)
	List<ExpenditurePayment> getexpenditurepaymentreportdatewisefororganization(String date, Long fkOragnizationId);

	@Query(value="SELECT * FROM expenditure_payment WHERE payment_date=?1 AND fk_admin_id=?2",nativeQuery=true)
	List<ExpenditurePayment> getexpenditurepaymentreportdatewiseforadmin(String date, Long fkAdminId);

	
	@Query(value="SELECT * FROM expenditure_payment where expenditure_name=?1 AND payment_date BETWEEN ?2 AND ?3",nativeQuery=true)
	List<ExpenditurePayment> getexpenditurepaymentreportrangewiseforsuperadmin(String expenditureName, String fromdate,
			String todate);

	@Query(value="SELECT * FROM expenditure_payment where expenditure_name=?1 AND payment_date BETWEEN ?2 AND ?3 AND fk_oragnization_id=?4",nativeQuery=true)
	List<ExpenditurePayment> getexpenditurepaymentreportrangewisefororganization(String expenditureName,
			String fromdate, String todate, Long fkOragnizationId);

	@Query(value="SELECT * FROM expenditure_payment where expenditure_name=?1 AND payment_date BETWEEN ?2 AND ?3 AND fk_admin_id=?4",nativeQuery=true)
	List<ExpenditurePayment> getexpenditurepaymentreportrangewiseforadmin(String expenditureName, String fromdate,
			String todate, Long fkAdminId);


}
