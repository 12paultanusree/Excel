package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcelToDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/internship";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "qwerty";
    private static final String EXCEL_FILE_PATH = "C:\\Users\\pault\\OneDrive\\Desktop\\Tripillar_Internship\\TestFile.xlsx";
    public static void main(String[] args) throws IOException, SQLException {
        FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        Sheet sheet = workbook.getSheet("Sheet1");
//        Sheet sheet = workbook.getSheet("Users");
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        for (Row row : sheet){
            if(row.getRowNum() == 0) continue; // SKIPPING THE HEADING
            Cell usernameCell = row.getCell(0);
            Cell passwordCell = row.getCell(1);
            String username = usernameCell.getStringCellValue();
            String password = passwordCell.getStringCellValue();
            preparedStatement.setString(1,username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        }
        con.close();
        workbook.close();
        System.out.println("Data successfully entered into DB..!!");

}
}