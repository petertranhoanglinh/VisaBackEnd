-- SEQUENCE: public.pdt_seq

-- DROP SEQUENCE public.pdt_seq;

CREATE SEQUENCE public.pdt_seq
    CYCLE
    INCREMENT 1
    START 100000
    MINVALUE 100000
    MAXVALUE 9999999999
    CACHE 1;

ALTER SEQUENCE public.pdt_seq
    OWNER TO postgres;