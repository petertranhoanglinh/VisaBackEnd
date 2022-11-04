-- FUNCTION: public.get_ord_id(character varying)

-- DROP FUNCTION public.get_ord_id(character varying);

CREATE OR REPLACE FUNCTION public.get_ord_id(
	sp_com_id character varying)
    RETURNS character varying
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
declare
	rec varchar ;
	txt varchar;
begin 
  txt = cast ( nextval('ord_seq') as int8);
  rec:=  sp_com_id || txt;
  return rec;
end;
$BODY$;

ALTER FUNCTION public.get_ord_id(character varying)
    OWNER TO bmnprpjdbokbwl;
