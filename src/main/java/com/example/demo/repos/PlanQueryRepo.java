package com.example.demo.repos;

import com.example.demo.models.PlanQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanQueryRepo extends JpaRepository<PlanQuery,Integer> {
    @Query(value = "SELECT employee.id, employee.employee_name, employee.contract_number, employee.rate, employee.birthday, working_position.descr AS working_position, academic_rank.descr AS academic_rank, academic_degree.descr AS academic_degree FROM working_position INNER JOIN (academic_rank INNER JOIN (academic_degree INNER JOIN employee ON academic_degree.id = employee.academic_degree) ON academic_rank.id = employee.academic_rank) ON working_position.id = employee.working_position WHERE employee.id = :id",nativeQuery = true)
    PlanQuery findTeacherById(@Param("id")Integer id);
}
