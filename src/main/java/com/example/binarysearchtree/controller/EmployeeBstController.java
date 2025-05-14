package com.example.binarysearchtree.controller;

import com.example.binarysearchtree.model.Employee;
import com.example.binarysearchtree.service.EmployeeBstService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeBstController {

    private final EmployeeBstService employeeService;

    public EmployeeBstController(EmployeeBstService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee added successfully";
    }

    @GetMapping("/exists/{id}")
    public boolean employeeExists(@PathVariable Integer id) {
        return employeeService.employeeExists(id);
    }

    @GetMapping("/sorted")
    public List<Employee> getAllEmployeesSorted() {
        return employeeService.getAllEmployeesSorted();
    }

    @GetMapping("/tree")
    public String getTreeStructure() {
        return employeeService.getTreeStructure();
    }
}