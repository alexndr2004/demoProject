package com.demoproject.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    private int id;
    private String name;
    private int countPerson;
    private Department department;

    public Company(String name, int countPerson, Department department) {
        this.name = name;
        this.countPerson = countPerson;
        this.department = department;
    }
}