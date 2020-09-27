package app.kartik.sunderban;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.kartik.sunderban.tigers.Tiger;
import app.kartik.sunderban.tigers.Tigers;

@SpringBootTest
class SunderbanApplicationTests
{
	private static final Logger logger = Logger.getLogger(SunderbanApplicationTests.class.getName());

	@Autowired Tigers tigers;

	@Test
	void test_get_tiger()
	{
		Tiger tiger = tigers.select("bengal");

		logger.info("Got Tiger: " + tiger);

		Assert.assertEquals("Bengal", tiger.getName());
		Assert.assertEquals("https://en.wikipedia.org/wiki/Bengal_tiger", tiger.getWikiLink());
		Assert.assertNotNull(tiger.getImageLink());

		logger.info("Test Ran!");
	}
}
