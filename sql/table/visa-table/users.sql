-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    userid character varying(255) COLLATE pg_catalog."default" NOT NULL,
    address character varying(255) COLLATE pg_catalog."default" DEFAULT ''::character varying,
    email character varying(255) COLLATE pg_catalog."default" DEFAULT ''::character varying,
    password character varying(255) COLLATE pg_catalog."default",
    phone character varying(255) COLLATE pg_catalog."default" DEFAULT ''::character varying,
    photo character varying(255) COLLATE pg_catalog."default" DEFAULT ''::character varying,
    role character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default",
    create_date character varying(255) COLLATE pg_catalog."default" DEFAULT to_char(CURRENT_TIMESTAMP, 'yyyymmdd HH24:MI:SS'::text),
    one_time_password character varying(255) COLLATE pg_catalog."default",
    otp_requested_time timestamp without time zone,
    CONSTRAINT users_pkey PRIMARY KEY (userid)
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to bmnprpjdbokbwl;