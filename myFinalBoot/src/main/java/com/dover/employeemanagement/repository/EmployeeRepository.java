package com.dover.employeemanagement.repository;

import com.dover.employeemanagement.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByDepartment(String department);
}