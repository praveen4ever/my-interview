package com.interview.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("Should sort employees by their natural ordering")
    void shouldSortEmployeesByNaturalOrder() {
        List<Employee> sortedEmployees = employeeFilterSort.sortEmployee(employees);

        assertThat(sortedEmployees)
                .extracting(Employee::getEmployeeName)
                .containsExactly("Zara", "John", "Alex");
    }

    @Test
    @DisplayName("Should sort employees by salary")
    void shouldSortEmployeesBySalary() {
        List<Employee> sortedEmployees = employeeFilterSort.sortEmployeeBySalary(employees);

        assertThat(sortedEmployees)
                .extracting(Employee::getEmployeeName)
                .containsExactly("John", "Zara", "Alex");
    }

    @Test
    @DisplayName("Should return distinct departments")
    void shouldReturnDistinctDepartments() {
        List<String> distinctDepartments = employeeFilterSort.getDistinctDepartments(employees);

        assertThat(distinctDepartments)
                .containsExactly("Engineering", "HR");
    }

    @Test
    @DisplayName("Should count employees by department")
    void shouldCountEmployeesByDepartment() {
        Map<String, Integer> result = employeeFilterSort.countEmployeeByDept(employees);

        assertThat(result).isNotNull();
        assertThat(result)
                .containsEntry("Engineering", 1)
                .containsEntry("HR", 2);
    }
}
