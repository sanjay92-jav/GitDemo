package ApachePOI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteFormulaCell {

	public static void main(String[] args) throws IOException {
		
		String filepath="C:\\Users\\sanja\\Desktop\\book.xlsx";
		FileInputStream instream=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(instream);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		sheet.getRow(7).createCell(2).setCellFormula("SUM(C2:C6)");
		
		instream.close();
		
		FileOutputStream outstream=new FileOutputStream(filepath);
		workbook.write(outstream);
		workbook.close();
		outstream.close();
		System.out.println("Total Calculated");

	}

}
