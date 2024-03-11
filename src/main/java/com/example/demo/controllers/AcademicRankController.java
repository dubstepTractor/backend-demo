package com.example.demo.controllers;

import com.example.demo.models.AcademicRank;
import com.example.demo.services.AcademicRankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class AcademicRankController {
    private final AcademicRankService academicRankService;

    public AcademicRankController(AcademicRankService academicRankService) {
        this.academicRankService = academicRankService;
    }

    @GetMapping("/academic-rank")
    public ResponseEntity<List<AcademicRank>> getAcademicRanks() {
        List<AcademicRank> academicRanks = academicRankService.getAll();
        return new ResponseEntity<>(academicRanks, HttpStatus.OK);
    }
}
