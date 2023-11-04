package com.SMS.employee.controller;

import com.SMS.employee.model.Employee;
import com.SMS.employee.services.EmployeeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping("/employees")
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
  }

  @GetMapping("/employees")
  public List<Employee> getAllEmployes() {
    return employeeService.getAllEmployees();
  }

  @DeleteMapping("/employees/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
    boolean deleted = false;
    deleted = employeeService.deletedEmployee(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", deleted);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
    Employee employee = null;
    employee = employeeService.getEmployeeById(id);
    return ResponseEntity.ok(employee);
  }

  @PutMapping("/employees/{id}")
  public ResponseEntity<Employee> updateEmployee(
      @PathVariable Long id, @RequestBody Employee employee) {

    employee = employeeService.updateEmployee(id, employee);
    return ResponseEntity.ok(employee);
  }
}