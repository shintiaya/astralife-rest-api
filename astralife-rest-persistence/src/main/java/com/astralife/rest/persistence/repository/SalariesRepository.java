package com.astralife.rest.persistence.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.astralife.rest.persistence.model.Salaries;

@Repository
public interface SalariesRepository extends GenericRepository<Salaries, Long>{

	@Query("SELECT obj FROM Salaries obj WHERE obj.employee.empNo = ?1 ")
	Salaries getByEmpNo(Long empNo);

	@Transactional
	@Modifying
	@Query("DELETE Salaries obj WHERE id in (SELECT id FROM Salaries obj2 where obj2.employee.empNo= ?1) ")
	void deleteByEmpNo(Long empNo);

}
