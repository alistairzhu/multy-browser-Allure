/**
 * 
 */
package controllers;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dbHelpers.JdbcConstants;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.VideoFormatKeys;
import org.monte.media.math.Rational;
import org.testng.annotations.*;

import utils.DateAndTime;
import utils.EnvironmentSetup;

/**
 * @BeforeSuite :  Setup environment.
 * @BeforeMethod : startRecording().
 * @AfterMethod : stopRecording();
 */
public class TestController extends Initialization
{
	public Connection connection;

	@BeforeClass
	public void setUp() {
		/**
		 * Set up Database connection only when the switch is "enabled".
		 *
		 */
		if (DatabaseConnectionFeature.equalsIgnoreCase("enabled")) {
			String databaseURL = JdbcConstants.URL;
			String user = JdbcConstants.USERNAME;
			String password = JdbcConstants.PASSWORD;
			connection = null;
			try {
				Class.forName(JdbcConstants.DRIVER_NAME);
				System.out.println("Connecting to Database...");
				connection = DriverManager.getConnection(databaseURL, user, password);
				if (connection != null) {
					System.out.println("Connected to the Database...");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		}
	}

	@AfterClass
	public void tearDownAll() {
		/**
		 * Close Database connection only when the switch is "enabled".
		 *
		 */
		if (DatabaseConnectionFeature.equalsIgnoreCase("enabled")) {
			if (connection != null) {
				try {
					System.out.println("Closing Database Connection...");
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}


	@BeforeSuite
	public void beforeSuite() throws Exception
	{
		System.out.println("Browser: "+BrowserType);
		System.out.println("Website URL: "+WebsiteURL);
		EnvironmentSetup.environmentSetup();
	}
	

	/* Method to Start Video Recording of the Automation Session */
	@SuppressWarnings("static-access")
	@BeforeMethod(alwaysRun = true)
	public void startRecording(Method methodName) throws Exception 
	{
		File file = new File(Videos);
		String ExecutingMethod = methodName.getName();
		String FileName = String.valueOf(this.getClass().getSimpleName()) + "." + ExecutingMethod + "_"
				+ BrowserType.toUpperCase() + "_" + DateAndTime.getDate() + DateAndTime.getTime();
		
		Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		screenRecorder = new utils.SpecializedScreenRecorder(gc, captureSize,
				new Format(new Object[] { FormatKeys.MediaTypeKey, FormatKeys.MediaType.VIDEO, FormatKeys.MimeTypeKey,
				"video/avi" }),
				new Format(new Object[] { FormatKeys.MediaTypeKey, FormatKeys.MediaType.VIDEO, FormatKeys.EncodingKey,
						"tscc", VideoFormatKeys.CompressorNameKey, "tscc", VideoFormatKeys.DepthKey, 24,
						FormatKeys.FrameRateKey, Rational.valueOf((double) 15.0), VideoFormatKeys.QualityKey,
						Float.valueOf(1.0f), FormatKeys.KeyFrameIntervalKey, 900 }),
				new Format(new Object[] { FormatKeys.MediaTypeKey, FormatKeys.MediaType.VIDEO, FormatKeys.EncodingKey,
						"black", FormatKeys.FrameRateKey, Rational.valueOf((double) 30.0) }),
				null, file, FileName);

		if (VideoRecordingFeature.equalsIgnoreCase("enabled"))
		{
			this.screenRecorder.start();
		}
	}
	
	
	/* Method to Stop Video Recording of the Automation Session */
	public void stopRecording() throws Exception 
	{
		screenRecorder.stop();
	}

	/* After Test 'to Stop Recording of the Automation Session' */
	@AfterMethod
	public void stoprec() throws Exception {
		if (VideoRecordingFeature.equalsIgnoreCase("enabled")) 
		{
			stopRecording();
		}
	}
	
}
