package com.example.demo.helpers.writer;

import com.example.demo.helpers.deleteYear.DeleteFromDataBase;
import com.example.demo.models.*;
import com.example.demo.services.*;
import org.apache.poi.ss.usermodel.Workbook;

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
    final DeleteFromDataBase deleteFromDataBase;
    final SpecialityService specialityService;

    Integer idNewYear = -1;
    Integer idNewGroupB = -1;
    Integer idNewGroupM = -1;
    Integer idNewGroupBI = -1;
    List<Integer> idsNewDisciplines = new ArrayList<Integer>();
    Map<Integer, Integer> idsNewWorkload = new HashMap<>();
    List<Integer> getIdsNewWorkloadAssign = new ArrayList<Integer>();

    public WriteDataBase(StudyYearService studyYearService, StudentsGroupService studentsGroupService, DisciplineService disciplineService, WorkloadService workloadService, WorkloadAssignService workloadAssignService, EmployeeService employeeService, DeleteDataService deleteDataService, SpecialityService specialityService) {
        this.studyYearService = studyYearService;
        this.studentsGroupService = studentsGroupService;
        this.disciplineService = disciplineService;
        this.workloadService = workloadService;
        this.workloadAssignService = workloadAssignService;
        this.employeeService = employeeService;
        deleteFromDataBase = new DeleteFromDataBase(studyYearService,studentsGroupService,disciplineService,workloadService,workloadAssignService,deleteDataService);
        this.specialityService = specialityService;
    }

    public void fillDataBase(Workbook workbook, Integer year) throws Exception {
        idNewYear = -1;
        idNewGroupB = -1;
        idNewGroupM = -1;
        idNewGroupBI = -1;
        idsNewDisciplines = new ArrayList<Integer>();
        idsNewWorkload = new HashMap<>();
        List<Integer> getIdsNewWorkloadAssign = new ArrayList<Integer>();
        List<Employee> employees = employeeService.getAll();
        List<Speciality> specialities = specialityService.getAll();
        // Считываем входной файл
        List<InputFile> listValue = readFile(workbook, employees, specialities, year);
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
            deleteFromDataBase.DeleteYear(idNewYear);
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
                Integer group = getGroup(year, curr.getSemesterDescr(), curr.getIdSpeciality());
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
                    data.getEkz(), data.getCons(), data.getKrR(),
                    data.getUcPract(), data.getPrPract(), data.getPredDPract());
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
        String newNameB2 = "ПИН.ИИ " + (year % 100) + "06";
        Integer studentCountB = findCountStudent(listValue, 1, 2);
        Integer subGroupCountB = findSubGroupCount(listValue, 1,2);
        Integer studentCountM = findCountStudent(listValue, 9,1);
        Integer subGroupCountM = findSubGroupCount(listValue, 9,1);
        Integer studentCountB2 = findCountStudent(listValue, 1,7);
        Integer subGroupCountB2 = findSubGroupCount(listValue, 1,7);
        if (studentCountB < 0 || studentCountM < 0 || subGroupCountB < 0 || subGroupCountM < 0) {
            throw new Exception("Неправильное количество студентов или количество подгрупп");
        }
        Integer idYear = studyYearService.findIdYear(year);
        if (idYear < 0) {
            throw new Exception("Ошибка при создании учебного года. Проверьте данные.");
        }
        StudentsGroup studentsGroupB = new StudentsGroup(newNameB, 2, 1, 1, studentCountB, idYear, subGroupCountB);
        StudentsGroup studentsGroupM = new StudentsGroup(newNameM, 1, 3, 1, studentCountM, idYear, subGroupCountM);
        if (studentCountB2 > 0 && subGroupCountB2 > 0) {
            StudentsGroup studentsGroupB2 = new StudentsGroup(newNameB2, 7, 1, 1, studentCountB2, idYear, subGroupCountB2);
            idNewGroupBI = studentsGroupService.add(studentsGroupB2);
        }
        idNewGroupB = studentsGroupService.add(studentsGroupB);
        if (idNewGroupB == -1) {
            throw new Exception("Ошибка при добавлении новой учебной группы");
        }
        idNewGroupM = studentsGroupService.add(studentsGroupM);
        if (idNewGroupM == -1) {
            throw new Exception("Ошибка при добавлении новой учебной группы");
        }
        //Обновление данных учебных групп за прошлые года
        updateDataGroup(year,listValue);
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
        if (idNewYear == -1) {
            throw new Exception("Ошибка при добавлении нового учебного года");
        }
    }

    private void updateDataGroup(Integer year, List<InputFile> listValue) throws Exception {
        InputFile valueFor2Course = getInputFileBySemester(listValue,3,2);
        InputFile valueFor3Course = getInputFileBySemester(listValue,5,2);
        InputFile valueFor4Course = getInputFileBySemester(listValue,7,2);
        InputFile valueFor2CourseM = getInputFileBySemester(listValue,11,1);

        InputFile valueFor2CourseI = getInputFileBySemester(listValue,3,7);
        InputFile valueFor3CourseI = getInputFileBySemester(listValue,5,7);
        InputFile valueFor4CourseI = getInputFileBySemester(listValue,7,7);

        if(!valueFor2Course.equals(null)){
            studentsGroupService.updateField(valueFor2Course.StudentCount, valueFor2Course.SubGroupCount,studyYearService.findIdYear(year-1),valueFor2Course.getIdSpeciality());
        }
        if(!valueFor3Course.equals(null)){
            studentsGroupService.updateField(valueFor3Course.StudentCount, valueFor3Course.SubGroupCount,studyYearService.findIdYear(year-2),valueFor3Course.getIdSpeciality());
        }
        if(!valueFor4Course.equals(null)) {
            studentsGroupService.updateField(valueFor4Course.StudentCount, valueFor4Course.SubGroupCount, studyYearService.findIdYear(year - 3),valueFor4Course.getIdSpeciality());
        }
        if(!valueFor2CourseM.equals(null)) {
            studentsGroupService.updateField(valueFor2CourseM.StudentCount, valueFor2CourseM.SubGroupCount, studyYearService.findIdYear(year - 1), valueFor2CourseM.getIdSpeciality());
        }
        if(valueFor2CourseI != null){
            studentsGroupService.updateField(valueFor2CourseI.StudentCount, valueFor2CourseI.SubGroupCount, studyYearService.findIdYear(year - 1),valueFor2CourseI.getIdSpeciality());
        }
        if(valueFor3CourseI != null){
            studentsGroupService.updateField(valueFor3CourseI.StudentCount, valueFor3CourseI.SubGroupCount, studyYearService.findIdYear(year - 1), valueFor3CourseI.getIdSpeciality());
        }
        if(valueFor4CourseI !=null){
            studentsGroupService.updateField(valueFor4CourseI.StudentCount, valueFor4CourseI.SubGroupCount, studyYearService.findIdYear(year - 1), valueFor4CourseI.getIdSpeciality());
        }
    }

    private InputFile getInputFileBySemester(List<InputFile> listValue, Integer semester, Integer idSpeciality){
        for(InputFile value : listValue){
            if(value.getSemesterDescr().equals(semester) && value.getIdSpeciality().equals(idSpeciality))
                return value;
        }
        return null;
    }

    private Integer getGroup(Integer year, Integer semester, Integer idSpeciality) throws Exception {
        switch (semester) {
            case 1:
            case 2:
                Integer course1 = studentsGroupService.findIdByYear(studyYearService.findIdYear(year), idSpeciality);
                if (course1 < 0) {
                    throw new Exception("Не хватает учебного года для заполнения нагрузки");
                }
                return course1;
            case 3:
            case 4:
                Integer course2 = studentsGroupService.findIdByYear(studyYearService.findIdYear(year - 1), idSpeciality);
                if (course2 < 0) {
                    throw new Exception("Не хватает учебного года для заполнения нагрузки");
                }
                return course2;
            case 5:
            case 6:
                Integer course3 = studentsGroupService.findIdByYear(studyYearService.findIdYear(year - 2), idSpeciality);
                if (course3 < 0) {
                    throw new Exception("Не хватает учебного года для заполнения нагрузки");
                }
                return course3;
            case 7:
            case 8:
                Integer course4 = studentsGroupService.findIdByYear(studyYearService.findIdYear(year - 3),idSpeciality);
                if (course4 < 0) {
                    throw new Exception("Не хватает учебного года для заполнения нагрузки");
                }
                return course4;
            case 9:
            case 10:
                Integer mag1 = studentsGroupService.findIdByYear(studyYearService.findIdYear(year), idSpeciality);
                if (mag1 < 0) {
                    throw new Exception("Не хватает учебного года для заполнения нагрузки");
                }
                return mag1;
            case 11:
            case 12:
                Integer mag2 = studentsGroupService.findIdByYear(studyYearService.findIdYear(year - 1), idSpeciality);
                if (mag2 < 0) {
                    throw new Exception("Не хватает учебного года для заполнения нагрузки");
                }
                return mag2;
            default:
                return -1;
        }
    }

}
