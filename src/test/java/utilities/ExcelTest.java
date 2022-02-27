package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.SQLOutput;

public class ExcelTest {
    public static void main(String[] args) {

        String path="/Users/fatima/IdeaProjects/MindtekCucumberAutomation/src/test/resources/Data1/TestData.xlsx";
        try {
            FileInputStream input= new FileInputStream(path);
            Workbook book= new XSSFWorkbook(input);
            Sheet page= book.getSheet("Sheet1");
            String name1=page.getRow(1).getCell(0).toString();
            System.out.println(name1);
            String position1=page.getRow(2).getCell(2).toString();
            System.out.println(position1);

            page.createRow(3).createCell(0).setCellValue("Kim");
            page.getRow(3).createCell(1).setCellValue("Yan");

            FileOutputStream output=new FileOutputStream(path);
            book.write(output);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ExcelUtils.readExcel("TestData", "Sheet1");

        System.out.println(ExcelUtils.getValue(2,3));

        ExcelUtils.setValue(3,2,"Scrum Master");
        ExcelUtils.setValue(3,3,100000);
    }
}
