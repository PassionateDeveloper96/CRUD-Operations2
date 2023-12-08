package com.independent.crudoperations2.repository;

import com.independent.crudoperations2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("SELECT e from Employee e where e.name=?1 ")
    List<Employee> findByName(String name);
}
