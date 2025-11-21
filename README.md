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

y no hay alguna forma para que quede mas bonito y formateado en el readme?
🏢 Sistema de Registro de Jornada Laboral
<div align="center">
https://img.shields.io/badge/Spring%2520Boot-3.x-brightgreen
https://img.shields.io/badge/Java-17%252B-orange
https://img.shields.io/badge/API-REST-blue
https://img.shields.io/badge/License-MIT-green

Sistema completo para la gestión de fichajes y control horario de empleados

</div>
📖 Tabla de Contenidos
Descripción

Características

Modelo de Datos

Instalación

Uso de la API

Documentación

Tecnologías

🎯 Descripción
Sistema API REST desarrollado con Spring Boot para la gestión integral del registro de jornada laboral. Permite administrar departamentos, empleados y controlar los fichajes de entrada/salida de forma automatizada e inteligente.

✨ Características
Funcionalidad	Descripción
🔄 Fichaje Automático	Sistema que alterna automáticamente entre ENTRADA y SALIDA
💰 Control de Presupuesto	Valida que los salarios no excedan el presupuesto del departamento
📊 Gestión Completa	CRUD completo para todas las entidades
🛡️ Validación de Negocio	Previene fichajes duplicados y errores comunes
📚 Documentación Interactiva	Swagger UI integrado para testing en tiempo real
🗃️ Modelo de Datos
📊 Diagrama de Entidades
text
┌───────────────┐    ┌──────────────┐    ┌──────────────┐
│  Departamento │    │   Empleado   │    │   Fichaje    │
├───────────────┤    ├──────────────┤    ├──────────────┤
│ id (PK)       │1   │ id (PK)      │1   │ id (PK)      │
│ nombre        │───∞│ nombreComp   │───∞│ momento      │
│ presupuesto   │    │ cargo        │    │ tipo         │
└───────────────┘    │ salario      │    │ empleado_id  │
                     │ depto_id     │    └──────────────┘
                     └──────────────┘
🏷️ Detalles de Entidades
Entidad	Campos Principales
Departamento	id, nombre, presupuesto
Empleado	id, nombreCompleto, cargo, salario
Fichaje	id, momento, tipo (ENTRADA/SALIDA)
🚀 Instalación Rápida
Prerrequisitos
☕ Java 17 o superior

🍃 Maven 3.6+

⚡ Pasos de Instalación
bash
# 1. Clonar el repositorio
git clone https://github.com/tu-usuario/registro-jornada.git
cd registro-jornada

# 2. Compilar el proyecto
mvn clean compile

# 3. Ejecutar la aplicación
mvn spring-boot:run
🔧 Configuración
La aplicación se ejecutará en: http://localhost:8080

📡 Uso de la API
🏷️ Gestión de Departamentos
Método	Endpoint	Descripción
GET	/api/v1/departamentos	📋 Listar todos los departamentos
POST	/api/v1/departamentos	➕ Crear nuevo departamento
PUT	/api/v1/departamentos/{id}	✏️ Actualizar departamento
Ejemplo crear departamento:

json
POST /api/v1/departamentos
{
  "nombre": "Desarrollo Software",
  "presupuesto": 200000.00
}
👥 Gestión de Empleados
Método	Endpoint	Descripción
GET	/api/v1/empleados	👨‍💼 Listar empleados
POST	/api/v1/empleados	🆕 Crear empleado
PUT	/api/v1/empleados/{empId}/departamento/{deptId}	🔗 Asignar a departamento
⏰ Sistema de Fichajes
Método	Endpoint	Descripción
POST	/api/v1/empleados/{id}/fichar	🎫 Registrar fichaje (automático)
GET	/api/v1/empleados/{id}/fichajes	📈 Ver historial
Ejemplo de fichaje:

http
POST /api/v1/empleados/1/fichar
# Respuesta: {"tipo": "ENTRADA", "momento": "2025-01-20T08:00:00"}
📚 Documentación
🔍 Swagger UI
Accede a la documentación interactiva completa:

text
http://localhost:8080/swagger-ui.html
🗄️ Base de Datos H2
Consola de administración embebida:

text
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb

Usuario: sa

Contraseña: (vacío)

🧪 Colección Postman
Incluida en el repositorio: postman-collection.json

⚠️ Manejo de Errores
La API utiliza estándares RFC 7807 con ProblemDetail:

Error	Código	Descripción
EntidadNoEncontrada	404	Recurso no encontrado
FichajeDuplicado	409	Entrada/Salida consecutiva del mismo tipo
PresupuestoExcedido	400	Salarios exceden presupuesto del departamento
🛠️ Tecnologías
<div align="center">
Capa	Tecnologías
Backend	Spring Boot 3.x, Spring Data JPA, Spring MVC
Base de Datos	H2 (desarrollo), JPA/Hibernate
Documentación	OpenAPI 3.0, Swagger UI
Validación	Bean Validation, Custom Validators
Testing	JUnit 5, Mockito, Postman
</div>
📊 Estructura del Proyecto
text
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── empresa/
│   │           └── jornada/
│   │               ├── controller/     # 🎮 Controladores REST
│   │               ├── service/        # ⚙️ Lógica de negocio
│   │               ├── repository/     # 🗄️ Acceso a datos
│   │               ├── model/          # 🏷️ Entidades JPA
│   │               ├── dto/            # 📦 Objetos transferencia
│   │               └── exception/      # ⚠️ Manejo errores
│   └── resources/
│       ├── application.properties      # ⚙️ Configuración
└── test/                              # 🧪 Tests
🎓 Información Académica
Aspecto	Detalle
Tipo de Proyecto	Registro de Jornada - Tipo C
Módulos	Acceso a Datos, Programación de Servicios y Procesos
Curso Académico	2025-26
Fecha de Entrega	28 de Noviembre de 2025
<div align="center">
¿Preguntas o problemas?
Consulta la documentación en Swagger o abre un issue en el repositorio.

Desarrollado con ❤️ usando Spring Boot

</div>
