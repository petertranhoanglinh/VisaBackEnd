-- FUNCTION: public.coin_log_update()

-- DROP FUNCTION IF EXISTS public.coin_log_update();

CREATE OR REPLACE FUNCTION public.coin_log_update()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
	IF NEW.time_update <> OLD.time_update THEN
		 INSERT INTO coin_log(
				 coinid, coinname, price_log)
		VALUES (new.coinid, new.coinname, new.price);
	END IF;

	RETURN NEW;
END;
$BODY$;

ALTER FUNCTION public.coin_log_update()
    OWNER TO postgres;
