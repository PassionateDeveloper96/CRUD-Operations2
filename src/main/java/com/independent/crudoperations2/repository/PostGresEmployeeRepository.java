package com.independent.crudoperations2.repository;

import com.independent.crudoperations2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostGresEmployeeRepository extends JpaRepository<Employee,Integer> {
}
