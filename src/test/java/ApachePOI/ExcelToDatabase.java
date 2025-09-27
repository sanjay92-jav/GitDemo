package ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToDatabase {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetesting","root","Sanjay@92");
		Statement stmt=con.createStatement();
		
		// create a new table in database 
		String sql="create table emp(name varchar(50),age double(4,0),department varchar(50))";
		stmt.execute(sql);
		
		// Excel
		FileInputStream file=new FileInputStream("C:\\Users\\sanja\\Desktop\\file1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		for(int r=1;r<=sheet.getLastRowNum();r++)
		{
			XSSFRow row=sheet.getRow(r);
			String name=row.getCell(0).getStringCellValue();
			double age=row.getCell(1).getNumericCellValue();
			String dept=row.getCell(2).getStringCellValue();
			
			sql="insert into emp values('"+name+"','"+age+"','"+dept+"')";
			stmt.execute(sql);
			stmt.execute("commit");
		}
		
		workbook.close();
		file.close();
		con.close();
		
		System.out.println("Done!");

	}

}
