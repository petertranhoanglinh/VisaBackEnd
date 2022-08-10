-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    userid character varying(255) COLLATE pg_catalog."default" NOT NULL,
    ctrid character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    rankcd character varying(255) COLLATE pg_catalog."default",
    role character varying(255) COLLATE pg_catalog."default",
    time_create timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    username character varying(255) COLLATE pg_catalog."default",
    referral_code character varying(8) COLLATE pg_catalog."default" DEFAULT random_string(8),
    rate numeric DEFAULT 0,
    photo character varying COLLATE pg_catalog."default" DEFAULT ''::character varying,
    CONSTRAINT users_pkey PRIMARY KEY (userid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;