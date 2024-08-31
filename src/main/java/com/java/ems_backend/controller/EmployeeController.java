package com.java.ems_backend.controller;


import com.java.ems_backend.dto.EmployeeDto;
import com.java.ems_backend.service.EmployeeService;
import jakarta.persistence.PostUpdate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Build addEmployee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    // Build GetAll All employee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtoList);
    }

    // Build Update employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted Successfully", HttpStatus.OK);
    }
    // Build Search Employee REST API
    @GetMapping("/search")
    public ResponseEntity<List<EmployeeDto>> getEmployeeByQuery(@RequestParam("query") String query) {
        List<EmployeeDto> searchEmployeeDtoList = employeeService.SearchEmployee(query);
        return ResponseEntity.ok(searchEmployeeDtoList);
    }
}

