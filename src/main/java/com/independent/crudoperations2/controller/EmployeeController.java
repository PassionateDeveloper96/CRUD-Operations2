package com.independent.crudoperations2.controller;

import com.independent.crudoperations2.requestmodel.EmployeeRequestModel;
import com.independent.crudoperations2.responsemodel.EmployeeResponseModel;
import com.independent.crudoperations2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/testing")
    public String test() {
        return "Test API works";
    }

    @RequestMapping("/addEmployee")
    public EmployeeResponseModel add(@RequestBody EmployeeRequestModel empRequestModel) {
        return employeeService.addEmployee(empRequestModel);
    }
}
