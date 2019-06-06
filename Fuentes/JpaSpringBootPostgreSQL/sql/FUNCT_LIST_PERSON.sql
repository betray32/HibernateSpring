-- Crear procedure para obtener todos los registros
CREATE OR REPLACE FUNCTION list_person()
 RETURNS TABLE(id numeric, first_name character varying, last_name character varying , address character varying)
 LANGUAGE plpgsql
AS $function$
begin
 	return QUERY
 	select * from person;
	
end;
$function$;

-- Obtener registro a partir del id
CREATE OR REPLACE FUNCTION list_person_id(idregistro integer)
 RETURNS TABLE(id numeric, first_name character varying, last_name character varying , address character varying)
 LANGUAGE plpgsql
AS $function$
begin
 	return QUERY
 	select * 
 	from person 
 	where person.id = idregistro;
	
end;
$function$;

-- Obtener datos especificos de cliente, ejemplo con entradas y salidas
CREATE OR REPLACE FUNCTION obtenerDatosClienteInicial
(
	idregistro integer
	, out nombre text
	, out direccion text
)
	AS 
	$function$
begin
 	select first_name into nombre from person where id=idregistro;
 	select address into direccion from person where id=idregistro;
	
end;
$function$ LANGUAGE plpgsql;