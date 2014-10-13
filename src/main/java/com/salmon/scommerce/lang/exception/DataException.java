package com.salmon.scommerce.lang.exception;

/**
 * @author Young Yang
 * 
 * 用于和数据源交互时错误的处理
 */
public class DataException extends SystemException {

	
	private static final long serialVersionUID = -2681947315400624910L;
	
	public DataException(String errorMessage) {
		super(errorMessage);
	}
	
	public DataException() {
		
	}


}
