package com.LMS.utilities;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
    public static int totalRow;

    public List<Map<String, String>> getData(String excelFilePath, String sheetName) throws IOException {
        Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
        Sheet sheet = workbook.getSheet(sheetName);
        workbook.close();
        return readSheet(sheet);
    }

    private List<Map<String, String>> readSheet(Sheet sheet) {
        Row row;
        Cell cell;
        totalRow = sheet.getLastRowNum();
        List<Map<String, String>> excelRows = new ArrayList<>();
        for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
            row = sheet.getRow(currentRow);
            int totalColumn = row.getLastCellNum();
            LinkedHashMap<String, String> columnMapData = new LinkedHashMap<>();
            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                cell = row.getCell(currentColumn);
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
                if (null != cell)
                	if(cell.getCellType().equals(CellType.STRING)) {
                		columnMapData.put(columnHeaderName, cell.getStringCellValue());
                	}else if(cell.getCellType().equals(CellType.NUMERIC)) {
                		columnMapData.put(columnHeaderName, String.valueOf(cell.getNumericCellValue()));
                	}
                else
                    columnMapData.put(columnHeaderName, "");
            }
            excelRows.add(columnMapData);
        }
        return excelRows;
    }

    public int countRow() {
        return totalRow;
    }
}