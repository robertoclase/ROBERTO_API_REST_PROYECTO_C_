
# API Registro de Jornada - Roberto API

## 📋 Descripción
API REST desarrollada con Spring Boot para la gestión del registro de jornada laboral en una empresa. Permite gestionar departamentos, empleados y sus fichajes de entrada/salida.

## 🚀 Características
- **Gestión completa de Departamentos y Empleados** (CRUD)
- **Sistema de fichajes automático** que alterna entre ENTRADA y SALIDA
- **Validación de presupuesto** al asignar empleados a departamentos
- **Documentación OpenAPI 3.0** con Swagger UI
- **Manejo de errores** con ProblemDetail estándar
- **Base de datos H2** en memoria para desarrollo




## 📁 Estructura del Proyecto
src/main/java/com/salesianostriana/dam/apirestroberto/

├── controller/ # Controladores REST

├── dto/ # Data Transfer Objects (Records)

├── exception/ # Manejo de excepciones

├── model/ # Entidades JPA

├── repository/ # Repositorios Spring Data

└── service/ # Lógica de negocio



### Pasos para ejecutar
1. Clonar el repositorio
2. Ejecutar: `mvn spring-boot:run`
3. La aplicación estará en: `http://localhost:8080`

## 📚 Documentación API

### Swagger UI
Disponible en: `http://localhost:8080/swagger-ui.html`

### 🔗 Endpoints principales
  
#### Departamentos
- `GET /api/v1/departamentos` - Listar todos
- `POST /api/v1/departamentos` - Crear nuevo
- `GET /api/v1/departamentos/{id}` - Obtener por ID
- `PUT /api/v1/departamentos/{id}` - Actualizar
- `DELETE /api/v1/departamentos/{id}` - Eliminar

#### Empleados
- `GET /api/v1/empleados` - Listar todos
- `POST /api/v1/empleados` - Crear nuevo
- `GET /api/v1/empleados/{id}` - Obtener por ID
- `PUT /api/v1/empleados/{id}` - Actualizar
- `DELETE /api/v1/empleados/{id}` - Eliminar
- `PUT /api/v1/empleados/{empleadoId}/departamento/{deptoId}` - Asignar departamento

#### Fichajes
- `POST /api/v1/empleados/{empleadoId}/fichar` - Registrar fichaje
- `GET /api/v1/empleados/{empleadoId}/fichajes` - Historial de fichajes

## 🎯 Modelo de Datos

### Entidades
- **Departamento**: id, nombre (único), presupuesto
- **Empleado**: id, nombreCompleto, cargo, salario, departamento
- **Fichaje**: id, momento, tipo (ENTRADA/SALIDA), empleado

### Relaciones
- Un Departamento tiene muchos Empleados (1:N)
- Un Empleado tiene muchos Fichajes (1:N)

## ⚠️ Manejo de Errores

La API utiliza ProblemDetail para respuestas de error estandarizadas:

- `404 NOT FOUND`: Recurso no encontrado
- `400 BAD REQUEST`: Error de validación o presupuesto excedido
- `409 CONFLICT`: Fichaje duplicado
- `500 INTERNAL SERVER ERROR`: Error interno

## 🧪 Testing

### Base de datos H2
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: (vacío)

### Colección Postman
Incluida en el proyecto: `ROBERTO_API_POSTMAN.json`
