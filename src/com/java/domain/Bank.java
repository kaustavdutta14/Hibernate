package com.java.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column (name="id")
	public int id;
	@Column (name="name")
	public String name;
	
	@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
	List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Bank(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Bank() {
		
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + "]";
	}
	

	
}
