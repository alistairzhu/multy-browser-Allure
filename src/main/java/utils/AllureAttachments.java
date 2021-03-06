/**
 * 
 */
package utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import controllers.ApplicationConfiguration;
import org.testng.Reporter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 * @Author Gladson Antony
 * @Date 26-Jan-2017
 */
public class AllureAttachments extends ApplicationConfiguration //AZ: tobe deleted because it is replaced by saveFullPageScreenshotToFile()
{
	/*To Attach the Entire Page Screenshot*/
	@Attachment(value = "Entirepage Screenshot of {0}", type = "image/png")
	public static byte[] saveFullPageScreenshot(String name,WebDriver driver)
	{
		try {
			BufferedImage image  = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver).getImage();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return "Unable to Get Screenshot.".getBytes();
	}

	/*To Attach the Entire Page Screenshot as a file*/
	public static void saveFullPageScreenshotToFile(String name,WebDriver driver)
	{
		try {

			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			File DestFile=new File(name);
			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
		}
		catch (IOException e)
		{
			Reporter.log("\nUnable to take Screenshot.\n", true);
			e.printStackTrace();
		}
	}

	/*To Convert the File to Bytes*/
	private static byte[] fileToBytes(String fileName) throws Exception 
	{
		File file = new File(fileName);
		return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
	}

	/*To Attach the CSV File to the Allure Report*/
	@Attachment(value = "CSV Attachment", type = "text/csv")
	public static byte[] attachFileType_CSV(String filePath) throws Exception 
	{
		return fileToBytes(filePath);
	}

	/*To Attach the XML File to the Allure Report*/
	@Attachment(value = "XML Attachment", type = "text/xml")
	public static byte[] attachFileType_XML(String filePath) throws Exception 
	{
		return fileToBytes(filePath);
	}

	/*To Attach the XLSX File to the Allure Report*/
	@Attachment(value = "MS Excel - XLSX Attachment")
	public static byte[] attachFileType_XLSX(String filePath) throws Exception
	{
		return fileToBytes(filePath);
	}
	
	/*To Attach the XLS File to the Allure Report*/
	@Attachment(value = "MS Excel - XLS Attachment")
	public static byte[] attachFileType_XLS(String filePath) throws Exception
	{
		return fileToBytes(filePath);
	}

	/*To Attach the TXT File to the Allure Report*/
	@Attachment(value = "TXT Attachment", type ="text/plain")
	public static byte[] attachFileType_TXT(String filePath) throws Exception 
	{
		return fileToBytes(filePath);
	}

	/*To Attach the JSON File to the Allure Report*/
	@Attachment(value="JSON Attachment", type="text/json")
	public static byte[] attachFileType_JSON(String filePath) throws Exception
	{
		return fileToBytes(filePath);
	}
	
	/*To Attach the DOCX File to the Allure Report*/
	@Attachment(value="MS Word - DOCX Attachment")
	public byte[] attachFileType_DOCX(String filePath) throws Exception
	{
		return fileToBytes(filePath);
	}
	
	/*To Attach the DOC File to the Allure Report*/
	@Attachment(value="MS Word - DOC Attachment")
	public static byte[] attachFileType_DOC(String filePath) throws Exception
	{
		return fileToBytes(filePath);
	}
	
	/*To Attach the JPEG Image File to the Allure Report*/
	@Attachment(value="JPEG Attachment", type = "image/jpg")
	public static byte[] attachFileType_JPEG(String filePath) throws Exception
	{
		return fileToBytes(filePath);
	}
	
	/*To Attach the PNG Image File to the Allure Report*/
	@Attachment(value="PNG Attachment", type = "image/png")
	public static byte[] attachFileType_PNG(String filePath) throws Exception
	{
		return fileToBytes(filePath);
	}
	
}
