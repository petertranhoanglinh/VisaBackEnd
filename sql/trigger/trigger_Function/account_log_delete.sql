-- FUNCTION: public.account_log_delete()

-- DROP FUNCTION IF EXISTS public.account_log_delete();

CREATE OR REPLACE FUNCTION public.account_log_delete()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN

    INSERT INTO public.accounts_log(accountid, coinid, quantitycoin_log, contract, time_create,status )
	VALUES (old.accountId,old.coinId,old.quantityCoin,old.contract, to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text), 'DEL');
	RETURN NEW;
END;
$BODY$;

ALTER FUNCTION public.account_log_delete()
    OWNER TO postgres;
