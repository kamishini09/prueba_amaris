package com.amaris.prueba.infrastructure.models;

import com.amaris.prueba.domain.models.Employee;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmployeeDTO {
    private int id;
    private String employeeName;
    private double employeeSalary;
    private int employeeAge;
    private String profileImage;
    private double salaryYear;

    public EmployeeDTO(int id, String nombre, double salario, int edad, String imagen) {
        this.id = id;
        this.employeeName = nombre;
        this.employeeSalary = salario;
        this.employeeAge = edad;
        this.profileImage = imagen;
    }

    public static EmployeeDTO employeeToEmployeeDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getEmployee_name(),
                employee.getEmployee_salary(),
                employee.getEmployee_age(),
                employee.getProfile_image()
        );
    }
}
