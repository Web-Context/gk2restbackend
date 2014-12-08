package com.webcontext.apps.gk2.restservice.persistence.model;

import java.util.Map;

/**
 * A default entity manager.
 *
 * @author Frederic Delorme<frederic.delorme@web-context.com
 *
 */
public class MongoEntity {
	public Map<String, String> _id;

	public MongoEntity() {
		// TODO Auto-generated constructor stub
	}

	public MongoEntity(Map<String, String> _id) {
		super();
		this._id = _id;
	}

	/**
	 * @return the _id
	 */
	public Map<String, String> get_id() {
		return _id;
	}

	/**
	 * @param _id
	 *            the _id to set
	 */
	public void set_id(Map<String, String> _id) {
		this._id = _id;
	}

}