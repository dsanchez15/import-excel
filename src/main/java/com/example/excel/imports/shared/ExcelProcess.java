package com.example.excel.imports.shared;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelProcess {

    public static Map<Integer, Object> processExcel(MultipartFile excel) throws IOException {

        Map<Integer, Object> data = new HashMap<>();
        Map<Integer, String> dataRow = null;

        InputStream in = excel.getInputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row currentRow : sheet) {
            dataRow = new HashMap<>();
            for (Cell currentCell : currentRow) {
                dataRow.put(currentCell.getColumnIndex(), readCellContent(currentCell));
            }
            data.put(currentRow.getRowNum(), dataRow);
            workbook.close();
        }

        return data;
    }

    private static String readCellContent(Cell cell) {
        String content;
        switch (cell.getCellType()) {
            case STRING:
                content = cell.getStringCellValue();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    content = cell.getDateCellValue() + "";
                } else {
                    content = cell.getNumericCellValue() + "";
                }
                break;
            case BOOLEAN:
                content = cell.getBooleanCellValue() + "";
                break;
            case FORMULA:
                content = cell.getCellFormula() + "";
                break;
            default:
                content = "";
        }
        return content;
    }
}
