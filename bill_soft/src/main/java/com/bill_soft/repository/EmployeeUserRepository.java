package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.bill_soft.dto.RequestEmployeeDto;
import com.bill_soft.entity.EmployeeUser;

@Repository
public interface EmployeeUserRepository extends JpaRepository<EmployeeUser,Long>{

	EmployeeUser findByEmailId(String emailId);

	boolean existsByUserName(String userName);

	boolean existsByEmailId(String emailId);
  
	@Query(value="SELECT new com.bill_soft.dto.RequestEmployeeDto(pkEmployeeId,firstName,lastName,userName,role) FROM EmployeeUser  where userName = ?1")
	List<RequestEmployeeDto> getUesrDetailsForAllocation(String userName);
 
	
	@Query(value="from EmployeeUser where userName=?1")
	List<EmployeeUser> findUsersByUserName(String userName);
   
	
//	@Query(value="SELECT new com.bill_soft.bean.EmployeeUserBean(pkEmployeeId,firstName,lastName,emailId,contactNumber,userName)FROM EmployeeUser where fk_admin_id =?1")
//	List<EmployeeUserBean> getuserlistforadmin(Long fkAdminId);
//
//	@Query(value="SELECT new com.bill_soft.bean.EmployeeUserBean(pkEmployeeId,firstName,lastName,emailId,contactNumber,userName)FROM EmployeeUser")
//	List<EmployeeUserBean> getuserlistforsuperadmin();
//
//	@Query(value="SELECT new com.bill_soft.bean.EmployeeUserBean(pkEmployeeId,firstName,lastName,emailId,contactNumber,userName)FROM EmployeeUser where fk_oragnization_id =?1")
//	List<EmployeeUserBean> getuserlistfororagnization(Long fkOragnizationId);
	
	@Query(value="SELECT role from employee_details where username=?1 ",nativeQuery=true)
	String findRoleByUserName(String username);

	EmployeeUser findByUserName(String username);

	@Query(value="SELECT role from employee_details where username=?1 ",nativeQuery=true)
	String getRole(String username);

	/*
	 * @Query(value="FROM EmployeeUser") Optional<EmployeeUser>
	 * getuserlisteditforsuperadmin();
	 * 
	 * @Query(value="FROM EmployeeUser",nativeQuery=true) Optional<EmployeeUser>
	 * getuserlisteditfororagnization(Long fkOragnizationId);
	 * 
	 * @Query(value="FROM EmployeeUser") Optional<EmployeeUser>
	 * getuserlisteditforadmin(Long fkAdminId);
	 */
	
	
	@Query(value="SELECT * FROM employee_details WHERE email_id=?1",nativeQuery=true)
	EmployeeUser findByEmail(String emailId);

	@Query(value="SELECT * FROM employee_details where fk_admin_id=?1",nativeQuery=true)
	List<EmployeeUser> getuserlistforadmin(Long fkAdminId);

	@Query(value="SELECT * FROM employee_details where fk_oragnization_id=?1",nativeQuery=true)
	List<EmployeeUser> getuserlistfororagnization(Long fkOragnizationId);

	@Query(value="SELECT * FROM employee_details",nativeQuery=true)
	List<EmployeeUser> getuserlistforsuperadmin();

	@Query(value="select * FROM employee_details where username=?1 ",nativeQuery=true)
	EmployeeUser getadminname(String username);

	

}
