package com.independent.crudoperations2.responsemodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModel {

    private int id;
    private String name;
    private int Salary;
    private String department;
}
