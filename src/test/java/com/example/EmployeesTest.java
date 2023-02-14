package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesTest {
private Employees employeeService;

    @BeforeEach
    void clearEmployeeService() {
        employeeService = null;
    }

    @Test
    void payEmployees() {
        var employeeRepository = new EmployeeRepositoryStub();
        var bankService = new BankServiceSpy();
        employeeService = new Employees(employeeRepository, bankService);

        var result = employeeService.payEmployees();
        assertEquals(3, result);

        var secondResult = employeeService.payEmployees();
        assertEquals(0, secondResult);
    }

    @Test
    void payEmployees2() {
        var employeeRepository = mock(EmployeeRepository.class);
        var bankService = spy(BankService.class);
        var employees = List.of(
                new Employee("1", 25000),
                new Employee("2", 35000),
                new Employee("3", 45000),
                new Employee("4", 50765)
        );
        when(employeeRepository.findAll()).thenReturn(employees);
        employeeService = new Employees(employeeRepository, bankService);

        var result = employeeService.payEmployees();
        assertEquals(4, result);

        var secondResult = employeeService.payEmployees();
        assertEquals(0, secondResult);
    }
}
