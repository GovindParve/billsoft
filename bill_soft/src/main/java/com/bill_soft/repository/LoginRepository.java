package com.bill_soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.dto.RequestPermissionDto;
import com.bill_soft.entity.UserDetails;

@Repository
public interface LoginRepository  extends JpaRepository<UserDetails,Long> {

	@Query(value="SELECT new com.bill_soft.dto.RequestPermissionDto(us.pkid,us.firstName,us.lastName,us.userName,us.role,sh.businessType,sh.fkOrganizationId,sh.organizationName) FROM UserDetails us ,Shop sh where userName = ?1 AND us.pkid=sh.fkAdminId")
	List<RequestPermissionDto> getUesrDetailsForAllocation(String userName);

	
	@Query("from UserDetails where userName=?1")
	List<UserDetails> findUsersByUserName(String userName);

	UserDetails findByUserName(String userName);


	UserDetails findByEmailId(String emailId);


	boolean existsByEmailId(String emailId);


	boolean existsByUserName(String userName);


UserDetails findByResetPasswordToken(String token);

 @Query(value="SELECT u.email_id FROM user_details u WHERE u.email_id=?1",nativeQuery=true)
 String findByEmailAddress(String email);

@Query(value="SELECT u.pkid,u.first_name,u.last_name,u.username, u.email_id FROM user_details u WHERE role=user",nativeQuery=true)
List<UserDetails> getuserList(Long pkid1);


@Query(value="SELECT role from user_details where username=?1",nativeQuery=true)
String findRoleByUserName(String username);

@Query(value="SELECT username from user_details where role=?1  AND pkid=?2",nativeQuery=true)
String getusernameforcategory(String role, Long pkid);

@Query(value="SELECT username from user_details where role=?1  AND pkid=?2 ",nativeQuery=true)
String getusernameforsubcategory(String role,Long pkid);

@Query(value="SELECT pkid,username FROM user_details WHERE role='admin'",nativeQuery=true)
List<String> getadmindropdownforsuperadmin();

@Query(value="SELECT pkid,username FROM user_details WHERE fk_organization_id=?1 AND role='admin'",nativeQuery=true)
List<String> getadmindropdownfororagnization(Long fkOragnizationId);

@Query(value="SELECT pkid,username FROM user_details WHERE role='oragnization'",nativeQuery=true)
List<String> getoragnizationdropdownforsuperadmin();

//@Query(value="SELECT us.pkid,us.firstName,us.lastName,us.userName,us.role,) FROM UserDetails us ,Shop sh where userName = ?1 AND us.pkid=sh.fkOrganizationId")
@Query(value="SELECT US.pkid,US.first_name,US.last_name,US.username,US.role,SH.business_type FROM user_details US,shop_details SH WHERE US.username=?1 AND US.pkid=SH.fk_organization_id",nativeQuery=true)
UserDetails  getOragnizationDetailsForAllocation(String username);

@Query(value="SELECT new com.bill_soft.dto.RequestPermissionDto(us.pkid,us.firstName,us.lastName,us.userName,us.role) FROM UserDetails us  where userName = ?1")
List<RequestPermissionDto> getUesrDetailsForAllocationSuperadmin(String username);

//@Query(value="SELECT new com.bill_soft.dto.RequestPermissionDto(us.pkid,us.firstName,us.lastName,us.userName,us.role) FROM UserDetails us  where userName = ?1")
//UserDetails getSuperadminnDetailsForAllocation(String username);

@Query(value="SELECT us.pkid,us.first_name,us.last_name,us.username,us.role FROM user_details us  where username = ?1",nativeQuery=true)
UserDetails getSuperadminnDetailsForAllocation(String username);

@Query(value="SELECT US.pkid,US.first_name,US.last_name,US.username,US.role,SH.business_type,SH.fk_organization_id,SH.organization_name  FROM user_details US,shop_details SH WHERE US.username=?1 AND US.pkid=SH.fk_admin_id",nativeQuery=true)
List<Object[]> getAdminDetailsForAllocation(String username);










	

}
