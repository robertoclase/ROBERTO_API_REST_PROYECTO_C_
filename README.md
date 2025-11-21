# ROBERTO_API_REST_PROYECTO_C_


🕒 Sistema de Registro de Jornada Laboral

📋 Descripción

API REST desarrollada con Spring Boot para la gestión del registro de jornada laboral en una empresa. El sistema permite administrar departamentos, empleados y controlar los fichajes de entrada y salida de forma automatizada.

🏗️ Modelo de Datos
Estructura de Entidades
Departamento
id (Long) - Identificador único

nombre (String) - Nombre del departamento (único)

presupuesto (BigDecimal) - Presupuesto anual

Empleado
id (Long) - Identificador único

nombreCompleto (String) - Nombre completo

cargo (String) - Puesto de trabajo

salario (BigDecimal) - Salario anual

departamento (Departamento) - Departamento asignado

Fichaje
id (Long) - Identificador único

momento (LocalDateTime) - Fecha y hora del registro

tipo (Enum) - ENTRADA o SALIDA

empleado (Empleado) - Empleado asociado

🚀 Endpoints Principales
📍 Departamentos
Método	Endpoint	Descripción
GET	/api/v1/departamentos	Listar todos
GET	/api/v1/departamentos/{id}	Obtener por ID
POST	/api/v1/departamentos	Crear nuevo
PUT	/api/v1/departamentos/{id}	Actualizar
DELETE	/api/v1/departamentos/{id}	Eliminar
👥 Empleados
Método	Endpoint	Descripción
GET	/api/v1/empleados	Listar todos
GET	/api/v1/empleados/{id}	Obtener por ID
POST	/api/v1/empleados	Crear nuevo
PUT	/api/v1/empleados/{id}	Actualizar
PUT	/api/v1/empleados/{empId}/departamento/{deptId}	Asignar a departamento
⏰ Fichajes
Método	Endpoint	Descripción
POST	/api/v1/empleados/{id}/fichar	Registrar fichaje (alterna automáticamente)
GET	/api/v1/empleados/{id}/fichajes	Historial de fichajes
⚙️ Instalación y Ejecución
Prerrequisitos
Java 17+

Maven 3.6+

🛠️ Pasos
Clonar y compilar

bash
git clone [url-del-repositorio]
cd registro-jornada
mvn clean compile
Ejecutar la aplicación

bash
mvn spring-boot:run
Acceder a la aplicación

text
http://localhost:8080
📚 Documentación
Swagger UI
Documentación interactiva disponible en:

text
http://localhost:8080/swagger-ui.html
Base de datos H2
Consola de administración:

text
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb

User: sa

Password: (vacío)

🧪 Pruebas
Colección Postman
El repositorio incluye postman-collection.json con todos los endpoints configurados para pruebas.

Ejemplos de Uso
Crear departamento:

http
POST /api/v1/departamentos
{
  "nombre": "Desarrollo",
  "presupuesto": 150000.00
}
Registrar fichaje:

http
POST /api/v1/empleados/1/fichar
⚠️ Gestión de Errores
La API maneja los siguientes errores con ProblemDetail:

404 NOT FOUND - Entidad no encontrada

409 CONFLICT - Fichaje duplicado (ej: dos entradas consecutivas)

400 BAD REQUEST - Presupuesto excedido al asignar salarios

🏆 Características Técnicas
Framework: Spring Boot 3.x

Documentación: OpenAPI 3.0 + Swagger UI

Base de datos: H2 (memoria)

Validación: Bean Validation

DTOs: Pattern para transferencia de datos

Gestión de errores: ProblemDetail RFC 7807

📅 Información del Proyecto
Tipo: Proyecto educativo - Registro de Jornada Tipo C

Módulos: Acceso a Datos + Programación de Servicios y Procesos

Curso: 2025-26

Fecha de entrega: 28 de Noviembre de 2025

👨‍💻 Desarrollo
Proyecto desarrollado individualmente siguiendo metodologías ágiles y buenas prácticas de desarrollo con Spring Boot.
