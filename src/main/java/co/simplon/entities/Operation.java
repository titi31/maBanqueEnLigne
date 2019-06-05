package co.simplon.entities;
import java.util.Date;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType = DiscriminatorType.STRING, length=1)
public abstract class Operation implements Serializable{
	@Id
	@GeneratedValue
	private long NumOp;
	private Date DateOperation;
	private double Amount;
	
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Account account;
	public Operation( Date dateOperation, double amount,Account account) {
		super();
		
		DateOperation = dateOperation;
		Amount = amount;
		this.account=account;
	}
	public Operation() {
		super();
	}
	
	public long getNumOp() {
		return NumOp;
	}
	public void setNumOp(long numOp) {
		NumOp = numOp;
	}
	public Date getDateOperation() {
		return DateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		DateOperation = dateOperation;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	
	
	
}
