package com.independent.crudoperations2.service;

import com.independent.crudoperations2.entity.Employee;
import com.independent.crudoperations2.repository.EmployeeRepository;
import com.independent.crudoperations2.requestmodel.EmployeeRequestModel;
import com.independent.crudoperations2.responsemodel.EmployeeResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel) {
        Employee employee = new Employee(employeeRequestModel.getId(), employeeRequestModel.getName(), employeeRequestModel.getSalary(), employeeRequestModel.getDepartment());
        employeeRepository.save(employee);
        Employee getSavedEmployee = employeeRepository.getById(employeeRequestModel.getId());
        return new EmployeeResponseModel(getSavedEmployee.getId(), getSavedEmployee.getName(), getSavedEmployee.getSalary(), getSavedEmployee.getDepartment());
    }
}
