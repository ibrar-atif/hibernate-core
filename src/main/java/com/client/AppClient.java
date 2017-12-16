package com.client;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.entity.Address;
import com.entity.Branch;
import com.entity.Employee;

public class AppClient {

	 private static final SessionFactory sessionFactory = buildSessionFactory();
	 
	 
	 public static void main(String[] a){
		 buildSessionFactory();
		 //createEmployee();
		 
		 //getEmployee();
		// createBranch();
		 
		 //createAddress();
		 //createBranchAlone();
		// getAddress();
		 updateBranch();
		 sessionFactory.close();
	 }

	 private static void getAddress() {
			Session session = sessionFactory.openSession();
			Address add = (Address) session.load(Address.class, new Long(5));
			 System.out.println(add.getCity());
			 session.close();
		}
	 
	 private static void createAddress() {
			Session session = sessionFactory.openSession();
			 Address add = new Address();
			 add.setCity("Chennai");
			 add.setState("TamilNadu");
			 Transaction tx = session.beginTransaction();
			 session.save(add);
			 //tx.commit();
			 session.close();
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
	
	private static void createBranch() {
		Session session = sessionFactory.openSession();
		 
		 Branch b = new Branch();
		 b.setName("TIB");
		 Transaction tx = session.beginTransaction();
		 Employee emp = new Employee();
		 emp.setName("Sam");
		 emp.setBranch(b);
		 //b.getEmployees().add(emp);
		 session.save(b);
		 tx.commit();
		 session.close();
	}
	
	private static void createBranchAlone() {
		Session session = sessionFactory.openSession();
		 
		 Branch b = new Branch();
		 b.setName("Computer Science");
		 Transaction tx = session.beginTransaction();
		 session.save(b);
		 tx.commit();
		 session.close();
	}
	
	private static void getBranch(){

		Session session = sessionFactory.openSession();
		 

		 Transaction tx = session.beginTransaction();
		 Branch b = (Branch) session.get(Branch.class, new Long(7));
		 Employee emp = new Employee();
		 emp.setName("Rajl++333");
		 emp.setBranch(b);
		 b.getEmployees().add(emp);
		 session.save(b);
		 //session.save(emp);
		 tx.commit();
		 session.close();
	
		
	}
	
	private static void updateBranch(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		 

		Branch b = new Branch();
		b.setBranchId(2);
		//b.setName("New");
		Branch b1 = (Branch) session.get(Branch.class, new Long(2));
 		session.merge(b);
		 //session.save(emp);
		 tx.commit();
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
