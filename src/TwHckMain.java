import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Predicate;


public class TwHckMain {
	public static void main(String[] args) throws InterruptedException {
		final WebDriver wd = new FirefoxDriver();
		wd.get("http://trivia-app.herokuapp.com/registered");
		WebElement inputEmail = wd.findElement(By.id("player_email"));
		inputEmail.sendKeys("inscricoes@agilebrazil.com");
		WebElement btnSend = wd.findElement(By.name("commit"));
		btnSend.click();
		
		while(true) {
		
		 FluentWait<By> fluentWait = new FluentWait<By>(By.id("questions"));
	        fluentWait.pollingEvery(100, TimeUnit.MILLISECONDS);
	        fluentWait.withTimeout(1000, TimeUnit.MILLISECONDS);
	        fluentWait.until(new Predicate<By>() {
	            public boolean apply(By by) {
	                try {
	                    return wd.findElement(By.className("answer")).isDisplayed();
	                } catch (NoSuchElementException ex) {
	                    return false;
	                }
	            }
	        });
	        
	        for(WebElement we : wd.findElements(By.className("question"))){
	        	we.findElement(By.className("answer0")).click();
	        }
	        
	        wd.findElement(By.className("play")).click();
		}
//	        for(WebElement we : wd.findElements(By.className("answer0"))){
//	        	System.out.println(we.isDisplayed());
////	        	System.out.println(we.getText());
//	        	Thread.sleep(4000);
//	        }
		
	}
}
