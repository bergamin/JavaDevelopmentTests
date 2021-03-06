package br.com.bergamin.finances.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
// Another option to the named queries is the use of DAO classes
@NamedQuery(query="SELECT SUM(t.value) FROM Transaction t WHERE t.account = :pAccount AND t.type = :pType",
            name="SumValue")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private BigDecimal value;
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	private String description;
	@ManyToOne
	private Account account;
	@ManyToMany
	private List<Category> category;

	@Override
	public String toString() {
		return "Transaction [value=" + value + ", type=" + type + ", date=" + date + ", description=" + description
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategories(List<Category> category) {
		this.category = category;
	}

}
