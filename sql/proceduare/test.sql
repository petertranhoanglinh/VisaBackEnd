-- PROCEDURE: public.test(text)

-- DROP PROCEDURE public.test(text);

CREATE OR REPLACE PROCEDURE public.test(
	INOUT vuserid text DEFAULT NULL::text)
LANGUAGE 'plpgsql'
AS $BODY$
declare v_rec record;
BEGIN
   SELECT * INTO v_rec FROM users WHERE userid = vuserId    ;
   if(v_rec is not null) then vuserid := v_rec.userName || ' ' || v_rec.role ; end if;
END
$BODY$;
