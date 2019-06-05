package co.simplon.metier;

import org.springframework.data.domain.Page;

import co.simplon.entities.Account;
import co.simplon.entities.Operation;
public interface IBanqueMetier {
	public Account consulterCompte(long codeAccount);
	public void verser(long codeAccount,double montant);
	public void retirer(long codeAccount,double montant);
	public void virement(long codeAccount1,long codeAccount2,double montant);
	public Page<Operation> listOperations(long codeAccount, int page , int size);
}
