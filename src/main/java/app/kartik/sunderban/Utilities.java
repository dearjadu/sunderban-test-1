package app.kartik.sunderban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Useful common utilities and short-hand methods
 */
public class Utilities
{
	private static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * Construct a Map representation from a JSON document
	 *
	 * @param json the JSON document
	 *
	 * @return Map representation
	 */
	public static Map<String, Object> jsonToMap(String json)
	{
		try
		{
			TypeReference<HashMap<String, Object>> typeRef =
					new TypeReference<HashMap<String, Object>>() {
					};

			return objectMapper.readValue(json, typeRef);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Construct a JSON document from the given {@code type}
	 *
	 * @param type An object
	 *
	 * @return JSON document
	 */
	public static String typeToJson(Object type)
	{
		try
		{
			return objectMapper.writeValueAsString(type);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Short-hand method to read the given {@code resourcePath} as a classpath resource into a String
	 *
	 * @param resourcePath Path to the classpath resource to read
	 *
	 * @return Read text
	 */
	public static String readClasspathResource(String resourcePath)
	{
		InputStream in = Utilities.class.getClassLoader().getResourceAsStream(resourcePath);

		Objects.requireNonNull(in);

		String text;

		BufferedReader reader = null;

		try
		{
			text = (reader = new BufferedReader(new InputStreamReader(in))).lines().collect(Collectors.joining("\n"));
		}
		finally
		{
			if(reader != null)
			{
				try
				{
					reader.close();
				}
				catch (IOException e)
				{
					// ignore
				}
			}
		}

		return text;
	}
}
