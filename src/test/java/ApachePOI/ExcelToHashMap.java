package ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMap {

	public static void main(String[] args) throws IOException {
		
		HashMap<String,String> data=new HashMap<String,String>();
		
		FileInputStream file=new FileInputStream("C:\\Users\\sanja\\Desktop\\student.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		for(int r=0;r<=sheet.getLastRowNum();r++)
		{
			String key=sheet.getRow(r).getCell(0).getStringCellValue();
			String value=sheet.getRow(r).getCell(1).getStringCellValue();
			data.put(key, value);
			
		}
		
		// Read data from HashMap
		
		for(Map.Entry entry:data.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		

	}

}
