/**
 * 
 */
package com.webcontext.apps.gk2.restservice.test;

import static com.jayway.restassured.RestAssured.get;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

/**
 * @author Frederic Delorme<frederic.delorme@web-context.com
 *
 */
public class GameRestServiceTest {

	/**
	 * Test method for {@link com.webcontext.apps.gk2.restservice.services.GameRestService#findByTitle(java.lang.String)}.
	 */
	@Test
	@Ignore
	public void testFindByTitle() {
		get("/game/find/Watch%20Dogs")
		.then()
			.statusCode(200)
			.body("title", equal("Watch Dogs"));
	}

	/**
	 * Test method for {@link com.webcontext.apps.gk2.restservice.services.GameRestService#findById(java.lang.String)}.
	 */
	@Test
	@Ignore
	public void testFindById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.webcontext.apps.gk2.restservice.services.GameRestService#findAll(int, int)}.
	 */
	@Test
	@Ignore
	public void testFindAll() {
		fail("Not yet implemented");
	}

}
