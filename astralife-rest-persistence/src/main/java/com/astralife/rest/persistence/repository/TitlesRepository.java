package com.astralife.rest.persistence.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.astralife.rest.persistence.model.Titles;

@Repository
public interface TitlesRepository extends GenericRepository<Titles, Long>{

	@Query("SELECT obj FROM Titles obj WHERE obj.employee.empNo = ?1 ")
	Titles getByEmpNo(Long empNo);

	@Transactional
	@Modifying
	@Query("DELETE Titles obj WHERE id in (SELECT id FROM Titles obj2 where obj2.employee.empNo= ?1) ")
	void deleteByEmpNo(Long empNo);

}
