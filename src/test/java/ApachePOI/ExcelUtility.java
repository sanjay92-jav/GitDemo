package ApachePOI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	String path=null;
	
	 ExcelUtility(String path) 
	 {
		this.path=path;
	 }
	 
	 public int getRowCount(String sheetName) throws IOException
	 {
		 fi=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetName);
		 int rowCount=sheet.getLastRowNum();
		 workbook.close();
		 fi.close();
		 return rowCount;
	 }

	 
	 public int getCellCount(String sheetName,int rowNum) throws IOException
	 {
		 fi=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetName);
		 row=sheet.getRow(rowNum);
		 int cellCount=row.getLastCellNum();
		 workbook.close();
		 fi.close();
		 return cellCount;
	 }
	 
	 public String getCellData(String sheetName,int rowNum,int column) throws IOException
	 {
		 fi=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetName);
		 row=sheet.getRow(rowNum);
		 cell=row.getCell(column);
		 
		 DataFormatter formatter=new DataFormatter();       // For formatting the value stored in aCell
		 String data;
		 try
		 {
			 data=formatter.formatCellValue(cell);       // Returns the formatted value of a cell as a String regardlessof the cell type
		 }
		 catch(Exception e)
		 {
			 data="";
		 }
		 workbook.close();
		 fi.close();
		 return data;
	 }
	 
	 public void setCellData(String sheetName,int rowNum,int colNum,String data) throws IOException
	 {
		 fi=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetName);
		 row=sheet.getRow(rowNum);
		 cell=row.createCell(colNum);
		 cell.setCellValue(data);
		 
		 fo=new FileOutputStream(path);
		 workbook.write(fo);
		 workbook.close();
		 fi.close();
		 fo.close();
      }
	 
	 public void fillColor(String sheetName,int rowNum,int colNum) throws IOException
	 {
		 fi=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetName);
		 row=sheet.getRow(rowNum);
		 cell=row.getCell(colNum);
		 
		 style=workbook.createCellStyle();
		 style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());         //in case of test failure change color to red
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 
		 cell.setCellStyle(style);
		 workbook.write(fo);
		 workbook.close();
		 fi.close();
		 fo.close();
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
