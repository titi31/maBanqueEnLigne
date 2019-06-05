package co.simplon.entities;

import java.util.Collection;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Customer implements Serializable{
		@Id @GeneratedValue
	    private long codeCli;
	    private String name;
		private String email;
		@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
	    private Collection<Account> account;
	    public Customer() {
			super();
		}
		public Customer( String name, String email) {
			super();
			
			this.name = name;
			this.email = email;
			
		}
		public long getCodeCli() {
			return codeCli;
		}
		public void setCodeCli(long codeCli) {
			this.codeCli = codeCli;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Collection<Account> getAccount() {
			return account;
		}
		public void setAccount(Collection<Account> account) {
			this.account = account;
		}

}
