-- Crear procedure para obtener todos los registros
CREATE OR REPLACE FUNCTION list_person()
 RETURNS TABLE(id numeric, first_name character varying, last_name character varying , address character varying)
 LANGUAGE plpgsql
AS $function$
begin
 	return QUERY
 	select * from person;
	
end;
$function$
;
