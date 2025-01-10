INSERT INTO usuario (id_usuario, username, email, password, fecha_creacion)
VALUES (1, 'bacurillo', 'bacurillo@example.com', '1234', '2025-01-05 10:05:00'),
       (2, 'mariagonzalez', 'maria.gonzalez@example.com', 'mypassword456', '2025-01-05 10:05:00'),
       (3, 'pedrolopez', 'pedro.lopez@example.com', 'secure789', '2025-01-05 10:10:00'),
       (4, 'anaferreira', 'ana.ferreira@example.com', 'mysecret012', '2025-01-05 10:15:00'),
       (5, 'carlosramos', 'carlos.ramos@example.com', 'carpassword345',
        '2025-01-05 10:20:00'),
       (6, 'juanperez', 'juan.perez@example.com', 'password123',
        '2025-01-05 10:00:00')ON CONFLICT (id_usuario) DO NOTHING;

INSERT INTO metodo_pago (id_metodo_pago, nombre)
VALUES ('TDC', 'Tarjeta de Crédito'),
       ('TDD', 'Tarjeta de Débito'),
       ('EFC', 'Efectivo'),
       ('TBA', 'Transferencia Bancaria'),
       ('PPL', 'PayPal'),
       ('BTC', 'Bitcoin'),
       ('CHQ', 'Cheque'),
       ('APP', 'Apple Pay'),
       ('GGP', 'Google Pay'),
       ('COD', 'Códigos de Descuento') ON CONFLICT (id_metodo_pago) DO NOTHING;

-- Categorías de Gasto
INSERT INTO categoria (id_categoria, nombre, tipo, descripcion)
VALUES ('COM', 'Comida', 'Gasto', 'Gastos relacionados con alimentos y bebidas'),
       ('HOG', 'Hogar', 'Gasto', 'Gastos relacionados con la vivienda y el hogar'),
       ('TRA', 'Transporte', 'Gasto', 'Gastos relacionados con el transporte y movilidad'),
       ('SAL', 'Salud', 'Gasto', 'Gastos médicos, seguros y salud'),
       ('COM', 'Comunicación', 'Gasto', 'Gastos en servicios de telefonía e internet'),
       ('EDU', 'Educación', 'Gasto', 'Gastos relacionados con la educación y formación'),
       ('AUT', 'Automóvil', 'Gasto',
        'Gastos relacionados con la compra, mantenimiento y gasolina de vehículos') ON CONFLICT (id_categoria) DO NOTHING;

-- Categorías de Ingreso
INSERT INTO categoria (id_Categoria, nombre, tipo, descripcion)
VALUES ('SAL', 'Salario', 'Ingreso', 'Ingresos provenientes del salario o sueldo'),
       ('VEN', 'Ventas', 'Ingreso', 'Ingresos generados por la venta de productos o servicios'),
       ('AHO', 'Ahorros', 'Ingreso', 'Ingresos provenientes de ahorros o inversiones'),
       ('FRE', 'Freelance', 'Ingreso', 'Ingresos por trabajos freelance o autónomos'),
       ('BON', 'Bonificaciones', 'Ingreso', 'Ingresos adicionales por bonificaciones o premios'),
       ('REN', 'Rentas', 'Ingreso',
        'Ingresos provenientes de propiedades o alquileres') ON CONFLICT (id_Categoria) DO NOTHING;


-----------------------------------
-- Ingresos para el Usuario 1
INSERT INTO ingreso (id_ingreso, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES (1, 1500.00, '2025-01-01', 'Salario mensual', 1, 'SAL', 'TDC'),
       (2, 200.00, '2025-01-02', 'Ventas producto A', 1, 'VEN', 'EFC'),
       (3, 100.00, '2025-01-03', 'Freelance proyecto', 1, 'FRE', 'TDC') ON CONFLICT (id_ingreso) DO NOTHING;

-- Ingresos para el Usuario 2
INSERT INTO ingreso (id_ingreso, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES (4, 1200.00, '2025-01-01', 'Salario mensual', 2, 'SAL', 'EFC'),
       (5, 500.00, '2025-01-05', 'Ventas producto B', 2, 'VEN', 'TDD'),
       (6, 300.00, '2025-01-06', 'Bonificación de rendimiento', 2, 'BON', 'EFC'),
       (7, 100.00, '2025-01-07', 'Freelance tarea extra', 2, 'FRE', 'TDD') ON CONFLICT (id_ingreso) DO NOTHING;

-- Ingresos para el Usuario 3
INSERT INTO ingreso (id_ingreso, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES (8, 1500.00, '2025-01-01', 'Salario mensual', 3, 'SAL', 'EFC'),
       (9, 350.00, '2025-01-02', 'Rentas alquiler propiedad', 3, 'REN', 'EFC'),
       (10, 200.00, '2025-01-03', 'Ventas producto C', 3, 'VEN', 'TDC'),
       (11, 150.00, '2025-01-04', 'Freelance desarrollo web', 3, 'FRE', 'EFC'),
       (12, 250.00, '2025-01-05', 'Bonus anual', 3, 'BON', 'TDC') ON CONFLICT (id_ingreso) DO NOTHING;

-- Ingresos para el Usuario 4
INSERT INTO ingreso (id_ingreso, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES (13, 1800.00, '2025-01-01', 'Salario mensual', 4, 'SAL', 'TDC'),
       (14, 100.00, '2025-01-02', 'Ventas producto D', 4, 'VEN', 'EFC'),
       (15, 400.00, '2025-01-03', 'Freelance consultoría', 4, 'FRE', 'TDC'),
       (16, 50.00, '2025-01-04', 'Bonificación de desempeño', 4, 'BON', 'EFC') ON CONFLICT (id_ingreso) DO NOTHING;

-- Ingresos para el Usuario 5
INSERT INTO ingreso (id_ingreso, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES (17, 1100.00, '2025-01-01', 'Salario mensual', 5, 'SAL', 'EFC'),
       (18, 200.00, '2025-01-03', 'Ventas producto E', 5, 'VEN', 'TDC'),
       (19, 150.00, '2025-01-04', 'Freelance redacción', 5, 'FRE', 'EFC'),
       (20, 80.00, '2025-01-05', 'Bonificación especial', 5, 'BON', 'TDC'),
       (21, 200.00, '2025-01-06', 'Consultoría freelance', 5, 'FRE', 'EFC') ON CONFLICT (id_ingreso) DO NOTHING;

-- Ingresos para el Usuario 6
INSERT INTO ingreso (id_ingreso, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES (22, 1600.00, '2025-01-01', 'Salario mensual', 6, 'SAL', 'TDC'),
       (23, 100.00, '2025-01-02', 'Rentas alquiler propiedad', 6, 'REN', 'EFC'),
       (24, 300.00, '2025-01-03', 'Ventas producto F', 6, 'VEN', 'TDC'),
       (25, 100.00, '2025-01-04', 'Freelance desarrollo de software', 6, 'FRE', 'EFC'),
       (26, 120.00, '2025-01-05', 'Bonificación por proyecto', 6, 'BON', 'TDC'),
       (27, 80.00, '2025-01-06', 'Freelance marketing', 6, 'FRE', 'EFC') ON CONFLICT (id_ingreso) DO NOTHING;


----------------------

-- Gastos para el Usuario 1
INSERT INTO gasto (id_gasto, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES
    (1, 100.00, '2025-01-01', 'Compra de material de oficina', 1, 'COM', 'EFC'),
    (2, 50.00, '2025-01-02', 'Compra de herramientas de trabajo', 1, 'TRA', 'TDC'),
    (3, 200.00, '2025-01-03', 'Suscripción mensual a software', 1, 'AUT', 'TBA')
    ON CONFLICT (id_gasto) DO NOTHING;
--
-- Gastos para el Usuario 2
INSERT INTO gasto (id_gasto, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES
    (4, 150.00, '2025-01-01', 'Compra de libros', 2, 'EDU', 'EFC'),
    (5, 30.00, '2025-01-02', 'Alquiler de espacio de trabajo', 2, 'SAL', 'TDC'),
    (6, 80.00, '2025-01-03', 'Reparación de equipo', 2, 'HOG', 'PPL'),
    (7, 120.00, '2025-01-04', 'Viaje de negocios', 2, 'COM', 'TBA') ON CONFLICT (id_gasto) DO NOTHING;

-- Gastos para el Usuario 3
INSERT INTO gasto (id_gasto, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES
    (8, 300.00, '2025-01-01', 'Alquiler oficina', 3, 'COM', 'EFC'),
    (9, 100.00, '2025-01-02', 'Material para proyecto', 3, 'AUT', 'BTC'),
    (10, 50.00, '2025-01-03', 'Pago de suscripción a plataforma', 3, 'HOG', 'TDC'),
    (11, 70.00, '2025-01-04', 'Compra de equipo tecnológico', 3, 'SAL', 'APP') ON CONFLICT (id_gasto) DO NOTHING;

-- Gastos para el Usuario 4
INSERT INTO gasto (id_gasto, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES
    (12, 200.00, '2025-01-01', 'Compra de equipos de oficina', 4, 'EDU', 'GGP'),
    (13, 150.00, '2025-01-02', 'Pago de asesoría jurídica', 4, 'COM', 'TDD'),
    (14, 250.00, '2025-01-03', 'Pago de suscripción a software', 4, 'TRA', 'TBA') ON CONFLICT (id_gasto) DO NOTHING;

-- Gastos para el Usuario 5
INSERT INTO gasto (id_gasto, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES
    (15, 50.00, '2025-01-01', 'Compra de suministros', 5, 'TRA', 'COD'),
    (16, 30.00, '2025-01-02', 'Pago de transporte', 5, 'HOG', 'TDC'),
    (17, 100.00, '2025-01-03', 'Compra de material promocional', 5, 'COM', 'PPL'),
    (18, 60.00, '2025-01-04', 'Servicios de mensajería', 5, 'HOG', 'CHQ') ON CONFLICT (id_gasto) DO NOTHING;

-- Gastos para el Usuario 6
INSERT INTO gasto (id_gasto, monto, fecha, descripcion, id_usuario, id_categoria, id_metodo_pago)
VALUES
    (19, 200.00, '2025-01-01', 'Pago de renta de oficina', 6, 'COM', 'TBA'),
    (20, 100.00, '2025-01-02', 'Compra de equipos informáticos', 6, 'HOG', 'BTC'),
    (21, 70.00, '2025-01-03', 'Pago de suscripción a herramientas', 6, 'TRA', 'TDC'),
    (22, 50.00, '2025-01-04', 'Servicios de publicidad online', 6, 'SAL', 'APP'),
    (23, 80.00, '2025-01-05', 'Pago de consultoría externa', 6, 'EDU', 'GGP') ON CONFLICT (id_gasto) DO NOTHING;
