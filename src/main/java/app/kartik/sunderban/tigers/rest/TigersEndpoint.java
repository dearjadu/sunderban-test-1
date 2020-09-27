package app.kartik.sunderban.tigers.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.kartik.sunderban.tigers.Tiger;
import app.kartik.sunderban.tigers.Tigers;

/**
 * A {@link RestController} to expose the methods of {@link Tigers} repository as REST APIs. The APIs can be called using
 * a browser by typing: http://localhost:8080/tigers OR http://localhost:8080/{name}
 */
@RestController
@RequestMapping("/tigers")
public class TigersEndpoint
{
	@Autowired
	Tigers tigers;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Tiger> tigers()
	{
		return tigers.selectAll();
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Tiger tiger(@PathVariable String name)
	{
		return tigers.select(name);
	}
}
