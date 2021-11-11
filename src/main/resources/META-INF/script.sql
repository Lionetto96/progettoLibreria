-- Table: public.autore



-- DROP TABLE public.autore;
Insert into autore
values( 12, 'Filippo', ' Leggio')
CREATE TABLE IF NOT EXISTS public.autore
(
id_autore integer NOT NULL,
nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
cognome character varying(50) COLLATE pg_catalog."default" NOT NULL,
CONSTRAINT autore_pkey PRIMARY KEY (id_autore)
)



TABLESPACE pg_default;



ALTER TABLE public.autore
OWNER to postgres;
-- Table: public.libro



-- DROP TABLE public.libro;



CREATE TABLE IF NOT EXISTS public.libro
(
id_libro integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
titolo character varying(50) COLLATE pg_catalog."default" NOT NULL,
pagine integer,
CONSTRAINT libro_pkey PRIMARY KEY (id_libro)
)



TABLESPACE pg_default;



ALTER TABLE public.libro
OWNER to postgres;

--sequences
-- SEQUENCE: public.autore_sequence



-- DROP SEQUENCE public.autore_sequence;



CREATE SEQUENCE public.autore_sequence
INCREMENT 1
START 10
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;



ALTER SEQUENCE public.autore_sequence
OWNER TO postgres;






-- SEQUENCE: public.libro_sequence



-- DROP SEQUENCE public.libro_sequence;



CREATE SEQUENCE public.libro_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;



ALTER SEQUENCE public.libro_sequence
OWNER TO postgres;