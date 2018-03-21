package com.inheritence.tpsc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity  
@Table(name = "Job")  
@Inheritance(strategy=InheritanceType.JOINED)  
public class Job {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	      
	@Column(name = "ID")  
	private int id;  
	  
	@Column(name = "name")  
	private String name;  

	public Job(){
		
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
	
}
