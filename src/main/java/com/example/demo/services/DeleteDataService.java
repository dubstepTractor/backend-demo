package com.example.demo.services;

import com.example.demo.models.DeleteData;
import com.example.demo.repos.DeleteDataRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeleteDataService {
    private final DeleteDataRepo deleteDataRepo;

    public DeleteDataService(DeleteDataRepo deleteDataRepo) {
        this.deleteDataRepo = deleteDataRepo;
    }

    public List<DeleteData> getAll(Integer idYear) {
        List<DeleteData> data = deleteDataRepo.findDeleteDataByYear(idYear);
        for(DeleteData d : data){
            System.out.println(d.getIdWorkload());
        }
        return deleteDataRepo.findDeleteDataByYear(idYear);
    }
}
