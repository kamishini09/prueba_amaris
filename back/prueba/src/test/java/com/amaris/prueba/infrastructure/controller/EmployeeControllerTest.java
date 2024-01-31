package com.amaris.prueba.infrastructure.controller;

import com.amaris.prueba.aplication.service.GetEmployeeService;
import com.amaris.prueba.infrastructure.models.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private GetEmployeeService employeeService;

    @Test
    void getAll() {
        List<EmployeeDTO> mockEmployeeDTOList = Arrays.asList(
                new EmployeeDTO(1, "Prueba 1", 50000, 25, "image1.jpg"),
                new EmployeeDTO(2, "Prueba 2", 60000, 30, "image2.jpg")
        );
        Mockito.when(employeeService.allEmployee()).thenReturn(mockEmployeeDTOList);

        ResponseEntity<List<EmployeeDTO>> responseEntity = employeeController.getAll();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockEmployeeDTOList, responseEntity.getBody());
    }

    @Test
    void getEmployeeById() {
        int employeeId = 1;
        EmployeeDTO mockEmployeeDTO = new EmployeeDTO(1, "John Doe", 50000, 25, "image1.jpg");
        Mockito.when(employeeService.employeeById(employeeId)).thenReturn(mockEmployeeDTO);

        ResponseEntity<EmployeeDTO> responseEntity = employeeController.getEmployeeById(employeeId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockEmployeeDTO, responseEntity.getBody());
    }
}