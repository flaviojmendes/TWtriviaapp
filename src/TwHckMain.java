import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TwHckMain {
	private static final String URL = "http://trivia-app.herokuapp.com/registered";
	private static final String EMAIL = "teste@code.com";
	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new FirefoxDriver();
		wd.get(URL);
		
		WebElement inputEmail = wd.findElement(By.id("player_email"));
		inputEmail.sendKeys(EMAIL);
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
