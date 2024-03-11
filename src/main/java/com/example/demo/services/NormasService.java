package com.example.demo.services;

import com.example.demo.models.Normas;
import com.example.demo.repos.NormasRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormasService {
    private final NormasRepo normasRepo;

    public NormasService(NormasRepo normasRepo) {
        this.normasRepo = normasRepo;
    }

    public List<Normas> getAll() {
        return normasRepo.findAll();
    }
}
