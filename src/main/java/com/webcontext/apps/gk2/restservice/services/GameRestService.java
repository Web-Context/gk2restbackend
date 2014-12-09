/**
 * 
 */
package com.webcontext.apps.gk2.restservice.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.webcontext.apps.gk2.restservice.model.Game;
import com.webcontext.apps.gk2.restservice.persistence.exception.NullMongoDBConnection;
import com.webcontext.apps.gk2.restservice.repository.GameRepository;

/**
 * Serve Game information on some REST web service.
 * 
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
	public void findByTitle(@PathParam("title") String title) {
		logger.debug("Retrieve a game on its title " + title + ".");
		List<Game> gameList;
		try {
			gameList = games.findByTitle(title);
			if (games != null) {
				Response.ok(gameList.get(0));
			} else {
				Response.status(Status.NOT_FOUND);
			}
		} catch (NullMongoDBConnection e) {
			Response.status(Status.BAD_REQUEST);
		}
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public void findById(@PathParam("id") String id) {
		logger.debug("Retrieve a game on its id=" + id + ".");
		Game game = null;
		try {
			game = games.findById(id);
			if (game != null) {
				Response.ok(game);
			} else {
				Response.status(Status.NOT_FOUND);
			}
		} catch (NullMongoDBConnection e) {
			Response.status(Status.BAD_REQUEST);
		}
	}

	/**
	 * Retrieve <code>pageSize</code> games from list starting at
	 * <code>offset</code>.
	 * 
	 * @param offset
	 *            first item for the game list.
	 * @param pageSize
	 *            number of items to retrieve.
	 */
	@GET
	@Path("/{offset}-{pageSize}")
	@Produces("application/json")
	public void findAll(@PathParam("offset") int offset,
			@PathParam("pageSize") int pageSize) {
		logger.debug("Retrieve @pageSize=" + pageSize + " games from @offset="
				+ offset);
		List<Game> gameList;
		try {
			gameList = games.find("",offset, pageSize);
			if (games != null) {
				Response.ok(gameList);
			} else {
				Response.status(Status.NOT_FOUND);
			}
		} catch (NullMongoDBConnection e) {
			Response.status(Status.BAD_REQUEST);
		}
	}

}
