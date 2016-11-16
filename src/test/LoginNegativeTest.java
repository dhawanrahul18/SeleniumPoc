package test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginNegativeTest {
	
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//input[@name='un']")
	WebElement inputbox;
	@FindBy(xpath="//input[@name='pw']")
	WebElement pswd;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8080/LoginApp/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String title= driver.getTitle();
		System.out.println("Title of page opened is: "+title );
		PageFactory.initElements(driver, this);
	}

	@Test
	public void NegativeTest() {
		// enter text in input boxes
		inputbox.sendKeys("Suresh");
		pswd.sendKeys("Password");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Logout";
		assertEquals(actualTitle, expectedTitle);
		driver.close();
	}
	
	@Test
	public void PositiveTest() {
		// enter text in input boxes
		inputbox.sendKeys("Suresh");
		pswd.sendKeys("MySel@123");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		String expectedTitle = "User Page";
		assertEquals(actualTitle, expectedTitle);
		driver.close();
	}
}
