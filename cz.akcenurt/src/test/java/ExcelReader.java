import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("src/test/Resources/data.xlsx"));
        Workbook excelData = new XSSFWorkbook(fileInputStream);
        Sheet sheet = excelData.getSheetAt(1);
//        Row row = sheet.getRow(0);
//        System.out.println(row.getCell(1).getStringCellValue());
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            System.out.println(row.getCell(0).getStringCellValue());
        }


    }



}
