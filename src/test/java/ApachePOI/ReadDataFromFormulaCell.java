package ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromFormulaCell {

	public static void main(String[] args) throws IOException {
		
		String path="C:\\Users\\sanja\\Desktop\\Salary.xlsx";
		FileInputStream file=new FileInputStream(path);
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		int NumberOfRows=sheet.getLastRowNum();
        int NumberOfCells=sheet.getRow(0).getLastCellNum();
        
        for(int r=0;r<=NumberOfRows;r++)
        {
        	XSSFRow row=sheet.getRow(r);      // first row
        	
        	for(int c=0;c<NumberOfCells;c++)
        	{
        	  XSSFCell cell=row.getCell(c);     // first cell
        	   switch(cell.getCellType())
        	   {
        	   case STRING:System.out.print(cell.getStringCellValue());break;
        	   case NUMERIC:System.out.print(cell.getNumericCellValue());break;
        	   case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
        	   case FORMULA:System.out.println(cell.getNumericCellValue());break;
        	   }
        	   
        	   System.out.print(" ");
        	}
        	System.out.println();
        }
        
        file.close();
	}

}
