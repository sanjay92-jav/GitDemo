package ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteFormulaCell {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Numbers");
        XSSFRow row=sheet.createRow(0);
        row.createCell(0).setCellValue(10);
        row.createCell(1).setCellValue(20);
        row.createCell(2).setCellValue(30);
        
        row.createCell(3).setCellFormula("A1*B1*C1");
        
        
        String path="C:\\Users\\sanja\\Desktop\\cal.xlsx";
        FileOutputStream file=new FileOutputStream(path);
        
        workbook.write(file);
        file.close();
        
        System.out.println("File created");
        
        
        // How to open password protected workbook
        
//        String password="san123";
//		XSSFWorkbook workbook=(XSSFWorkbook) WorkbookFactory.create(file, password);
        
	}

}
