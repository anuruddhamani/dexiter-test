package testng_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Test1 {

	@Test(enabled=false)
	public void verifyTest() {
		System.setProperty("webdriver.firefox.marionette", "D:\\selenium project\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * driver.get(
		 * "http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html"
		 * ); WebElement src=driver.findElement(By.xpath(
		 * "//h1[text()='Block 1']")); WebElement
		 * target=driver.findElement(By.xpath("//h1[text()='Block 4']"));
		 */
		driver.get("http://www.flipcart.com");
		WebElement ddm = driver.findElement(By.xpath("//span[text()='Electronics']"));

		Actions act = new Actions(driver);
		act.moveToElement(ddm).perform();
		driver.findElement(By.xpath("//span[text()='Lenovo']")).click();

	}

	@Test(dependsOnMethods="test3")
	public void test2() {
		System.out.println("Test2");
	}

	@Test()
	public void test3() {
		System.out.println("Test3");
	}

	@Test(dependsOnMethods="test3")
	public void test4() {
		System.out.println("Test4");
	}

}
