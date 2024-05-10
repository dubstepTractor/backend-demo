package com.example.demo.helpers.plan;

import com.example.demo.models.PlanQuery;
import com.example.demo.models.WorkloadQuery;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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

    private static List<Double> CalculationLaborCosts(WorkloadQuery workload) {
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

}
