package com.salmon.scommerce.persistence.repository;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.salmon.scommerce.persistence.domain.BaseDomain;
import com.salmon.scommerce.persistence.domain.CUDTemplate;

public interface BaseMapper<T extends BaseDomain> {
	
	
	@SelectProvider(type=CUDTemplate.class,method="getById")
	@ResultMap("result")
	//public List<T> select(T obj);
	public T getById(T obj);
	
	
	/**
	 * insert
	 * @param obj
	 */
	@InsertProvider(type=CUDTemplate.class,method="insert")
	public int insert(T obj);
	
	/**
	 * update
	 */
	@UpdateProvider(type=CUDTemplate.class,method="update")
	public int update(T obj); 
	
	/**
	 * delete
	 */
	@DeleteProvider(type=CUDTemplate.class,method="delete")
	public int delete(T obj); 

}
