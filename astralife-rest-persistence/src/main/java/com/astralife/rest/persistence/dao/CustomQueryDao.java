package com.astralife.rest.persistence.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CustomQueryDao {

	public void createDatabase(@Param("query") String query) throws Exception;
	public Long executeQuery(@Param("query") Object query) throws Exception;
	public List<HashMap<String, Object>> select(@Param("query") Object query);
	public Long count(@Param("query") Object query);
	public String getSingleResult(@Param("query") String query) throws Exception;
	public List<HashMap<String, Object>> selectData(@Param("query") String query);
	
}
