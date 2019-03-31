package org.hut.exception;

public class MyException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException() {
		super("自定义异常");
	}
}
