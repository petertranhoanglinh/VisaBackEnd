-- PROCEDURE: public.user_pk(character varying, character varying, numeric)

-- DROP PROCEDURE public.user_pk(character varying, character varying, numeric);

CREATE OR REPLACE PROCEDURE public.user_pk(
	IN sp_email character varying,
	IN sp_password character varying,
	INOUT text numeric)
LANGUAGE 'plpgsql'
AS $BODY$
declare 
v_data record;
txt varchar;
BEGIN
    txt = cast ( nextval('user_seq') as int8);
	select * into v_data from users where email = sp_email;
	if(v_data.email is not null) then text = 0;
	else 
		insert into users(userid,password,email,role , username)
		values('VN'||txt , sp_password, sp_email,'USER',sp_email);
		text = 1;
	end if;
	commit;	
END;
$BODY$;
