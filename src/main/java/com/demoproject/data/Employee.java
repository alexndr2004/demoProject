package com.demoproject.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    protected int id;
    protected String name;
    protected String surname;
    protected int hours;
    protected int begin;
    protected int endWork;
    protected Role role;
    protected Preference preference;
    protected boolean synch;
    protected double performance;
    protected double percent;
    protected double salary;

    public Employee(String name, String surname, int hours, int begin, Role role, Preference preference, boolean synch,
                    double percent) {
        this.name = name;
        this.surname = surname;
        this.hours = hours;
        this.begin = begin;
        this.role = role;
        this.preference = preference;
        this.synch = synch;
        this.percent = percent;
    }

    public Employee(int id, String name, String surname, int hours, int begin, Role role, Preference preference, boolean synch,
                    double percent) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.hours = hours;
        this.begin = begin;
        this.role = role;
        this.preference = preference;
        this.synch = synch;
        this.percent = percent;
    }
}