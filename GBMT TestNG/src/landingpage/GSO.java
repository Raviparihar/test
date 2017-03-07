package landingpage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.*;

public class GSO {
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
			  
			  //Summary of Campaigns, MOG & Properties
			  if(driver.findElement(By.id("summaryOfCampaignsMOGProperties")).isDisplayed())
			  {  driver.findElement(By.id("summaryOfCampaignsMOGProperties")).click();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   String summaryOfCampaignsMOGProperties =  driver.findElement(By.id("summaryOfCampaignsMOGProperties")).getText();
			   System.out.println("Summary of Campaigns, MOG & Properties is present");
			  }
			   else
			   {System.out.println("Summary of Campaigns, MOG & Properties is NOT present");}
			   
			  //Spend by Market Map based on Actual Spend 2017
              if(driver.findElement(By.id("SpendByMarketMap")).isDisplayed())
			  {  driver.findElement(By.id("SpendByMarketMap")).click();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   String SpendByMarketMap =  driver.findElement(By.id("SpendByMarketMap")).getText();
			   System.out.println("Spend by Market Map based on Actual Spend 2017 is Present");
			  }
			   else
			   {System.out.println("Spend by Market Map based on Actual Spend 2017 is NOT present");}
			  
			  
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
			  if(driver.findElement(By.id("Top10SpendersbasedOnProjectedActualSpend")).isDisplayed())
			  {    driver.findElement(By.id("Top10SpendersbasedOnProjectedActualSpend")).click();
			       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			       String Top10SpendersbasedOnProjectedActualSpend =  driver.findElement(By.id("Top10SpendersbasedOnProjectedActualSpend")).getText();
			      System.out.println("Top 10 Spenders based on Projected & Actual Spend is visible");
			  }
			   else
			   {System.out.println("Top 10 Spenders based on Projected & Actual Spend is not visible");}
			  
			  //What's New
			  if(driver.findElement(By.xpath(".//*[@id='main-container']/div/div/div[2]/div[2]/div[1]/div[1]/h4/a")).isDisplayed())
			  {  
				  driver.findElement(By.xpath(".//*[@id='main-container']/div/div/div[2]/div[2]/div[1]/div[1]/h4/a")).click();
		      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		      String Whatsnew =  driver.findElement(By.xpath(".//*[@id='main-container']/div/div/div[2]/div[2]/div[1]/div[1]/h4/a")).getText();
		      System.out.println(" What's new is visible");
			  }
		        else
		      {System.out.println("What's new is not visible");}	
		  
			  
			  //Calender of deadlines
			  if(driver.findElement(By.xpath(".//*[@id='main-container']/div/div/div[2]/div[2]/div[1]/div[1]/h4/a")).isDisplayed())
			  {  driver.findElement(By.xpath(".//*[@id='main-container']/div/div/div[2]/div[2]/div[1]/div[1]/h4/a")).click();
			      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			      String Calender =  driver.findElement(By.xpath(".//*[@id='main-container']/div/div/div[2]/div[2]/div[1]/div[1]/h4/a")).getText();
			      System.out.println(" Calender of deadlines is visible");
			  }
			   else
			   {System.out.println("Calender of deadlines is not visible");}	
			  
			  
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
	             dropdown.selectByValue("100072");
	             driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	             String Argentinaurl =  driver.getCurrentUrl();
	     	     String AregentinaExpectedurl = "https://gbmt-stage.neoogilvy.com/dashboard?market_id=100072&year=2016";
	     	     if (Argentinaurl.equalsIgnoreCase(AregentinaExpectedurl))
	       	       System.out.println("The Dashboard for Argentina for the year 2016");
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
			     driver.findElement(By.xpath(".//*[@id='year']")).click();
		         driver.findElement(By.xpath("html/body/div[3]/div[3]/table/tbody/tr/td/span[8]")).click();
		         driver.findElement(By.xpath("html/body/div[3]/div[3]/table/tbody/tr/td/span[8]")).click();
		         
		         driver.findElement(By.xpath(".//*[@id='version']")).sendKeys("2");
		         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		         driver.findElement(By.xpath(".//*[@id='main-container']/div[2]/div/form/div[2]/div/div[2]/button[1]")).click();
		        
		     }
			else
			    System.out.println("The budget can't be added");
			
		 }
	/*-------------------------------------------------------------------------------------------------------*/
	@Test (priority = 3)
	//Projections Page
	public void Projections() 
	      {   // Projections opened
		    String PageProjections = "PROJECTIONS";
		   	WebElement LinkProjections = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[3]/a/span"));
		    LinkProjections.click();
		    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		    String s = driver.findElement(By.className("page-heading")).getText();
		    System.out.print(s);
		    System.out.println("You are on the"  + s  +  "page");
		    Assert.assertEquals(PageProjections,s,"No Page Found");
		    
		    if(driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a[1]")).isDisplayed())
		    {
		    driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a[1]")).click();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    //String PageTitle = driver.getTitle();
		    equals(driver.getTitle().contains("Submit Projections "));
		    System.out.println("Finalize Projections button is Visible and clicked");
		      }
		    else 
		    {System.out.println("Finalize Projection button is not displayed");}
		    
		    driver.navigate().back();
		    if(driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a[2]")).isDisplayed())
		    {
		    driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a[2]")).click();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    System.out.println("Projections can be addded here");
		    
		    //Adding Projections
		    
		    Select dropdown = new Select(driver.findElement(By.id("market")));
	        dropdown.selectByVisibleText("ARGENTINA");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        driver.findElement(By.xpath(".//*[@id='period']")).click();
	        driver.findElement(By.xpath("html/body/div[4]/div[2]/table/tbody/tr/td/span[11]")).click();
	        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	        
	        
	        Select MediaClass = new Select(driver.findElement(By.id("mcs")));
	        MediaClass.selectByValue("INTERNET");
	        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	        
	        
	      /*  driver.findElement(By.id("type-mog")).sendKeys("ATLANTIC MEDIA INTERNATIONAL INC");
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); */
	        
	        driver.findElement(By.name("projections[1][property]")).sendKeys("CIO ONLINE");
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        driver.findElement(By.name("projections[1][nca_value]")).sendKeys("2000");
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        driver.findElement(By.name("media_owner")).sendKeys("IDG");
	        driver.findElement(By.xpath(".//*[@id='projection-create']/div/div[5]/div[2]/div/button")).click();
	        
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        
	        driver.findElement(By.className("btn btn-warning push-5-r push-10")).click();
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        
	        Select SearchMarket = new Select(driver.findElement(By.id("market")));
	        SearchMarket.selectByValue("100072");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        }
		    else 
		    {System.out.println("Add projections button is not displayed");
		    }
		    
		    driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a[4]")).click();
		    String UploadUrl = driver.getCurrentUrl();
		    if(UploadUrl.equals("https://gbmt-stage.neoogilvy.com/projections/upload"))
		    {
		    	driver.findElement(By.className("form-control date top-form required")).click();
		    	driver.findElement(By.xpath("html/body/div[3]/div[2]/table/tbody/tr/td/span[10]")).click();
		    	WebElement upload = driver.findElement(By.name("file"));
		    	upload.click();
		    	upload.sendKeys("C:\\Users\\manu.narang\\workspace\\GBMT TestNG\\Projection Template");
		    }
	} // Projections Closed
	/*-----------------------------------------------------------------------------------------------------*/
	@Test (priority = 4)
	//Actual Spends Page
	  public void ActualSpendsPage()
	       { //ActualSpendsPage opened
	            WebElement LinkActualSpend = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[4]/a"));
	            LinkActualSpend.click();
		    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    	String PageActualSpend = "ACTUAL SPENDS";
		    	String s = driver.findElement(By.className("page-heading")).getText();
		    	System.out.println("You are on the  "  + s  +  "  page");
		    	Assert.assertEquals(PageActualSpend,s,"No Page Found");
		    	
		    	if(driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a[1]")).isDisplayed())
			    {
			    driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a[1]")).click();
			    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    System.out.println("Actual spend can be added here");
			    
			    Select AddActualSpends = new Select (driver.findElement(By.id("market")));
			    AddActualSpends.selectByVisibleText("ARGENTINA");
			    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    
			    driver.findElement(By.name("date")).click();
			    driver.findElement(By.xpath("html/body/div[4]/div[2]/table/tbody/tr/td/span[11]")).click();
			    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    
			    Select AddActualSpendsMCS = new Select (driver.findElement(By.id("mcs")));
			    AddActualSpendsMCS.selectByVisibleText("INTERNET");
			    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    
			    driver.findElement(By.id("campaign")).sendKeys("IDG campaign");
			    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    
			    driver.findElement(By.id("mo-1")).sendKeys("IDG");
			    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    
			    driver.findElement(By.id("pr-1")).sendKeys("Internet");
			    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    
			    driver.findElement(By.id("sd-1")).click();
			    driver.findElement(By.xpath("html/body/div[4]/div[1]/table/tbody/tr[1]/td[2]")).click();
			    
			    driver.findElement(By.id("ed-1")).click();
			    driver.findElement(By.xpath("html/body/div[4]/div[1]/table/tbody/tr[3]/td[2]")).click();
			    
			    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    
			    
			    driver.findElement(By.name("data[1][spend]")).sendKeys("2000");
			    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			     }
		    	else 
			    {System.out.println("Add Actual spend is not displayed");}
	  } //ActualSpendsPage closed
	/*-----------------------------------------------------------------------------------------------------*/
	@Test (priority = 5)
	//Rationale Page
	  public void RationalPage()
	       {  //RationalPage opened
		    	WebElement LinkRationale = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[5]/a"));
		    	LinkRationale.click();
		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	String PageRationale = "RATIONALE";
		    	String s = driver.findElement(By.className("page-heading")).getText();
		    	System.out.print(s);
		    	Assert.assertEquals(PageRationale,s,"No Page Found");
		    	
		    	Select dropdown = new Select(driver.findElement(By.name("market")));
		        dropdown.selectByVisibleText("ARGENTINA");
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        
		        driver.findElement(By.name("period")).click();
			    driver.findElement(By.xpath("html/body/div[4]/div[2]/table/tbody/tr/td/span[11]")).click();
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        
		    } //RationalPage Closed
/*-----------------------------------------------------------------------------------------------------*/
	@Test (priority = 6)
	//Reconciliations Page
	public void ReconciliationsPage()
	{  
		    	WebElement LinkReconciliations = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[6]/a/span"));
		    	LinkReconciliations.click();
		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	
		    	if(driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[6]/ul/li[1]/a/span")).isDisplayed());
		    	{
		        System.out.println("Reconciliation link is present");
		    	driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[6]/ul/li[1]/a/span")).click();
		    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    	}
		    	String Reconcilialtions = driver.getCurrentUrl();
		    	if(Reconcilialtions .equalsIgnoreCase("https://gbmt-stage.neoogilvy.com/reconciliations"))
		    	{
		    		driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a[1]")).click();
		    	    driver.findElement(By.id("date")).click();
		    	    driver.findElement(By.xpath("html/body/div[4]/div[3]/table/tbody/tr/td/span[8]")).click();
		    	}   
		    	    else 
		    		{System.out.println("Reconciliation link is not visible");}
		    	
	         if(driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[6]/ul/li[2]/a")).isDisplayed())
	         {
		    	System.out.println("Year End Reconciliation Report link is present");
		    	driver.findElement(By.xpath(".//*[@id='select2-media_owner_id-container']")).click();
		    	driver.findElement(By.className("select2-search__field")).sendKeys("AD THEORENT");
		    	driver.findElement(By.name("download")).click();
		    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	         }
		    	else 
		    		{System.out.println("Year End Reconciliation Reportlink is not visible");}
		    } //Reconciliations Page Closed
	
/*---------------------------------------------------------------------------------------------------------*/
@Test (priority = 7)
		    	//NonFlightedSpend
		    		   public void NonFlightedSpends ()
		    		   {
	                    driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[7]/a/span")).click();
	                    driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a[1]")).click();
	                    //Add button
	                    String add = driver.getCurrentUrl();
	                    if (add.equals("https://gbmt-stage.neoogilvy.com/nonflighted/add"))
	                    {
	                    	System.out.println("You can add the flighted spend here");
	                        driver.navigate().back();
	                    }
	                        else 
	                        {
	                    	System.out.println("Add screens is not visible");
	                        }
	                    //Edit Button
	                    boolean EditButton = driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a[2]")).isDisplayed();
	                    if (EditButton)
	                    	System.out.println("EDIT button is displayed");
	                    else
	                    	System.out.println("EDIT button is not displayed");
	                    
	                    //Export Button
	                    boolean ExportButton = driver.findElement(By.xpath(".//*[@id='main-container']/div[1]/div/div[2]/a[3]")).isDisplayed();
	                    if (ExportButton)
	                    	System.out.println("Export button is displayed");
	                    else
	                    	System.out.println("Export button is not displayed");
	                    	 }
		    	    	
/*-----------------------------------------------------------------------------------------------------------*/	    	
@Test (priority = 8)
	//Reports Page
		   public void ReportsPage()
		    	{ //ReportsPage opened
		
		     int click = 0;        
		       
		       driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/a/span")).click();
		       System.out.println("Reports menu clicked");
	           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		       
		       
		       driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[1]/a/span")).click();
		       System.out.println("Rationale in reports menu clicked");
		       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		       click ++;
		       
		       driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[2]/a/span")).click();
		        System.out.println("Actual by market cliked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[3]/a/span")).click();
		        System.out.println("Actual by media class cliked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[4]/a")).click();
		        System.out.println("Actual by MOG cliked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[5]/a/span")).click();
		        System.out.println("Compliance clicked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[6]/a")).click();
		        System.out.println("CSR clicked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[7]/a")).click();
		        System.out.println("Projection clicked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[8]/a")).click();
		        System.out.println("custom projection clicked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[9]/a")).click();
		        System.out.println("Historical CSR clicked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[10]/a/span")).click();
		        System.out.println("Projections Workbook clicked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[11]/a")).click();
		        System.out.println("Custom Reports clicked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[12]/a")).click();
		        System.out.println("US Quaterly audit clicked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[8]/ul/li[13]/a")).click();
		        System.out.println("Historical Trend clicked");
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        click ++;
		        
		        if (click == 13)
		        { System.out.println("All the links have been clicked");}
		        
		        } // //ReportsPage Closed
	/*-----------------------------------------------------------------------------------------------------*/

//Workflow Page
	@Test (priority = 9)
	public void WokflowPage ()
	{
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[9]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[9]/ul/li[1]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ProjectionsWorkbook = driver.getCurrentUrl();
		if (ProjectionsWorkbook.equals("https://gbmt-stage.neoogilvy.com/projection_workbook"))
			{System.out.println("You are on the Projections workbook page");
		    driver.navigate().back();
			}
		else 
		{System.out.println("Projections workbook page not visible");}
			
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[9]/ul/li[1]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String CSRWorkbook = driver.getCurrentUrl();
		if (CSRWorkbook.equals("https://gbmt-stage.neoogilvy.com/csr_workbooks"))
		{
			System.out.println("CSR Workbook page is visible");
			driver.navigate().back();
	    }
		else {System.out.println("CSR workbook page is not visible");}
			
	}
/*-----------------------------------------------------------------------------------------------------*/	
	//Configurations Page
	@Test (priority = 10)
	public void ConfigurationsPage ()
	{
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[10]/a/span")).click();
		int count1 = 0;
		
		
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[10]/ul/li[1]/a/span"));
		System.out.println("Regions clicked");
		count1++;
		
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[10]/ul/li[2]/a/span"));
		System.out.println("Markets clicked");
		count1++;
		
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[10]/ul/li[3]/a/span"));
		System.out.println("Media Owners clicked");
		count1++;
		
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[10]/ul/li[4]/a/span"));
		System.out.println("Properties clicked");
		count1++;
		
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[10]/ul/li[5]/a/span"));
		System.out.println("IPC Structure clicked");
		count1++;
		
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[10]/ul/li[6]/a/span"));
		System.out.println("Media class clicked");
		count1++;
		
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[10]/ul/li[7]/a/span"));
		System.out.println("Digital Channel clicked");
		count1++;	
		
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[10]/ul/li[8]/a/span"));
		System.out.println("Currency Conversion clicked");
		count1++;
		
		if (count1 ==8)
			System.out.println("All the links have been clicked");
		else System.out.println("Some links are missed");
		}
/*---------------------------------------------------------------------------------------------------------*/
	//Administration Page 
		@Test (priority = 11)
		 public void AdministrationPage()
	 	{
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[11]/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[11]/ul/li/a/span")).click();
		String Users = driver.getCurrentUrl();
		if (Users.equals("https://gbmt-stage.neoogilvy.com/users"))
		{
			System.out.println("You are on the Users Page");
			WebElement Search = driver.findElement(By.xpath(".//*[@id='sidebar-scroll']/div/div/ul/li[11]/a/span"));
			Search.sendKeys("Alex caplan");
			try
			{
			Thread.sleep(2000L);
			}
			 catch (InterruptedException f) 
	         {
		      f.printStackTrace();
	         }
		}
		
	 	}
/*-------------------------------------------------------------------------------------------------------*/		
	
	
//Support Page
	@Test (priority = 12)
	public void SupportsPage ()
		    	{  // SupportsPage opened
		    	WebElement SupportPage = driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[1]/div/div/ul/li[6]/a/span"));
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
