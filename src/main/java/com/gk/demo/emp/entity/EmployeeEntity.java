package com.gk.demo.emp.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employee")
public class EmployeeEntity {
	
	private long empId;
	
	private String firstName;
	
	private String lastName;
	
	private String designation;
	
	private double salary;
	
	private Date doj;
		

	public EmployeeEntity() {
		
	}


	public EmployeeEntity(long empId, String firstName, String lastName, String designation, double salary, Date doj) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.salary = salary;
		this.doj = doj;
	}


	public long getEmpId() {
		return empId;
	}


	public void setEmpId(long empId) {
		this.empId = empId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Date getDoj() {
		return doj;
	}


	public void setDoj(Date doj) {
		this.doj = doj;
	}


	@Override
	public String toString() {
		return "EmployeeEntity [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", designation=" + designation + ", salary=" + salary + ", doj=" + doj + "]";
	}
	

}
