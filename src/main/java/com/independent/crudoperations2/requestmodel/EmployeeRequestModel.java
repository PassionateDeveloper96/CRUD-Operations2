package com.independent.crudoperations2.requestmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeRequestModel {

    private int id;
    private String name;
    private String department;
    private int salary;
}
