package com.manytomany;

import java.util.HashSet;
import java.util.Set;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Client {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
	public static void main(String a[]){
		buildSessionFactory();
		//PersonCreated();
		//getPerson();
		//getLanguge();
		
		createLanguage();
		
		
	}
	
	public static void PersonCreated(){
		Person p = new Person();
		p.setPname("vivek");
		
		Language l1 = new Language();
		l1.setLname("hindi11");
		Language l2 = new Language();
		l2.setLname("english11");
		
		Set<Language> set = new HashSet<Language>();
		set.add(l1);
		set.add(l2);
		
		p.setLanguages(set);
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(p);
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}
	
	public static void getPerson(){

		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Person p = (Person) session.get(Person.class, new Long(1));
		tx.commit();
		session.close();
		sessionFactory.close();
		
	
	}
	
public static void getLanguge(){

		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Language l = (Language) session.get(Language.class, new Long(1));
		tx.commit();
		session.close();
		sessionFactory.close();
		
	
	}

public static void createLanguage(){
	Person p = new Person();
	p.setPname("sam");
	
	Person p2 = new Person();
	p2.setPname("rajiv");
	
	
	
	Language l1 = new Language();
	l1.setLname("dutch");
		
	Set<Person> set = new HashSet<Person>();
	set.add(p);
	set.add(p2);
	
	l1.setPersons(set);
	
	Session session = sessionFactory.openSession();
	
	Transaction tx = session.beginTransaction();
	
	session.save(l1);
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
