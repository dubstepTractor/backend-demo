package com.example.demo.controllers;

import com.example.demo.models.Speciality;
import com.example.demo.services.SpecialityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class SpecialityController {
    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping("/speciality")
    public ResponseEntity<List<Speciality>> getDisciplines() {
        List<Speciality> data = specialityService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
