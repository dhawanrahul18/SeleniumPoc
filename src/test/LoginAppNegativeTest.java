package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

public class LoginAppNegativeTest {
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
	public void LoginTest() throws Exception {
		// enter text in input boxes
		inputbox.sendKeys("Suresh");
		pswd.sendKeys("MySel@123");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Abc Page";
		assertNotEquals(actualTitle, expectedTitle);
		LinkPageTest();
		fillBasicInformationPage();
		driver.close();
		System.out.println("Result is Success");
	}
	
	
	public void LinkPageTest() {
		driver.findElement(By.id("link")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Abc";
		assertNotEquals(actualTitle, expectedTitle);
	}
	
	public void fillBasicInformationPage() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("a@a.com");
		driver.findElement(By.xpath("//input[@name='entry.1901012585']")).sendKeys("Ram");
		driver.findElement(By.xpath("//input[@name='entry.611606310']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@name='entry.1903159403']")).sendKeys("Tech M");
		driver.findElement(By.xpath("//textarea[@name='entry.622705528']")).sendKeys("305 , Sector -48 , Near Tech M Building");
		driver.findElement(By.xpath(".//*[@id='mG61Hd']/div/div[2]/div[2]/div[6]/div[2]/div[1]/div[1]/div[1]")).sendKeys("Texas");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='mG61Hd']/div/div[2]/div[2]/div[7]/div[2]/div[1]/div[1]/div[1]")).sendKeys("New York");
		driver.findElement(By.xpath(".//*[@id='mG61Hd']/div/div[2]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]")).sendKeys("United States");
		/*Select select1= new Select(driver.findElement(By.xpath(".//*[@id='mG61Hd']/div/div[2]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]")));
		select1.selectByIndex(1);
		Thread.sleep(2000);*/
		driver.findElement(By.xpath("//input[@name='entry.1120322252']")).sendKeys("121001");
		driver.findElement(By.xpath("//input[@name='entry.736102517']")).sendKeys("9999999999");
		driver.findElement(By.xpath("//input[@name='entry.1020396855']")).sendKeys("0121009867");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='mG61Hd']/div/div[2]/div[2]/div[12]/div[2]/div[1]/div[1]/div[1]")).sendKeys("System Engineer");
		driver.findElement(By.xpath(".//*[@id='mG61Hd']/div/div[2]/div[3]/div[1]/div/div/content/span")).click();;
		System.out.println("information filled");
		boolean b = driver.getPageSource().contains("ZipCode must be of 5 numeric digits.");
		assertEquals(true, b);
	}

}
