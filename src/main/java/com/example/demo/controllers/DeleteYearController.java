package com.example.demo.controllers;


import com.example.demo.helpers.deleteYear.DeleteFromDataBase;
import com.example.demo.models.DeleteData;
import com.example.demo.models.StudyYear;
import com.example.demo.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/database")
public class DeleteYearController {
    private final DeleteFromDataBase deleteFromDataBase;

    public DeleteYearController(StudyYearService studyYearService, StudentsGroupService studentsGroupService, DisciplineService disciplineService, WorkloadService workloadService, WorkloadAssignService workloadAssignService, DeleteDataService deleteDataService) {
        this.deleteFromDataBase = new DeleteFromDataBase(studyYearService, studentsGroupService, disciplineService, workloadService, workloadAssignService, deleteDataService);
    }

    @GetMapping("/data-delete")
    public ResponseEntity<List<DeleteData>> getDataDelete(@RequestParam("id") Integer id) {
        List<DeleteData> data = deleteFromDataBase.getDataDelete(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/find-delete-year")
    public ResponseEntity<StudyYear> getDeleteYear() {
        return new ResponseEntity<>(deleteFromDataBase.getDeleteYear(), HttpStatus.OK);
    }

    @GetMapping("/delete-year")
    public ResponseEntity<String> deleteYear() {
        try {
            StudyYear year = deleteFromDataBase.getDeleteYear();
            deleteFromDataBase.DeleteYear(year.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
