package com.gk.demo.emp.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Component
@ApiModel(description = "This is Employee model")
public class Employee {
	
	@ApiModelProperty("unique id of employee")
	private long empId;
	
	@ApiModelProperty("first name of the employee")
	@NotNull
	private String firstName;
	
	@ApiModelProperty("last name of the employee")
	private String lastName;
	
	@ApiModelProperty("designation/position of the employee")
	private String designation;
	
	@ApiModelProperty("salary of the employee")
	private double salary;
	
	@ApiModelProperty("date of joining of the employee")
	@NotNull
	private Date doj;

	public Employee() {
		super();
	}

	public Employee(long empId, String firstName, String lastName, String designation, double salary, Date doj) {
		super();
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
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", designation="
				+ designation + ", salary=" + salary + ", doj=" + doj + "]";
	}
	
		
}
