package ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcel {

	public static void main(String[] args) throws IOException {
		
		String filepath="C:\\Users\\sanja\\Desktop\\employee.xlsx";
		FileOutputStream outstream=new FileOutputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Emp Info");
		
//		ArrayList<Object[]> empdata=new ArrayList<Object[]>();
//		
//		empdata.add(new Object[] {"EmpID","Name","Job"});
//		empdata.add(new Object[] {101,"David","Engineer"});
//		empdata.add(new Object[] {102,"Smith","Manager"});
//		empdata.add(new Object[] {103,"Scott","Analyst"});
//		
//		for(int r=0;r<empdata.size();r++)
//		{
//			XSSFRow row=sheet.createRow(r);
//			Object[] data=empdata.get(r);
//			
//			for(int c=0;c<data.length;c++)
//			{
//				XSSFCell cell=row.createCell(c);
//				Object value=data[c];
//				
//				if(value instanceof String)
//					cell.setCellValue((String)value);
//				if(value instanceof Integer)
//					cell.setCellValue((Integer)value);
//			}
//			
//		}

// -------------- Using for loop -----------------------------
		
//		Object[][] empdata= {
//				{"EmpID","Name","Job"},
//				{101,"David","Engineer"},
//				{102,"Smith","Manager"},
//				{103,"Scott","Analyst"}
//		};
				
//		int rows=empdata.length;
//		int cells=empdata[0].length;
//		
//		for(int r=0;r<rows;r++)
//		{
//			XSSFRow row=sheet.createRow(r);
//			for(int c=0;c<cells;c++)
//			{
//				XSSFCell cell=row.createCell(c);
//				Object value= empdata[r][c];
//				
//				if(value instanceof String)
//					cell.setCellValue((String)value);
//				if(value instanceof Integer)
//					cell.setCellValue((Integer)value);
//				if(value instanceof Boolean)
//					cell.setCellValue((Boolean)value);
//			}
//		}
		
		
// ------------- Using for each loop ---------------	
		

		ArrayList<Object[]> empdata=new ArrayList<Object[]>();
		
		empdata.add(new Object[] {"EmpID","Name","Job"});
		empdata.add(new Object[] {101,"David","Engineer"});
		empdata.add(new Object[] {102,"Smith","Manager"});
		empdata.add(new Object[] {103,"Scott","Analyst"});
		
		int rowCount=0;
		for(Object[] emp:empdata)
		{
			XSSFRow row=sheet.createRow(rowCount++);
			int columnCount=0;
			for(Object value:emp)
			{
				XSSFCell cell=row.createCell(columnCount++);
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
			}
		}
			
			
		
		workbook.write(outstream);
		
		outstream.close();
		
		System.out.println("File created");

	}

}
