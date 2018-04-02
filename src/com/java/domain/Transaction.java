package com.java.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.java.domain.Account;
import com.java.domain.AccountType;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@Column (name="id")
	public int id;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "account_id")
	public Account account;
	
	@Column (name ="amount")
	public double amount;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	public AccountType accountType;
	
	
	
	public Transaction(int id,Account account, double amount,AccountType accountType) {
		super();
		this.id = id;
		this.account =account ;
		this.amount = amount;
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "transaction [id=" + id + ", account=" + account + ", amount=" + amount + ", accountType=" + accountType
				+ "]";
	}
	public Transaction() {
	}
	
}
