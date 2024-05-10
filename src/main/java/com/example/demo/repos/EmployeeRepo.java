package com.example.demo.repos;

import com.example.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM employee WHERE id = :id", nativeQuery = true)
    Employee findEmployeeById(@Param("id") Integer id);
}
