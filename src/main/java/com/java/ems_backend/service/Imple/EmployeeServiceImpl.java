package com.java.ems_backend.service.Imple;

import com.java.ems_backend.dto.EmployeeDto;
import com.java.ems_backend.entity.Employee;
import com.java.ems_backend.exception.ResourceNotFoundException;
import com.java.ems_backend.mapper.EmployeeMapper;
import com.java.ems_backend.repository.EmployeeRepository;
import com.java.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id" + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        // get employee from the repository
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id" + id));
        // update employee
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setMobileNumber(employeeDto.getMobileNumber());
        employee.setCountry(employeeDto.getCountry());
        employee.setGender(employeeDto.getGender());
        employee.setDateofbirth(employeeDto.getDateofbirth());
        employee.setPicture(employeeDto.getPicture());
        // save employee in the repository
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id" + id));
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDto> SearchEmployee(String query) {
        List<Employee> employees = employeeRepository.SearchEmployee(query);

        return employees.stream().map((x) -> EmployeeMapper.mapToEmployeeDto(x))
                .collect(Collectors.toUnmodifiableList());
    }
}
