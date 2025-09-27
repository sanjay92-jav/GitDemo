package ApachePOI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "LoginData")
	public void loginTest(String user,String pwd,String exp)
	{
		driver.get("https://admin-demo.nopcommerce.com/login");
		WebElement email=driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys(user);
		WebElement pass=driver.findElement(By.id("Password"));
		pass.clear();
		pass.sendKeys(pwd);
		driver.findElement(By.cssSelector("button")).click();
		
		String expTitle="Dashboard / nopCommerce administration";
		String acuTitle=driver.getTitle();
		
		if(exp.equals("valid"))
		{
			if(expTitle.equals(acuTitle))
			{
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		else if(exp.equals("invalid"))
		{
			if(expTitle.equals(acuTitle))
			{
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
	}

	// Data Provider method always return two dimensional array
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
/*		
		String loginData[][]= {
				{"admin@yourstore.com","admin","valid"},
				{"admin@yourstore.com","adm","invalid"},
				{"adm@yourstore.com","admin","invalid"},
				{"adm@yourstore.com","adm","invalid"}
               };
*/		
		// get the data from excel
		String path="C:\\Users\\sanja\\Desktop\\data.xlsx";
		ExcelUtility excel=new ExcelUtility(path);
		int totalRows=excel.getRowCount("Sheet1");
		int totalCol=excel.getCellCount("Sheet1",1);
		
		String loginData[][]=new String[totalRows][totalCol];
		for(int i=1;i<=totalRows;i++)
		{
			for(int j=0;j<totalCol;j++)
			{
				loginData[i-1][j]=excel.getCellData("Sheet1", i, j);
			}
			
		}
		
		return loginData;
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}

}
