package co.simplon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import co.simplon.dao.*;
import co.simplon.entities.*;
import co.simplon.metier.IBanqueMetier;

import java.util.Date;
@SpringBootApplication
public class MaBanqueEnLigneApplication implements CommandLineRunner{
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	public static void main(String[] args)  {
		
		SpringApplication.run(MaBanqueEnLigneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Customer c1=customerRepository.save(new Customer("timothe","timothe@gmail.com"));
		Customer c2=customerRepository.save(new Customer("Jerome","jerome@gmail.com"));
		Account cp1= accountRepository.save(new CurrentAccount(new Date(),3000,c1,200));
		Account cp2=accountRepository.save(new SavingAccount(new Date(),9000,c2,5.5));
		Operation op1=operationRepository.save(new Versement(new Date(),500,cp1));
		Operation op2=operationRepository.save(new Versement(new Date(),1000,cp1));
		Operation op3=operationRepository.save(new Retrait(new Date(),50,cp1));
		Operation op4=operationRepository.save(new Versement(new Date(),800,cp2));
		Operation op5=operationRepository.save(new Versement(new Date(),1500,cp2));
		Operation op6=operationRepository.save(new Retrait(new Date(),100,cp2));*/
		//banqueMetier.verser(cp1.getCodeAcount(), 100);
	}

}
