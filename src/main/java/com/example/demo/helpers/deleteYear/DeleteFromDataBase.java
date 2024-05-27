package com.example.demo.helpers.deleteYear;

import com.example.demo.models.DeleteData;
import com.example.demo.models.StudyYear;
import com.example.demo.services.*;
import jakarta.transaction.Transactional;

import java.util.List;

public class DeleteFromDataBase {
    final StudyYearService studyYearService;
    final StudentsGroupService studentsGroupService;
    final DisciplineService disciplineService;
    final WorkloadService workloadService;
    final WorkloadAssignService workloadAssignService;
    final DeleteDataService deleteDataService;

    public DeleteFromDataBase(StudyYearService studyYearService, StudentsGroupService studentsGroupService, DisciplineService disciplineService, WorkloadService workloadService, WorkloadAssignService workloadAssignService, DeleteDataService deleteData) {
        this.studyYearService = studyYearService;
        this.studentsGroupService = studentsGroupService;
        this.disciplineService = disciplineService;
        this.workloadService = workloadService;
        this.workloadAssignService = workloadAssignService;
        this.deleteDataService = deleteData;
    }

    @Transactional
    public void DeleteYear(Integer idYear) throws Exception {
        List<DeleteData> deleteData = getDataDelete(idYear);
        for (DeleteData data : deleteData) {
            System.out.println(data.getIdWorkloadAssign());
            workloadAssignService.delete(data.getIdWorkloadAssign());
            workloadService.delete(data.getIdWorkload());
            disciplineService.delete(data.getIdDiscipline());
        }
        Integer idGroupB = studentsGroupService.findIdByYearB(idYear);
        Integer idGroupM = studentsGroupService.findIdByYearM(idYear);
        studentsGroupService.delete(idGroupB);
        studentsGroupService.delete(idGroupM);
        studyYearService.delete(idYear);
    }

    public List<DeleteData> getDataDelete(Integer idYear) {
        return deleteDataService.getAll(idYear);
    }

    public StudyYear getDeleteYear() {
        return studyYearService.getMaxYear();
    }
}
