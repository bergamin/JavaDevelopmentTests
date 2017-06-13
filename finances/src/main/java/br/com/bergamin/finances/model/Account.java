package br.com.bergamin.finances.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String holder;
	private String number;
	private String bank;
	private String office;
	
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Account [id=" + id
				    + ", holder=" + holder
				    + ", number=" + number
				    + ", bank=" + bank
				    + ", office=" + office
				    + "]";
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
}