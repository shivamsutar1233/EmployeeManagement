package com.example.EmployeeManagement.Employee;

import com.example.EmployeeManagement.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Employee")
@CrossOrigin("*")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //http://localhost:8080/api/v1/Employee
    @GetMapping
    public List<Employee> getEmployees() {
        return this.employeeService.getEmployees();
    }

    //http://localhost:8080/api/v1/Employee
    @PostMapping
    public boolean AddEmployee(@RequestBody Employee employee) {return this.employeeService.addEmployee(employee);}

    //http://localhost:8080/api/v1/Employee/id
    @DeleteMapping("{id}")
    public boolean DeleteEmployee(@PathVariable("id") int id) {return  this.employeeService.deleteEmployee(id);}

    //http://localhost:8080/api/v1/Employee/id
    @PutMapping ("{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id") int id) {return this.employeeService.updateEmployee(id,employee);}

}
