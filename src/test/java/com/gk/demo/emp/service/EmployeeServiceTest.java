package com.gk.demo.emp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.gk.demo.emp.dto.Employee;
import com.gk.demo.emp.entity.EmployeeEntity;
import com.gk.demo.emp.repository.EmployeeRepository;
import com.gk.demo.emp.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@Mock
	private ModelMapper modelMapper;
	
	@Test
	public void testFetchEmployeeDetails() {
		
		EmployeeEntity entity = new EmployeeEntity(1L, "Mike", "Hannigan", "", 20000.00, null);
		
		//Employee dto = new Employee(1L, "Mike", "Hannigan", "", 20000.00, null);
		
		when(employeeRepository.findByEmpId(1L)).thenReturn(entity);
		
		Employee employee = employeeService.fetchEmployeeDetails(1);
		
		assertEquals("Mike", employee.getFirstName());
		
		//assertThat(employeeService.fetchEmployeeDetails(1)).isEqualTo(employee);
		
		
	}
	
	/*@SuppressWarnings("unchecked")
	@Test
	public void testFetchAllEmployee() {
		
		List<EmployeeEntity> empList = new ArrayList<>(); 
		
		EmployeeEntity emp1 = new EmployeeEntity(1, "Mike", "Hannigan", "", 20000.00, null);
		EmployeeEntity emp2 = new EmployeeEntity(1, "Richard", "Bruke", "", 50000.00, null);
		
		empList.add(emp1);
		empList.add(emp2);
		
		when(employeeService.fetchAllEmployee()).thenReturn((List<Employee>) modelMapper.map(empList, Employee.class));
		
		assertThat(employeeService.fetchAllEmployee()).size().isEqualTo(2);
		
		
	}*/
	
	
	

}
