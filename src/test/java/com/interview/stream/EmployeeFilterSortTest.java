package com.interview.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeFilterSortTest {

    private EmployeeFilterSort employeeFilterSort;
    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        employeeFilterSort = new EmployeeFilterSort();
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Alex", "Engineering", 70000));
        employees.add(new Employee(2, "John", "HR", 50000));
        employees.add(new Employee(3, "Zara", "HR", 60000));
    }

    @Test
    void sortEmployee() {
        List<Employee> sortedEmployees = employeeFilterSort.sortEmployee(employees);

        // Validate the sorting logic
        assertEquals("Zara", sortedEmployees.get(0).getEmployeeName());
        assertEquals("John", sortedEmployees.get(1).getEmployeeName());
        assertEquals("Alex", sortedEmployees.get(2).getEmployeeName());
    }

    @Test
    void sortEmployeeBySalary() {
        List<Employee> sortedEmployees = employeeFilterSort.sortEmployeeBySalary(employees);

        // Validate the sorting logic
        assertEquals("John", sortedEmployees.get(0).getEmployeeName());
        assertEquals("Zara", sortedEmployees.get(1).getEmployeeName());
        assertEquals("Alex", sortedEmployees.get(2).getEmployeeName());
    }

    @Test
    void countEmployeeByDept() {
        Map<String, Integer> result = employeeFilterSort.countEmployeeByDept(employees);
        assertThat(result).isNotNull();
        assertThat(result.get("Engineering")).isEqualTo(1);
        assertThat(result.get("HR")).isEqualTo(2);
    }
}
