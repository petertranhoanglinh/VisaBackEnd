-- SEQUENCE: public.ord_seq

-- DROP SEQUENCE public.ord_seq;

CREATE SEQUENCE public.ord_seq
    CYCLE
    INCREMENT 1
    START 1000000000
    MINVALUE 1000000000
    MAXVALUE 99999999999
    CACHE 1;

ALTER SEQUENCE public.ord_seq
    OWNER TO bmnprpjdbokbwl;