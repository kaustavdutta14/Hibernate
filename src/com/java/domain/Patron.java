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
@Table(name = "patron")
public class Patron {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column (name="id")
	public int id;
	@Column (name="name")
	public String name;
	@Column (name="image")
	public byte[] image;
	
	@OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
	List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Patron(int id, String name, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


	public Patron() {	
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

	@Override
	public String toString() {
		return "Patron [id=" + id + ", name=" + name + ", image=" + image + "]";
	}
	
}
