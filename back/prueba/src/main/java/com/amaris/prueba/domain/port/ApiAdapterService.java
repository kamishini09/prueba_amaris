package com.amaris.prueba.domain.port;

import com.amaris.prueba.domain.models.Employee;
import java.util.List;


public interface ApiAdapterService  {
    List<Employee> todosEmpleados();
    Employee empleadoPorId(int id);
}
