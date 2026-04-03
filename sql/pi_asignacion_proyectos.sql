-- Daniel Angel Encinas

-- Creacion y uso de la base de datos
DROP DATABASE IF EXISTS pi_asignacion_proyectos;
CREATE DATABASE pi_asignacion_proyectos;
USE pi_asignacion_proyectos;



-- Creacion de la tabla Cliente
CREATE TABLE cliente (
                         id INT AUTO_INCREMENT,
                         DNI VARCHAR(11),
                         nombre VARCHAR(50) NOT NULL,
                         apellido1 VARCHAR(75) NOT NULL,
                         apellido2 VARCHAR(75),
                         email VARCHAR(100) NOT NULL,
                         telefono VARCHAR(11) NOT NULL,
                         CONSTRAINT pk_cliente PRIMARY KEY(id),
                         CONSTRAINT uk_cliente_dni UNIQUE KEY(DNI)
);

-- Creacion de la tabla Desarrollador
CREATE TABLE desarrollador (
                               id INT AUTO_INCREMENT,
                               DNI VARCHAR(11),
                               nombre VARCHAR(50) NOT NULL,
                               apellido1 VARCHAR(75) NOT NULL,
                               apellido2 VARCHAR(75),
                               email VARCHAR(100) NOT NULL,
                               fecha_alta DATE NOT NULL,
                               CONSTRAINT pk_desarrollador PRIMARY KEY(id),
                               CONSTRAINT uk_desarrollador_dni UNIQUE KEY(DNI)
);

-- Creacion de la tabla Proyecto
CREATE TABLE proyecto (
                          id INT AUTO_INCREMENT,
                          nombre VARCHAR(50) NOT NULL,
                          descripcion VARCHAR(500),
                          fecha_inicio DATE NOT NULL,
                          fecha_fin DATE,
                          horas_previstas INT,
                          CONSTRAINT pk_proyecto PRIMARY KEY(id)
);

-- Creacion de la tabla Asignacion
CREATE TABLE asignacion (
                            id INT AUTO_INCREMENT,
                            id_cliente INT NOT NULL,
                            id_desarrollador INT NOT NULL,
                            id_proyecto INT NOT NULL,
                            fecha_inicio DATE NOT NULL,
                            fecha_fin DATE,
                            horas_trabajadas INT,
                            CONSTRAINT pk_asignacion PRIMARY KEY(id),
                            CONSTRAINT fk_asignacion_cliente FOREIGN KEY(id_cliente) REFERENCES cliente(id),
                            CONSTRAINT fk_asignacion_desarrollador FOREIGN KEY(id_desarrollador) REFERENCES desarrollador(id),
                            CONSTRAINT fk_asignacion_proyecto FOREIGN KEY(id_proyecto) REFERENCES proyecto(id)
);


-- Creacion de usuario
DROP USER mantenimiento@'%';
CREATE USER mantenimiento@'%' IDENTIFIED BY 'admin';
-- Permisos al usuario
GRANT INSERT, DELETE, SELECT, UPDATE, EXECUTE ON pi_asignacion_proyectos.* TO mantenimiento@'%';


-- Creacion del procedimiento para insertar datos a la tabla desarrollador
DELIMITER //
CREATE PROCEDURE sp_insertar_desarrollador(
    -- Datos de entrada
    IN dni VARCHAR(11),
    IN nombre VARCHAR(50),
    IN apellido1 VARCHAR(75),
    IN apellido2 VARCHAR(75),
    IN email VARCHAR(100),
    IN fecha_alta DATE
)
BEGIN
	-- Sentecia con los datos para introducir en la tabla
INSERT INTO desarrollador (DNI, nombre, apellido1, apellido2, email, fecha_alta)
VALUES (dni, nombre, apellido1, apellido2, email, fecha_alta);
END //
DELIMITER ;

-- Creacion del procedimiento para consultar datos de la tabla desarrollador
DELIMITER //
CREATE PROCEDURE sp_get_desarrollador(
    -- Id que ha dado el usuario
    IN v_id INT
)
BEGIN
	-- Sentencia con el id dado
SELECT * FROM desarrollador WHERE id = v_id;
END //
DELIMITER ;

-- Creacion del procedimiento para modificar los datos de la tabla desarrollador
DELIMITER //
CREATE PROCEDURE sp_update_desarrollador(
    -- El id para identificarlo y los demas datos para modificarlos
    IN v_id INT,
    IN v_dni VARCHAR(11),
    IN v_nombre VARCHAR(50),
    IN v_apellido1 VARCHAR(75),
    IN v_apellido2 VARCHAR(75),
    IN v_email VARCHAR(100),
    IN v_fecha_alta DATE
)
BEGIN
	-- Sentencia para actualizar
UPDATE desarrollador SET DNI = v_dni, nombre = v_nombre, apellido1 = v_apellido1, apellido2 = v_apellido2, email = v_email, fecha_alta = v_fecha_alta WHERE id = v_id;
END //
DELIMITER ;