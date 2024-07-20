package ui;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserDashBoard {
	
	WebDriver driver;
	UserDashBoard(WebDriver driver){
		this.driver=driver;
	}

	
	By search= By.xpath("//*[@id='searchBoxId']");
	By clickonBook= By.xpath("//*[@id='b']");
	By UserPassword= By.xpath("//*[@id='Password']");
	By LoginButton= By.xpath("//*[@id='LoginButton']");
	By msg=By.xpath("toast-message");
	By Title= By.xpath("//*[@class='page_title']");
	By AddBook= By.xpath("//*[@id='add']");
	By Delete= By.xpath("//*[@id='delete']");
	
	
	public void search(String BookTitle) {
		driver.findElement(search).sendKeys(BookTitle);
	}
	
	public void clickOnbook(String bookname) {
		List<WebElement> list =driver.findElements(LoginButton);
		 
        Select select = new Select(list.get(0)); // Assuming the first element in the list is the correct dropdown
       
            // Select the first occurrence of "selenium" in the dropdown
            List<WebElement> options = select.getOptions();
            for (WebElement option : options) {
                if (option.getText().equals(bookname)) {
                    select.selectByVisibleText(bookname);
                    
                    String PageTitle=driver.getTitle(); // same we can do with currenturl
                    String ExpectedPageTitle = bookname;
                    
                    if(PageTitle.equals(ExpectedPageTitle)) {    // we can also add validation on page element like price a
                    	System.out.println("Correct page opened :  " + PageTitle);
                    }else {
                    	System.out.println("Redirected to the invalid page");
                    }
        
                    break; 
                }else {
                	System.out.println("No Data fount for the given ");
                }
            }
        }
	

	
	public void Actions() {
		 String PageTitle=driver.getTitle();
		 
		// if the title is "Admin," the user can add the book. If the title is anything else, it will display an error message
		 
		 if(PageTitle.equals("Admin")) {
			 driver.findElement(AddBook).click();
			 WebElement add= driver.findElement(AddBook);
			 boolean result = add.isDisplayed();
			 if(result==true) {
				   System.out.println("Add option is present");
			 }else {
				 System.out.println("Test FAiled");
			 }
			 
		 }
		 
		 else if(PageTitle.equals("BookKeeper")) {
			 driver.findElement(AddBook).click();
			 String ErrorMessage ="You don’t have access to perform this action";
			 
			   Alert alert = driver.switchTo().alert();
	            String alertText = alert.getText();
	            if (alertText.equals(ErrorMessage)) {
	                System.out.println("Test Pass: Message - " + alertText);
	                alert.accept(); 
	            } else {
	                System.out.println("Test Fail: Message - " + alertText + ". Expected message is: " + ErrorMessage + ". Please fill correct data.");
	                alert.dismiss(); 
	            }
		 }
		 else  {
	       			 driver.findElement(AddBook).click();
	       			 String ErrorMessage ="You don’t have access to perform this action";
	       			 
	       			   Alert alert = driver.switchTo().alert();
	       	            String alertText = alert.getText();
	       	            if (alertText.equals(ErrorMessage)) {
	       	                System.out.println("Test Pass: Message - " + alertText);
	       	                alert.accept(); // Accept the alert (click OK)
	       	            } else {
	       	                System.out.println("Test Fail: Message - " + alertText + ". Expected message is: " + ErrorMessage + ". Please fill correct data.");
	       	                alert.dismiss(); // Dismiss the alert (click Cancel)
	       	            }
	            
		 }
	}
}
