package ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {
	WebDriver driver;
	LoginPageObject(WebDriver driver){
		this.driver=driver;
	}
		
		By loginText= By.xpath("//*[@id='login']");
		By Username= By.xpath("//*[@id='UserName']");
		By UserPassword= By.xpath("//*[@id='Password']");
		By LoginButton= By.xpath("//*[@id='LoginButton']");
		By msg=By.xpath("toast-message");
		By Title= By.xpath("//*[@class='page_title']");
		
		public void clickLoginText() {
			driver.findElement(loginText).click();
		}
		
		public void sendUserName(String UserName) {
			driver.findElement(Username).sendKeys(UserName);
		}
		
		public void sendPassword(String Password) {
			driver.findElement(UserPassword).sendKeys(Password);
		}
		
		public void LoginButton() {
			driver.findElement(LoginButton).click();
			try {
	            Alert alert = driver.switchTo().alert();
	            String alertText = alert.getText();
	            String expectedMessage = "login successfully";
	            
	            if (alertText.equals(expectedMessage)) {
	                System.out.println("Test Pass: Message - " + alertText);
	                alert.accept(); // Accept the alert (click OK)
	            } else {
	                System.out.println("Test Fail: Message - " + alertText + ". Expected message is: " + expectedMessage + ". Please fill correct data.");
	                alert.dismiss(); // Dismiss the alert (click Cancel)
	            }
	        } catch (Exception e) {
	            System.out.println("No alert present. Something went wrong.");
	            e.printStackTrace();
	        } 
//			finally {
//	            // Close the browser session
//	            driver.quit();
//	        }
        }
    
			public void getTitle() {
				String Title =driver.getTitle();
				String ExpectedTitle= "BookStore";
				if(Title.equals("Admin")) {
					System.out.println( "Test Pass : Title : " + Title );
				}else if(Title.equals("BookKeeper")) {
					System.out.println( "Test Pass : Title : " + Title );
				}else if(Title.equals("Searcher")) {
					System.out.println( "Test Pass : Title : " + Title );
				}else {
					System.out.println( "Test Failed" );
				}
			}
			
		
		
		

	}

