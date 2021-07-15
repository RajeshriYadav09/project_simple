package com.techcushy.project_simple.service;

import com.techcushy.project_simple.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
     List<Employee> getAllEmployee();
     void saveEmployee(Employee employee);
     Employee getEmployeeById(long id);
     void deleteEmployee(long id);
}
