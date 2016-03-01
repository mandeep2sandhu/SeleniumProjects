package MoovWebSupportLink;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class VerifySignUp {
	WebDriver Browser;
	String Url = "https://help.moovweb.com/hc/en-us";

	@Test
	// To verify alert message and all web elements are present on SignUp page
	public void main() {
		// Verify if alert is present
		System.out.println("---------TestCase Starts------");
		Boolean alert = Browser.findElement(By.xpath("//*[@id='application_alerts']/div/p")).isDisplayed();

		if (alert == true) {
			// Verify the message of Alert
			String Alert_Message = Browser.findElement(By.xpath("//*[@id='application_alerts']/div/p")).getText();
			System.out.println("Alert message text is found as: " + Alert_Message);
		}

		else {
			System.out.println("Alert message is not found on the page");

		}

		Boolean username = Browser.findElement(By.id("user_name")).isDisplayed();
		if (username == true) {
			System.out.println("Username text field is present");
		} else {
			System.out.println("Username text field is not found");

		}

		Boolean email = Browser.findElement(By.id("user_email")).isDisplayed();
		if (email == true) {
			System.out.println("user email text field is present");
		} else {
			System.out.println("User email text field is not found");

		}
		Boolean company = Browser.findElement(By.id("user_company_name")).isDisplayed();
		if (company == true) {
			System.out.println("Company text field is present");
		} else {
			System.out.println("company text field is not found");

		}
		Boolean password = Browser.findElement(By.id("user_password")).isDisplayed();
		if (password == true) {
			System.out.println("User password text field is present");
		} else {
			System.out.println("password text field is not found");

		}
		Boolean password_confirm = Browser.findElement(By.id("user_password_confirmation")).isDisplayed();
		if (password_confirm == true) {
			System.out.println("password confirmation text field is present");
		} else {
			System.out.println("password confirmation text field is not found");

		}
		Boolean checkbox = Browser.findElement(By.xpath("//*[@id='user_terms_of_service']")).isDisplayed();
		if (checkbox == true) {
			System.out.println("Check box for terms of service is present");
			String Checkbox_text = Browser.findElement(By.xpath("//*[@id='user_terms_of_service_input']/label"))
					.getText();
			System.out.println(" Text in CheckBox section is present as: " + Checkbox_text);
		} else {
			System.out.println("checkbox is not found");
		}
		
		Boolean sign_up_button = Browser.findElement(By.xpath("//*[@id='user_submit_action']/button")).isDisplayed();
		if (sign_up_button ==true){
			System.out.println("Sign Up link is present");
		}
		else { System.out.println("Sign Up link is not present");
		}
		
		String Text_Below_SignUP = Browser.findElement(By.xpath("//*[@id='intro']/div/div/div")).getText();
		System.out.println("Text below sign up button is present as: " +Text_Below_SignUP); 
		System.out.println("---------TestCase ends-------");
		
	}
	

	@BeforeMethod
	public void beforeMethod() {
		// Open FireFox browser
		Browser = new FirefoxDriver();

		// Open MoovWeb Support Link
		Browser.get(Url);

		// look for Sign In button and click on that
		WebElement SignIn_Button = Browser.findElement(By.xpath("html/body/header/div/nav/a[2]"));
		SignIn_Button.click();

		// to get Control of new opened window
		Browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String handle = Browser.getWindowHandle();
		Browser.switchTo().window(handle);
	}

	@AfterMethod
	public void afterMethod() {
		Browser.close();
	}
}
