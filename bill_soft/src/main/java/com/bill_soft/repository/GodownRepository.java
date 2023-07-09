package com.bill_soft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill_soft.entity.GodownEntry;

@Repository
public interface GodownRepository  extends JpaRepository<GodownEntry ,Long>
{
    @Query(value="SELECT * FROM godown_entry",nativeQuery=true)
	List<GodownEntry> getgodownlistforsuperadmin();

    
    @Query(value="SELECT * FROM godown_entry  where fk_organization_id=?1",nativeQuery=true)
	List<GodownEntry> getgodownlistfororagnization(Long fkOragnizationId);

    @Query(value="SELECT * FROM godown_entry  where fk_admin_id=?1",nativeQuery=true)
	List<GodownEntry> getgodownlistforadmin(Long fkAdminId);

    @Query(value="SELECT * FROM godown_entry where pk_godown_id=?1",nativeQuery=true)
	Optional<GodownEntry> getgodowneditforsuperadmin(Long id);
    
    @Query(value="SELECT * FROM godown_entry where pk_godown_id=?1 AND fk_oragnization_id=?2",nativeQuery=true)
	Optional<GodownEntry> getgodowneditfororagnization(Long id,Long fkOragnizationId);
    
    @Query(value="SELECT * FROM godown_entry where pk_godown_id=?1 AND fk_admin_id=?2",nativeQuery=true)
    Optional<GodownEntry> getgodowneditforadmin(Long id,Long fkAdminId);

    @Query(value="SELECT pk_godown_id,godown_name FROM godown_entry",nativeQuery=true)
	List<String> getgodowndropdownforsuperadmin();

    @Query(value="SELECT pk_godown_id,godown_name FROM godown_entry where fk_oragnization_id=?1",nativeQuery=true)
	List<String> getgodowndropdownfororagnization(Long fkOragnizationId);

    @Query(value="SELECT pk_godown_id,godown_name FROM godown_entry where fk_admin_id=?1",nativeQuery=true)
	List<String> getgodowndropdownforadmin(Long fkAdminId);
    		

}
