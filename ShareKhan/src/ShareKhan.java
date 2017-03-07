import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//taskkill /f /im chromedriver.exe

public class ShareKhan {

	public static void main(String[] args) {
		// Launch Chrome
		
		/*System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();*/
		WebDriver driver= new FirefoxDriver();
		// Inserting wait time
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Maximising chrome window
		driver.manage().window().maximize();
		
		// open sharekhan loging page
		driver.get("https://strade.sharekhan.com/rmmweb/rcs.sk");
		
		// Logon to share khan
		
		 // Enter user and password

		login(driver);
		
		//Click Reports tab to view limit statement
		
		driver.findElement(By.xpath("/html/body/center/div/table/tbody/tr[1]/td/div[2]/table/tbody/tr/td/a[5]")).click();
		
		// Click on derivatives in limit section
		
		driver.findElement(By.xpath("//*[@id='div_1']/ul/li[2]/a")).click();
		
		// get value to populate cell A3, B3, C3
		
		String A3=driver.findElement(By.xpath("//*[@id='sort']/tbody/tr[2]/td[1]")).getText();
		String B3=driver.findElement(By.xpath("//*[@id='sort']/tbody/tr[2]/td[2]/a")).getText();
		String C3=driver.findElement(By.xpath("//*[@id='sort']/tbody/tr[2]/td[3]")).getText();
		
		//Print output in CSV format
		
		System.out.println(A3 + ";" + B3+";"+ C3);
		
		// When More Transaction Report button is clicked, it opens in new window. To avoid new window driver.navigate has been used
		// so that it does not opens in the new window
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td/div[2]/table/tbody/tr/td/a[5]")).click();
		driver.findElement(By.xpath("/html/body/center/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[3]/div[1]/table/tbody/tr[1]/td/div/a")).click();
		driver.navigate().to("https://strade.sharekhan.com/eodweb/login.do?caller=executeLoginValidation");
		
		// Click on Transaction Report button
		
		driver.findElement(By.xpath("//*[@id='aa8']/span")).click();
		
		// Click on Currency tab
		driver.findElement(By.xpath("//*[@id='bb8']/font/font/font/font/a")).click();
		
		// Click on Client Net Summary
		driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td/form/table[4]/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/select[3]")).click();
		
		// Change starting year as 2016 ( cns statds for client net summary)
		WebElement cnsyear1=driver.findElement(By.name("fyear"));
		Select year=new Select(cnsyear1);
		year.selectByValue("2016");
		
		// Change end year as 2017
		WebElement cnsyear2=driver.findElement(By.name("tyear"));
		Select tyear=new Select(cnsyear2);
		tyear.selectByValue("2017");
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		// Click on Show button
		driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td/form/table[4]/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[3]/input")).click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// When More Transaction Report button is clicked, it opens in new window. To avoid new window driver.navigate has been used
		// so that it does not opens in the new window
		
		
		driver.navigate().to("https://strade.sharekhan.com/eodweb/jsps/cmmtradeconfirmation.jsp?id=mtabselect(0,%27aa%27,%27bb%27,8)");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on Trade confirmation
				driver.findElement(By.xpath("//*[@id='bb8']/font/a/span")).click();
				
				// Change starting year as 2016
				WebElement tcyear1=driver.findElement(By.name("fyear"));
				Select tcyear=new Select(tcyear1);
				tcyear.selectByValue("2016");
				
				// Change end year as 2017
				WebElement tcyear2=driver.findElement(By.name("tyear"));
				Select ttcyear=new Select(tcyear2);
				ttcyear.selectByValue("2017");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				// Click on Show button
				driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td/form/table[4]/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr[2]/td[3]/input")).click();
				
				// Click on Turnover link after navigating back to home page
				driver.navigate().to("https://strade.sharekhan.com/rmmweb/rcs.sk");
				
				// Click on Turnover position link
				
				driver.findElement(By.xpath("/html/body/center/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/div[2]/ul/li[2]/a")).click();
				
				String A7S12=driver.findElement(By.xpath("//*[@id='sort']")).getText();
				System.out.println(A7S12 + ";");
				
				//driver.quit();
	}

	private static void login(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id='loginid']")).sendKeys("AMAL2224");
//		sendKeysByXpath(driver,"//*[@id='loginid']","AMAL2224");
		
		driver.findElement(By.xpath("//*[@id='pwSignup']")).sendKeys("AMAL@1234");
		driver.findElement(By.xpath("//*[@id='pwSignup1']")).sendKeys("PUSHP@123");
		driver.findElement(By.xpath("//*[@id='logintable']/tbody/tr[5]/td[2]/input")).click();
	}
	
	private static void sendKeysByXpath(WebDriver driver, String xpath, CharSequence txt){
		driver.findElement(By.xpath(xpath)).sendKeys(txt);
	}

}
