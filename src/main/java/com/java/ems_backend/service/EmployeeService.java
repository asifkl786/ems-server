package com.java.ems_backend.service;

import com.java.ems_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long id , EmployeeDto employeeDto);
    void deleteEmployee(Long id);
    List<EmployeeDto> SearchEmployee(String query);
}
