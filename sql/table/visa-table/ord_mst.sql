-- Table: public.ord_mst

-- DROP TABLE public.ord_mst;

CREATE TABLE IF NOT EXISTS public.ord_mst
(
    ord_id character varying(20) COLLATE pg_catalog."default" NOT NULL DEFAULT get_ord_id('visa'::character varying),
    consumer_id numeric(11,0) NOT NULL,
    service_id numeric(8,0) NOT NULL,
    work_user character varying(20) COLLATE pg_catalog."default" NOT NULL,
    vat numeric(12,4) NOT NULL,
    status character varying(1) COLLATE pg_catalog."default" NOT NULL DEFAULT 'A'::character varying,
    create_date character varying(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    ins_date character varying(20) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    total_amt numeric(20,4),
    CONSTRAINT ord_mst_pkey PRIMARY KEY (ord_id),
    CONSTRAINT fk_ord_mst_customer FOREIGN KEY (consumer_id)
        REFERENCES public.consumer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_ord_mst_work_user FOREIGN KEY (work_user)
        REFERENCES public.users (userid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.ord_mst
    OWNER to bmnprpjdbokbwl;
-- Index: consumer_ord_id_index

-- DROP INDEX public.consumer_ord_id_index;

CREATE INDEX consumer_ord_id_index
    ON public.ord_mst USING btree
    (ord_id COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: consumer_work_user_index

-- DROP INDEX public.consumer_work_user_index;

CREATE INDEX consumer_work_user_index
    ON public.ord_mst USING btree
    (work_user COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;