package com.example.demo.helpers.plan;

import com.example.demo.models.PlanQuery;
import com.example.demo.models.WorkloadQuery;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.example.demo.helpers.WorkbookHelpers.*;

public class PlanExcelProcessor {
    public static Workbook createReportPlan(PlanQuery teacher, List<WorkloadQuery> workload) {
        // Получение полного пути к файлу шаблона
        File templateFile = new File("src/main/java/com/example/demo/helpers/templates/IndPlanTemplate.xlsx");
        return createReport(templateFile, teacher, workload);
    }

    private static Workbook createReport(File templateFile, PlanQuery teacher, List<WorkloadQuery> workload) {
        try {
            // Загрузка шаблонного файла Excel
            FileInputStream fis = new FileInputStream(templateFile);
            Workbook workbook = WorkbookFactory.create(fis); // Автоматическое определение формата (xls или xlsx)
            fis.close();
            for (int i = 0; i < 6; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                switch (i) {
                    case 0:
                        GenerateTitle(sheet, teacher, workload.get(0).getStudyYear());
                        break;
                    case 1:
                        GenerateSemester(sheet, workload, true);
                        break;
                    case 2:
                        GenerateSemester(sheet, workload, false);
                        break;
                    case 3:
                        GenerateLaborCosts(sheet, workload, true);
                        break;
                    case 4:
                        GenerateLaborCosts(sheet, workload, false);
                        break;
                    default:
                        break;
                }
            }
            workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
            return workbook;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void GenerateTitle(Sheet sheet, PlanQuery teacher, Integer year) {
        // меняем год плана
        String yearPlan = "На  " + year + " / " + (year + 1) + " учебный год";
        setCellSheet(sheet, 25, 5, yearPlan);
        // меняем ФИО
        setCellSheet(sheet, 28, 7, teacher.getEmployeeName());
        // меняем ставку и должность
        String rang = teacher.getAcademicRank() + " (" + teacher.getRate() + ")";
        setCellSheet(sheet, 30, 8, rang);
    }

    private static void GenerateSemester(Sheet sheet, List<WorkloadQuery> workload, Boolean IsAutumnSemester) {
        int numRow = 4;
        for (WorkloadQuery data : workload) {
            if (IsAutumnSemester(data.getSemesterDescr()) == IsAutumnSemester) {
                setCellSheet(sheet, numRow, 2, data.getDescr().replaceAll("\"", ""));
                String col2 = data.getFacultyDescr() + "," + getCourse(data.getSemesterDescr()) + " курс," + data.getSpecialityDescr();
                setCellSheet(sheet, numRow, 3, col2);
                setCellSheet(sheet, numRow, 4, data.getStudentCount());
                numRow += 2;
            }
        }
    }

    private static void GenerateLaborCosts(Sheet sheet, List<WorkloadQuery> workload, Boolean IsAutumnSemester) {
        int numRow = 3;
        for (WorkloadQuery data : workload) {
            if (IsAutumnSemester(data.getSemesterDescr()) == IsAutumnSemester) {
                List<Double> LaborCosts = CalculationLaborCosts(data);
                int numCol = 8;
                for (Double cost : LaborCosts) {
                    setCellSheet(sheet, numRow, numCol, cost);
                    numCol++;
                }
                numRow += 2;
            }
        }
    }
}
