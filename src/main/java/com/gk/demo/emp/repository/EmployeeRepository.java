package com.gk.demo.emp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gk.demo.emp.entity.EmployeeEntity;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, Long>{
	
	EmployeeEntity findByEmpId(long id);
	
	void deleteByEmpId(long id);

}
