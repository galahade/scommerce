package com.salmon.scommerce.lang.exception;

/**
 * @author Young Yang
 * 系统异常.
 * 软件的缺陷, 客户端对此类异常是无能为力的.
 * 一般是编程错误导致的异常, 一旦出现此种异常, 应该予以解决.
 */
public class SystemException extends RuntimeException {

	
	private static final long serialVersionUID = 976767386025043218L;
	
	protected SystemException() {
		
	}
	
	/**
	 * 系统异常的构造器.
	 * 
	 * @param errorMessage 错误信息
	 */
	protected SystemException(final String errorMessage) {
		super(errorMessage);
	}
	
	/**
	 * 系统异常的构造器.
	 * 
	 * @param errorMessage 错误信息
	 * @param t 导致该异常的原因
	 */
	protected SystemException( final String errorMessage, Throwable t) {
		super(errorMessage,t);
	}

}
