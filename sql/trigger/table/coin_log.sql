-- Table: public.coin_log

-- DROP TABLE public.coin_log;

CREATE TABLE IF NOT EXISTS public.coin_log
(
    id_log numeric NOT NULL DEFAULT nextval('seqid'::regclass),
    coinid character varying(255) COLLATE pg_catalog."default" NOT NULL,
    coinname character varying(255) COLLATE pg_catalog."default",
    price_log numeric(19,8),
    time_update char(8) COLLATE pg_catalog."default" DEFAULT to_char((CURRENT_DATE)::timestamp with time zone, 'yyyymmdd'::text),
    CONSTRAINT coin_log_pkey PRIMARY KEY (id_log)
)

TABLESPACE pg_default;

ALTER TABLE public.coin_log
    OWNER to postgres;