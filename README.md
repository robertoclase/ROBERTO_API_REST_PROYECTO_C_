🏢 SISTEMA DE REGISTRO DE JORNADA LABORAL
<!DOCTYPE html><html lang="es"> <head> <meta charset="UTF-8"> <meta name="viewport" content="width=device-width, initial-scale=1.0"> <title>Documentación API - Registro Jornada</title> <style> :root { --primary: #2563eb; --secondary: #7c3aed; --success: #059669; --warning: #d97706; --danger: #dc2626; --dark: #1e293b; --light: #f8fafc; --gray: #64748b; }
text
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        min-height: 100vh;
        color: var(--dark);
        line-height: 1.6;
    }
    
    .container {
        max-width: 1200px;
        margin: 0 auto;
        padding: 20px;
    }
    
    .header {
        text-align: center;
        background: white;
        padding: 40px;
        border-radius: 20px;
        box-shadow: 0 20px 40px rgba(0,0,0,0.1);
        margin-bottom: 30px;
        position: relative;
        overflow: hidden;
    }
    
    .header::before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        height: 4px;
        background: linear-gradient(90deg, var(--primary), var(--secondary));
    }
    
    .badges {
        display: flex;
        justify-content: center;
        gap: 10px;
        margin: 20px 0;
        flex-wrap: wrap;
    }
    
    .badge {
        padding: 8px 16px;
        border-radius: 20px;
        font-size: 0.9em;
        font-weight: 600;
        color: white;
    }
    
    .badge.spring { background: var(--success); }
    .badge.java { background: var(--warning); }
    .badge.api { background: var(--primary); }
    .badge.database { background: var(--secondary); }
    
    .grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
        gap: 20px;
        margin: 30px 0;
    }
    
    .card {
        background: white;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 10px 30px rgba(0,0,0,0.1);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }
    
    .card:hover {
        transform: translateY(-5px);
        box-shadow: 0 20px 40px rgba(0,0,0,0.15);
    }
    
    .card h3 {
        color: var(--primary);
        margin-bottom: 15px;
        display: flex;
        align-items: center;
        gap: 10px;
    }
    
    .card h3 i {
        font-size: 1.2em;
    }
    
    .endpoint {
        background: var(--light);
        padding: 15px;
        border-radius: 10px;
        margin: 10px 0;
        border-left: 4px solid var(--primary);
    }
    
    .endpoint.get { border-left-color: var(--success); }
    .endpoint.post { border-left-color: var(--warning); }
    .endpoint.put { border-left-color: var(--primary); }
    .endpoint.delete { border-left-color: var(--danger); }
    
    .method {
        display: inline-block;
        padding: 4px 12px;
        border-radius: 6px;
        color: white;
        font-weight: bold;
        font-size: 0.8em;
        margin-right: 10px;
    }
    
    .method.get { background: var(--success); }
    .method.post { background: var(--warning); }
    .method.put { background: var(--primary); }
    .method.delete { background: var(--danger); }
    
    .diagram {
        background: var(--light);
        padding: 25px;
        border-radius: 15px;
        text-align: center;
        margin: 20px 0;
    }
    
    .entity {
        display: inline-block;
        background: white;
        padding: 20px;
        margin: 10px;
        border-radius: 10px;
        box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        min-width: 200px;
    }
    
    .entity h4 {
        color: var(--primary);
        margin-bottom: 10px;
    }
    
    .relationship {
        margin: 20px 0;
        font-size: 1.2em;
        color: var(--gray);
    }
    
    .code-block {
        background: var(--dark);
        color: var(--light);
        padding: 20px;
        border-radius: 10px;
        margin: 15px 0;
        overflow-x: auto;
    }
    
    .steps {
        counter-reset: step;
    }
    
    .step {
        position: relative;
        padding-left: 60px;
        margin: 20px 0;
    }
    
    .step::before {
        counter-increment: step;
        content: counter(step);
        position: absolute;
        left: 0;
        top: 0;
        width: 40px;
        height: 40px;
        background: var(--primary);
        color: white;
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        font-weight: bold;
    }
    
    .feature-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
        gap: 15px;
    }
    
    .feature {
        display: flex;
        align-items: center;
        gap: 15px;
        padding: 15px;
        background: var(--light);
        border-radius: 10px;
    }
    
    .feature i {
        font-size: 1.5em;
        color: var(--primary);
    }
    
    .tech-stack {
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
        gap: 15px;
        margin: 20px 0;
    }
    
    .tech-item {
        background: white;
        padding: 15px 25px;
        border-radius: 25px;
        box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        font-weight: 600;
        color: var(--dark);
    }
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head> <body> <div class="container"> <!-- HEADER --> <div class="header"> <h1>🏢 SISTEMA DE REGISTRO DE JORNADA LABORAL</h1> <p>API REST completa desarrollada con Spring Boot para la gestión integral de control horario</p>
text
        <div class="badges">
            <span class="badge spring"><i class="fas fa-leaf"></i> Spring Boot 3.x</span>
            <span class="badge java"><i class="fab fa-java"></i> Java 17+</span>
            <span class="badge api"><i class="fas fa-code"></i> API REST</span>
            <span class="badge database"><i class="fas fa-database"></i> H2 Database</span>
        </div>
    </div>

    <!-- CARACTERÍSTICAS PRINCIPALES -->
    <div class="card">
        <h2>🚀 Características Principales</h2>
        <div class="feature-grid">
            <div class="feature">
                <i class="fas fa-sync-alt"></i>
                <div>
                    <strong>Fichaje Automático</strong>
                    <p>Alterna inteligentemente entre ENTRADA/SALIDA</p>
                </div>
            </div>
            <div class="feature">
                <i class="fas fa-chart-line"></i>
                <div>
                    <strong>Control de Presupuesto</strong>
                    <p>Valida salarios vs presupuesto departamental</p>
                </div>
            </div>
            <div class="feature">
                <i class="fas fa-shield-alt"></i>
                <div>
                    <strong>Validación de Negocio</strong>
                    <p>Previene errores y fichajes duplicados</p>
                </div>
            </div>
            <div class="feature">
                <i class="fas fa-book"></i>
                <div>
                    <strong>Documentación Completa</strong>
                    <p>Swagger UI integrado y colección Postman</p>
                </div>
            </div>
        </div>
    </div>

    <!-- MODELO DE DATOS -->
    <div class="card">
        <h2>🗃️ Modelo de Datos</h2>
        
        <div class="diagram">
            <div class="entity">
                <h4>📊 Departamento</h4>
                <p><strong>id</strong> (Long, PK)</p>
                <p><strong>nombre</strong> (String, único)</p>
                <p><strong>presupuesto</strong> (BigDecimal)</p>
            </div>
            
            <div class="relationship">
                <i class="fas fa-arrows-alt-h"></i> 1 ←→ N
            </div>
            
            <div class="entity">
                <h4>👤 Empleado</h4>
                <p><strong>id</strong> (Long, PK)</p>
                <p><strong>nombreCompleto</strong> (String)</p>
                <p><strong>cargo</strong> (String)</p>
                <p><strong>salario</strong> (BigDecimal)</p>
            </div>
            
            <div class="relationship">
                <i class="fas fa-arrows-alt-h"></i> 1 ←→ N
            </div>
            
            <div class="entity">
                <h4>⏰ Fichaje</h4>
                <p><strong>id</strong> (Long, PK)</p>
                <p><strong>momento</strong> (LocalDateTime)</p>
                <p><strong>tipo</strong> (Enum: ENTRADA/SALIDA)</p>
            </div>
        </div>
    </div>

    <!-- ENDPOINTS DE LA API -->
    <div class="card">
        <h2>📡 Endpoints de la API</h2>
        
        <h3><i class="fas fa-building"></i> Departamentos</h3>
        <div class="endpoint get">
            <span class="method get">GET</span>
            <strong>/api/v1/departamentos</strong>
            <p>Obtener todos los departamentos</p>
        </div>
        <div class="endpoint post">
            <span class="method post">POST</span>
            <strong>/api/v1/departamentos</strong>
            <p>Crear nuevo departamento</p>
        </div>
        <div class="endpoint put">
            <span class="method put">PUT</span>
            <strong>/api/v1/departamentos/{id}</strong>
            <p>Actualizar departamento existente</p>
        </div>

        <h3><i class="fas fa-users"></i> Empleados</h3>
        <div class="endpoint get">
            <span class="method get">GET</span>
            <strong>/api/v1/empleados</strong>
            <p>Listar todos los empleados</p>
        </div>
        <div class="endpoint post">
            <span class="method post">POST</span>
            <strong>/api/v1/empleados</strong>
            <p>Crear nuevo empleado</p>
        </div>
        <div class="endpoint put">
            <span class="method put">PUT</span>
            <strong>/api/v1/empleados/{empleadoId}/departamento/{deptoId}</strong>
            <p>Asignar empleado a departamento</p>
        </div>

        <h3><i class="fas fa-clock"></i> Fichajes</h3>
        <div class="endpoint post">
            <span class="method post">POST</span>
            <strong>/api/v1/empleados/{empleadoId}/fichar</strong>
            <p>Registrar fichaje (sistema automático ENTRADA/SALIDA)</p>
        </div>
        <div class="endpoint get">
            <span class="method get">GET</span>
            <strong>/api/v1/empleados/{empleadoId}/fichajes</strong>
            <p>Obtener historial completo de fichajes</p>
        </div>
    </div>

    <!-- INSTALACIÓN Y CONFIGURACIÓN -->
    <div class="card">
        <h2>⚙️ Instalación y Configuración</h2>
        
        <div class="steps">
            <div class="step">
                <h4>Prerrequisitos</h4>
                <p>☕ Java 17+ | 🍃 Maven 3.6+</p>
            </div>
            
            <div class="step">
                <h4>Clonar y Compilar</h4>
                <div class="code-block">
                    git clone https://github.com/tu-usuario/registro-jornada.git<br>
                    cd registro-jornada<br>
                    mvn clean compile
                </div>
            </div>
            
            <div class="step">
                <h4>Ejecutar la Aplicación</h4>
                <div class="code-block">
                    mvn spring-boot:run
                </div>
            </div>
            
            <div class="step">
                <h4>Acceso a la Aplicación</h4>
                <p>🌐 <strong>URL Principal:</strong> http://localhost:8080</p>
            </div>
        </div>
    </div>

    <!-- DOCUMENTACIÓN Y HERRAMIENTAS -->
    <div class="card">
        <h2>📚 Documentación y Herramientas</h2>
        
        <div class="grid">
            <div class="card">
                <h3><i class="fas fa-book-open"></i> Swagger UI</h3>
                <p>Documentación interactiva completa de la API</p>
                <div class="endpoint get">
                    <strong>http://localhost:8080/swagger-ui.html</strong>
                </div>
            </div>
            
            <div class="card">
                <h3><i class="fas fa-database"></i> Consola H2</h3>
                <p>Base de datos en memoria - DesarrolloT</p>
                <div class="endpoint get">
                    <strong>http://localhost:8080/h2-console</strong>
                    <p>JDBC: jdbc:h2:mem:testdb | User: sa</p>
                </div>
            </div>
            
            <div class="card">
                <h3><i class="fas fa-file-export"></i> Postman</h3>
                <p>Colección completa para testing</p>
                <p>📁 <strong>postman-collection.json</strong></p>
            </div>
        </div>
    </div>

    <!-- EJEMPLOS DE USO -->
    <div class="card">
        <h2>💡 Ejemplos de Uso</h2>
        
        <h3>Crear Departamento</h3>
        <div class="code-block">
            POST /api/v1/departamentos<br>
            Content-Type: application/json<br><br>
            {<br>
            &nbsp;&nbsp;"nombre": "Desarrollo Software",<br>
            &nbsp;&nbsp;"presupuesto": 200000.00<br>
            }
        </div>
        
        <h3>Registrar Fichaje</h3>
        <div class="code-block">
            POST /api/v1/empleados/1/fichar<br><br>
            // Respuesta automática:<br>
            {<br>
            &nbsp;&nbsp;"tipo": "ENTRADA",<br>
            &nbsp;&nbsp;"momento": "2025-01-20T08:00:00",<br>
            &nbsp;&nbsp;"empleado": "Ana García López"<br>
            }
        </div>
    </div>

    <!-- GESTIÓN DE ERRORES -->
    <div class="card">
        <h2>⚠️ Gestión de Errores</h2>
        
        <div class="grid">
            <div class="card">
                <h3 style="color: var(--danger);">🔍 404 Not Found</h3>
                <p><strong>EntidadNoEncontradaException</strong></p>
                <p>Recurso solicitado no existe</p>
            </div>
            
            <div class="card">
                <h3 style="color: var(--warning);">⚡ 409 Conflict</h3>
                <p><strong>FichajeDuplicadoException</strong></p>
                <p>Dos fichajes consecutivos del mismo tipo</p>
            </div>
            
            <div class="card">
                <h3 style="color: var(--danger);">💰 400 Bad Request</h3>
                <p><strong>PresupuestoExcedidoException</strong></p>
                <p>Salarios exceden presupuesto del departamento</p>
            </div>
        </div>
    </div>

    <!-- TECNOLOGÍAS -->
    <div class="card">
        <h2>🛠️ Stack Tecnológico</h2>
        
        <div class="tech-stack">
            <div class="tech-item">Spring Boot 3.x</div>
            <div class="tech-item">Spring Data JPA</div>
            <div class="tech-item">Spring MVC</div>
            <div class="tech-item">H2 Database</div>
            <div class="tech-item">OpenAPI 3.0</div>
            <div class="tech-item">Swagger UI</div>
            <div class="tech-item">Bean Validation</div>
            <div class="tech-item">Maven</div>
        </div>
    </div>

    <!-- INFORMACIÓN ACADÉMICA -->
    <div class="card">
        <h2>🎓 Información del Proyecto</h2>
        
        <div class="grid">
            <div class="card">
                <h3><i class="fas fa-graduation-cap"></i> Académico</h3>
                <p><strong>Tipo:</strong> Registro de Jornada - Tipo C</p>
                <p><strong>Módulos:</strong> Acceso a Datos + Servicios y Procesos</p>
            </div>
            
            <div class="card">
                <h3><i class="fas fa-calendar"></i> Temporal</h3>
                <p><strong>Curso:</strong> 2025-26</p>
                <p><strong>Entrega:</strong> 28 Noviembre 2025</p>
            </div>
            
            <div class="card">
                <h3><i class="fas fa-code"></i> Desarrollo</h3>
                <p><strong>Metodología:</strong> Scrum Express</p>
                <p><strong>Entrega:</strong> Repositorio GitHub</p>
            </div>
        </div>
    </div>

    <!-- FOOTER -->
    <div class="header" style="text-align: center; margin-top: 40px;">
        <h3>¿Necesitas Ayuda?</h3>
        <p>Consulta la documentación en Swagger o abre un issue en el repositorio</p>
        <div class="badges">
            <span class="badge spring"><i class="fas fa-book"></i> Documentación Completa</span>
            <span class="badge java"><i class="fas fa-code-branch"></i> Código Abierto</span>
        </div>
        <p style="margin-top: 20px; color: var(--gray);">
            Desarrollado con ❤️ usando Spring Boot | Curso 2025-26
        </p>
    </div>
</div>
</body> </html>
