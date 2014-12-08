package com.webcontext.apps.gk2.restservice.persistence.exception;

/**
 * A specific exception thrown by MongoDBConnection when connection is
 * impossible.
 * 
 * @author Frederic Delorme<frederic.delorme@web-context.com>
 * 
 */
public class NullMongoDBConnection extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8762131616763841871L;

	/**
	 * 
	 */
	public NullMongoDBConnection() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NullMongoDBConnection(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NullMongoDBConnection(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NullMongoDBConnection(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}