package com.salmon.scommerce.persistence.domain;

public class WhereColumn {
	public String name;
	public boolean isString;
	
	public WhereColumn(String name, boolean isString){
		this.name = name;
		this.isString = isString;
	}

}
