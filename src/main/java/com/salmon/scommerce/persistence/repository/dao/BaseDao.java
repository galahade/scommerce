package com.salmon.scommerce.persistence.repository.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseDao<T> extends SqlSessionDaoSupport {
	
	private String packagePath = "com.salmon.scommerce.persistence.repository.";
	
	public T selectOne(T obj){
		
		return this.getSqlSession().selectOne(getMethodPath(obj.getClass()) + ".getByObjectParams");
	}
	
	/**
	 * Retrieve a single row mapped by object Id
	 * @param clazz
	 * @param id the primary id
	 * @return the returned object type
	 */
	public T selectOne(Class clazz, int id){
		
		return this.selectOne(getMethodPath(clazz) + ".getByEntityId", id);
	}
	
	public T selectOne(String sqlStat, Object object){
		
		return this.getSqlSession().selectOne(sqlStat, object);
	}
	
	
	public List<T> selectList(Class<T> clazz,Object obj){
		return this.getSqlSession().selectList(getMethodPath(clazz.getClass()), obj);	
	}

	public int add(T obj){
		
		return this.getSqlSession().insert(getMethodPath(obj.getClass()) + ".add", obj);
	}
	
	public int update(T obj){
		return this.getSqlSession().update(getMethodPath(obj.getClass()) + ".update", obj);
	}
	
	public int delete(T obj){
		return this.getSqlSession().delete(getMethodPath(obj.getClass()) + ".delete", obj);
	}
	
	public int delete(Class clazz, int id){
		return this.getSqlSession().delete(getMethodPath(clazz) + ".delete", id);
	}
	
	
	
	private String getMethodPath(Class clazz){
		
		return packagePath + clazz.getSimpleName() + "Mapper";
	}
	
}

