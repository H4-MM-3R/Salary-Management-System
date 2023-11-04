package com.SMS.employee.services;

import com.SMS.employee.model.Employee;
import java.util.List;

public interface EmployeeService {
  Employee createEmployee(Employee employee);

  List<Employee> getAllEmployees();

  boolean deletedEmployee(Long id);

  Employee getEmployeeById(long id);

  Employee updateEmployee(Long id, Employee employee);
}
