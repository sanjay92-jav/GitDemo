package sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class authenticationPopup {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

		String message = driver.findElement(By.cssSelector("p")).getText();
		Assert.assertTrue(message.contains("Congratulations"));
	}

}
