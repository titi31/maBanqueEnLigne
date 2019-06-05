package co.simplon.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
@Entity
@DiscriminatorValue("V")
public class Versement extends Operation{

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement( Date dateOperation, double amount,Account account) {
		super( dateOperation, amount,account);
		// TODO Auto-generated constructor stub
	}

}
