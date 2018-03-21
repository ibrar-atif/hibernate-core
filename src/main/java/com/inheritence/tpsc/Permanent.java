package com.inheritence.tpsc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity  
@Table(name="Permanent")  
@PrimaryKeyJoinColumn(name="ID")  
public class Permanent extends Job{

	@Column(name="salary")    
	private float salary;  
	  
	@Column(name="bonus")     
	private int bonus; 
	
	public Permanent(){
		
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
