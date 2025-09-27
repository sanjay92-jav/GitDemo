package ApachePOI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// How to write web table data into Excel sheet in Selenium
// Web scraping/ Web harvesting/ Web data extraction

public class WriteWebTableToExcel {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
		
		String path="C:\\Users\\sanja\\Desktop\\population.xlsx";
		ExcelUtility exutil=new ExcelUtility(path);
		exutil.setCellData("Sheet1", 0, 0,"Country");
		exutil.setCellData("Sheet1", 0, 1,"Population");
		exutil.setCellData("Sheet1", 0, 2,"% of world");
		exutil.setCellData("Sheet1", 0, 3,"Date");
		exutil.setCellData("Sheet1", 0, 4,"Source");
		
		WebElement table=driver.findElement(By.xpath("//table[@class='wikitable sortable mw-datatable sort-under static-row-numbers sticky-header col1left col5left jquery-tablesorter']"));
		
		int rows=table.findElements(By.xpath("tr")).size();    // rows present in web table
		
		for(int r=1;r<=rows;r++)
		{
			String country=table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
			String population=table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
			String perOfWorld=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
			String date=table.findElement(By.xpath("tr["+r+"]/td[4]")).getText();
			String source=table.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
			
			System.out.println(country+population+perOfWorld+date+source);
			
			// Writing data in excel sheet
			
			exutil.setCellData("Sheet1", r, 0, country);
			exutil.setCellData("Sheet1", r, 1, population);
			exutil.setCellData("Sheet1", r, 2, perOfWorld);
			exutil.setCellData("Sheet1", r, 3, date);
			exutil.setCellData("Sheet1", r, 4, source);
		}
		
		System.out.println("Web scrapping is done successfully....");		
		
	}
		
}
