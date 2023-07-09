package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.BankPayment;

@Repository
public interface BankPaymentRepository extends JpaRepository<BankPayment,Long>{

	@Query(value="SELECT * FROM bank_payment where bank_name=?1",nativeQuery=true)
	List<BankPayment> getbankpaymentreportnamewiseforsuperadmin(String bankName);

	@Query(value="SELECT * FROM bank_payment where bank_name=?1 AND fk_oragnization_id=?2",nativeQuery=true)
	List<BankPayment> getbankpaymentreportnamewisefororganization(String bankName, Long fkOragnizationId);

	@Query(value="SELECT * FROM bank_payment where bank_name=?1 AND fk_admin_id=?2",nativeQuery=true)
	List<BankPayment> getbankpaymentreportnamewiseforadmin(String bankName, Long fkAdminId);

	@Query(value="SELECT * FROM bank_Payment where payment_date BETWEEN 1? AND 2?",nativeQuery=true)
	List<BankPayment> getbankpaymentreportrangewiseforsuperadmin(String Fromdate, String Todate);

	@Query(value="SELECT * FROM bank_payment where payment_date BETWEEN ?1 AND ?2 AND fk_oragnization_id=?3",nativeQuery=true)
	List<BankPayment> getbankpaymentreportrangewisefororganization(String Fromdate, String Todate,
			Long fkOragnizationId);

	@Query(value="SELECT * FROM bank_payment where payment_date BETWEEN ?1 AND ?2 AND  fk_admin_id=?3",nativeQuery=true)
	List<BankPayment> getbankpaymentreportrangewiseforadmin(String Fromdate, String Todate, Long fkAdminId);

}
