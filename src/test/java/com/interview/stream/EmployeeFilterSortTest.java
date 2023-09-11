package com.interview.stream;

import org.assertj.core.groups.Tuple;
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

    @Test
    @DisplayName("Should increment employees by department")
    void shouldIncrementSalariesByDept(){
        List<Employee> updatedEmployees = employeeFilterSort.incrementSalaryByDept(employees,"HR",2);
        assertThat(updatedEmployees).isNotNull();
        assertThat(updatedEmployees)
                .extracting(Employee::getEmployeeName,Employee::getEmployeeSalary)
                .contains(
                        Tuple.tuple("John",51000),
                        Tuple.tuple("Alex",70000),
                        Tuple.tuple("Zara",61200)
                );
    }


    @Test
    @DisplayName("Should not increment employees by department")
    void shouldNotIncrementSalariesByDept(){
        List<Employee> updatedEmployees = employeeFilterSort.incrementSalaryByDept(employees,"Developer",1);
        assertThat(updatedEmployees).isNotNull();
        assertThat(updatedEmployees)
                .extracting(Employee::getEmployeeName,Employee::getEmployeeSalary)
                .contains(
                        Tuple.tuple("John",50000),
                        Tuple.tuple("Alex",70000),
                        Tuple.tuple("Zara",60000)
                );
    }
}
