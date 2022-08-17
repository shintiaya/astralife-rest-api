package com.astralife.rest.persistence.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.astralife.rest.persistence.model.DepartmentsEmployee;

@Repository
public interface DepartmentsEmployeeRepository extends GenericRepository<DepartmentsEmployee, Long>{

	@Transactional
	@Modifying
	@Query("DELETE DepartmentsEmployee obj WHERE id in (SELECT id FROM DepartmentsEmployee obj2 where obj2.employee.empNo= ?1) ")
	void deleteByEmpNo(Long empNo);

	@Query("SELECT obj FROM DepartmentsEmployee obj WHERE obj.employee.empNo = ?1 ")
	DepartmentsEmployee getByEmpNo(Long empNo);

}
