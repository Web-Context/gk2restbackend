package com.webcontext.apps.gk2.restservice.persistence;

import java.util.List;

import com.mongodb.WriteResult;
import com.webcontext.apps.gk2.restservice.persistence.exception.NullMongoDBConnection;

/**
 * Interface describing a MongoDB repository.
 * 
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 * @param <T>
 */
public interface IMongoDbRepository<T> {

	/**
	 * Set the database connection for this repository.
	 * 
	 * @param conn
	 */
	public void setConnection(MongoDbConnection conn);

	/**
	 * Retrieve an entity from repository by its Id.
	 * 
	 * @param id
	 *            of the entity to retrieve.
	 * @return
	 * @throws NullMongoDBConnection
	 */
	public T findById(String id) throws NullMongoDBConnection;

	/**
	 * Retrieve data from the defined collection.
	 * 
	 * @return
	 * @throws NullMongoDBConnection
	 */
	public abstract List<T> find() throws NullMongoDBConnection;

	/**
	 * Retrieve data from a collection with particular criteria.
	 * 
	 * @param filter
	 * @return
	 * @throws NullMongoDBConnection
	 */
	public abstract List<T> find(String filter) throws NullMongoDBConnection;

	/**
	 * Retrieve data from a collection with particular filter and manage
	 * pagination.
	 * 
	 * @param filter
	 * @param offset
	 * @param pageSize
	 * @return
	 * @throws NullMongoDBConnection
	 */
	public abstract List<T> find(String filter, int offset, int pageSize)
			throws NullMongoDBConnection;

	/**
	 * return the number of record in a collection.
	 * 
	 * @return
	 * @throws NullMongoDBConnection
	 */
	public long count() throws NullMongoDBConnection;

	/**
	 * Save the <code>item</code> T and add to the <code>collection</code>
	 * 
	 * @param item
	 * @return _id for the create object into the collection.
	 * @throws NullMongoDBConnection
	 */
	public abstract WriteResult save(T item) throws NullMongoDBConnection;

	/**
	 * 
	 * @param item
	 * @throws NullMongoDBConnection
	 */
	public abstract void remove(T item) throws NullMongoDBConnection;

}