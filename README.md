## Prueba AMARIS
El siguiente proyecto tiene como finalidad la prueba tecnica para la empresa AMARIS
Las carpetas estan divididas de la siguiente manera:

## Carpeta Back
La carpeta back posee dentro un proyecto en arquitectura Hexagfonal con java17 Spring Boot 3.2.2 y funciona como un micro servicio que tiene expuesto 2 endpoints.

1. Enpoint: Path `/getbyid/{id}`  y el método HTTP tipo **GET** reecibe como parametro el id del empleado y retorna los siguientes datros en el caso de exito 

```json
        {
        "id": 1,
        "employeeName": "Tiger Nixon",
        "employeeSalary": 320800,
        "employeeAge": 61,
        "profileImage": "",
        "salaryYear": 3849600
    }
```       

En los caso de tener error a conmectarse con la api **dummy.restapiexample** puede devolver los siguientes mensajes:

1 Opcion 
```json
            {
             "message" : "Error al consultar el servicio, por favor intenta más tarde"
            }
```  
2 Opcion             

```json
            {
             "message" : "No se encontró empleado con el id: 1"
            }
```  
Cuando el id no se encuentra en la api  **dummy.restapiexample**

```json
            {
             "message" : "No se encontró empleado con el id: 888"
            }
```  

2. Enpoint: Path `/getall`  y el método HTTP tipo **GET** retorna todos loe empleado, los siguientes datos en el caso de exito 

```json
        
   [
     {
            "id": 1,
            "employeeName": "Tiger Nixon",
            "employeeSalary": 320800,
            "employeeAge": 61,
            "profileImage": "",
            "salaryYear": 3849600
        },
        {
            "id": 2,
            "employeeName": "Garrett Winters",
            "employeeSalary": 170750,
            "employeeAge": 63,
            "profileImage": "",
            "salaryYear": 3849600
        },
        {
            "id": 3,
            "employeeName": "Ashton Cox",
            "employeeSalary": 86000,
            "employeeAge": 66,
            "profileImage": "",
            "salaryYear": 3849600
        }
   ]
```       

En los caso de tener error a conmectarse con la api **dummy.restapiexample** puede devolver los siguientes mensajes:

 
```json
            {
             "message" : "Error al consultar el servicio, por favor intenta más tarde"
            }
        ```      

Para correr el proyecto solo es necesario descargar la carppeta prueba, abrir en un IDE para lo cual se recomienda IntelliJ Idea y ejecutar.


## Carpeta Front 

La carpeta front posee dentro un carpeta front-amaris que contiene el proyecto compatible con el back de la aplicacion
esta esta basada en Angular 17 y tiene una estructura de carpetas en la siguiente medida:
 * Component: contiene el componente Home que es quien contiene toda la operacion.
 * Moodels: contien el modelo de la aplicacion (Empployee).
 * Service: contiene el servicio utilizado para realizar el consumo de la api.
 * Shared: contiene el componente Header de la aplicacion.
 * environmetns: contiene el environmet de la url.

 Debe descargarse la aplicacion y ejecutar los siguientes comando: 
 1. npm install
 2. ng serve