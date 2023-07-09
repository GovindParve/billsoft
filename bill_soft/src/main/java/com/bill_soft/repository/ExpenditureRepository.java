package com.bill_soft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.ExpenditureDetails;

@Repository
public interface ExpenditureRepository extends JpaRepository<ExpenditureDetails,Long> {

	@Query(value="FROM  ExpenditureDetails")
	List<ExpenditureDetails> getexpenditurelistforsuperadmin();

	
	@Query(value="FROM  ExpenditureDetails where fkoragnizationId=?1")
	List<ExpenditureDetails> getexpenditurelistfororagnization(Long fkOrganisationId);

	@Query(value="FROM  ExpenditureDetails where fkAdminId=?1")
	List<ExpenditureDetails> getexpenditurelistforadmin(Long fkAdminId);

    @Query(value="FROM  ExpenditureDetails")
	Optional<ExpenditureDetails> getexpenditureeditforsuperadmin();

    
    @Query(value="FROM  ExpenditureDetails")
	Optional<ExpenditureDetails> getexpenditureeditfororagnization();
    
    @Query(value="FROM  ExpenditureDetails")
	Optional<ExpenditureDetails> getexpenditureeditforadmin();


    @Query(value="SELECT pkExpenditureId,expenditureName FROM ExpenditureDetails GROUP BY expenditureName")
	List<String> getexpendituredropdownforsuperadmin();
	
    @Query(value="SELECT pkExpenditureId,expenditureName FROM ExpenditureDetails Where fkoragnizationId=?1 GROUP BY expenditureName")
	List<String> getexpendituredropdownfororganization(Long fkOrganizationId);
    
    @Query(value="SELECT pkExpenditureId,expenditureName FROM ExpenditureDetails WHERE fkAdminId=?1 GROUP BY expenditureName")
	List<String> getexpendituredropdownforadmin(Long fkAdminId);
}
