package com.salmon.scommerce.persistence.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Function: baseDomain for Domain Object<br/> 
 * date: 2014年10月13日 下午2:24:45 <br/>
 * 
 * @author ctian
 *
 */
public class BaseDomain {
	
	/**
	 * return the tableName for Domain subclass Object.
	 * Use the Table annotation defined in the domain Object
	 */
	public String tableName(){
		
		Table table = this.getClass().getAnnotation(Table.class);
		if(table != null)
			return table.name();
		else
			throw new RuntimeException("undefine domain @Table,new Tablename(@Table(name))");
	}
	
	/**
	 * return the primary Key name defined in Domain subclass Object
	 * Use the @Id annotation
	 */
	public String id(){
		for(Field field : this.getClass().getDeclaredFields()){
			if(field.isAnnotationPresent(Id.class))
				return field.getName();
		}
		
		throw new RuntimeException("undefine Domain @id");
	}
	
	public String idColumnName(){
		String idPropertyName = this.id();
		return getColumnName(idPropertyName);
	}
	
	private static Map<Class<? extends BaseDomain>,List<String>> columnMap = new HashMap<Class<? extends BaseDomain>, List<String>>(); 
	
	private boolean isNull(String fieldName){
		Field filed;
		try {
			filed = this.getClass().getDeclaredField(fieldName);
			return isNull(filed);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean isNull(Field field) {
		try {
			field.setAccessible(true);
			return field.get(this) == null;
		} catch (IllegalArgumentException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e1){
			e1.printStackTrace();
		}
		return false;
	}
	
	/**
	 * return the columns defined in Domain subclass Object.
	 */
	public void cacluationColumnList(){
		
		if(columnMap.containsKey(this.getClass()))
			return;
		Field[] fields = this.getClass().getDeclaredFields();
		List<String> columnList = new ArrayList<String>();
		
		for(Field field :fields){
			if(field.isAnnotationPresent(Column.class)){
				columnList.add(field.getName());
			}
		}
		columnMap.put(this.getClass(), columnList);
		
	}
	
	/**
	 * return the where column names
	 */
	public List<WhereColumn> returnWhereColumnNames(){
		Field[] fields = this.getClass().getDeclaredFields();
		List<WhereColumn> columnList = new ArrayList<WhereColumn>(fields.length);
	
		for(Field field : fields){
			if(field.isAnnotationPresent(Column.class) && !isNull(field))
				columnList.add(new WhereColumn(field.getName(), field.getGenericType().equals(String.class)));
		}
		
		return columnList;
	}
	
	private String getColumnName(String propertyName){
		try {
			Field field = this.getClass().getDeclaredField(propertyName);
			String columnName = field.getAnnotation(Column.class).name();
			return columnName;
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
	 /** 
     * return insert Clause
     * @return 
     */  
    public String returnInsertColumnNames() {  
        StringBuilder sb = new StringBuilder();  
          
        List<String> list = columnMap.get(this.getClass());  
        int i = 0;  
        for(String column : list) {  
            if(isNull(column))  
                continue;  
           
            if(i++ != 0)  
                sb.append(',');
            String columnName = getColumnName(column);
            sb.append(columnName);  
        }  
        return sb.toString();  
    }  
	
    /** 
     * return insert params values 
     * @return 
     */  
    public String returnInsertColumnParams() {  
        StringBuilder sb = new StringBuilder();  
          
        List<String> list = columnMap.get(this.getClass());  
        int i = 0;  
        for(String column : list) {  
            if(isNull(column))  
                continue;  
              
            if(i++ != 0)  
                sb.append(',');  
            sb.append("#{").append(column).append('}');  
        }  
        return sb.toString();  
    }
	
	/**
	 * return the update set Clause param Values
	 */
	public String returnUpdateSet(){
		StringBuffer sb = new StringBuffer();
		
		List<String> list = columnMap.get(this.getClass());
		int i = 0;
		for(String column : list) {  
            if(isNull(column))  
                continue;  
              
            if(i++ != 0)  
                sb.append(',');
            String columnName = getColumnName(column);
            sb.append(columnName).append("=#{").append(column).append('}');  
        }  
		return sb.toString();
		
		
	}
	
	/** 
     * toString()
     */  
    @Override  
    public String toString() {  
        Field[] fields = this.getClass().getDeclaredFields();  
        StringBuilder sb = new StringBuilder();  
        sb.append('[');  
        for(Field f : fields) {  
            if(Modifier.isStatic(f.getModifiers()) || Modifier.isFinal(f.getModifiers()))  
                continue;  
            Object value = null;  
            try {  
                f.setAccessible(true);  
                value = f.get(this);  
            } catch (IllegalArgumentException e) {  
                e.printStackTrace();  
            } catch (IllegalAccessException e) {  
                e.printStackTrace();  
            }  
            if(value != null)  
                sb.append(f.getName()).append('=').append(value).append(',');  
        }  
        sb.append(']');  
          
        return sb.toString();  
    }  
		
	

}
