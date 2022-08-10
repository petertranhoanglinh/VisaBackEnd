-- Table: public.rewiew

-- DROP TABLE public.rewiew;

CREATE TABLE IF NOT EXISTS public.rewiew
(
    id numeric NOT NULL DEFAULT nextval('seqid'::regclass),
    pdt_id numeric NOT NULL,
    create_by character varying(50) COLLATE pg_catalog."default" NOT NULL,
    rate integer DEFAULT 0,
    comment character varying(255) COLLATE pg_catalog."default",
    create_date character(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    CONSTRAINT rewiew_pkey PRIMARY KEY (id),
    CONSTRAINT pk_accountid_rewiew FOREIGN KEY (create_by)
        REFERENCES public.users (userid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT pk_pdt_id_rewiew FOREIGN KEY (pdt_id)
        REFERENCES public.product (pdt_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.rewiew
    OWNER to postgres;