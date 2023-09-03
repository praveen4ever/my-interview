package com.interview.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class provides methods to manipulate Employee objects.
 */
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
}
