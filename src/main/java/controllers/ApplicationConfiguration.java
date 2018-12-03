package controllers;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

/**
 * Converting "ApplicationConfig.properties" into parameters.
 *
 */


@Resource.Classpath("ApplicationConfig.properties")
public class ApplicationConfiguration
{
	public ApplicationConfiguration()
	{
		PropertyLoader.newInstance().populate(this);
	}

	@Property("BrowserType")
	private String BrowserName;

	@Property("WebsiteURL")
	private String WebsiteURL;

	@Property("UserName")
	private String UserName;

	@Property("Password")
	private String Password;

	@Property("VideoRecordingFeature")
	private String VideoRecordingFeature;

	@Property("DatabaseConnectionFeature")
	private String DatabaseConnectionFeature;

	public String getBrowserName()
	{
		return BrowserName;
	}

	public String getWebsiteURL() 
	{
		return WebsiteURL;
	}

	public String getUserName() 
	{
		return UserName;
	}

	public String getPassword() 
	{
		return Password;
	}

	public String getVideoRecordingFeature() { return VideoRecordingFeature; }

	public String getDatabaseConnectionFeature() { return DatabaseConnectionFeature; }

}
