package com.java.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.domain.Account;
import com.java.domain.Bank;
import com.java.domain.Patron;
import com.java.domain.Result;

public class BankRepository {

	public Result add(Patron p) {
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			p.id = (Integer) session.save(p);
			session.save(p);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (tx != null)
			return Result.SUCCESS;
		else
			return Result.FAILURE;
	}
	
	public Result add(Bank bank) {
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bank.id = (Integer) session.save(bank);
			session.save(bank);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (tx != null)
			return Result.SUCCESS;
		else
			return Result.FAILURE;
	}

	public Result add(Account acc) {
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(acc);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (tx != null)
			return Result.SUCCESS;
		else
			return Result.FAILURE;
	}

	
	
	
	public Result remove(Patron p) {
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(p);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (tx != null)
			return Result.SUCCESS;
		else
			return Result.FAILURE;
	}
	
	public Result remove(Bank bank) {
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(bank);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (tx != null)
			return Result.SUCCESS;
		else
			return Result.FAILURE;
	}
	
	public Result remove(Account acc) {
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(acc);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (tx != null)
			return Result.SUCCESS;
		else
			return Result.FAILURE;
	}
	

	public Result update(Patron p) {
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(p);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (tx != null)
			return Result.SUCCESS;
		else
			return Result.FAILURE;
	}
	
	public Result update(Bank bank) {
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(bank);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (tx != null)
			return Result.SUCCESS;
		else
			return Result.FAILURE;
	}
	
	public Result update(Account acc) {
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(acc);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (tx != null)
			return Result.SUCCESS;
		else
			return Result.FAILURE;
	}
	
	

	public Patron findPatron(int id) {
		Patron patron = new Patron();
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			patron = session.get(Patron.class, id);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("find patron by id failed.");
		} finally {
			session.close();
		}
		return patron;
	}
	
	public Bank findBank(int id) {
		Bank bank=new Bank();
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bank = session.get(Bank.class, id);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("find patron by id failed.");
		} finally {
			session.close();
		}
		return bank;
	}
	
	public Account findAccount(int id) {
		Account acc=new Account();
		Session session = Main.factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			acc = session.get(Account.class, id);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("find patron by id failed.");
		} finally {
			session.close();
		}
		return acc;
	}
	
	
	

	public List<Patron> findPatron(String name) {
		Session session = Main.factory.openSession();
		Transaction tx = null;
		List<Patron> patrons = new ArrayList<>();
		try {
			tx = session.beginTransaction();
			String q = "from Patron where name = :name";
			Query query = session.createQuery(q);
			query.setParameter("name", name);
			patrons = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("find patron by name failed.");
		}
		return patrons;
	}
	
	
	public List<Bank> findBank(String name) {
		Session session = Main.factory.openSession();
		Transaction tx = null;
		List<Bank> b = new ArrayList<>();
		try {
			tx = session.beginTransaction();
			String q = "from Bank where name = :name";
			Query query = session.createQuery(q);
			query.setParameter("name", name);
			b = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("find patron by name failed.");
		}
		return b;
	}

	public com.java.domain.Transaction findTransaction(int id) {
		com.java.domain.Transaction transaction = new 	com.java.domain.Transaction();
		Session session = Main.factory.openSession();
		try {
			session.beginTransaction();
			transaction = session.get(com.java.domain.Transaction.class, id);
		}
		catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println("find transaction by id failed.");
		}
		return transaction;
	}
	
	public Result transact(	com.java.domain.Transaction transaction) {
		Result result = Result.FAILURE;
		Session session = Main.factory.openSession();
		try {
			session.beginTransaction();
			session.save(transaction);
			session.getTransaction().commit();
			result = Result.SUCCESS;
		}
		catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println("find transaction by id failed.");
		}
		return result;
	}
	
	
	public void listEmployees() {

		Session session = Main.factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List patron = session.createQuery("FROM Patron").list();
			for (Iterator iterator = patron.iterator(); iterator.hasNext();) {
				Patron p = (Patron) iterator.next();
			}
			System.out.print(patron);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
