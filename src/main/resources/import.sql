DELETE FROM fichaje;DELETE FROM empleado;DELETE FROM departamento;

INSERT INTO departamento (id, nombre, presupuesto) VALUES (1, 'Desarrollo', 50000.00);
INSERT INTO departamento (id, nombre, presupuesto) VALUES (2, 'Ventas', 30000.00);
INSERT INTO departamento (id, nombre, presupuesto) VALUES (3, 'Recursos Humanos', 40000.00);
INSERT INTO departamento (id, nombre, presupuesto) VALUES (4, 'Marketing', 35000.00);

INSERT INTO empleado (id, nombre_completo, cargo, salario, departamento_id) VALUES (1, 'Roberto García', 'Desarrollador Senior', 35000.00, 1);
INSERT INTO empleado (id, nombre_completo, cargo, salario, departamento_id) VALUES (2, 'Ana López', 'Comercial', 25000.00, 2);
INSERT INTO empleado (id, nombre_completo, cargo, salario, departamento_id) VALUES (3, 'Carlos Martínez', 'Analista', 28000.00, 1);
INSERT INTO empleado (id, nombre_completo, cargo, salario, departamento_id) VALUES (4, 'María Rodríguez', 'Responsable de Selección', 32000.00, 3);
INSERT INTO empleado (id, nombre_completo, cargo, salario, departamento_id) VALUES (5, 'David Sánchez', 'Especialista en Marketing', 27000.00, 4);
INSERT INTO empleado (id, nombre_completo, cargo, salario, departamento_id) VALUES (6, 'Laura Fernández', 'Becaria', 18000.00, NULL);

INSERT INTO fichaje (id, momento, tipo, empleado_id) VALUES (1, '2024-11-25 08:00:00', 'ENTRADA', 1);
INSERT INTO fichaje (id, momento, tipo, empleado_id) VALUES (2, '2024-11-25 14:00:00', 'SALIDA', 1);
INSERT INTO fichaje (id, momento, tipo, empleado_id) VALUES (3, '2024-11-25 15:00:00', 'ENTRADA', 1);
INSERT INTO fichaje (id, momento, tipo, empleado_id) VALUES (4, '2024-11-25 18:00:00', 'SALIDA', 1);
INSERT INTO fichaje (id, momento, tipo, empleado_id) VALUES (5, '2024-11-25 09:00:00', 'ENTRADA', 2);
INSERT INTO fichaje (id, momento, tipo, empleado_id) VALUES (6, '2024-11-25 17:30:00', 'SALIDA', 2);
INSERT INTO fichaje (id, momento, tipo, empleado_id) VALUES (7, '2024-11-25 08:30:00', 'ENTRADA', 3);
