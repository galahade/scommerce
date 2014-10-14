package com.salmon.scommerce.persistence.domain;
import  static org.apache.ibatis.jdbc.SqlBuilder.*;

public class CUDTemplate<T extends BaseDomain> {
	
	public String getById(T obj){
		String idname = obj.id();
		String idColumnName = obj.idColumnName();
		BEGIN();
		SELECT("*");
		FROM(obj.tableName());
		WHERE(idColumnName + "=#{" + idname + "}");
		
		return SQL();
	}
	
	public String insert(T obj){
		BEGIN();
		INSERT_INTO(obj.tableName());
		obj.cacluationColumnList();
		VALUES(obj.returnInsertColumnNames(),obj.returnInsertColumnParams());
		
		return SQL();
	}
	
	public String update(T obj){
		String idname = obj.id();
		String idColumnName = obj.idColumnName();
		BEGIN();
		UPDATE(obj.tableName());
		obj.cacluationColumnList();
		SET(obj.returnUpdateSet());
		WHERE(idColumnName + "=#{" + idname + "}");
		
		return SQL();
	}
	
	public String delete(T obj){
		String idname = obj.id();
		String idColumnName = obj.idColumnName();
		BEGIN();
		DELETE_FROM(obj.tableName());
		WHERE(idColumnName + "=#{" + idname +"}");
		
		return SQL();
	}

}
