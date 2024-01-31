package com.amaris.prueba.aplication.service;

import com.amaris.prueba.infrastructure.models.EmployeeDTO;
import java.util.List;


public interface GetEmployeeService {
    List<EmployeeDTO> allEmployee();
    EmployeeDTO employeeById(int id);
}
