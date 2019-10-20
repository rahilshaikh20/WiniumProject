package testCases;

import io.appium.java_client.windows.WindowsDriver;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TC002_WinAppDemo {

	public static WindowsDriver driver = null;

	public static void main(String[] args) throws IOException {

		try {
			/*  Need to install WindowsApplicationDriver.msi and launch WinAppDriver.exe first 
			 
			 * Runtime rt = Runtime.getRuntime(); 
			 * Process p = rt.exec("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe");
			 */
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");

			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.findElementByName("One").click();
			driver.findElementByName("Plus").click();
			driver.findElementByName("Seven").click();
			driver.findElementByName("Multiply by").click();
			driver.findElementByName("Four").click();
			driver.findElementByName("Equals").click();

			String result = driver.findElementByAccessibilityId("CalculatorResults").getAttribute("Name");
			String result1 = driver.findElementByAccessibilityId("CalculatorResults").getText();

			System.out.println("Result is: " + result);
			System.out.println("Result is: " + result1);

			driver.close();

		}

		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
