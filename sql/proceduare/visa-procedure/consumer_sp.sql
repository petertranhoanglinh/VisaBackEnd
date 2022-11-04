-- PROCEDURE: public.consumer_sp(numeric, character varying, character varying, character varying, character varying, character varying, numeric)

-- DROP PROCEDURE public.consumer_sp(numeric, character varying, character varying, character varying, character varying, character varying, numeric);

CREATE OR REPLACE PROCEDURE public.consumer_sp(
	IN id_sp numeric,
	IN name_sp character varying,
	IN address_sp character varying,
	IN mobile_sp character varying,
	IN email_sp character varying,
	IN work_user_sp character varying,
	INOUT result_sp numeric)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE v_id numeric;
BEGIN
	SELECT ID INTO v_id FROM CONSUMER WHERE id = ID_SP;
	
	IF(v_id is null) THEN 
		RESULT_SP = 1;
		INSERT INTO CONSUMER(NAME, ADDRESS, MOBILE, EMAIL, work_user)
		VALUES(NAME_SP, ADDRESS_SP, MOBILE_SP, EMAIL_SP, work_user_sp);
	ELSE 
	    UPDATE CONSUMER 
		   SET NAME = NAME_SP 
		     , ADDRESS = ADDRESS_SP
			 , MOBILE  = MOBILE_SP
			 , EMAIL   = EMAIL_SP
		 WHERE ID = ID_SP;
		 RESULT_SP = 2;
	END IF;
	
exception
    when unique_violation then
        RESULT_SP = 3;
COMMIT;
END;
$BODY$;
