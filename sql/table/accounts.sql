-- Table: public.accounts

-- DROP TABLE public.accounts;

CREATE TABLE IF NOT EXISTS public.accounts
(
    accountid character varying(20) COLLATE pg_catalog."default",
    coinid character varying(10) COLLATE pg_catalog."default",
    quantitycoin numeric(25,8) DEFAULT 0,
    contract character varying(50) COLLATE pg_catalog."default" NOT NULL DEFAULT random_string(20),
    id numeric NOT NULL DEFAULT nextval('seqid'::regclass),
    time_update character(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    CONSTRAINT accounts_pkey PRIMARY KEY (contract),
    CONSTRAINT fk_contraincoinid FOREIGN KEY (coinid)
        REFERENCES public.coin (coinid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_contraintuser FOREIGN KEY (accountid)
        REFERENCES public.users (userid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.accounts
    OWNER to postgres;