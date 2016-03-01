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

public class AllLinksPresent {
	
	WebDriver Browser;
	String Url = "https://help.moovweb.com/hc/en-us";

	@Test
	//To print the links present on sign up form
	public void main(){
		
		WebElement form = Browser.findElement(By.xpath("//*[@id='user_terms_of_service_input']"));
		List<WebElement> links = form.findElements(By.tagName("a"));
		int count = links.size();
		System.out.println("number of links present are: " + count);
		
		System.out.println("Name of links are: ");
		for (int i = 0; i<count; i++)
		{
			String link_name = links.get(i).getText();
			
			System.out.println (link_name);
		}
		
		WebElement another_link = Browser.findElement(By.xpath("//*[@id='intro']/div/div/div/a"));
		System.out.println(another_link.getText());
		
		
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
