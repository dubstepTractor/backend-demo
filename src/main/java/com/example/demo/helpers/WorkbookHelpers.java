package com.example.demo.helpers;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

public class WorkbookHelpers {
    public static byte[] convertWorkbookToByteArray(Workbook workbook) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }

    public static void setCellSheet(Sheet sheet, int row, int column, Object value) {
        Row currRow = sheet.getRow(row);
        if (currRow != null) {
            Cell cell = currRow.getCell(column);
            if (cell == null) {
                cell = currRow.createCell(column);
            }
            if (value instanceof String) {
                cell.setCellValue(value.toString());
            } else if (value instanceof Integer) {
                cell.setCellValue((Integer) value);
            } else if (value instanceof Boolean) {
                cell.setCellValue((boolean) value);
            } else if (value instanceof Double) {
                cell.setCellValue((Double) value);
            }
        }
    }

    public static Integer getCourse(Integer numSemester) {
        switch (numSemester) {
            case 1:
                return 1;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 3;
            case 7:
                return 4;
            case 8:
                return 4;
            case 9:
                return 1;
            case 10:
                return 1;
            case 11:
                return 2;
            case 12:
                return 2;
            default:
                return 0;
        }
    }
    public static Boolean IsAutumnSemester(Integer numSemester) {
        return numSemester % 2 != 0;
    }
}
