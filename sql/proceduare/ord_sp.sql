-- PROCEDURE: public.ord_sp(character varying, numeric, character varying, integer)

-- DROP PROCEDURE public.ord_sp(character varying, numeric, character varying, integer);

CREATE OR REPLACE PROCEDURE public.ord_sp(
	IN userid_sp character varying,
	IN amt_sp numeric,
	INOUT resul_sp integer)
LANGUAGE 'plpgsql'
AS $BODY$
declare 
v_ord_tmt record;
v_ord record;
v_ord_tmt_max numeric;
v_id_max numeric;
v_seller varchar;
v_ord_id varchar;
begin
    select max(ord_tmt) into v_ord_tmt_max from ord_tmt 
		where userid = userid_sp;
	select max(id) into v_id_max from ord_tmt where ord_tmt = v_ord_tmt_max; 
	select * into v_ord_tmt from ord_tmt  
		where id = v_id_max;
	select * into v_ord from ord where  ord_tmt = v_ord_tmt_max;
	select create_by into v_seller from product  where pdt_id = v_ord_tmt.pdt_id;
	if(v_ord is null) then 
		-- insert new ord 
		insert into ord (ord_tmt,userid,status,amt,seller)
		values(v_ord_tmt.ord_tmt,v_ord_tmt.userid , 1,amt_sp,v_seller);
		select ord_id into v_ord_id  from ord where ord_tmt = v_ord_tmt_max;
		update ord_tmt set ord_id = v_ord_id where ord_tmt = v_ord_tmt_max;
		resul_sp = 1;
		commit;
    end if;
		 
end;
$BODY$;
