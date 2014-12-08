/**
 * 
 */
package com.webcontext.apps.gk2.restservice.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.webcontext.apps.gk2.restservice.model.Game;
import com.webcontext.apps.gk2.restservice.persistence.exception.NullMongoDBConnection;
import com.webcontext.apps.gk2.restservice.repository.GameRepository;

/**
 * GameRepository Unit test
 * 
 * @author Frederic Delorme<frederic.delorme@web-context.com
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameRepositoryTest {

	private GameRepository games;

	private List<Game> listGames;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		games = new GameRepository();
		listGames = games.loadObjectFromJSONFile("dataset/games.json");
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#save(java.lang.Object)}
	 * .
	 */
	@Test
	public void test_01_Save() {
		int count = 0;
		for (Game game : listGames) {
			try {
				games.save(game);
				count++;
			} catch (NullMongoDBConnection e) {
				fail("Unable to save the game :" + game.toString());
			}
		}
		assertEquals("All games not inserted", 2, count);
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.repository.GameRepository#findByTitle(java.lang.String)}
	 * .
	 */
	@Test
	public void test_02_FindByTitle() {
		try {
			List<Game> list = games.findByTitle("Watch Dogs");
			if (list != null && list.size() > 0) {
				Game game = list.get(0);
				assertEquals("This Watch Dogs game was not retrieved",
						"gtalike", game.getTags().get(0));
			} else {
				fail("Unable to retrieve data");
			}
		} catch (NullMongoDBConnection e) {
			fail("Unable to retrieve data");
		}
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.repository.GameRepository#findById(java.lang.String)}
	 * .
	 */
	@Test
	@Ignore
	public void test_03_FindById() {
		try {
			Game game = games.findById("00001");
			assertEquals(
					"Unbale to find 'Watch Dogs' game with the id='00001'",
					"Watch Dogs", game.getTitle());
		} catch (NullMongoDBConnection e) {

			fail("Unable to retrieve the game with id '00001'");
		}

	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#find()}
	 * .
	 */
	@Test
	@Ignore
	public void test_04_Find() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#count()}
	 * .
	 */
	@Test
	@Ignore
	public void test_05_Count() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#find(java.lang.String)}
	 * .
	 */
	@Test
	@Ignore
	public void test_06_FindString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#find(java.lang.String, int, int)}
	 * .
	 */
	@Test
	@Ignore
	public void test_07_FindStringIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#remove(java.lang.Object)}
	 * .
	 */
	@Test
	@Ignore
	public void test_08_Remove() {
		fail("Not yet implemented");
	}

}
