package com.java.service;

import java.io.File;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.domain.Account;
import com.java.domain.AccountType;
import com.java.domain.Bank;
import com.java.domain.Patron;
import com.java.domain.Result;
import com.java.domain.Transaction;

public class Main {

	public static SessionFactory factory;
	
	public static void main(String[] args) {
		BankRepository br = new BankRepository();
		Patron p= new Patron();
		Bank bank= new Bank();
		Account acc= new Account();
		
		
		String ImagePath="C:/Users/Kaustav Dutta/Desktop/Assignments IMCS/Assignments/Assignment 7/Siddesh.png";
		File file = new File(ImagePath);
		byte[] bArray = new byte[(int) file.length()];
				
		 try {
	         factory = new Configuration().configure().addPackage("com.java.domain").addAnnotatedClass(Patron.class)
	        		 																.addAnnotatedClass(Bank.class)
	        		 																.addAnnotatedClass(Account.class)
	        		 																.addAnnotatedClass(Transaction.class)
	        		 																.buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		 
		/*p.setName("HA");
		p.setImage(bArray);	
		Result r=br.add(p);
		System.out.println(r);*/
		 
		 
			/* bank.setName("BBVA");
			 Result r=br.add(bank);
			 System.out.println(r);*/
		 
		/*acc.setId(3); 
		acc.setPatron(br.findPatron(3));
		acc.setBank(br.findBank(3));
		 Result r=br.add(acc);
		 System.out.println(r);*/
		 
		/*p.setId(4);
		 Result r=br.remove(p);
		 System.out.println(r); */
		 
		/* bank.setId(4);
		 Result r=br.remove(bank);
		 System.out.println(r);*/
		 
		 /*acc.setId(3); 
		 Result r=br.remove(acc);
		 System.out.println(r);
		 */
		 
		/* p.setId(5);
		 p.setName("CHANGED");
		 p.setImage(bArray);
		 Result r=br.update(p);
		 System.out.println(r);*/
		 
		/* bank.setId(3);
		 bank.setName("CHANGED");
		
		 Result r=br.update(bank);
		 System.out.println(r);*/
		 
		/* 
		 acc.setId(2);
		 acc.setPatron(br.findPatron(2));
		 Result r=br.update(acc);
		 System.out.println(r);*/
		
		 
		// br.findPatron(2);
		 
		/* p.setId(5);
		 Patron id =br.findPatron(p.id);
		 System.out.println(id);*/
		 
	/*	 
		 bank.setId(3);
		 Bank id =br.findBank(bank.id);
		 System.out.println(id);*/
		 
		Transaction tx= new Transaction(7,br.findAccount(2),350,AccountType.DEBIT);
			System.out.println(br.transact(tx));
			
			/*
			tx=br.findTransaction(7);
			System.out.println(tx);*/
			
		/* p.setName("HARSHA");
		 List<Patron> name =br.findPatron(p.name);
		 System.out.println(name);*/
		 
		/* bank.setName("CHANGED");
		 List<Bank> name =br.findBank(bank.name);
		 System.out.println(name);*/
		 
		//br.listEmployees();
	      
	}

	}

