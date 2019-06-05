package co.simplon.entities;
import java.util.Date;

import java.io.Serializable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType = DiscriminatorType.STRING,length=7)
public abstract class Account implements Serializable{
	@Id
	@GeneratedValue
	private long codeAcount;
	private Date DateCreation;
	private double Balance;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@OneToMany(mappedBy = "account")
	private Collection<Operation> operation;
	public Account(Date dateCreation, double balance, Customer customer) {
		super();
		this.codeAcount = codeAcount;
		DateCreation = dateCreation;
		Balance = balance;
		this.customer=customer;
		this.operation = operation;
	}
	public Account() {
		super();
	}
	public long getCodeAcount() {
		return codeAcount;
	}
	public void setCodeAcount(long codeAcount) {
		this.codeAcount = codeAcount;
	}

	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public Collection<Operation> getOperation() {
		return operation;
	}
	public void setOperation(Collection<Operation> operation) {
		this.operation = operation;
	}
}
