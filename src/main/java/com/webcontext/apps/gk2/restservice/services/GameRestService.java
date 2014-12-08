/**
 * 
 */
package com.webcontext.apps.gk2.restservice.services;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.webcontext.apps.gk2.restservice.manager.GameRepository;
import com.webcontext.apps.gk2.restservice.model.Game;
import com.webcontext.apps.gk2.restservice.persistence.exception.NullMongoDBConnection;

/**
 * @author Frederic Delorme<frederic.delorme@web-context.com
 *
 */
@Path("/game")
public class GameRestService {

	private static Logger logger = Logger.getLogger(GameRestService.class);

	@Inject
	private GameRepository games;

	@GET
	@Path("/find/{title}")
	@Produces("application/json")
	public Game findByTitle(@PathParam("title") String title) {
		logger.debug("Retrieve a game on its title " + title + ".");
		Game game = games.findByTitle(title);
		return game;
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Game findById(@PathParam("id") String id) {
		logger.debug("Retrieve a game on its id=" + id + ".");
		Game game = null;
		try {
			game = games.findById(id);
		} catch (NullMongoDBConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return game;
	}

}
