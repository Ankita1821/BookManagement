package ui;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class resigrationTest {
	WebDriver driver;
	@BeforeClass
	void setup() {
		 //To Open browser
		  driver= new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ZERO);
	      driver.get("http:www.bookstore.com");// added dummy url to open the site
	      driver.manage().window().maximize(); // to maximize the window
	      
	}

	@Test(priority=0)
	void Userregistration(Map<String, String> data) {
		Registration RegistrationPage= new Registration(driver);
		RegistrationPage.setUserName(data.get("name"));  // using data.get it will fetch different data from the test data file
		RegistrationPage.setUserEmailId(data.get("EmailId"));
		RegistrationPage.setUserRole(data.get("Role"));
		RegistrationPage.submit();
		RegistrationPage.getMsg();
		RegistrationPage.getTitle();

	}
	
	@Test(priority=1)
	void LoginPage(Map<String, String> data) {
		LoginPageObject LoginPage=new LoginPageObject(driver);
		LoginPage.clickLoginText();
		LoginPage.sendUserName(data.get("UserName"));
		LoginPage.sendPassword(data.get("Password"));
		LoginPage.LoginButton();
		LoginPage.getTitle();
	}
	
	
	
	@Test(priority=2)
	void BookManagementDashboard(Map<String, String> data) {
		
		LoginPageObject LoginPage=new LoginPageObject(driver);
		LoginPage.clickLoginText();
		LoginPage.sendUserName(data.get("UserName"));
		LoginPage.sendPassword(data.get("Password"));
		LoginPage.LoginButton();
		LoginPage.getTitle();
		
		
		UserDashBoard UserDashBoard=new UserDashBoard(driver);
		UserDashBoard.search(data.get("BookTitle"));
		UserDashBoard.clickOnbook(data.get("BookId"));
		UserDashBoard.Actions();
	
	}
	
	
	//Using below data we can fetch the data from excel sheet for multiple input 
	 /*   TakesScreenshot screesnhot=(TakesScreenshot)driver;
      File sourceFile=screesnhot.getScreenshotAs(OutputType.FILE);
      File targetFile= new File(System.getProperty("user.dir")+"\\screenshots\\images.png");
      sourceFile.renameTo(targetFile);// copy source file to the target file
      
      if(PageTitle.equals(ExpectedTitle)) {
    	  System.out.println("Test Passed : PageTitle :" + PageTitle);
      }else {
    	  System.out.println("Test Failed: Expected Title is : " + ExpectedTitle);
      }
      
      
      //Reading data from excel
   FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\testdata\\TestData.xlsx");
      XSSFWorkbook workbook= new XSSFWorkbook(file);
      XSSFSheet sheet= workbook.getSheet("Sheet1");
      int totalRows=sheet.getLastRowNum();
      int totalCells=sheet.getRow(1).getLastCellNum();
	  System.out.println("totalRows : " + totalRows);//13
	  System.out.println("totalCells: " + totalCells);//3

	  for(int r=0;r<=totalRows;r++) {
		  XSSFRow currentRow=sheet.getRow(r);
		 
				  for(int c=0;c<totalCells;c++) {
					  XSSFCell cell= currentRow.getCell(c);
					  System.out.print(cell.toString()+"\t");
				  }
				  System.out.println();
				  
	  }

				  */	 
}
