-- PROCEDURE: public.call_sp_notify(numeric, character varying, character varying, character varying, character varying)

-- DROP PROCEDURE public.call_sp_notify(numeric, character varying, character varying, character varying, character varying);

CREATE OR REPLACE PROCEDURE public.call_sp_notify(
	INOUT sp_test numeric,
	sp_title character varying,
	sp_note character varying,
	sp_image character varying,
	sp_range character varying)
LANGUAGE 'plpgsql'
AS $BODY$
begin
  if(sp_test = 0) then insert into notify ( title ,note , image , range )
  values (sp_title ,sp_note, sp_image, sp_range);
  else delete from notify where id = sp_test ;
  end if;
  commit;
  sp_test = 999;
end;
$BODY$;
