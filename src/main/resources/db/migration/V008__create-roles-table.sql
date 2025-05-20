BEGIN;

CREATE TABLE IF NOT EXISTS public.roles
(
    id serial PRIMARY KEY,
    type character varying(255) COLLATE pg_catalog."default" UNIQUE NOT NULL
);

INSERT INTO public.roles (type) VALUES 
    ('ROLE_USER'),
    ('ROLE_ADMIN'),
    ('ROLE_INSTITUTION');

END;