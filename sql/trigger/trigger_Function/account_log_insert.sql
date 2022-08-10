-- FUNCTION: public.account_log_insert()

-- DROP FUNCTION IF EXISTS public.account_log_insert();

CREATE OR REPLACE FUNCTION public.account_log_insert()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN

    INSERT INTO public.accounts_log(accountid, coinid, quantitycoin_log, contract, time_create,status )
	VALUES (new.accountId,new.coinId,new.quantityCoin,new.contract, new.time_update, 'INS');
	RETURN NEW;
END;
$BODY$;

ALTER FUNCTION public.account_log_insert()
    OWNER TO postgres;
