-- PROCEDURE: public.sp_ord_tmt(numeric, numeric, numeric, character varying)

-- DROP PROCEDURE IF EXISTS public.sp_ord_tmt(numeric, numeric, numeric, character varying);

CREATE OR REPLACE PROCEDURE public.sp_ord_tmt(
	IN qty_sp numeric,
	IN pdt_id_sp numeric,
	IN userid_sp character varying,
	INOUT result_sp numeric)
LANGUAGE 'plpgsql'
AS $BODY$
declare v_ord_tmt_sp numeric;
v_qty numeric;
begin 
	select max(ord_tmt) into v_ord_tmt_sp from ord_tmt where userid = userid_sp 
    and ord_id = '';
	select qty into v_qty from  ord_tmt
	where userid = userid_sp and ord_tmt = v_ord_tmt_sp and pdt_id = pdt_id_sp and ord_id = ''; 
    if(v_qty is null ) then v_qty := 0; end if;
	if(v_ord_tmt_sp is null and v_qty = 0)
		then 
		if(qty_sp < 0 ) then qty_sp:= 0; end if;
		insert into ord_tmt (userid, pdt_id , qty )
			 values(userid_sp, pdt_id_sp , qty_sp);
			 result_sp = 1;
		-- tạo mới đơn hàng 
	elsif  (v_ord_tmt_sp is not null and v_qty = 0)
		then 
	    delete from ord_tmt where userid = userid_sp and pdt_id = pdt_id_sp and ord_id = '';
		if(qty_sp < 0 ) then qty_sp:= 0; end if;
		insert into ord_tmt (userid, pdt_id , qty,ord_tmt )
			 values(userid_sp, pdt_id_sp , qty_sp, v_ord_tmt_sp);
			 result_sp = 2;
			 -- thêm mới sản phẩm vào đơn hàng 
	else 
	     if((v_qty + qty_sp) < 0) then v_qty = 0 ;
		 else
		 	v_qty := v_qty + qty_sp ; end if;
	     update ord_tmt set qty = v_qty , update_date = to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text)
	     where userid = userid_sp and pdt_id = pdt_id_sp;
		 result_sp = 3;
		   -- update đơn hàng 
	end if;
	commit;
end; 
$BODY$;
ALTER PROCEDURE public.sp_ord_tmt(numeric, numeric, numeric, character varying)
    OWNER TO postgres;
