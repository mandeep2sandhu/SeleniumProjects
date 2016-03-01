package ApplyForQaJobs;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WorkBridgeAssociate {

	public static void main(String[] args) {

		String projectPath=System.getProperty("user.dir");
		 
		String resumePath=projectPath + "\\resume\\Mandeep Sandhu.docx";
		String jobLink="http://www.indeed.com/viewjob?jk=15d9070a04533e8b&from=myjobs&tk=1ac2kt40lbdfmfuq";
		
		
		WebDriver Browser = new FirefoxDriver();
		Browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Opening the job posting link
		Browser.get(jobLink);


		//click View or Apply Job
		Browser.findElement(By.xpath("//*[@id='bvjl']/a")).click();

		// Focus on Workbridge  window
		Set<String> windows = Browser.getWindowHandles();
		Iterator<String> iterate = windows.iterator();
		iterate.next();
		String secondwin2 = iterate.next();
		Browser.switchTo().window(secondwin2);
 
		//click on 2-click apply
		Browser.findElement(By.xpath("//*[@id='apply_for_this_job']")).click();

		// Fill the form
		Browser.findElement(By.id("firstname")).sendKeys("Mandeep");
		Browser.findElement(By.id("lastname")).sendKeys("Sandhu");
		Browser.findElement(By.id("email")).sendKeys("mandeep2sandhu@gmail.com");
		Browser.findElement(By.id("phone")).sendKeys("408-834-9321");
		Browser.findElement(By.id("apply_attach_file")).sendKeys(resumePath);
		
		//Submit
		Browser.findElement(By.xpath("//*[@id='jobpost_send_info']")).click();
		
		Browser.switchTo().frame(0);
        Browser.findElement(By.xpath("//*[@id='recaptcha-anchor']/div[5]")).click();
        
        //Captcha- not automated.
	}
}
