-- SEQUENCE: public.seqid

-- DROP SEQUENCE public.seqid;

CREATE SEQUENCE public.seqid
    CYCLE
    INCREMENT 1
    START 1
    MINVALUE 0
    MAXVALUE 9999999999
    CACHE 1;

ALTER SEQUENCE public.seqid
    OWNER TO postgres;