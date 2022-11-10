-- Type: address_type

-- DROP TYPE public.address_type;

CREATE TYPE public.address_type AS
(
	apartment_number character varying(255),
	ward character varying(50),
	district character varying(50),
	city character varying(20)
);

ALTER TYPE public.address_type
    OWNER TO bmnprpjdbokbwl;