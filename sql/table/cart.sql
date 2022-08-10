-- Table: public.cart

-- DROP TABLE public.cart;

CREATE TABLE IF NOT EXISTS public.cart
(
    id numeric NOT NULL DEFAULT nextval('seqorder'::regclass),
    coinid character varying(10) COLLATE pg_catalog."default",
    quantity numeric(25,8),
    sellerid character varying(50) COLLATE pg_catalog."default",
    buyerid character varying(50) COLLATE pg_catalog."default",
    contract_s character varying(255) COLLATE pg_catalog."default",
    contract_b character varying(255) COLLATE pg_catalog."default",
    create_date character varying(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    update_date character varying(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    coin_price numeric(25,8),
    status numeric(1,0),
    note character varying(255) COLLATE pg_catalog."default",
    optioncoin character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT cart_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.cart
    OWNER to postgres;