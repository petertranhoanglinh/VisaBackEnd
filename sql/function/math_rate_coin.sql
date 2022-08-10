-- FUNCTION: public.math_rate_coin_fn(character varying, numeric)

-- DROP FUNCTION public.math_rate_coin_fn(character varying, numeric);

CREATE OR REPLACE FUNCTION public.math_rate_coin_fn(
	v_coinid character varying,
	v_price_input numeric)
    RETURNS numeric
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
declare 
  v_total numeric(5,2);
  v_price_now "coin".price % type;
BEGIN 
  SELECT price into v_price_now from coin where coinId = v_coinId ;
  if(v_price_now  != 0) then 
    v_total:= ( v_price_now / v_price_InPut ) * 100;
  else
  v_total = 0;
  end if;
return v_total - 100;
end;
$BODY$;

ALTER FUNCTION public.math_rate_coin_fn(character varying, numeric)
    OWNER TO postgres;
