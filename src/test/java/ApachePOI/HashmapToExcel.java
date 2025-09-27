package ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashmapToExcel {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
	    XSSFSheet sheet=workbook.createSheet("Student data");
	    
	    Map<String,String> data=new HashMap<String,String>();
	    data.put("101","John");
	    data.put("102","Smith");
	    data.put("103","Scott");
	    data.put("104","Kim");
	    data.put("105","Mary");
	    
	    int rowCount=0;
	    for(Map.Entry<String,String> entry:data.entrySet()) 
	    {
	    	XSSFRow row=sheet.createRow(rowCount++);
	    	row.createCell(0).setCellValue(entry.getKey());
	    	row.createCell(1).setCellValue(entry.getValue());
	    	
	    }
	    
	    FileOutputStream file=new FileOutputStream("C:\\Users\\sanja\\Desktop\\student.xlsx");
	    workbook.write(file);
	    file.close();
	    workbook.close();
	    
	    System.out.println("File created");
        
	}

}
