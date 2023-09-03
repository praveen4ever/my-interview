package com.interview.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFilterSort {

    public List<Employee> sortEmployee(List<Employee> input){
        return input.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
    }
}
