package co.simplon.entities;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
@Entity
@DiscriminatorValue("epargne")
public class SavingAccount extends Account{
	private double taux;

	public SavingAccount() {
		super();
	}

	public SavingAccount(Date dateCreation, double balance,
			Customer customer, double taux) {
		super( dateCreation, balance, customer);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
