package ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Registration {

	WebDriver driver;

	Registration(WebDriver driver){
		this.driver=driver;
	}
	
	//locator

	By name= By.xpath("//*[@id='username']");
	By email= By.xpath("//*[@id='emailid']");
	By BookStoreRole= By.xpath("//*[@id='role']");
	By Submit= By.xpath("//*[@id='sbmit']");
	By msg=By.xpath("toast-message");
	By Title= By.xpath("//*[@class='page_title']");
	
	public void setUserName(String user) {
		driver.findElement(name).sendKeys(user);
	}
	public void setUserEmailId(String mailid) {
		driver.findElement(email).sendKeys(mailid);
	}
	
	public void setUserRole(String userrole) {
		driver.findElement(BookStoreRole).sendKeys(userrole);	
		}
	
	public void submit() {
		driver.findElement(Submit).click();
		}
	
	public void getMsg() {
		Alert alert= driver.switchTo().alert();
		String alertText=alert.getText();
		String expectedMessage = "Registration done successfully";
		if(alertText.equals(expectedMessage)) {
			System.out.println( "Test Pass : Message : " + alertText );
		}else {
			System.out.println( "Test Fail : Message : " + alertText +"Expected message is : "+ expectedMessage + "Please fill correct data");
		}
	}
		
		
		public void getTitle() {
			String Title =driver.getTitle();
			String ExpectedTitle= "Login BookStore";
			if(Title.equals(ExpectedTitle)) {
				System.out.println( "Test Pass : Title : " + Title );
			}else {
				System.out.println( "Test Fail : Title : " + Title +"Redirected to the different page");
			}
		}
		
}
