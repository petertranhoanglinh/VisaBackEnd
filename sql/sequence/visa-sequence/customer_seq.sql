-- SEQUENCE: public.customer_seq

-- DROP SEQUENCE public.customer_seq;

CREATE SEQUENCE public.customer_seq
    CYCLE
    INCREMENT 1
    START 1000000000
    MINVALUE 1000000000
    MAXVALUE 9999999999
    CACHE 1;

ALTER SEQUENCE public.customer_seq
    OWNER TO bmnprpjdbokbwl;