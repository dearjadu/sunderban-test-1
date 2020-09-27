package app.kartik.sunderban.tigers;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import app.kartik.sunderban.Utilities;

/**
 * Data repository of {@link Tiger} objects. In a real-world implementation, this class would read data from a
 * persistent store such as a SQL or NoSQL database, and would support more sophisticated queries. For this demo, the
 * repository is constructed from a JSON file (see main/resources/tigers.json) at the time of initialization of this
 * repository.
 */
@Component
public class Tigers
{
	private static final Logger logger = Logger.getLogger(Tigers.class.getName());

	private Map<String, Tiger> tigers;

	/**
	 * Select a {@link Tiger} based on the given {@code name}
	 *
	 * @param name Name to lookup; searched without case sensitivity
	 *
	 * @return Matching Tiger object, or {@code null}
	 */
	public Tiger select(String name)
	{
		logger.info("Selecting a Tiger by name: " + name);

		return tigers.get(name.toUpperCase());
	}

	/**
	 * Select all {@link Tiger} objects as a {@link Collection}.
	 *
	 * @return Collection of Tiger objects available in this repository
	 */
	public Collection<Tiger> selectAll()
	{
		logger.info("Selecting all Tigers");

		return tigers.values();
	}

	/**
	 * Read the "database" of {@link Tiger} objects from the {@code tigers.json} classpath resource immediately after
	 * the object initialization
	 */
	@PostConstruct
	void readTigerDatabase()
	{
		Map<String, Object> map = Utilities.jsonToMap(Utilities.readClasspathResource("tigers.json"));

		tigers = new TreeMap<>();

		map.forEach((k, v) -> tigers.put(k.toUpperCase(), readTiger((Map<?, ?>) v)));
	}

	private Tiger readTiger(Map<?, ?> json)
	{
		Tiger tiger = new Tiger();

		tiger.setName((String) json.get("name"));
		tiger.setWikiLink((String) json.get("wikiLink"));
		tiger.setImageLink((String) json.get("imageLink"));

		return tiger;
	}
}
