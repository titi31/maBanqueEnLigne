package co.simplon.entities;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
@Entity
@DiscriminatorValue("courant")
public class CurrentAccount extends Account{
	private double decouvert;
	public CurrentAccount() {
		super( );
	}

	public CurrentAccount( Date dateCreation, double balance,
			Customer customer, double decouvert) {
		super( dateCreation, balance, customer);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
}
