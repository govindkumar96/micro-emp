package com.gk.demo.emp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gk.demo.emp.dto.Employee;


@Service
public class EmployeeServiceImplBkp {
	
	private int id = 1;
	
	private static Map<Integer, Employee> empMap = new HashMap<>();
	
	public List<Employee> fetchAll() {		
		List<Employee> myList = new ArrayList<>(empMap.values());
		return myList;
		
	}

	public Employee fetchOne(int empId) {		
		Employee e = empMap.get(empId);
		return e;
	}

	public Employee addOne(Employee emp) {
		
		int empId = id++;
		emp.setEmpId(empId);
		empMap.put(empId, emp);
		return emp;
	}

	public String updateOne(int empId, Employee emp) {
		
		Employee e = new Employee();
		
		e.setEmpId(empId);

		empMap.remove(empId);
		if(null != emp.getFirstName()) {
			e.setFirstName(emp.getFirstName());
			
		}if(null != emp.getLastName()) {
			e.setLastName(emp.getLastName());
			
		}if(null != new Double(emp.getSalary())) {
			e.setSalary(emp.getSalary());
			
		}if(null != emp.getDesignation()) {
			e.setDesignation(emp.getDesignation());
			
		}
		
		empMap.put(empId, e);
		return "Employee details updated successfully for empId: "+empId;
	}

	public String deleteOne(int empId) {
		empMap.remove(empId);
		return "Deleted employee successfully !!";
	}
	
	
	

}
