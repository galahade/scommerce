package com.salmon.scommerce.lang.exception;

/**
 * @author Young Yang
 * 逻辑异常.
 * 用户未按正常流程操作导致的异常.
 * 不应该直接抛出到页面层显示给用户. 
 */
public class LogicException extends RuntimeException {

	
	private static final long serialVersionUID = -6542808745122543752L;
	
	/**
	 * 带有异常信息的构造器.
	 * 
	 * @param message 异常信息
	 */
	public LogicException(final String message) {
		super(message);
	}
	
	/**
	 * 带有异常信息的构造器.
	 * 
	 * @param message 异常信息
	 * @param t 导致该异常的原因
	 */
	public LogicException(final String message, Throwable t) {
		super(message,t);
	}

}
