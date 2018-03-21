package com.inheritence.tpch;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.manytomany.Language;
import com.manytomany.Person;

public class Client {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
	public static void main(String a[]){
		buildSessionFactory();
		//insertval();
		insertDev();
				
	}
	
	public static void insertval(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Worker w = new Worker();
		w.setFirstname("w");
		w.setLastname("l");
		
		session.save(w);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	public static void insertDev(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
	Developer d = new Developer();
	d.setFirstname("vivek");
	d.setLastname("kumar");
	d.setDomain("java");
		
		session.save(d);
		tx.commit();
		session.close();
		sessionFactory.close();
	}

	  private static SessionFactory buildSessionFactory() {
	        try {
	            return new AnnotationConfiguration().configure().buildSessionFactory();
	        }
	        catch (Throwable ex) {
	            throw new ExceptionInInitializerError(ex);
	        }
	    }




}
