-- Database: noteshop

-- DROP DATABASE IF EXISTS noteshop;

CREATE DATABASE noteshop
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id integer NOT NULL,
    login character varying(20) COLLATE pg_catalog."default" NOT NULL,
    password character varying(20) COLLATE pg_catalog."default" NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(16) COLLATE pg_catalog."default" NOT NULL,
    isadmin boolean NOT NULL DEFAULT false,
    street character varying(100) COLLATE pg_catalog."default",
    city character varying(100) COLLATE pg_catalog."default",
    state character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;


-- Table: public.notebook

-- DROP TABLE IF EXISTS public.notebook;

CREATE TABLE IF NOT EXISTS public.notebook
(
    id integer NOT NULL,
    manufacturer_id integer NOT NULL,
    model character varying(100) COLLATE pg_catalog."default" NOT NULL,
    screen numeric(12,2),
    ram integer NOT NULL,
    cpu character varying(30) COLLATE pg_catalog."default" NOT NULL,
    card character varying(100) COLLATE pg_catalog."default" NOT NULL,
    ssd integer NOT NULL,
    hdd integer NOT NULL,
    cdrom boolean NOT NULL,
    lan character varying(20) COLLATE pg_catalog."default" NOT NULL,
    wifi character varying(20) COLLATE pg_catalog."default" NOT NULL,
    bt boolean NOT NULL,
    power character varying(30) COLLATE pg_catalog."default" NOT NULL,
    price numeric(10,2) NOT NULL,
    img character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT notebook_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.notebook
    OWNER to postgres;


-- Table: public.manufacturer

-- DROP TABLE IF EXISTS public.manufacturer;

CREATE TABLE IF NOT EXISTS public.manufacturer
(
    id integer NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT manufacturer_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.manufacturer
    OWNER to postgres;


-- Table: public.basket

-- DROP TABLE IF EXISTS public.basket;

CREATE TABLE IF NOT EXISTS public.basket
(
    id integer NOT NULL,
    id_user integer NOT NULL,
    id_notebook integer NOT NULL,
    count integer NOT NULL,
    status integer NOT NULL,
    CONSTRAINT basket_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.basket
    OWNER to postgres;

-- Table: public.orders

-- DROP TABLE IF EXISTS public.orders;

CREATE TABLE IF NOT EXISTS public.orders
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    customer integer,
    delivery_name character varying(100) COLLATE pg_catalog."default",
    delivery_street character varying(100) COLLATE pg_catalog."default",
    delivery_city character varying(100) COLLATE pg_catalog."default",
    delivery_state character varying(100) COLLATE pg_catalog."default",
    summ numeric(20,2),
    create_at date,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT "user" FOREIGN KEY (customer)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.orders
    OWNER to postgres;


-- Table: public.orders_notebooks

-- DROP TABLE IF EXISTS public.orders_notebooks;

CREATE TABLE IF NOT EXISTS public.orders_notebooks
(
    order_id integer NOT NULL,
    notebooks_id integer,
    CONSTRAINT orders_notebooks_pkey PRIMARY KEY (order_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.orders_notebooks
    OWNER to postgres;