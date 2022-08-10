-- PROCEDURE: public.done_cart_sp(character varying, numeric, character varying)

-- DROP PROCEDURE public.done_cart_sp(character varying, numeric, character varying);

CREATE OR REPLACE PROCEDURE public.done_cart_sp(
	INOUT textinout character varying,
	sp_id numeric,
	sp_contract_b character varying)
LANGUAGE 'plpgsql'
AS $BODY$
declare v_rec record;
        v_buyer varchar;
        v_quantityB numeric(25,8);
begin
  select quantitycoin into v_quantityB from accounts where contract = sp_contract_b;
  select accountId into v_buyer from accounts where contract = sp_contract_b;
  select * into v_rec  from cart where id = sp_id;
  if(v_rec.status= 0) then 
     if(v_quantityB < (v_rec.quantity * v_rec.coin_price)) then
	    textInOut = 'the number of coins is not enough to make' ;
	 else 
	    -- do update coin seller (ETH , BTC ,USDT )
		   update accounts set quantityCoin = quantityCoin + (v_rec.quantity * v_rec.coin_price) 
		        where coinid = v_rec.optionCoin and accountId =  v_rec.sellerId;
		   update accounts set quantityCoin = quantityCoin - v_rec.quantity where coinId = v_rec.coinId and accountId = v_rec.sellerId;
		-- do update coin buyer
		   update accounts set quantityCoin = quantityCoin - (v_rec.quantity * v_rec.coin_price) where contract = sp_contract_b;
		   update accounts set quantityCoin = quantityCoin + v_rec.quantity where coinId = v_rec.coinId and accountId = v_buyer;
		-- update cart
		   update cart set status = 1 , update_date = to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text) 
		   , note = 'finish' , contract_b = sp_contract_b , buyerid = v_buyer
		   where id = sp_id; 
		commit;
		textInOut = 'DONE';
	 end if;
  else
    textInOut  = 'Orders that have been completed cannot be purchased';
  end if;
end;
$BODY$;
