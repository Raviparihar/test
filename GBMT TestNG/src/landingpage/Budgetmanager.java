package landingpage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Budgetmanager {
	private static WebDriver driver = null;	

	@Test (priority = 1)
	//Home Dashboard page
	     public void Dashboard()  
	           { // Dashboard opened
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String currenturl =  driver.getCurrentUrl();
		System.out.println(currenturl);
		String expectedurl = "https://gbmt-stage.neoogilvy.com/dashboard";
		  if (currenturl.equalsIgnoreCase(expectedurl))
			  {System.out.println("The Dashboard home page");
		      driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			  }
		    
		    // TC #6 and TC#7 
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      WebElement GBMT = driver.findElement(By.xpath("html/body/div[1]/span[1]/a/img"));
			  String GBMTPath = GBMT.getAttribute("src");
			  if (GBMTPath.equals("https://gbmt-stage.neoogilvy.com/img/avatars/global-budget-management-tool-logo.jpeg"))
				  System.out.println("Global management tool logo rendered fine.");
			  else 
				  System.out.println("Global management tool logo not visible.");
			  
			  //TC#8
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  WebElement IBM = driver.findElement(By.xpath("html/body/div[1]/span[2]/a/img"));
			  String IBMPath = IBM.getAttribute("src");
			  System.out.println(IBMPath);
			  if (IBMPath.equals("https://gbmt-stage.neoogilvy.com/img/avatars/ibm_logo.png"))
				  System.out.println("IBM logo visible.");
			  else 
				  System.out.println("IBM logo not visible.");
			  
			  //TC#11
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  if (driver.findElement(By.xpath(".//*[@id='header-navbar']/ul[1]/li[2]/button")).isDisplayed())
			  {
				  System.out.println("Notification Tab visible");
			  }
			  
			  //TC#12
			  driver.findElement(By.xpath(".//*[@id='header-navbar']/ul[1]/li[1]/div/button")).click();
			  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			  String Profile = driver.findElement(By.xpath(".//*[@id='header-navbar']/ul[1]/li[1]/div/ul/li[1]")).getText();
			  if (Profile.equals("PROFILE"))
			  {
				  System.out.println("The Profile is visible");
				  
			  }
			  String Actions = driver.findElement(By.xpath(".//*[@id='header-navbar']/ul[1]/li[1]/div/ul/li[4]")).getText();
			  if (Profile.equals("ACTIONS"))
			  {
				  System.out.println("The ACTIONS are visible");
		      }
			  else
			  {System.out.println("The actions is not visible");}
			  
			  //TC#13
			  
			  // Summary of Budget, Projected & Actual Spend
			  if(driver.findElement(By.id("summaryOfBudgetProjectedActualSpend")).isDisplayed())
			  {
				  driver.findElement(By.id("summaryOfBudgetProjectedActualSpend")).click();
				  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   String summaryOfBudgetProjectedActualSpend =  driver.findElement(By.id("summaryOfBudgetProjectedActualSpend")).getText();
			   System.out.println("Summary of Budget, Projected & Actual Spend is present");
			  }
			   else
			   {System.out.println("Summary of Budget, Projected & Actual Spend is NOT present");}
			  
			  //TC#14
			  
			  String MarketText = "Market:";
	          String Text = driver.findElement(By.className("col-sm-2")).getText();
	        // if(Text.equals(MarketText))
	         {
	        	 System.out.println("Market drop down is present");
	             Select dropdown = new Select(driver.findElement(By.id("market_id")));
	             dropdown.selectByValue("100041");
	             driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	             String Albaniaurl =  driver.getCurrentUrl();
	     	     String AlbaniaExpectedurl = "https://gbmt-stage.neoogilvy.com/dashboard?market_id=100041&year=2016";
	     	     if (Albaniaurl.equalsIgnoreCase(AlbaniaExpectedurl))
	       	       System.out.println("The Dashboard for Albania for the year 2016");
	     	       driver.findElement(By.id("date")).click();
	         }
			}//Dashboard closed
	/*-----------------------------------------------------------------------------------------------------*/
	//Budgets Page
	@Test (priority = 2)
	public void BudgetsPage ()
	 {
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[2]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String URL = "https://gbmt-stage.neoogilvy.com/budgets/add";
		if (URL.equals("https://gbmt-stage.neoogilvy.com/budgets/add"))
		{
		     System.out.println("You can add the budget here");
		     driver.findElement(By.id("ca_1")).sendKeys("1000");
		     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		     driver.findElement(By.id("pr_1")).sendKeys("999");
		     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		     driver.findElement(By.id("year")).click();
	         driver.findElement(By.xpath("html/body/div[3]/div[3]/table/tbody/tr/td/span[8]")).click();
	         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	         driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/form/div[2]/div/div[2]/button[1]")).click();
	        
	         
		}
		else
		    System.out.println("The budget can't be added");
		
	 }
		
//----------------------------------------------------------------------------------------------------	
	//AdministrationPage
	@Test (priority = 3)
	public void AdministrationPage ()
	{
		WebElement AdministrationPage = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[3]/a/span"));
		AdministrationPage.click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	
    	boolean Auditlog = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[3]/ul/li/a/span")).isDisplayed();
		if(Auditlog)
		{
			System.out.println ("You clicked on the Administration link");
			WebElement AuditLog = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[3]/ul/li/a/span"));
			AuditLog.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String URL = driver.getCurrentUrl();
			if (URL.equals("https://gbmt-stage.neoogilvy.com/audits"))
				System.out.println ("Audit log Appeared");
			else
				System.out.println ("Audit log didn't appear");
		}
		else
		{
			System.out.println ("You didn't click on the Administration link");
		}
			
	}
	
//Support Page
	@Test (priority = 4)
	public void SupportsPage ()
		    	{  // SupportsPage opened
		    	WebElement SupportPage = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[4]/a/span"));
		    	SupportPage.click();
		    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    	   try {
					Thread.sleep(2000L);
					String SupportURL = "https://gbmt-stage.neoogilvy.com/supports";
				    String CurrentURL2 = driver.getCurrentUrl();
					if (CurrentURL2.equals(SupportURL))
					System.out.println ("You are on the supports page");
				       } 
		    	       catch (InterruptedException f) 
		    	         {
					      f.printStackTrace();
				         }
		    	}  // SupportsPage closed  	 
	/*-----------------------------------------------------------------------------------------------------*/
	@BeforeClass
	public void beforeClass() {
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://gbmt-stage.neoogilvy.com/home");
		  driver.manage().window().maximize();
		  
		  WebElement Image = driver.findElement(By.xpath(".//*[@id='wrap']/tbody/tr[1]/td/div/div[1]/img"));
		  String ImagePath = Image.getAttribute("src");
		 // System.out.println (ImagePath);
		  //String src = ((JavascriptExecutor)driver).executeScript("return arguments[1].attributes['src'].value;", ImagePath).toString();
		  //System.out.println (src);	  
		  
		  
		  if (ImagePath.equals("https://gbmt-stage-login.neoogilvy.com/loginPage/logo.png")) //Checking the Logo
		      { 
			   System.out.println ("Logo Rendered fine");
		       String Bold = driver.findElement(By.xpath(".//*[@id='wrap']/tbody/tr[1]/td/div/div[2]/b")).getText();
		       String WebBold = "gbmt-stage-login.neoogilvy.com";
				  if(Bold.equals (WebBold))
					 System.out.println ("The Headliner matched");
		          else 
		        	System.out.println ("The Headliner is missing");
		       }
		          else System.out.println ("Logo missing");
		       
		       driver.findElement(By.id("email")).isDisplayed();
		         if(true)
		           {
		            driver.findElement(By.id("email")).isEnabled();
		             if(true)
		            	 System.out.println ("Email is enabled");
		             else 
		            	 System.out.println ("Email field is not enabled"); 
		           } else 
		        	   System.out.println ("Email field is not displayed");
		               driver.findElement(By.id("email")).sendKeys("neomg.testuser@ogilvy.com"); 
		               driver.findElement(By.id("psw")).isDisplayed();
		  	           if(true)
		  	           {
		  	            driver.findElement(By.id("psw")).isEnabled();
		  	           if(true)
		  	            	 System.out.println("Password is enabled");
		  	           else 
		  	            	 System.out.println("Password field is not enabled");
		  	           } else 
		  	        	   System.out.println("Password field is not displayed");
			               driver.findElement(By.id("psw")).sendKeys("P@ssw0rd");
			   
			   WebElement submit = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div[1]/form/button"));
			   submit.click();
			   driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			   String HomeUrl = "https://gbmt-stage.neoogilvy.com/dashboard";
			   String CurrentUrl1=driver.getCurrentUrl();
			      if (CurrentUrl1.equals(HomeUrl))
				      System.out.println("You have sucessfuly logged in");
			      else 
			    	  System.out.println("The credentials are wrong");
	          }
	  @AfterClass
	  public void afterClass() {
		 //driver.close();
		// driver.quit();
		  }
	}
