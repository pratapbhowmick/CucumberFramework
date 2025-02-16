package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    public static void loadExcelFile(String filePath, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load Excel file.");
        }
    }

    public static String getCellData(int rowNum, int colNum) {
        return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
    }
}
