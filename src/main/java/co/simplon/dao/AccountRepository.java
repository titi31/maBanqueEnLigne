package co.simplon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.simplon.entities.Account;
public interface AccountRepository extends JpaRepository<Account, Long> {
	@Query("select a from Account a where a.codeAcount=:x")
	public Account findOne(@Param("x")long codeAccount);
}
