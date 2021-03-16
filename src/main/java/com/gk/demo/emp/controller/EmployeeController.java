package com.gk.demo.emp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gk.demo.emp.dto.Employee;
import com.gk.demo.emp.exception.RecordNotFoundException;
import com.gk.demo.emp.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	private final static Logger LOGGER = LogManager.getLogger(EmployeeController.class); 
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Fetches all existing employees")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "OK", response = Employee.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Employee.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Employee.class),
			@ApiResponse(code = 404, message = "Not Found", response = Employee.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Employee.class) })
	public ResponseEntity<List<Employee>> allEmployees() {
		LOGGER.info("fetch for all employees initiated...");
		List<Employee> response = employeeService.fetchAllEmployee();
		LOGGER.info("fetch for all employees completed...");
		//return ResponseEntity.ok(response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping(value = "/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Fetches an employee of the given Id")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "OK", response = Employee.class),	
			@ApiResponse(code = 400, message = "Bad Request", response = Employee.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Employee.class),
			@ApiResponse(code = 404, message = "Not Found", response = Employee.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Employee.class) })
	public ResponseEntity<Employee> getEmployees(@ApiParam(value = "data to fetch employee details") @PathVariable long empId) {
		Employee response = employeeService.fetchEmployeeDetails(empId);
		if(response == null) {
			throw new RecordNotFoundException("Invalid employee id :"+empId);
		}
		return new ResponseEntity<Employee>(response, HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Creates a new employee")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "OK", response = Object.class),
			@ApiResponse(code = 201, message = "Created", response = Object.class),
			//@ApiResponse(code = 204, message = "No Content", response = Object.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Object.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Object.class),
			@ApiResponse(code = 404, message = "Not Found", response = Object.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Object.class) })
	public ResponseEntity<Object> addEmployees(@ApiParam(value = "data to create an employee") @Valid @RequestBody Employee emp) {
		long id = employeeService.createEmployee(emp);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();

	}

	@PutMapping(value = "/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Updates an existing employee of the given Id")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 201, message = "Created", response = String.class),
			@ApiResponse(code = 204, message = "No Content", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) })
	public ResponseEntity<String> updateEmployees(@ApiParam(value = "data to update an employee") 
													@PathVariable long empId, @Valid @RequestBody Employee emp) {
		String response = employeeService.updateEmployee(empId, emp);
		return new ResponseEntity<String>(response, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(value = "/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Deletes an employee of the given Id")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 202, message = "Accepted", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) })
	public ResponseEntity<String> deleteEmployees(@ApiParam(value = "data to delete an employee") 
													@PathVariable long empId) {
		String response = employeeService.deleteEmployee(empId);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/upload")
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		
		return "Upload Successful !!";
		
	}

}
