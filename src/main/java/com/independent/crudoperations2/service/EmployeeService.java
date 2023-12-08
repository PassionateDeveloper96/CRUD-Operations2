package com.independent.crudoperations2.service;

import com.independent.crudoperations2.entity.Employee;
import com.independent.crudoperations2.repository.EmployeeRepository;
import com.independent.crudoperations2.requestmodel.EmployeeRequestModel;
import com.independent.crudoperations2.responsemodel.EmployeeResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //Add Employee Logic
    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel) {
        Employee employee = new Employee(employeeRequestModel.getId(), employeeRequestModel.getName(), employeeRequestModel.getSalary(), employeeRequestModel.getDepartment());
        employeeRepository.save(employee);
        Employee getSavedEmployee = employeeRepository.getById(employeeRequestModel.getId());
        return new EmployeeResponseModel(getSavedEmployee.getId(), getSavedEmployee.getName(), getSavedEmployee.getSalary(), getSavedEmployee.getDepartment());
    }

    //Get Employee ID.
    public EmployeeResponseModel getEmployee(Integer id){
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee=optionalEmployee.get();
            return new EmployeeResponseModel(employee.getId(), employee.getName(), employee.getSalary(), employee.getDepartment());
        }
        else{
            return null;
        }
    }
    public List<EmployeeResponseModel> getEmployee(String name){
        List<Employee> listEmployee=employeeRepository.findByName(name);
        List<EmployeeResponseModel> employeeResponseModelList=new ArrayList<>();
        if(listEmployee!=null && !listEmployee.isEmpty()){
            for(Employee employees:listEmployee){
                employeeResponseModelList.add(new EmployeeResponseModel(employees.getId(),employees.getName(),employees.getSalary(),employees.getDepartment()));
            }
            return employeeResponseModelList;
        }
        else{
            return null;
        }
    }

    public String updateEmployee(int id, Map<String,Object> updates){

        Employee existingEmployee=employeeRepository.findById(id).orElse(null);
        if(existingEmployee==null){
            return "Employee not Found";
        }

        updates.forEach((key,value)->{
            switch(key){
                case "name":
                    existingEmployee.setName((String) value);
                    break;
                case "sal":
                    existingEmployee.setSalary((int) value);
                    break;
                case "designation":
                    existingEmployee.setDepartment((String) value);
                    break;

            }
        });
        employeeRepository.save(existingEmployee);
        return "employee updated successully";


    }
    public String removeEmployee(int id){
        employeeRepository.deleteById(id);
        return "delete Success";
    }

}



/*public EmployeeResponseModel getEmployee(String name){
        List<Employee> listEmployee=employeeRepository.findByName(name);
        if(listEmployee!=null && !listEmployee.isEmpty()) {

            for (Employee employee : listEmployee) {
                return new EmployeeResponseModel(employee.getId(), employee.getName(), employee.getSalary(), employee.getDepartment());
            }

        }
        else{
            return null;
        }
    }
    //for (int i = 0; i < listEmployee.size(); i++) {
            //Employee employee = listEmployee.get(i);
            //return new EmployeeResponseModel(employee.getId(), employee.getName(), employee.getSalary(), employee.getDepartment());
            // }
    */
