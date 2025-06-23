package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Iterable<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
    }

    public Employee updateEmployee(Long id, Employee updated) {
        Employee e1 = getEmployeeById(id);
        e1.setFirstName(updated.getFirstName());
        e1.setLastName(updated.getLastName());
        e1.setEmail(updated.getEmail());
        e1.setDepartment(updated.getDepartment());
        e1.setPosition(updated.getPosition());
        e1.setSalary(updated.getSalary());
        return repository.save(e1);
    }

    public void deleteEmployee(Long id) {
        Employee emp = getEmployeeById(id);
        repository.delete(emp);
    }
}