package com.interview.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Employee implements Comparable<Employee>{
    private int employeeId;
    private String employeeName;
    private String employeeDept;
    private int employeeSalary;


    @Override
    public int compareTo(Employee o) {
        return o.getEmployeeName().compareTo(this.employeeName);
    }
}
