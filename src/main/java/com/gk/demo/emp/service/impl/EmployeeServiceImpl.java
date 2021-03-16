package com.gk.demo.emp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.demo.emp.dto.Employee;
import com.gk.demo.emp.entity.EmployeeEntity;
import com.gk.demo.emp.repository.EmployeeRepository;
import com.gk.demo.emp.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired 
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> fetchAllEmployee() {
		List<EmployeeEntity> empEntity = employeeRepository.findAll();
		List<Employee> empList = empEntity.stream().map(e -> entityToModel(e)).collect(Collectors.toList());
		return empList;
	}

	@Override
	public Employee fetchEmployeeDetails(long id) {
		Employee emp = null;
		EmployeeEntity empEntity = employeeRepository.findByEmpId(id);
		if (null != empEntity) {
			emp = entityToModel(empEntity);
		}
		return emp;
	}

	@Override
	public long createEmployee(Employee emp) {
		EmployeeEntity empEntity = employeeRepository.save(modelToEntity(emp));
		return empEntity.getEmpId();
	}

	@Override
	public String updateEmployee(long id, Employee emp) {
		emp.setEmpId(id);
		employeeRepository.save(modelToEntity(emp));
		return "Successfully updated";
	}

	@Override
	public String deleteEmployee(long id) {
		employeeRepository.deleteByEmpId(id);
		return "Successfully deleted";
	}
	
	private Employee entityToModel(EmployeeEntity entity) {
		Employee emp = modelMapper.map(entity, Employee.class);
		return emp;
	}
	
	private EmployeeEntity modelToEntity(Employee model) {
		return modelMapper.map(model, EmployeeEntity.class);
	}
	
}
