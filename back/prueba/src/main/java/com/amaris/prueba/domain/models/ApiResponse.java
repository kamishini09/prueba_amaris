package com.amaris.prueba.domain.models;

import java.util.List;

public class ApiResponse {

     private String status;
     private List<Employee> data;
     private String message;

     public ApiResponse(String status, List<Employee> data, String message) {
          this.status = status;
          this.data = data;
          this.message = message;
     }

     public String getStatus() {
          return status;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     public List<Employee> getData() {
          return data;
     }

     public void setData(List<Employee> data) {
          this.data = data;
     }

     public String getMessage() {
          return message;
     }

     public void setMessage(String message) {
          this.message = message;
     }
}
