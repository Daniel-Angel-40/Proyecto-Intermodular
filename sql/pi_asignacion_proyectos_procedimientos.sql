-- Creacion del procedimiento para insertar datos a la tabla desarrollador
DELIMITER //
CREATE PROCEDURE sp_ins_desarrollador(
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
CREATE PROCEDURE sp_upd_desarrollador(
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

-- Creacion del procedimiento para eliminar datos de la tabla desarrollador
DELIMITER //
CREATE PROCEDURE sp_del_desarrollador(
    -- Id para poder eliminar un desarrollador
    IN v_id INT
)
BEGIN
	-- Sentencia para eliminar un desarrollador
DELETE FROM desarrollador WHERE id = v_id;
END //
DELIMITER ;