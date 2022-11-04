-- Table: public.consumer

-- DROP TABLE public.consumer;

CREATE TABLE IF NOT EXISTS public.consumer
(
    id numeric NOT NULL DEFAULT nextval('customer_seq'::regclass),
    name character varying(32) COLLATE pg_catalog."default" NOT NULL,
    address character varying(150) COLLATE pg_catalog."default",
    mobile character varying(32) COLLATE pg_catalog."default" NOT NULL,
    email character varying(32) COLLATE pg_catalog."default" DEFAULT ''::character varying,
    work_date character varying(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    work_user character varying(32) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT consumer_pkey PRIMARY KEY (mobile),
    CONSTRAINT consumer_id_key UNIQUE (id),
    CONSTRAINT fk_customer FOREIGN KEY (work_user)
        REFERENCES public.users (userid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.consumer
    OWNER to bmnprpjdbokbwl;
-- Index: consumer_mobile_index

-- DROP INDEX public.consumer_mobile_index;

CREATE INDEX consumer_mobile_index
    ON public.consumer USING btree
    (mobile COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;