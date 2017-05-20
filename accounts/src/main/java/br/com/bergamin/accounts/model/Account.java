package br.com.bergamin.accounts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_ACCOUNTS", sequenceName = "SEQ_ACCOUNTS", initialValue = 1)
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ACCOUNTS")
	private Integer id;
	private String holder;
	private String bank;
	private String office;
	private String number;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
