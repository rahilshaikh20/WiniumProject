package testCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class TC001_WiniumDemo {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		System.out.println("***TC started***");
		
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), option);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		//WebElement window =  driver.findElementByClassName("ApplicationFrameWindow");
		WebElement window =  driver.findElementByClassName("Windows.UI.Core.CoreWindow");
		
		/*
		 * driver.findElement(By.name("Calculator")).click();
		 * System.out.println("***calc clicked***");
		 * 
		 * driver.findElement(By.id("Maximize")).click();
		 * System.out.println("***Max clicked***");  StandardOperators
		 */
		window.findElement(By.className("LandmarkTarget")).findElement(By.id("NumberPad"))
		.findElement(By.id("num8Button")).click();
		System.out.println("***8 clicked***");
		
		window.findElement(By.className("LandmarkTarget")).findElement(By.id("StandardOperators"))
		.findElement(By.id("multiplyButton")).click();
		System.out.println("***Mul clicked***");
		
		driver.findElementByName("Two").click();
		System.out.println("***2 clicked***");
		
		window.findElement(By.className("LandmarkTarget")).findElement(By.id("StandardOperators"))
		.findElement(By.id("equalButton")).click();
		System.out.println("***= clicked***");
		
		String result = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
		
		System.out.println(result);
		
		driver.close();
		driver.quit();
		
		
		
		
	}
}
