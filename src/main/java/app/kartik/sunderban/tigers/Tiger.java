package app.kartik.sunderban.tigers;

import java.util.StringJoiner;

public class Tiger
{
	private String name;
	private String wikiLink;
	private String imageLink;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getWikiLink()
	{
		return wikiLink;
	}

	public void setWikiLink(String wikiLink)
	{
		this.wikiLink = wikiLink;
	}

	public String getImageLink()
	{
		return imageLink;
	}

	public void setImageLink(String imageLink)
	{
		this.imageLink = imageLink;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Tiger.class.getSimpleName() + "[", "]").add("name='" + name + "'")
				.add("wikiLink='" + wikiLink + "'").add("imageLink='" + imageLink + "'").toString();
	}
}
