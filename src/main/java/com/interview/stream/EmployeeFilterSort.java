package com.interview.stream;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class provides methods to manipulate Employee objects.
 */
@Service
public class EmployeeFilterSort {

    /**
     * Sorts employees based on their natural ordering.
     *
     * @param employees List of employees to sort
     * @return Sorted list of employees
     */
    public List<Employee> sortEmployee(List<Employee> employees) {
        return List.copyOf(employees.stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    /**
     * Sorts employees based on their salary.
     *
     * @param employees List of employees to sort
     * @return Sorted list of employees by salary
     */
    public List<Employee> sortEmployeeBySalary(List<Employee> employees) {
        return List.copyOf(employees.stream()
                .sorted(Comparator.comparing(Employee::getEmployeeSalary))
                .collect(Collectors.toList()));
    }

    /**
     * Retrieves distinct department names from the list of employees.
     *
     * @param employees List of employees
     * @return List of distinct departments
     */
    public List<String> getDistinctDepartments(List<Employee> employees) {
        return List.copyOf(employees.stream()
                .map(Employee::getEmployeeDept)
                .distinct()
                .collect(Collectors.toList()));
    }

    /**
     * Counts the number of employees in each department.
     *
     * @param employees List of employees
     * @return Map of department names to count of employees in that department
     */
    public Map<String, Integer> countEmployeeByDept(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getEmployeeDept,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                Long::intValue
                        )
                ));
    }

    /**
     * Increment the salary of employees in a specific department by a given percentage.
     *
     * @param employees  The list of Employee objects.
     * @param dept       The department name for which the salary increment is applicable.
     * @param percentage The percentage by which to increase the salary.
     * @return A new list containing Employee objects with updated salaries.
     */
    public List<Employee> incrementSalaryByDept(List<Employee> employees, String dept,int percentage){
        return List.copyOf(employees.stream()
                .map(a-> {
                    if(a.getEmployeeDept().equals(dept)){
                        a.setEmployeeSalary(a.getEmployeeSalary()+(a.getEmployeeSalary()*percentage/100));
                    }
                    return a;
                })
                .collect(Collectors.toList()));
    }
}
