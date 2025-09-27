package sel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement element=driver.findElement(By.cssSelector("#animals"));
		
		List se=new ArrayList();
		Select select=new Select(element);
		List<WebElement> li=select.getOptions();
		for(WebElement a:li)
		{
			se.add(a.getText());
		}
		
		System.out.println(se);
		
//		Collections.sort();
	}
}
