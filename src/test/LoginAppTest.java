package test;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import junit.framework.TestCase;


public class LoginAppTest extends TestCase {
	static WebDriver driver= null;
	static WebDriver ieDriver= null;
	static{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "D://IEDriverServer.exe");
		//System.setProperty("webdriver.firefox.driver", "D://geckodriver.exe");
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		//ieDriver = new InternetExplorerDriver();
		System.out.println("in chrome");
		driver.navigate().to("http://localhost:8080/LoginApp/");
		driver.manage().window().maximize();
		String url=driver.getCurrentUrl();
		System.out.println("Url opened is: "+url);
		String title= driver.getTitle();
		System.out.println("Title of page opened is: "+title );
		signInTest();
		System.out.println("Success Login");
		BasicInformationPageTest();
		System.out.println("Switch to Basic Information");
		fillBasicInformationPage();
	}
	
	@Test
	private static void fillBasicInformationPage() throws InterruptedException {
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
		driver.findElement(By.xpath("//input[@name='entry.1120322252']")).sendKeys("12100");
		driver.findElement(By.xpath("//input[@name='entry.736102517']")).sendKeys("9999999999");
		driver.findElement(By.xpath("//input[@name='entry.1020396855']")).sendKeys("0121009867");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='mG61Hd']/div/div[2]/div[2]/div[12]/div[2]/div[1]/div[1]/div[1]")).sendKeys("System Engineer");
		driver.findElement(By.xpath(".//*[@id='mG61Hd']/div/div[2]/div[3]/div[1]/div/div/content/span")).click();;
		System.out.println("information filled");
		boolean b = driver.getPageSource().contains("Your response has been recorded.");
		assertEquals(true, b);
	}

	@Test
	private static void BasicInformationPageTest() {
		driver.findElement(By.id("link")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Basic Information";
		assertEquals(actualTitle, expectedTitle);
	}


	@Before
	public void setup() {
		driver= new ChromeDriver();
		ieDriver = new InternetExplorerDriver();
		System.out.println("in chrome");
		driver.navigate().to("http://localhost:8080/LoginApp/");
		driver.manage().window().maximize();
		String url=driver.getCurrentUrl();
		System.out.println("Url opened is: "+url);
		String title= driver.getTitle();
		System.out.println("Title of page opened is: "+title );
	}
	
	@Test
	private static void signInTest() throws InterruptedException {
		driver.findElement(By.name("un")).sendKeys("Rahul");;
		driver.findElement(By.name("pw")).sendKeys("MySel@123");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		String expectedTitle = "User Page";
		assertEquals(actualTitle, expectedTitle);
	}

}
