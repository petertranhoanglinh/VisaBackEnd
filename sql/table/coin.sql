-- Table: public.coin

-- DROP TABLE public.coin;

CREATE TABLE IF NOT EXISTS public.coin
(
    coinid character varying(255) COLLATE pg_catalog."default" NOT NULL,
    coinname character varying(255) COLLATE pg_catalog."default",
    time_update timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    price numeric(19,8),
    maket_cap numeric(19,8) DEFAULT 0,
    total_coin numeric DEFAULT 0,
    CONSTRAINT coin_pkey PRIMARY KEY (coinid)
)

TABLESPACE pg_default;

ALTER TABLE public.coin
    OWNER to postgres;

-- Trigger: coin_update

-- DROP TRIGGER coin_update ON public.coin;

CREATE TRIGGER coin_update
    AFTER UPDATE 
    ON public.coin
    FOR EACH ROW
    EXECUTE FUNCTION public.coin_log_update();