import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TwHckMain {
	public static void main(String[] args) throws InterruptedException {
		final WebDriver wd = new WebDriver();
		wd.get("http://trivia-app.herokuapp.com/registered");
		WebElement inputEmail = wd.findElement(By.id("player_email"));
		inputEmail.sendKeys("mauricio.faustino@gmail.com");
		WebElement btnSend = wd.findElement(By.name("commit"));
		btnSend.click();
		
		while(true) {
	        
	        for(WebElement we : wd.findElements(By.className("question"))){
	        	we.findElement(By.className("answer0")).click();
	        }
	        
	        wd.findElement(By.className("play")).click();
		}
	}
}
