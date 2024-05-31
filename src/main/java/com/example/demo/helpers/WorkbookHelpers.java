package com.example.demo.helpers;

import com.example.demo.helpers.writer.InputFile;
import com.example.demo.models.WorkloadQuery;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkbookHelpers {
    public static Workbook multipartFileToWorkbook(MultipartFile file) throws IOException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(file.getBytes())) {
            return WorkbookFactory.create(bis);
        }
    }

    public static byte[] convertWorkbookToByteArray(Workbook workbook) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }

    public static void setFormulaCell(Sheet sheet, int row, int column, String value) {
        Row currRow = sheet.getRow(row);
        if (currRow == null) {
            currRow = sheet.createRow(row);
        }
        Cell cell = currRow.getCell(column);
        if (cell == null) {
            cell = currRow.createCell(column);
        }
        cell.setCellFormula(value);
    }

    public static void setCellSheet(Sheet sheet, int row, int column, Object value) {
        Row currRow = sheet.getRow(row);
        if (currRow == null) {
            currRow = sheet.createRow(row);
        }
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

    public static void setCellSheetWithStyle(Sheet sheet, int row, int column, Object value) {
        Row currRow = sheet.getRow(row);
        if (currRow == null) {
            currRow = sheet.createRow(row);
        }
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
        GenerateStyleCell(cell);
    }

    private static void GenerateStyleCell(Cell cell) {
        CellStyle thickBorderCellStyle = cell.getSheet().getWorkbook().createCellStyle();
        thickBorderCellStyle.setBorderTop(BorderStyle.MEDIUM);
        thickBorderCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        thickBorderCellStyle.setBorderLeft(BorderStyle.MEDIUM);
        thickBorderCellStyle.setBorderRight(BorderStyle.MEDIUM);
        thickBorderCellStyle.setAlignment(HorizontalAlignment.CENTER);
        thickBorderCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        thickBorderCellStyle.setWrapText(true);
        cell.setCellStyle(thickBorderCellStyle);
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

    public static List<WorkloadQuery> selectionMagisters(List<WorkloadQuery> workload, Boolean isAutumn) {
        List<WorkloadQuery> magisters = new ArrayList<>();
        for (WorkloadQuery work : workload) {
            if (work.getSemesterDescr() > 8 && IsAutumnSemester(work.getSemesterDescr()) == isAutumn) {
                magisters.add(work);
            }
        }
        return magisters;
    }

    public static List<WorkloadQuery> selectionBachelors(List<WorkloadQuery> workload, Boolean isAutumn) {
        List<WorkloadQuery> bachelors = new ArrayList<>();
        for (WorkloadQuery work : workload) {
            if (work.getSemesterDescr() < 9 && IsAutumnSemester(work.getSemesterDescr()) == isAutumn) {
                bachelors.add(work);
            }
        }
        return bachelors;
    }

    public static List<Double> CalculationLaborCosts(WorkloadQuery workload) {
        List<Double> result = new ArrayList<Double>();
        for (int i = 2; i < 18; i++) {
            switch (i) {
                case 2:
                    result.add((double) workload.getLectureCount() * workload.getWeekCount());
                    break;
                case 3:
                    result.add((double) workload.getPracticeCount() * workload.getWeekCount() * workload.getSubgroupCount());
                    break;
                case 4:
                    result.add((double) workload.getLabCount() * workload.getWeekCount() * CalcSubGroup(workload.getStudentCount()));
                    break;
                case 5:
                    result.add(CalcKons(workload));
                    break;
                case 6:
                    result.add(workload.getEkz() ? CalcEkz(workload) : 0);
                    break;
                case 7:
                    result.add(workload.getZach() ? 0.25 * workload.getStudentCount() : 0);
                    break;
                case 8:
                    result.add(workload.getKp() ? (double) 3 * workload.getStudentCount() : 0);
                    break;
                case 9:
                    result.add(workload.getKr() ? (double) 2 * workload.getStudentCount() : 0);
                    break;
                case 10:
                    result.add((double) 0);
                    break;
                case 11:
                    result.add((double) 4 * 5 * workload.getUchPr() * workload.getSubgroupCount());
                    break;
                case 12:
                    result.add(workload.getPrPr() != 0 ? (double) workload.getStudentCount() * 2 : 0);
                    break;
                case 13:
                    result.add(workload.getPredDipPr() != 0 ? (double) workload.getStudentCount() * workload.getPredDipPr() : 0);
                    break;
                case 14:
                    result.add(workload.getDpRuk() ? (double) (14 + 0.5 + 0.5) * workload.getStudentCount() : 0);
                    break;
                case 15:
                    result.add(CalcGek(workload));
                    break;
                case 16:
                    result.add((double) 3 * workload.getStudentCount() * workload.getNiir());
                    break;
                case 17:
                    result.add((double) 0);
                    break;
            }
        }
        return result;
    }

    private static Integer CalcSubGroup(Integer countStudent) {
        if (countStudent < 18) {
            return 1;
        } else {
            return countStudent / 9;
        }
    }

    private static Double CalcKons(WorkloadQuery workload) {
        double res;
        switch (workload.getStudyForm()) {
            case "Очно":
                res = 0.05 * workload.getLectureCount() * workload.getWeekCount();
            default:
                res = 0.05 * workload.getLectureCount() * workload.getWeekCount() * 3;
        }
        if (workload.getEkz()) {
            res += 2;
        }
        return res;
    }

    private static Double CalcEkz(WorkloadQuery workload) {
        switch (workload.getStudyForm()) {
            case "Очно":
                return 0.33 * workload.getStudentCount();
            default:
                return 0.4 * workload.getStudentCount();
        }
    }

    private static Double CalcGek(WorkloadQuery workload) {
        double res = 0;
        res += workload.getGek() ? (double) 0.5 * workload.getStudentCount() * 6 : 0;
        res += workload.getGak() ? (double) 0.5 * workload.getStudentCount() * 5 : 0;
        res += workload.getGakPred() ? (double) 0.25 * workload.getStudentCount() : 0;
        return res;
    }
    public static Integer findCountStudent(List<InputFile> list, Integer semester, Integer idSpeciality){
        for (InputFile data : list){
            if(data.getSemesterDescr().equals(semester) && data.getIdSpeciality().equals(idSpeciality)){
                return data.getStudentCount();
            }
        }
        return -1;
    }
    public static Integer findSubGroupCount(List<InputFile> list, Integer semester, Integer idSpeciality){
        for (InputFile data : list){
            if(data.getSemesterDescr().equals(semester) && data.getIdSpeciality().equals(idSpeciality)){
                return data.getSubGroupCount();
            }
        }
        return -1;
    }
}
