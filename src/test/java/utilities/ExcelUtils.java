package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class ExcelUtils {
    /*
    .readExcel(name,SheetName);
    .getValue(row.cell);
    .setValue(row,cell);
     */
    static Sheet sheet;
    static String path;
    static Workbook book;

    public static void readExcel(String name, String sheetName){
        path= "/Users/fatima/IdeaProjects/MindtekCucumberAutomation/src/test/resources/Data1/"+name+".xlsx";
        try {
            FileInputStream input=new FileInputStream(path);
            Workbook book = new XSSFWorkbook(input);
            sheet= book.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Object getValue(int row, int cell) {

        return sheet.getRow(row).getCell(cell);

    }

    public static void setValue(int row, int cell, String value){
        int numberOfRows=sheet.getPhysicalNumberOfRows();

        if(numberOfRows>row){
            sheet.getRow(row).createCell(cell).setCellValue(value);
        }else{
            sheet.createRow(row).createCell(cell).setCellValue(value);
        }

        FileOutputStream output= null;
        try {
             output = new FileOutputStream(path);
            book.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void setValue(int row, int cell, double value){
        int numberOfRows=sheet.getPhysicalNumberOfRows();

        if(numberOfRows>row){
            sheet.getRow(row).createCell(cell).setCellValue(value);
        }else{
            sheet.createRow(row).createCell(cell).setCellValue(value);
        }

        FileOutputStream output= null;
        try {
            output = new FileOutputStream(path);
            book.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
