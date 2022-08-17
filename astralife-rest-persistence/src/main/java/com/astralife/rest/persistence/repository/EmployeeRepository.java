package com.astralife.rest.persistence.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.astralife.rest.persistence.model.Employee;

@Repository
public interface EmployeeRepository extends GenericRepository<Employee, Long>{

	Employee findByEmpNo(Long empNo);

	@Transactional
	@Modifying
	@Query("DELETE Employee obj WHERE obj.empNo = ?1 ")
	void deleteByEmpNo(Long empNo);

}
