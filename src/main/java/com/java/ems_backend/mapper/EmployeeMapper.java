package com.java.ems_backend.mapper;

import com.java.ems_backend.dto.EmployeeDto;
import com.java.ems_backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getMiddleName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getMobileNumber()
        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getMiddleName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getMobileNumber()
        );
    }
}
