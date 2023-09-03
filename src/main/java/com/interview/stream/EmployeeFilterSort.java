package com.interview.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeFilterSort {

    public List<Employee> sortEmployee(List<Employee> employees) {
        return employees
                .stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Employee> sortEmployeeBySalary(List<Employee> employees) {
        return employees
                .stream()
                .sorted(Comparator.comparing(Employee::getEmployeeSalary))
                .collect(Collectors.toList());
    }

    public List<String> findListOfDepts(List<Employee> employees){
        return employees
                .stream()
                .map(Employee::getEmployeeDept)
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, Integer> countEmployeeByDept(List<Employee> employees) {
        return employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getEmployeeDept,
                                Collectors.collectingAndThen(
                                        Collectors.counting(),
                                        Long::intValue
                                )
                        )
                );
    }
}
