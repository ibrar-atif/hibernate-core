package com.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCH")
public class Branch {


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BID", unique = true, nullable = false)
	private long branchId;
	
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "branch", cascade=CascadeType.ALL)
	private Set<Employee> employees = new HashSet<Employee>();
	
	public Branch(){
		
	}

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
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
