package co.simplon.metier;

import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.dao.AccountRepository;
import co.simplon.dao.OperationRepository;
import co.simplon.entities.Account;
import co.simplon.entities.CurrentAccount;
import co.simplon.entities.Operation;
import co.simplon.entities.Retrait;
import co.simplon.entities.Versement;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Account consulterCompte(long codeAccount) {
		Account cp = accountRepository.findOne(codeAccount);
		if (cp == null)
			throw new RuntimeException("compte introuvable");
		return cp;

	}

	public void verser(long codeAccount, double montant) {
		Account cp = consulterCompte(codeAccount);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setBalance(cp.getBalance() + montant);
		accountRepository.save(cp);

	}

	public void retirer(long codeAccount, double montant) {
		Account cp = consulterCompte(codeAccount);
		double facilitesCaisse = 0;
		if (cp instanceof CurrentAccount)
			facilitesCaisse = ((CurrentAccount) cp).getDecouvert();
		if (cp.getBalance() + facilitesCaisse < montant)
			throw new RuntimeException("solde insuffisant");
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setBalance(cp.getBalance() - montant);
		accountRepository.save(cp);

	}

	public void virement(long codeAccount1, long codeAccount2, double montant) {
		if (codeAccount1 == codeAccount2)
			throw new RuntimeException("Impossible virement sur le meme compte");
		retirer(codeAccount1, montant);
		verser(codeAccount2, montant);

	}

	public Page<Operation> listOperations(long codeAccount, int page, int size) {

		return operationRepository.listOperations(codeAccount, PageRequest.of(page, size));
	}
}
