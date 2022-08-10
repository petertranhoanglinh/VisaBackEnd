-- PROCEDURE: public.cart_sp(text, numeric, character varying, numeric, character varying, character varying, character varying, character varying, numeric, numeric, character varying, character varying)

-- DROP PROCEDURE public.cart_sp(text, numeric, character varying, numeric, character varying, character varying, character varying, character varying, numeric, numeric, character varying, character varying);

CREATE OR REPLACE PROCEDURE public.cart_sp(
	INOUT textout text,
	sp_id numeric,
	sp_coinid character varying,
	sp_quantity numeric,
	sp_seller_id character varying,
	sp_buyer_id character varying,
	sp_contract_s character varying,
	sp_contract_b character varying,
	sp_coin_price numeric,
	sp_status numeric,
	sp_note character varying,
	sp_optioncoin character varying)
LANGUAGE 'plpgsql'
AS $BODY$
declare v_quantityAccount numeric(25,8);
v_quantityCart numeric(25,8);
begin 

  SELECT QUANTITYCOIN INTO v_quantityAccount  FROM ACCOUNTS WHERE COINID = sp_coinid AND ACCOUNTID = sp_seller_id;
  SELECT SUM(QUANTITY) INTO v_quantityCart FROM CART WHERE COINID = sp_coinid  and sellerid = sp_seller_id and status = 0;
   
  IF((v_quantityAccount -  COALESCE(v_quantityCart,0)) < sp_quantity) THEN 
     textout = 'the amount of coins is not enough' ;
  ELSE
		  IF(textOut = 'INS') THEN 
				  INSERT INTO public.cart(
						coinid
					  , quantity
					  , sellerid
					  , buyerid
					  , contract_s
					  , contract_b
					  , coin_price
					  , status
					  , note
					  , optionCoin)
					VALUES (sp_coinId, sp_quantity,sp_seller_id
					,sp_buyer_id,sp_contract_s,sp_contract_b,sp_coin_price ,sp_status,sp_note,sp_optionCoin);
					COMMIT; 
					textOut = 'INS SUCCESS';
			  ELSIF(textOut = 'UPD')THEN
					UPDATE public.cart
					SET 
					  update_date = to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text)
					, coin_price = sp_coin_price
					, status     = sp_status
					, note       = sp_note
					WHERE id = sp_id;
					textOut = 'UPD SUCCESS';
					COMMIT; 
			  ELSE 
			textOut = 'FAIL';
		  END IF;
   END IF;
END;
$BODY$;
