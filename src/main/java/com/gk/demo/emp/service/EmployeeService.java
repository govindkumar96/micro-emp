package com.gk.demo.emp.service;

import java.util.List;

import com.gk.demo.emp.dto.Employee;

public interface EmployeeService {
	
	List<Employee> fetchAllEmployee();
	
	Employee fetchEmployeeDetails(long id);
	
	long createEmployee(Employee emp);
	
	String updateEmployee(long id, Employee emp);
	
	String deleteEmployee(long id);
	
}
