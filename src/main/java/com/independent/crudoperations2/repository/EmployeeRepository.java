package com.independent.crudoperations2.repository;

import com.independent.crudoperations2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
