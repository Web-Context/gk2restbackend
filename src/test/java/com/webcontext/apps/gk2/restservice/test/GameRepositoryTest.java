/**
 * 
 */
package com.webcontext.apps.gk2.restservice.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.webcontext.apps.gk2.restservice.model.Game;
import com.webcontext.apps.gk2.restservice.persistence.exception.NullMongoDBConnection;
import com.webcontext.apps.gk2.restservice.repository.GameRepository;

/**
 * GameRepository Unit test
 * 
 * @author Frederic Delorme<frederic.delorme@web-context.com>
 *
 */
@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameRepositoryTest {

	@Deployment
	public static JavaArchive createArchive() {
		return ShrinkWrap.create(JavaArchive.class, "foo.jar")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addPackage(GameRepository.class.getPackage());
	}

	@Inject
	private GameRepository games;

	private List<Game> listGames;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		listGames = games.loadObjectFromJSONFile("dataset/games.json");
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#save(java.lang.Object)}
	 * .
	 */
	@Test
	public void test_01_Save() {
		games.removeAll();
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
	public void test_03_FindById() {
		try {
			Game game = games.findById("000001");
			assertEquals(
					"Unbale to find 'Watch Dogs' game with the id='000001'",
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
	public void test_04_Find() {
		try {
			List<Game> list = games.find();
			assertEquals("Unbale to find any game", list.size() > 0, true);
		} catch (NullMongoDBConnection e) {
			fail("Unable to retrieve the game with id '00001'");
		}
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#count()}
	 * .
	 */
	@Test
	public void test_05_Count() {
		try {
			long nb = games.count();
			assertEquals("Number of games is not 2", nb, 2);
		} catch (NullMongoDBConnection e) {
			fail("Unable to count games.");
		}

	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#find(java.lang.String, int, int)}
	 * .
	 */
	@Test
	public void test_07_FindStringIntInt() {
		try {
			List<Game> list = games
					.find("{platform : { $all: ['X360']}}", 1, 1);
			assertEquals("Unbale to find any game", list.size(), 1);
		} catch (NullMongoDBConnection e) {
			fail("Unable to retrieve the game with id '00001'");
		}
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.gk2.restservice.persistence.MongoDbRepository#remove(java.lang.Object)}
	 * .
	 */
	@Test
	public void test_08_Remove() {
		try {
			for (Game item : listGames) {
				games.remove(item);
			}
			assertEquals("List of collection 'games' was not purged",
					games.count(), 0);
		} catch (NullMongoDBConnection e) {
			fail("Unable to purge collection");
		}
	}

}
