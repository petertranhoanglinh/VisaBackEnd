-- Table: public.cart_shopping

-- DROP TABLE public.cart_shopping;

CREATE TABLE IF NOT EXISTS public.cart_shopping
(
    id numeric NOT NULL DEFAULT nextval('seqorder'::regclass),
    seller_id character varying(20) COLLATE pg_catalog."default",
    contract_seller character varying(50) COLLATE pg_catalog."default",
    buyer_id character varying(20) COLLATE pg_catalog."default",
    contract_buyer character varying(50) COLLATE pg_catalog."default",
    status character varying(10) COLLATE pg_catalog."default",
    date_create date DEFAULT CURRENT_DATE,
    work_user character varying(10) COLLATE pg_catalog."default",
    time_update character(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    quantity_coin numeric(25,8),
    coinid character varying(10) COLLATE pg_catalog."default",
    coin_price numeric(19,8) DEFAULT 0,
    CONSTRAINT cart_shopping_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.cart_shopping
    OWNER to postgres;