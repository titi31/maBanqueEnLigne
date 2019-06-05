package co.simplon.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperation, double amount,Account account) {
		super(dateOperation, amount,account);
		// TODO Auto-generated constructor stub
	}

}
