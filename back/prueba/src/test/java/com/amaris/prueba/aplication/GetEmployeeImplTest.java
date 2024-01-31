package com.amaris.prueba.aplication;

import com.amaris.prueba.domain.models.Employee;
import com.amaris.prueba.domain.port.ApiAdapterService;
import com.amaris.prueba.infrastructure.models.EmployeeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class GetEmployeeImplTest {

    @InjectMocks
    private GetEmployeeImpl getEmployeeService;

    @Mock
    private ApiAdapterService apiAdapterService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void allEmployee() {
        Employee employee1 = new Employee(1, "John Doe", 50000, 25, "image1.jpg");
        Employee employee2 = new Employee(2, "Jane Doe", 60000, 30, "image2.jpg");
        Mockito.when(apiAdapterService.todosEmpleados()).thenReturn(Arrays.asList(employee1, employee2));

        List<EmployeeDTO> result = getEmployeeService.allEmployee();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getEmployeeName());
        assertEquals(60000 * 12, result.get(1).getSalaryYear());
    }

    @Test
    void employeeById() {
        int employeeId = 1;
        Employee employee = new Employee(employeeId, "John Doe", 50000, 25, "image1.jpg");
        Mockito.when(apiAdapterService.empleadoPorId(Mockito.anyInt())).thenReturn(employee);

        EmployeeDTO result = getEmployeeService.employeeById(employeeId);

        assertEquals("John Doe", result.getEmployeeName());
        assertEquals(50000 * 12, result.getSalaryYear());
    }
}