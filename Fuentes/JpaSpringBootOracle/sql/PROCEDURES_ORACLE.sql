
-- Procedimientos

-----------------------------------------------------------------------
-- Obtener todas las personas
CREATE OR REPLACE PROCEDURE OBTENER_PERSONAS
(
    c_personas OUT SYS_REFCURSOR
)
IS
BEGIN

    OPEN c_personas FOR
    SELECT * FROM PERSONA;
 
END;
/

-----------------------------------------------------------------------

-- Obtener un procedure de salida con codigos de salida y mensaje
CREATE OR REPLACE PROCEDURE OBTENER_PERSONAS_COD
(
    c_personas OUT SYS_REFCURSOR,
    codigo out numeric,
    mensaje out varchar2
)
IS
BEGIN

    OPEN c_personas FOR
    SELECT * FROM PERSONA;

    codigo := 0;
    mensaje := 'OK';

    EXCEPTION
    WHEN OTHERS THEN
        codigo := 500;
        mensaje := 'ERROR';

END;
/

-----------------------------------------------------------------------
-- Obtener data especifica a partir de un ID

CREATE OR REPLACE PROCEDURE OBTENER_CLIENTE_XID
(
    p_id IN varchar2,
    p_nombre OUT varchar2,
    p_direccion OUT varchar2
)
IS
BEGIN

    select NOMBRE into p_nombre FROM PERSONA WHERE IDPERSONA = p_id;
    select DIRECCION into p_direccion FROM PERSONA WHERE IDPERSONA = p_id;
 
END;
/
-----------------------------------------------------------------------