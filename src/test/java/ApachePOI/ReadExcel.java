package ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		
		String excelPath="C:\\Users\\sanja\\Desktop\\Worbook1.xlsx";
		
		FileInputStream input=new FileInputStream(excelPath);
		XSSFWorkbook workbook=new XSSFWorkbook(input);
//		XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		// --------- Using for loop -------------
		
//		int rows=sheet.getLastRowNum();
//		int cells=sheet.getRow(0).getLastCellNum();
//		for(int r=0;r<=rows;r++)
//		{
//			XSSFRow row=sheet.getRow(r);
//			
//			for(int c=0;c<cells;c++)
//			{
//				XSSFCell cell=row.getCell(c);
//				
//				switch(cell.getCellType())
//				{
//				  case STRING:System.out.print(cell.getStringCellValue());break;
//				  case NUMERIC:System.out.print(cell.getNumericCellValue());break;
//				  case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
//				}
//				
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
		
  
		
		// --------- Iterator ---------------
		
		Iterator rowiterator=sheet.rowIterator();
		while(rowiterator.hasNext())
		{
			XSSFRow row=(XSSFRow) rowiterator.next();
			Iterator cellIterator=row.cellIterator();
			
			while(cellIterator.hasNext())
			{
				XSSFCell cell=(XSSFCell) cellIterator.next();
				
				switch(cell.getCellType())
				{
				  case STRING:System.out.print(cell.getStringCellValue());break;
				  case NUMERIC:System.out.print(cell.getNumericCellValue());break;
				  case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
				}
							
				System.out.print(" ");
			}
			System.out.println();
		}
		
				
	}

}
