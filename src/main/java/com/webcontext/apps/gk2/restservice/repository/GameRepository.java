/**
 * 
 */
package com.webcontext.apps.gk2.restservice.repository;

import java.io.IOException;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.util.JSON;
import com.webcontext.apps.gk2.restservice.model.Game;
import com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository;
import com.webcontext.apps.gk2.restservice.persistence.exception.NullMongoDBConnection;
import com.webcontext.apps.gk2.restservice.utils.FileIO;

/**
 * a basic Web REST web service to serve Game entity.
 * 
 * @author Frederic Delorme<frederic.delorme@web-context.com>
 *
 */
public class GameRepository extends MongoDbRepository<Game> {

	/**
	 * Default constructor for default connection to "games" collection.
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
	 * @throws NullMongoDBConnection
	 */
	public List<Game> findByTitle(String title) throws NullMongoDBConnection {

		return this.find("{ \"title\" : \"" + title + "\" }");
	}

	/**
	 * Read the T object list from a JSON file.
	 * 
	 * @param filePath
	 *            the JSON file to be read and parsed to produce a
	 *            <code>List<T></code> objects.
	 * @return return a list of T object as a <code>list<T></code>.
	 * @throws IOException
	 */
	@SuppressWarnings("serial")
	public List<Game> loadObjectFromJSONFile(String filePath)
			throws IOException {
		String json = FileIO.fastRead(filePath);
		TypeToken<List<Game>> token = new TypeToken<List<Game>>() {
		};
		List<Game> list = gson.fromJson(json, token.getType());

		return list;
	}

	@Override
	public Game findById(String id) throws NullMongoDBConnection {
		List<Game> list =  super.find("{ id:'"+id+"'}");
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
