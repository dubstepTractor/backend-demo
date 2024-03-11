package com.example.demo.services;

import com.example.demo.models.Speciality;
import com.example.demo.repos.SpecialityRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService {
    private final SpecialityRepo specialityRepo;

    public SpecialityService(SpecialityRepo specialityRepo) {
        this.specialityRepo = specialityRepo;
    }

    public List<Speciality> getAll() {
        return specialityRepo.findAll();
    }
}
