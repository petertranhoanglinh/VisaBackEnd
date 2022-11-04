-- SEQUENCE: public.user_seq

-- DROP SEQUENCE public.user_seq;

CREATE SEQUENCE public.user_seq
    CYCLE
    INCREMENT 1
    START 100000
    MINVALUE 100000
    MAXVALUE 999999
    CACHE 1;

ALTER SEQUENCE public.user_seq
    OWNER TO bmnprpjdbokbwl;