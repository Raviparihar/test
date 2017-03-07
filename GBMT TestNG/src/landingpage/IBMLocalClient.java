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

public class IBMLocalClient {
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
			  //Summary of Campaigns, MOG & Properties
			  if(driver.findElement(By.id("summaryOfCampaignsMOGProperties")).isDisplayed())
			  {  driver.findElement(By.id("summaryOfCampaignsMOGProperties")).click();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   String summaryOfCampaignsMOGProperties =  driver.findElement(By.id("summaryOfCampaignsMOGProperties")).getText();
			   System.out.println("Summary of Campaigns, MOG & Properties is present");
			  }
			   else
			   {System.out.println("Summary of Campaigns, MOG & Properties is NOT present");}
			   
			  //Spend by Media Class based on Actual Spend
			  if(driver.findElement(By.id("pieChartOfSpendByMediaClass")).isDisplayed())
				  {  driver.findElement(By.id("pieChartOfSpendByMediaClass")).click();
				     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			         String pieChartOfSpendByMediaClass =  driver.findElement(By.id("pieChartOfSpendByMediaClass")).getText();
			         System.out.println("Spend by Media Class based on Actual Spend");
			      }
			   else
			   {System.out.println("Spend by Media Class based on Actual Spend");}
			  
			  //Top 10 Spenders based on Projected & Actual Spend
			  if(driver.findElement(By.id("Top10SpendersbasedOnActualSpend")).isDisplayed())
			  {    driver.findElement(By.id("Top10SpendersbasedOnActualSpend")).click();
			       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			       String Top10SpendersbasedOnProjectedActualSpend =  driver.findElement(By.id("Top10SpendersbasedOnActualSpend")).getText();
			      System.out.println("Top 10 Spenders based on Actual Spend is visible");
			  }
			   else
			   {System.out.println("Top 10 Spenders based on Actual Spend is not visible");}
			  
			 
		  //Spend by Digital Channel based on Actual Spend
			  if(driver.findElement(By.id("PieChartOfSpendByDigitalChannel")).isDisplayed())
			  {  driver.findElement(By.id("PieChartOfSpendByDigitalChannel")).click();
			     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
			     String PieChartOfSpendByDigitalChannel =  driver.findElement(By.id("PieChartOfSpendByDigitalChannel")).getText();
			     System.out.println("Spend by Digital Channel based on Actual Spend is visible");
			  }
			   else
			   {System.out.println("Spend by Digital Channel based on Actual Spend is not visible");}
			 
			  //TC#14
			  
			  String MarketText = "Market:";
	          String Text = driver.findElement(By.className("col-sm-2")).getText();
	        // if(Text.equals(MarketText))
	         {
	        	 System.out.println("Market drop down is present");
	             Select dropdown = new Select(driver.findElement(By.id("market_id")));
	             dropdown.selectByValue("100041");
	             driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	             String Argentinaurl =  driver.getCurrentUrl();
	     	     String AregentinaExpectedurl = "https://gbmt-stage.neoogilvy.com/dashboard?market_id=100041&year=2017";
	     	     if (Argentinaurl.equalsIgnoreCase(AregentinaExpectedurl))
	       	       System.out.println("The Dashboard for Albania for the year 2017");
	     	       driver.findElement(By.id("date")).click();
	         }
	     	}//Dashboard closed
	/*-----------------------------------------------------------------------------------------------------*/
	@Test (priority = 2)
	//Actual Spends Page
	  public void ActualSpendsPage()
	  { //ActualSpendsPage opened
	  WebElement LinkActualSpend = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[2]/a/span"));
	            LinkActualSpend.click();
		    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    	String PageActualSpend = "ACTUAL SPENDS";
		    	String s = driver.findElement(By.className("page-heading")).getText();
		    	System.out.println("You are on the  "  + s  +  "  page");
		    	Assert.assertEquals(PageActualSpend,s,"No Page Found");
		    	} //ActualSpendsPage closed
	/*-----------------------------------------------------------------------------------------------------*/
	
	@Test (priority = 3)
	//Reports Page
		   public void ReportsPage()
		    	{ //ReportsPage opened
		
		     int click = 0;        
		       /*WebElement ReportsPage = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[5]/a/span"));
		    	ReportsPage.click();
		    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    	System.out.println("Reports Menu clicked");
		    		*/
		       driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[3]/a/span")).click();
		       System.out.println("Reports menu clicked");
	           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		       
		       
		       driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[3]/ul/li[1]/a/span")).click();
		       System.out.println("Actual By Market Clicked");
		       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		       click++;
		       
		       driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[3]/ul/li[2]/a/span")).click();
		       System.out.println("Actual By Media Class cliked");
		       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		       click ++;
		    	
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[3]/ul/li[3]/a/span")).click();
		        System.out.println("Actual by MOG cliked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[3]/ul/li[4]/a/span")).click();
		        System.out.println("Custom Reports Clicked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        if (click == 5)
		        { System.out.println("All the links have been clicked");}
		        
		        } // //ReportsPage Closed
	/*-----------------------------------------------------------------------------------------------------*/
	//Support Page
	@Test (priority = 4)
	public void SupportsPage ()
		    	{  // SupportsPage opened
		    	WebElement SupportPage = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[4]/a"));
		    	SupportPage.click();
		    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    	   try {
					Thread.sleep(2000L);
					String SupportURL = "https://gbmt-stage.neoogilvy.com/supports";
				    String CurrentURL2 = driver.getCurrentUrl();
					if (CurrentURL2.equals(SupportURL))
					System.out.println ("You are on the support page");
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

