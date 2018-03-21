package com.inheritence.tpch;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="WORKER")
@DiscriminatorValue("DEV")
public class Developer extends Worker{

	@Column
	String domain;
	
	
	@Column
	private String departmentName;
	
	public Developer(){
		
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
