package com.example;

import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {

    private static List<Employee> employees = List.of(
            new Employee("1", 25000),
            new Employee("2", 35000),
            new Employee("3", 45000)
    );
    public List<Employee> findAll() {
        return employees;
    }
    public Employee save(Employee e) {
        return new Employee("1", 25000);
    }
}
