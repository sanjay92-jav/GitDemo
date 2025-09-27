package ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class practice {

	public static void main(String[] args) throws IOException {
		
       String filepath="C:\\Users\\sanja\\Desktop\\cal.xlsx";
       FileOutputStream file=new FileOutputStream(filepath);
       XSSFWorkbook workbook=new XSSFWorkbook();
       XSSFSheet sheet=workbook.createSheet("Numbers");
       XSSFRow row1=sheet.createRow(0);
       row1.createCell(0).setCellValue(10);
       row1.createCell(1).setCellValue(20);
       row1.createCell(2).setCellValue(30);
       row1.createCell(3).setCellFormula("A1*B1*C1");
       workbook.write(file);
       workbook.close();
       file.close();
       System.out.println("File created successfully");

	}

}
