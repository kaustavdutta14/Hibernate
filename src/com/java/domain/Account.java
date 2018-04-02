package com.java.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.java.domain.Bank;
import com.java.domain.Patron;


@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@Column(name = "id")
	public int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id")
	public Bank bank;
	
	@ManyToOne(cascade = { CascadeType.ALL})
	@JoinColumn(name = "patron_id")
	public Patron patron;
	
	
	public Account(int id, Bank bank, Patron patron) {
		super();
		this.id = id;
		this.bank = bank;
		this.patron = patron;
	}
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	List<Transaction> transactions;

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public Patron getPatron() {
		return patron;
	}
	
	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", bank=" + bank + ", patron=" + patron + "]";
	}

	public Account() {
	}
}
