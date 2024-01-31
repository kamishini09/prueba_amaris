package com.amaris.prueba.infrastructure.controller;

import com.amaris.prueba.aplication.service.GetEmployeeService;
import com.amaris.prueba.infrastructure.models.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/employee/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private GetEmployeeService employeeService;

    @GetMapping("getall")
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        return new ResponseEntity<>(employeeService.allEmployee(),HttpStatus.OK);
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.employeeById(id),HttpStatus.OK);
    }

}
