package ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormattingCellColour {

	public static void main(String[] args) throws  IOException {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Sheet1");
		
		// Setting Background Color
		XSSFCellStyle style=workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.BIG_SPOTS);
		
		XSSFRow row=sheet.createRow(0);
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("welcome");
        cell.setCellStyle(style);		
	
        XSSFCellStyle style1=workbook.createCellStyle();
		style1.setFillForegroundColor(IndexedColors.INDIGO.getIndex());
		style1.setFillPattern(FillPatternType.BRICKS);
		 cell=row.createCell(1);
		 cell.setCellValue("Automation");
		cell.setCellStyle(style1);
		
		FileOutputStream file=new FileOutputStream("C:\\Users\\sanja\\Desktop\\color.xlsx");
		workbook.write(file);
		file.close();
		workbook.close();
		
		System.out.println("Done!!");
		
	}

}
