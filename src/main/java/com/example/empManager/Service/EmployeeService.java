package com.example.empManager.Service;

import com.example.empManager.Model.Employee;
import com.example.empManager.Repository.EmployeeRepository;
import com.example.empManager.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(() ->
                new UserNotFoundException("User by id: " + id + "not found"));
    }
}
