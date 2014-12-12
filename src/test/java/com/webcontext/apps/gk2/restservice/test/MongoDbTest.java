/**
 * 
 */
package com.webcontext.apps.gk2.restservice.test;

import java.io.IOException;
import java.net.UnknownHostException;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;

/**
 * @author Frederic Delorme<frederic.delorme@web-context.com
 *
 */
public class MongoDbTest {
	MongodExecutable mongoExe = null;
	MongodProcess mongod = null;

	protected void start() throws UnknownHostException, IOException {
		MongodStarter runtime = MongodStarter.getDefaultInstance();
		mongoExe = runtime.prepare(new MongodConfigBuilder()
				.version(Version.V2_7_1).net(new Net(27017, true)).build());
		mongod = mongoExe.start();
	}

	protected void stop() {
		if (mongod != null) {
			mongod.stop();
			mongoExe.stop();
		}
	}

}
