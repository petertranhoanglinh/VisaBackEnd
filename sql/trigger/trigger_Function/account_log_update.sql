-- FUNCTION: public.account_log_update()

-- DROP FUNCTION IF EXISTS public.account_log_update();

CREATE OR REPLACE FUNCTION public.account_log_update()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
   IF (new.quantityCoin <> old.quantityCoin) then
    INSERT INTO public.accounts_log(accountid, coinid, quantitycoin_log, contract, time_create , status)
	VALUES (new.accountId,new.coinId,new.quantityCoin,new.contract, new.time_update , 'UPS');
   end if;
	RETURN NEW;
END;
$BODY$;

ALTER FUNCTION public.account_log_update()
    OWNER TO postgres;
