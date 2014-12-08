/**
 * 
 */
package com.webcontext.apps.gk2.restservice.manager;

import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import com.webcontext.apps.gk2.restservice.model.Game;
import com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository;
import com.webcontext.apps.gk2.restservice.persistence.exception.NullMongoDBConnection;

/**
 * a basic Web REST web service to serve Game entity.
 * 
 * @author Frederic Delorme<frederic.delorme@web-context.com
 *
 */
public class GameRepository extends MongoDbRepository<Game> {

	/**
	 * Default constructor for default connection.
	 */
	public GameRepository() {
		super("games");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#deserialize
	 * (com.mongodb.BasicDBObject)
	 */
	@Override
	public Game deserialize(BasicDBObject item) {
		Game game = new Game();
		game = gson.fromJson(item.toString(), Game.class);
		return game;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#serialize
	 * (java.lang.Object)
	 */
	@Override
	public BasicDBObject serialize(Game item) {
		BasicDBObject object = new BasicDBObject();

		object = (BasicDBObject) JSON.parse(gson.toJson(item).toString());
		return object;
	}

	/**
	 * Retrieve a game on its title.
	 * 
	 * @param title
	 * @return
	 */
	public Game findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.webcontext.apps.gk2.restservice.persistence.IMongoDbRepository#findById
	 * (java.lang.String)
	 */
	@Override
	public Game findById(String id) throws NullMongoDBConnection {
		// TODO Auto-generated method stub
		return null;
	}

}
