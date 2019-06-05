package co.simplon.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.simplon.entities.Account;
import co.simplon.entities.Operation;
public interface OperationRepository extends JpaRepository<Operation, Long>{
	@Query("select o from Operation o where o.account.codeAcount=:x order by o.DateOperation desc")
	public Page<Operation> listOperations(@Param("x")long codeAccount,Pageable pageable);
}
