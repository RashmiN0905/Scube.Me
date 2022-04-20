package genericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class TakesScreenshot_Class extends Base_class{

	
public static String screenShotMethod() {
		
		TakesScreenshot screenShot = (TakesScreenshot)Base_class.driver;
		File temp = screenShot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenShots/shot1.png");	
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filePath = dest.getAbsolutePath();
		System.out.println(filePath);
		return filePath;
	}
}
