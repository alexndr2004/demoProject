package com.demoproject.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private int id;
    private String name;
    private Employee employee;
    private boolean change;
    private boolean synch;
    private double performance;

    public Department(String name, Employee employee, boolean change, boolean synch) {
        this.name = name;
        this.employee = employee;
        this.change = change;
        this.synch = synch;
    }

    public Department(int id, String name, Employee employee, boolean change, boolean synch) {
        this.id = id;
        this.name = name;
        this.employee = employee;
        this.change = change;
        this.synch = synch;
    }
}