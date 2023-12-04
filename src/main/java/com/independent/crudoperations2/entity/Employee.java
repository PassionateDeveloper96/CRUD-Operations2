package com.independent.crudoperations2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee_table")
public class Employee {
    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;
    private String department;
}
