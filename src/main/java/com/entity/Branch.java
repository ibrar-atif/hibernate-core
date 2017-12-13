package com.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCH")
public class Branch {


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BID", unique = true, nullable = false)
	private long branchId;
	
	private String name;
	
	public Branch(){
		
	}

	public long getId() {
		return branchId;
	}

	public void setId(long id) {
		this.branchId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
