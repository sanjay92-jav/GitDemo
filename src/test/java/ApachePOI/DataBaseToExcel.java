package ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataBaseToExcel {

	public static void main(String[] args) throws SQLException, IOException {
		
        // connect to the database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetesting","root","Sanjay@92");
		
		// statement/query
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from credentials");
		
		// convert database to Excel
		FileOutputStream file=new FileOutputStream("C:\\Users\\sanja\\Desktop\\customerData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("customer data");
		XSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("scenario");
		row.createCell(1).setCellValue("username");
		row.createCell(2).setCellValue("password");
		
		int rowCount=1;                             
		while(rs.next())                           // returns false,when the cursor is positioned after the last row
		{
			
			row=sheet.createRow(rowCount++);
			
			row.createCell(0).setCellValue(rs.getString("scenario"));     // Retrieves the value of the designated column in the current row of this ResultSet object
			row.createCell(1).setCellValue(rs.getString("username"));
			row.createCell(2).setCellValue(rs.getString("password"));
		}
		
		
		workbook.write(file);
		file.close();
		workbook.close();
		
		System.out.println("file created");
		
		
	}

}
