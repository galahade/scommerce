package com.salmon.scommerce.lang.exception;

/**
 * @author Young Yang
 * �߼��쳣.
 * �û�δ���������̲������µ��쳣.
 * ��Ӧ��ֱ���׳���ҳ�����ʾ���û�. 
 */
public class LogicException extends RuntimeException {

	
	private static final long serialVersionUID = -6542808745122543752L;
	
	/**
	 * �����쳣��Ϣ�Ĺ�����.
	 * 
	 * @param message �쳣��Ϣ
	 */
	public LogicException(final String message) {
		super(message);
	}
	
	/**
	 * �����쳣��Ϣ�Ĺ�����.
	 * 
	 * @param message �쳣��Ϣ
	 * @param t ���¸��쳣��ԭ��
	 */
	public LogicException(final String message, Throwable t) {
		super(message,t);
	}

}
