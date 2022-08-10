-- Table: public.notify

-- DROP TABLE public.notify;

CREATE TABLE IF NOT EXISTS public.notify
(
    id numeric NOT NULL DEFAULT nextval('seqid'::regclass),
    evendate character varying COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    note character varying COLLATE pg_catalog."default" DEFAULT ''::character varying,
    image character varying COLLATE pg_catalog."default" DEFAULT ''::character varying,
    range character varying(10) COLLATE pg_catalog."default",
    title character varying COLLATE pg_catalog."default" DEFAULT ''::character varying,
    CONSTRAINT notify_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;  

ALTER TABLE public.notify
    OWNER to postgres;