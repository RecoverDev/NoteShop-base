--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2024-02-05 14:24:50

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16598)
-- Name: basket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.basket (
    id integer NOT NULL,
    id_user integer NOT NULL,
    id_notebook integer NOT NULL,
    count integer NOT NULL,
    status integer NOT NULL
);


ALTER TABLE public.basket OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16603)
-- Name: manufacturer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.manufacturer (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.manufacturer OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16608)
-- Name: notebook; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notebook (
    id integer NOT NULL,
    manufacturer_id integer NOT NULL,
    model character varying(100) NOT NULL,
    screen numeric(12,2),
    ram integer NOT NULL,
    cpu character varying(30) NOT NULL,
    card character varying(100) NOT NULL,
    ssd integer NOT NULL,
    hdd integer NOT NULL,
    cdrom boolean NOT NULL,
    lan character varying(20) NOT NULL,
    wifi character varying(20) NOT NULL,
    bt boolean NOT NULL,
    power character varying(30) NOT NULL,
    price numeric(10,2) NOT NULL,
    img character varying(20) NOT NULL
);


ALTER TABLE public.notebook OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 24851)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    id integer NOT NULL,
    customer integer,
    delivery_name character varying(100),
    delivery_street character varying(100),
    delivery_city character varying(100),
    delivery_state character varying(100),
    summ numeric(20,2),
    create_at date
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24850)
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.orders ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 221 (class 1259 OID 24866)
-- Name: orders_notebooks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders_notebooks (
    order_id integer NOT NULL,
    notebooks_id integer
);


ALTER TABLE public.orders_notebooks OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16613)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    login character varying(20) NOT NULL,
    password character varying(20) NOT NULL,
    name character varying(100) NOT NULL,
    email character varying(50) NOT NULL,
    phone character varying(16) NOT NULL,
    isadmin boolean DEFAULT false NOT NULL,
    street character varying(100),
    city character varying(100),
    state character varying(100)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 4811 (class 0 OID 16598)
-- Dependencies: 215
-- Data for Name: basket; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.basket (id, id_user, id_notebook, count, status) FROM stdin;
4	2	4	2	1
5	1	2	1	0
6	1	4	1	0
10	2	2	2	1
12	2	1	3	1
13	2	4	2	1
14	2	2	2	1
15	2	0	1	0
16	2	1	3	0
17	2	2	2	0
18	2	4	1	0
20	1	5	1	0
\.


--
-- TOC entry 4812 (class 0 OID 16603)
-- Dependencies: 216
-- Data for Name: manufacturer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.manufacturer (id, name) FROM stdin;
1	DELL
2	HP
3	Acer
4	Lenovo
5	Apple
6	ASUS
7	Huawei
\.


--
-- TOC entry 4813 (class 0 OID 16608)
-- Dependencies: 217
-- Data for Name: notebook; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notebook (id, manufacturer_id, model, screen, ram, cpu, card, ssd, hdd, cdrom, lan, wifi, bt, power, price, img) FROM stdin;
1	4	IP Gaming 3 15ACH6	15.60	8	AMD Ryzen 5 5600H	NVIDIA GeForce RTX 3050	256	0	f	10/100/1000 Мбит/с	802.11 a/b/g/n/ac/ax	t	Li-Pol 45 Wh 5 ч	100470.00	2.jpg
2	5	MacBook Air 13.3\\"	13.30	8	Apple M1 8 core	интегрированный	256	0	f	отсутствует	802.11 a/b/g/n/ac/ax	t	Li-Pol 49.9 Wh 18 ч	147650.00	3.jpg
3	3	Aspire 3 A315-56-38MN	15.60	8	Intel Core i3 1005G1 1.2ГГц	Intel UHD Graphics	256	0	f	10/100/1000 Мбит/с	802.11 a/b/g/n/ac/ax	t	Li-Ion 36 Wh	49990.00	1.jpg
4	6	TUF Gaming F15 FX506HCB-HN1138	15.60	8	Intel Core i5 11400H 2.7ГГц	NVIDIA GeForce RTX 3050	512	0	f	10/100/1000 Мбит/с	802.11 a/b/g/n/ac/ax	t	Li-Ion 48 Wh	113200.00	4.jpg
5	7	MateBook D 14 MDF-X	14.00	16	Intel Core i5 1240P 1.7ГГц	Intel Iris Xe graphics	512	0	f	10/100/1000 Мбит/с	802.11 a/b/g/n/ac/ax	t	Li-Pol 56 Wh	69990.00	5.jpg
6	6	VivoBook 15 X1502ZA-BQ1854	15.60	16	Intel Core i5-12500H 2.5 ГГц	Intel Iris Xe graphics	512	0	f	10/100/1000 Мбит/с	802.11 a/b/g/n/ac/ax	t	Li-Ion 65 Wh	69990.00	6.jpg
\.


--
-- TOC entry 4816 (class 0 OID 24851)
-- Dependencies: 220
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (id, customer, delivery_name, delivery_street, delivery_city, delivery_state, summ, create_at) FROM stdin;
4	2	Вася	Центральная	Столица	Центральный округ	69990.00	2023-12-26
\.


--
-- TOC entry 4817 (class 0 OID 24866)
-- Dependencies: 221
-- Data for Name: orders_notebooks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders_notebooks (order_id, notebooks_id) FROM stdin;
4	5
\.


--
-- TOC entry 4814 (class 0 OID 16613)
-- Dependencies: 218
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, login, password, name, email, phone, isadmin, street, city, state) FROM stdin;
1	admin	admin	Администратор	admin@noteshop.com	+7(999)777-77-77	t	\N	\N	\N
2	user	111	Вася Пупкин	vasya@mail.ru	 7(555)123-12-12	f	\N	\N	\N
3	masha	111	Маша Любопыткина	masha@gmail.com	+7(111)111-11-11	f	\N	\N	\N
4	ivanov	111	Иннокентий Иванов	kesha@yandex.ru	+7(222)222-22-22	f	\N	\N	\N
5	rustic	111	Руслан	rustic@mail.ru	+7(333)33-33-33	f	\N	\N	\N
6	dev	222	Петр Петров (разработчик)	dev@noteshop.com	+7(999)888-88-88	t	\N	\N	\N
9	new_user	222	Новый пользователь	new@mail.ru	+7(987)222-12-13	f	Третья улица строителей	Новый Урюпинск	Уйгурская область
\.


--
-- TOC entry 4823 (class 0 OID 0)
-- Dependencies: 219
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_id_seq', 4, true);


--
-- TOC entry 4656 (class 2606 OID 16602)
-- Name: basket basket_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.basket
    ADD CONSTRAINT basket_pkey PRIMARY KEY (id);


--
-- TOC entry 4658 (class 2606 OID 16607)
-- Name: manufacturer manufacturer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manufacturer
    ADD CONSTRAINT manufacturer_pkey PRIMARY KEY (id);


--
-- TOC entry 4660 (class 2606 OID 16612)
-- Name: notebook notebook_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notebook
    ADD CONSTRAINT notebook_pkey PRIMARY KEY (id);


--
-- TOC entry 4666 (class 2606 OID 24870)
-- Name: orders_notebooks orders_notebooks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders_notebooks
    ADD CONSTRAINT orders_notebooks_pkey PRIMARY KEY (order_id);


--
-- TOC entry 4664 (class 2606 OID 24855)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 4662 (class 2606 OID 16618)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 4667 (class 2606 OID 24856)
-- Name: orders user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "user" FOREIGN KEY (customer) REFERENCES public.users(id);


-- Completed on 2024-02-05 14:24:50

--
-- PostgreSQL database dump complete
--

