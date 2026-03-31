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


