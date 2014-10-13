package com.salmon.scommerce.lang.exception;

/**
 * @author Young Yang
 * ϵͳ�쳣.
 * �����ȱ��, �ͻ��˶Դ����쳣������Ϊ����.
 * һ���Ǳ�̴����µ��쳣, һ�����ִ����쳣, Ӧ�����Խ��.
 */
public class SystemException extends RuntimeException {

	
	private static final long serialVersionUID = 976767386025043218L;
	
	protected SystemException() {
		
	}
	
	/**
	 * ϵͳ�쳣�Ĺ�����.
	 * 
	 * @param errorMessage ������Ϣ
	 */
	protected SystemException(final String errorMessage) {
		super(errorMessage);
	}
	
	/**
	 * ϵͳ�쳣�Ĺ�����.
	 * 
	 * @param errorMessage ������Ϣ
	 * @param t ���¸��쳣��ԭ��
	 */
	protected SystemException( final String errorMessage, Throwable t) {
		super(errorMessage,t);
	}

}
