package com.example.EmployeeManagement.Employee;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    public boolean addEmployee(Employee employee) {
        System.out.println(employee.toString());
        Optional<Employee> employeeEmail = employeeRepository.findOneByEmail(employee.getEmail());
        if (employeeEmail.isPresent()) {
            throw new IllegalStateException("Employee email already exists");
        }
        employeeRepository.save(employee);
        return true;
    }
    public boolean deleteEmployee(int id) {
        if(!employeeRepository.existsById(id))
            throw new IllegalStateException("Employee does not exist");
        employeeRepository.deleteById(id);
        return true;
    }
    @Transactional
    public Employee updateEmployee(int id,Employee employee) {
        Employee databaseEmployee = employeeRepository.findById(id).orElseThrow(
                ()->new IllegalStateException("Could not find employee with id " + id));
        if(!databaseEmployee.getName().equals(employee.getName()))
            databaseEmployee.setName(employee.getName());
        if(!(databaseEmployee.getAge()==employee.getAge()))
            databaseEmployee.setAge(employee.getAge());
        if(!databaseEmployee.getEmail().equals(employee.getEmail()))
            databaseEmployee.setEmail(employee.getEmail());
        if (!databaseEmployee.getPhone().equals(employee.getPhone()))
            databaseEmployee.setPhone(employee.getPhone());
        return databaseEmployee;
    }
}
