-- PROCEDURE: public.consumer_del_sp(numeric, character varying, numeric)

-- DROP PROCEDURE public.consumer_del_sp(numeric, character varying, numeric);

CREATE OR REPLACE PROCEDURE public.consumer_del_sp(
	IN id_sp numeric,
	IN work_user_sp character varying,
	INOUT result_sp numeric)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE v_check numeric;
BEGIN 
	SELECT ID INTO v_check from consumer where ID = id_sp AND work_user = work_user_sp;
	
	IF(v_check is not null) THEN
		DELETE FROM CONSUMER WHERE ID = id_sp;
		result_sp = 1;
	ELSE 
	    result_sp = 2;
	END IF;
COMMIT;
END;
$BODY$;
