-- PROCEDURE: public.sp_rewiew(character varying, numeric, character varying, integer, character varying)

-- DROP PROCEDURE public.sp_rewiew(character varying, numeric, character varying, integer, character varying);

CREATE OR REPLACE PROCEDURE public.sp_rewiew(
	INOUT id_sp character varying,
	pdt_id_sp numeric,
	create_by_sp character varying,
	rate_sp integer,
	comment_sp character varying)
LANGUAGE 'plpgsql'
AS $BODY$
begin
	   insert into rewiew (pdt_id , create_by , rate , comment)
	   values(pdt_id_sp, create_by_sp, rate_sp, comment_sp);
	   commit;
	   id_sp = 'suscess';
end;
$BODY$;
