package com.webcontext.apps.gk2.restservice.persistence.exception;

/**
 * Exception raised by DataManager when the corresponding repository for an
 * entity class does not exists.
 * 
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 * 
 */
public class RepositoryDoesNotExistsException extends Exception {

	/**
	 * 
	 */
	public RepositoryDoesNotExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param arg0
	 * @param arg1
	 */
	public RepositoryDoesNotExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public RepositoryDoesNotExistsException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public RepositoryDoesNotExistsException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4852341721313731315L;

}