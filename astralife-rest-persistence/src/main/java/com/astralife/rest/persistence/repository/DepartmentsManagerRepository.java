package com.astralife.rest.persistence.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.astralife.rest.persistence.model.DepartmentsManager;

@Repository
public interface DepartmentsManagerRepository extends GenericRepository<DepartmentsManager, Long> {
	
	@Query("SELECT obj FROM DepartmentsManager obj WHERE obj.employee.empNo = ?1 ")
	DepartmentsManager getByEmpNo(Long empNo);

	@Transactional
	@Modifying
	@Query("DELETE DepartmentsManager obj WHERE id in (SELECT id FROM DepartmentsManager obj2 where obj2.employee.empNo= ?1) ")
	void deleteByEmpNo(Long empNo);

}
