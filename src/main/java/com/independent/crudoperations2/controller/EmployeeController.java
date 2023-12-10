package com.independent.crudoperations2.controller;

import com.independent.crudoperations2.requestmodel.EmployeeRequestModel;
import com.independent.crudoperations2.responsemodel.EmployeeResponseModel;
import com.independent.crudoperations2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //CRUD:-Create,Read,Update,Delete


    @RequestMapping("/testing")
    public String test(@RequestParam String tester) {
        return tester + "Test API works";
    }

    @RequestMapping("/addEmployee")
    public EmployeeResponseModel add(@RequestBody EmployeeRequestModel empRequestModel) {
        return employeeService.addEmployee(empRequestModel);
    }

    @GetMapping("/getById/{id}")
    public EmployeeResponseModel getById(@PathVariable Integer id){
        return employeeService.getEmployee(id);
    }
    @GetMapping("/getByName/{name}")
    public List<EmployeeResponseModel> getByName(@PathVariable String name){
        return employeeService.getEmployee(name);
    }

    @DeleteMapping("/deleteEmployee")
    public String removeEmployee(@RequestParam int id){
        return employeeService.removeEmployee(id);
    }

    @PatchMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Map<String,Object> updates){
        return employeeService.updateEmployee(id,updates);

    }



}
