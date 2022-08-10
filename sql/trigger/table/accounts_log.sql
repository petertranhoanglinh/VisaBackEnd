-- Table: public.accounts_log

-- DROP TABLE IF EXISTS public.accounts_log;

CREATE TABLE IF NOT EXISTS public.accounts_log
(
    accountid character varying(20) COLLATE pg_catalog."default",
    coinid character varying(10) COLLATE pg_catalog."default",
    contract character varying(50) COLLATE pg_catalog."default",
    id_log numeric NOT NULL DEFAULT nextval('seqid'::regclass),
    time_create character(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    status character varying(8) COLLATE pg_catalog."default",
    quantitycoin_log numeric(25,8) DEFAULT 0
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.accounts_log
    OWNER to postgres;