-- Table: public.product

-- DROP TABLE public.product;

CREATE TABLE IF NOT EXISTS public.product
(
    pdt_id numeric NOT NULL DEFAULT nextval('pdt_seq'::regclass),
    pdt_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    price numeric(19,6) DEFAULT 0,
    description character varying(255) COLLATE pg_catalog."default" DEFAULT ''::character varying,
    pdt_kind character varying(50) COLLATE pg_catalog."default",
    create_by character varying(50) COLLATE pg_catalog."default",
    create_date character varying(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    update_date character varying(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    start_sale character varying(8) COLLATE pg_catalog."default" DEFAULT '00000000'::character varying,
    end_sale character varying(8) COLLATE pg_catalog."default" DEFAULT '99999999'::character varying,
    kind_coin character varying(20) COLLATE pg_catalog."default" DEFAULT 'USDT'::character varying,
    note character varying(255) COLLATE pg_catalog."default" DEFAULT ''::character varying,
    image character varying(255) COLLATE pg_catalog."default" DEFAULT ''::character varying,
    image1 character varying(255) COLLATE pg_catalog."default" DEFAULT ''::character varying,
    image2 character varying(255) COLLATE pg_catalog."default" DEFAULT ''::character varying,
    CONSTRAINT product_pkey PRIMARY KEY (pdt_id),
    CONSTRAINT fk_pdt_coin FOREIGN KEY (kind_coin)
        REFERENCES public.coin (coinid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_pdt_user FOREIGN KEY (create_by)
        REFERENCES public.users (userid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.product
    OWNER to postgres;