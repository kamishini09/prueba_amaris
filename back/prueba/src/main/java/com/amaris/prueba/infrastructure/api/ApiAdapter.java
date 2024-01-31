package com.amaris.prueba.infrastructure.api;

import com.amaris.prueba.domain.models.ApiResponse;
import com.amaris.prueba.domain.models.Employee;
import com.amaris.prueba.domain.port.ApiAdapterService;
import com.amaris.prueba.shared.StandarErrorMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class ApiAdapter implements ApiAdapterService {

    private final RestTemplate restTemplate;
    private String apiUrl;

    public ApiAdapter(RestTemplate restTemplate, @Value("${api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @Override
    public List<Employee> todosEmpleados() {
        try {
            ResponseEntity<ApiResponse> responseEntity = restTemplate.getForEntity(apiUrl + "/employees", ApiResponse.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                ApiResponse apiResponse = responseEntity.getBody();
                if (apiResponse != null && apiResponse.getData() != null) {
                    return apiResponse.getData();
                }
            }
            throw new StandarErrorMessage("Error al consultar el servicio, por favor intenta más tarde");
        } catch (Exception e) {
            throw new StandarErrorMessage("Error al consultar el servicio, por favor intenta más tarde");
        }

    }

    @Override
    public Employee empleadoPorId(int id) {
        try {
            ResponseEntity<ApiResponse> responseEntity = restTemplate.getForEntity(apiUrl + "/employee/{id}", ApiResponse.class, id);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                ApiResponse apiResponse = responseEntity.getBody();
                if (apiResponse != null && apiResponse.getData() != null) {
                    return apiResponse.getData().get(0);
                }
            }
            throw new StandarErrorMessage("Error al consultar el servicio, por favor intenta más tarde");
        } catch (HttpClientErrorException e) {
            if (HttpStatus.TOO_MANY_REQUESTS.equals(e.getStatusCode())) {
                throw new StandarErrorMessage("Demasiados intentos, por favor espera antes de volver a intentar.");
            } else {
                throw new StandarErrorMessage("Error: " + e);
            }
        } catch (Exception e) {
            throw new StandarErrorMessage("No se encontró empleado con el id: " + id);
        }
    }

}
