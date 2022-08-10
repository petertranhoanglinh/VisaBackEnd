-- Table: public.ord_tmt

-- DROP TABLE public.ord_tmt;

CREATE TABLE IF NOT EXISTS public.ord_tmt
(
    userid character varying(20) COLLATE pg_catalog."default" NOT NULL,
    pdt_id numeric(20,0) NOT NULL,
    qty numeric NOT NULL,
    ord_tmt numeric DEFAULT nextval('seqid'::regclass),
    ord_id character varying COLLATE pg_catalog."default" DEFAULT ''::character varying,
    create_date character varying(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    update_date character varying(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    id numeric NOT NULL DEFAULT nextval('seqid'::regclass),
    CONSTRAINT ord_tmt_pkey PRIMARY KEY (id),
    CONSTRAINT fk_tmt_pdt FOREIGN KEY (pdt_id)
        REFERENCES public.product (pdt_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_tmt_user FOREIGN KEY (userid)
        REFERENCES public.users (userid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.ord_tmt
    OWNER to postgres;

GRANT ALL ON TABLE public.ord_tmt TO postgres;