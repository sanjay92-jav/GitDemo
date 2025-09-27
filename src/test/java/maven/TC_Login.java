package maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Login {
	
	@Test
	public void login_test()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//		driver.findElement(By.cssSelector("[name='username']")).sendKeys("Admin");
//		driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
//		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		driver.close();
	}

}
