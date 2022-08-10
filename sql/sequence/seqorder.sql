-- SEQUENCE: public.seqorder

-- DROP SEQUENCE public.seqorder;

CREATE SEQUENCE public.seqorder
    CYCLE
    INCREMENT 1
    START 1000000000
    MINVALUE 1000000000
    MAXVALUE 9999999999
    CACHE 1;

ALTER SEQUENCE public.seqorder
    OWNER TO postgres;