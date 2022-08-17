package com.astralife.rest.persistence.repository;

import org.springframework.stereotype.Repository;

import com.astralife.rest.persistence.model.Departments;

@Repository
public interface DepartmentsRepository extends GenericRepository<Departments, Long> {

	Departments findByDeptNo(String deptNo);

}
