package com.amaris.prueba.aplication;

import com.amaris.prueba.aplication.service.GetEmployeeService;
import com.amaris.prueba.domain.models.Employee;
import com.amaris.prueba.domain.port.ApiAdapterService;
import com.amaris.prueba.infrastructure.models.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetEmployeeImpl implements GetEmployeeService {
    @Autowired
    private ApiAdapterService apiAdapterService;


    @Override
    public List<EmployeeDTO> allEmployee() {
        List<Employee> employees = apiAdapterService.todosEmpleados();
        List<EmployeeDTO> employeesDTO = employees.stream()
                .map(employee -> {
                    EmployeeDTO employeeDTO = EmployeeDTO.employeeToEmployeeDTO(employee);
                    employeeDTO.setSalaryYear(employeeDTO.getEmployeeSalary() * 12);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
        return employeesDTO;
    }

    @Override
    public EmployeeDTO employeeById(int id) {
        Employee employee = apiAdapterService.empleadoPorId(id);
        EmployeeDTO employeeDTO = EmployeeDTO.employeeToEmployeeDTO(employee);
        employeeDTO.setSalaryYear(employeeDTO.getEmployeeSalary() * 12);
        return employeeDTO;
    }
}
