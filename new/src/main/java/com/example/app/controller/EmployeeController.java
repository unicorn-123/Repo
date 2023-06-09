package com.example.app.controller;

import com.example.app.entity.Employee;
import com.example.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
   private EmployeeService service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return service.saveEmployees(employees);
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return service.getEmployees();
    }


    @GetMapping("/employee/{id}")
    public Employee findByEmployeeId(@PathVariable int id){
        return service.getEmployeesById(id);
    }

    @GetMapping("/employee/{name}")
    public Employee findByEmployeeName(@PathVariable  String name){
        return service.getEmployeesByName(name);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }

}
