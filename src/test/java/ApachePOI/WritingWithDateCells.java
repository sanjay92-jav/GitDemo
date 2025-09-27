package ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingWithDateCells {
	
	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Date format");
		XSSFCell cell=sheet.createRow(0).createCell(0);
		cell.setCellValue(new Date());
		
		XSSFCreationHelper creationhelper=workbook.getCreationHelper();
		
		CellStyle style1=workbook.createCellStyle();
		style1.setDataFormat(creationhelper.createDataFormat().getFormat("dd-mm-yyyy"));
		XSSFCell cell1=sheet.createRow(1).createCell(0);
		cell1.setCellValue(new Date());
		cell1.setCellStyle(style1);
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\sanja\\Desktop\\dateFormat.xlsx");
		workbook.write(fos);
		workbook.close();
		fos.close();
		
	}

}
