-- PROCEDURE: public.product_sp(numeric, character varying, numeric, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying)

-- DROP PROCEDURE IF EXISTS public.product_sp(numeric, character varying, numeric, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying);

CREATE OR REPLACE PROCEDURE public.product_sp(
	INOUT pdt_id_sp numeric,
	IN pdt_name_sp character varying,
	IN price_sp numeric,
	IN description_sp character varying,
	IN pdt_kind_sp character varying,
	IN create_by_sp character varying,
	IN start_sale_sp character varying,
	IN end_sale_sp character varying,
	IN kind_coin_sp character varying,
	IN note_sp character varying,
	IN image_sp character varying,
	IN image1_sp character varying,
	IN image2_sp character varying)
LANGUAGE 'plpgsql'
AS $BODY$
declare  check_id_v  numeric  ;
begin 
    select pdt_id into check_id_v from product where pdt_id = pdt_id_sp;
     if (check_id_v is null) then 
      insert into product(
   	    pdt_name, price, description, pdt_kind, 
           create_by, start_sale, end_sale, 
           kind_coin, note, image, image1, image2)
           values(
           pdt_name_sp, price_sp, description_sp, pdt_kind_sp, 
           create_by_sp, start_sale_sp, end_sale_sp, 
           kind_coin_sp, note_sp, image_sp, image1_sp, image2_sp
           );
		   pdt_id_sp = 1;
       else 
           update product
              set pdt_name       = pdt_name_sp 
                , price          = price_sp
                , description    = description_sp
                , pdt_kind       = pdt_kind_sp
                , update_date    = to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text)
                , start_sale     = start_sale_sp 
                , end_sale       = end_sale_sp
                , kind_coin      = kind_coin_sp
                , note           = note_sp
                , image          = image_sp
                , image1          = image1_sp
                , image2          = image2_sp
           where  pdt_id = pdt_id_sp;
		   pdt_id_sp = 2;
       end if;
    commit;
end;
$BODY$;
ALTER PROCEDURE public.product_sp(numeric, character varying, numeric, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying)
    OWNER TO postgres;
