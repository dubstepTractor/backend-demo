package com.example.demo.repos;

import com.example.demo.models.DeleteData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeleteDataRepo extends JpaRepository<DeleteData, Integer> {

    @Query(value = "SELECT study_year.study_year, study_year.id as id_year, workload.id as id_workload, workload_assign.id as id_workload_assign, discipline.id as id_discipline FROM (study_year INNER JOIN (study_form INNER JOIN ((faculty INNER JOIN speciality ON faculty.id = speciality.faculty) INNER JOIN (semester INNER JOIN (qualification INNER JOIN (discipline INNER JOIN (workload INNER JOIN students_group ON workload.id_group = students_group.ID) ON discipline.id = workload.discipline) ON qualification.id = students_group.qualification) ON semester.id = workload.semester) ON speciality.id = students_group.speciality) ON study_form.id = students_group.study_form) ON study_year.id = workload.study_year) INNER JOIN workload_assign ON workload.id = workload_assign.workload WHERE (((study_year.ID)=:idYear))", nativeQuery = true)
    List<DeleteData> findDeleteDataByYear(@Param("idYear") Integer idYear);
}
