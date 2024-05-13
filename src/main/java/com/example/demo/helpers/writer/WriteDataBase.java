package com.example.demo.helpers.writer;

import com.example.demo.models.*;
import com.example.demo.services.*;
import org.apache.poi.ss.formula.atp.Switch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.helpers.WorkbookHelpers.findCountStudent;
import static com.example.demo.helpers.WorkbookHelpers.findSubGroupCount;
import static com.example.demo.helpers.writer.ReadFileExcel.readFile;

public class WriteDataBase {
    final StudyYearService studyYearService;
    final StudentsGroupService studentsGroupService;
    final DisciplineService disciplineService;
    final WorkloadService workloadService;
    final WorkloadAssignService workloadAssignService;
    final EmployeeService employeeService;

    Integer idNewYear = -1;
    Integer idNewGroupB = -1;
    Integer idNewGroupM = -1;
    List<Integer> idsNewDisciplines = new ArrayList<Integer>();
    Map<Integer, Integer> idsNewWorkload = new HashMap<>();
    List<Integer> getIdsNewWorkloadAssign = new ArrayList<Integer>();

    public WriteDataBase(StudyYearService studyYearService, StudentsGroupService studentsGroupService, DisciplineService disciplineService, WorkloadService workloadService, WorkloadAssignService workloadAssignService, EmployeeService employeeService) {
        this.studyYearService = studyYearService;
        this.studentsGroupService = studentsGroupService;
        this.disciplineService = disciplineService;
        this.workloadService = workloadService;
        this.workloadAssignService = workloadAssignService;
        this.employeeService = employeeService;
    }

    public void fillDataBase(String filePath, Integer year) throws Exception {
        idNewYear = -1;
        idNewGroupB = -1;
        idNewGroupM = -1;
        idsNewDisciplines = new ArrayList<Integer>();
        idsNewWorkload = new HashMap<>();
        List<Integer> getIdsNewWorkloadAssign = new ArrayList<Integer>();
        List<Employee> employees = employeeService.getAll();
        List<InputFile> listValue = readFile(filePath, employees, year);
        try {
            //Заполнение нового учебного года
            fillYear(year);
            //Добавление новой группы
            fillGroup(year, listValue);
            //Добавление дисциплин
            fillDisciplines(listValue);
            //Добавление Workload
            fillWorkload(listValue, year);
            //Добавление WorkloadAssign
            fillWorkloadAssign(listValue);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    private void fillWorkloadAssign(List<InputFile> listValue) throws Exception {
        for (Map.Entry<Integer, Integer> entry : idsNewWorkload.entrySet()) {
            Integer numList = entry.getKey();
            Integer idWorkload = entry.getValue();
            WorkloadAssign workloadAssign = new WorkloadAssign(
                    listValue.get(numList).getEmployee(), idWorkload, listValue.get(numList).getStudentCount().toString(),
                    "", listValue.get(numList).getContract());
            Integer idWork = workloadAssignService.add(workloadAssign);
            if (idWork == null) {
                throw new Exception("Ошибка при добавлении нагрузки");
            }
        }
    }

    private void fillWorkload(List<InputFile> listValue, Integer year) throws Exception {
        int count = 0;
        for (Integer idDiscipline : idsNewDisciplines) {
            InputFile curr = listValue.get(count);
            if (curr.getEmployee() != -1) {
                Integer group = getGroup(year, curr.getSemesterDescr());
                if (group < 0) {
                    throw new Exception("Ошибка при добавлении нагрузки");
                }
                Workload workload = new Workload(idDiscipline, idNewYear, curr.getSemesterDescr(), group);
                Integer newId = workloadService.add(workload);
                if (newId == null) {
                    throw new Exception("Ошибка при добавлении нагрузки");
                }
                idsNewWorkload.put(count, newId);
            }
            count++;
        }
    }

    private void fillDisciplines(List<InputFile> listValue) throws Exception {
        for (InputFile data : listValue) {
            Discipline newDiscipline = new Discipline(
                    data.getDescr(), data.getLectureCount(),
                    data.getPracticeCount(), data.getLabCount(),
                    data.getKR(), data.getKP(), data.getZach(),
                    data.getEkz(), data.getCons(), data.getKrR());
            Integer id = disciplineService.add(newDiscipline);
            if (id == null) {
                throw new Exception("Ошибка при добавлении новых предметов");
            }
            idsNewDisciplines.add(id);
        }
    }

    private void fillGroup(Integer year, List<InputFile> listValue) throws Exception {
        String newNameB = "ПИН " + (year % 100) + "06";
        String newNameM = "РПС " + year;
        Integer studentCountB = findCountStudent(listValue, 1);
        Integer subGroupCountB = findSubGroupCount(listValue, 1);
        Integer studentCountM = findCountStudent(listValue, 9);
        Integer subGroupCountM = findSubGroupCount(listValue, 9);
        if (studentCountB < 0 || studentCountM < 0 || subGroupCountB < 0 || subGroupCountM < 0) {
            throw new Exception("Неправильное количество студентов или количество подгрупп");
        }
        Integer idYear = studyYearService.findIdYear(year);
        if (idYear < 0) {
            throw new Exception("Ошибка при создании учебного года. Проверьте данные.");
        }
        StudentsGroup studentsGroupB = new StudentsGroup(newNameB, 2, 1, 1, studentCountB, idYear, subGroupCountB);
        StudentsGroup studentsGroupM = new StudentsGroup(newNameM, 1, 3, 1, studentCountM, idYear, subGroupCountM);
        idNewGroupB = studentsGroupService.add(studentsGroupB);
        if (idNewGroupB == -1) {
            throw new Exception("Ошибка при добавлении новой учебной группы");
        }
        idNewGroupM = studentsGroupService.add(studentsGroupM);
        if (idNewGroupM == -1) {
            throw new Exception("Ошибка при добавлении новой учебной группы");
        }
    }

    private void fillYear(Integer year) throws Exception {
        List<StudyYear> years = studyYearService.getAll();
        for (StudyYear sy : years) {
            if (sy.getStudyYear().equals(year)) {
                throw new Exception("Такой учебный год уже есть!");
            }
        }
        StudyYear newYear = new StudyYear(year);
        idNewYear = studyYearService.add(newYear);
        System.out.println("idNewYear " + idNewYear);
        if (idNewYear == -1) {
            throw new Exception("Ошибка при добавлении нового учебного года");
        }
    }

    private Integer getGroup(Integer year, Integer semester) throws Exception {
        Integer course1 = studentsGroupService.findIdByYearB(studyYearService.findIdYear(year));
        Integer course2 = studentsGroupService.findIdByYearB(studyYearService.findIdYear(year - 1));
        Integer course3 = studentsGroupService.findIdByYearB(studyYearService.findIdYear(year - 2));
        Integer course4 = studentsGroupService.findIdByYearB(studyYearService.findIdYear(year - 3));
        Integer mag1 = studentsGroupService.findIdByYearM(studyYearService.findIdYear(year));
        Integer mag2 = studentsGroupService.findIdByYearM(studyYearService.findIdYear(year - 1));
        if (course1 < 0 || course2 < 0 || course3 < 0 || course4 < 0 || mag1 < 0 || mag2 < 0) {
            throw new Exception("Не хватает учебного года для заполнения нагрузки");
        }
        switch (semester) {
            case 1:
            case 2:
                return course1;
            case 3:
            case 4:
                return course2;
            case 5:
            case 6:
                return course3;
            case 7:
            case 8:
                return course4;
            case 9:
            case 10:
                return mag1;
            case 11:
            case 12:
                return mag2;
            default:
                return -1;
        }
    }

}
