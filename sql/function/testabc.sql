-- FUNCTION: public.testabc()

-- DROP FUNCTION public.testabc();

CREATE OR REPLACE FUNCTION public.testabc(
	)
    RETURNS TABLE(userid_sp character varying, username_sp character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    RETURN QUERY 
	SELECT
        userid,
        username
    FROM
        users;
END;
$BODY$;

ALTER FUNCTION public.testabc()
    OWNER TO postgres;
