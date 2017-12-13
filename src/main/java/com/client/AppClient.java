package com.client;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.entity.Employee;

public class AppClient {

	 private static final SessionFactory sessionFactory = buildSessionFactory();
	 
	 
	 public static void main(String[] a){
		 buildSessionFactory();
		 //createEmployee();
		 
		 getEmployee();
		 sessionFactory.close();
	 }

	private static void createEmployee() {
		Session session = sessionFactory.openSession();
		 Employee emp = new Employee();
		 emp.setName("Rajll");
		 Transaction tx = session.beginTransaction();
		 session.save(emp);
		 tx.commit();
		 session.close();
	}
	
	private static void getEmployee() {
		Session session = sessionFactory.openSession();
		 Employee emp = (Employee) session.get(Employee.class, new Long(1));
		 
		 session.beginTransaction().commit();
		 emp.setName("Rahul");
		 session.save(emp);
		 session.close();
	}

    private static SessionFactory buildSessionFactory() {
        try {
            return new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

}
