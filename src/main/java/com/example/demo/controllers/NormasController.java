package com.example.demo.controllers;

import com.example.demo.models.Normas;
import com.example.demo.services.NormasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class NormasController {
    private final NormasService normasService;

    public NormasController(NormasService normasService) {
        this.normasService = normasService;
    }

    @GetMapping("/normas")
    public ResponseEntity<List<Normas>> getDisciplines() {
        List<Normas> data = normasService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
