package com.inheritence.tpcc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.inheritence.tpch.Developer;
import com.inheritence.tpch.Worker;

public class Client {

	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
	public static void main(String a[]){
		buildSessionFactory();
		insertval();
		
				
	}
	
	public static void insertval(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Camel c = new Camel();
		c.setDesert("sahara");
		c.setName("camel");
		c.setId(1);
		session.save(c);
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
