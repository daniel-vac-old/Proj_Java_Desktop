--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.25
-- Dumped by pg_dump version 9.3.25
-- Started on 2021-08-04 20:32:19

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2007 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 174 (class 1259 OID 16787)
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.categoria (
    idcat integer NOT NULL,
    nomecat character varying(40),
    comissao real
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16785)
-- Name: categoria_idcat_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categoria_idcat_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categoria_idcat_seq OWNER TO postgres;

--
-- TOC entry 2008 (class 0 OID 0)
-- Dependencies: 173
-- Name: categoria_idcat_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categoria_idcat_seq OWNED BY public.categoria.idcat;


--
-- TOC entry 172 (class 1259 OID 16779)
-- Name: fornecedor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.fornecedor (
    idfor integer NOT NULL,
    nomefor character varying(60),
    razfor character varying(60),
    cnpj character varying(18) NOT NULL
);


ALTER TABLE public.fornecedor OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 16777)
-- Name: fornecedor_idfor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fornecedor_idfor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fornecedor_idfor_seq OWNER TO postgres;

--
-- TOC entry 2009 (class 0 OID 0)
-- Dependencies: 171
-- Name: fornecedor_idfor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fornecedor_idfor_seq OWNED BY public.fornecedor.idfor;


--
-- TOC entry 178 (class 1259 OID 17085)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.produto (
    idpro integer NOT NULL,
    idfor integer NOT NULL,
    idcat integer NOT NULL,
    preco real,
    nomepro character varying(60),
    quantidade integer
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 17083)
-- Name: produto_idpro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_idpro_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_idpro_seq OWNER TO postgres;

--
-- TOC entry 2010 (class 0 OID 0)
-- Dependencies: 177
-- Name: produto_idpro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_idpro_seq OWNED BY public.produto.idpro;


--
-- TOC entry 176 (class 1259 OID 16857)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.usuario (
    iduser integer NOT NULL,
    tipouser integer,
    saluser real,
    nomeuser character varying(60),
    teluser character varying(16),
    useruser character varying(60),
    passuser character varying(30)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16855)
-- Name: usuario_iduser_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_iduser_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_iduser_seq OWNER TO postgres;

--
-- TOC entry 2011 (class 0 OID 0)
-- Dependencies: 175
-- Name: usuario_iduser_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_iduser_seq OWNED BY public.usuario.iduser;


--
-- TOC entry 179 (class 1259 OID 17116)
-- Name: usuarioproduto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.usuarioproduto (
    iduser integer NOT NULL,
    idpro integer NOT NULL,
    datalt character varying(10),
    datcad character varying(10),
    usernew character varying(60),
    useralt character varying(60)
);


ALTER TABLE public.usuarioproduto OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 17133)
-- Name: venda; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.venda (
    idvenda integer NOT NULL,
    totalvenda real
);


ALTER TABLE public.venda OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 17131)
-- Name: venda_idvenda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.venda_idvenda_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.venda_idvenda_seq OWNER TO postgres;

--
-- TOC entry 2012 (class 0 OID 0)
-- Dependencies: 180
-- Name: venda_idvenda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.venda_idvenda_seq OWNED BY public.venda.idvenda;


--
-- TOC entry 182 (class 1259 OID 17139)
-- Name: vendaproduto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.vendaproduto (
    idvenda integer NOT NULL,
    idpro integer NOT NULL,
    quantidade integer
);


ALTER TABLE public.vendaproduto OWNER TO postgres;

--
-- TOC entry 1856 (class 2604 OID 16790)
-- Name: idcat; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria ALTER COLUMN idcat SET DEFAULT nextval('public.categoria_idcat_seq'::regclass);


--
-- TOC entry 1855 (class 2604 OID 16782)
-- Name: idfor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor ALTER COLUMN idfor SET DEFAULT nextval('public.fornecedor_idfor_seq'::regclass);


--
-- TOC entry 1858 (class 2604 OID 17088)
-- Name: idpro; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN idpro SET DEFAULT nextval('public.produto_idpro_seq'::regclass);


--
-- TOC entry 1857 (class 2604 OID 16860)
-- Name: iduser; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN iduser SET DEFAULT nextval('public.usuario_iduser_seq'::regclass);


--
-- TOC entry 1859 (class 2604 OID 17136)
-- Name: idvenda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda ALTER COLUMN idvenda SET DEFAULT nextval('public.venda_idvenda_seq'::regclass);


--
-- TOC entry 1990 (class 0 OID 16787)
-- Dependencies: 174
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (idcat, nomecat, comissao) FROM stdin;
4	teste 2	1
6	Especial	2
\.


--
-- TOC entry 2013 (class 0 OID 0)
-- Dependencies: 173
-- Name: categoria_idcat_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categoria_idcat_seq', 7, true);


--
-- TOC entry 1988 (class 0 OID 16779)
-- Dependencies: 172
-- Data for Name: fornecedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fornecedor (idfor, nomefor, razfor, cnpj) FROM stdin;
2	Teste 3	Teste 3	33.333.333/3333-33
3	Daniel Fornecedor	Daniel & Daniel	17.198.111/0001-33
\.


--
-- TOC entry 2014 (class 0 OID 0)
-- Dependencies: 171
-- Name: fornecedor_idfor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fornecedor_idfor_seq', 4, true);


--
-- TOC entry 1994 (class 0 OID 17085)
-- Dependencies: 178
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto (idpro, idfor, idcat, preco, nomepro, quantidade) FROM stdin;
2	3	6	10	Produto Top	78
3	2	4	50	Teste 3	20
\.


--
-- TOC entry 2015 (class 0 OID 0)
-- Dependencies: 177
-- Name: produto_idpro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_idpro_seq', 5, true);


--
-- TOC entry 1992 (class 0 OID 16857)
-- Dependencies: 176
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (iduser, tipouser, saluser, nomeuser, teluser, useruser, passuser) FROM stdin;
1	2	10000	Daniel	(17) 99999-9999	root	toor
4	1	1200	teste	(11) 11111-1111	teste	teste
\.


--
-- TOC entry 2016 (class 0 OID 0)
-- Dependencies: 175
-- Name: usuario_iduser_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_iduser_seq', 5, true);


--
-- TOC entry 1995 (class 0 OID 17116)
-- Dependencies: 179
-- Data for Name: usuarioproduto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarioproduto (iduser, idpro, datalt, datcad, usernew, useralt) FROM stdin;
\.


--
-- TOC entry 1997 (class 0 OID 17133)
-- Dependencies: 181
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venda (idvenda, totalvenda) FROM stdin;
1	660
2	1000
3	30
4	12120
5	50
6	20
7	600
8	120
9	500
10	4000
11	500
\.


--
-- TOC entry 2017 (class 0 OID 0)
-- Dependencies: 180
-- Name: venda_idvenda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.venda_idvenda_seq', 11, true);


--
-- TOC entry 1998 (class 0 OID 17139)
-- Dependencies: 182
-- Data for Name: vendaproduto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vendaproduto (idvenda, idpro, quantidade) FROM stdin;
6	2	2
7	2	10
7	3	10
8	2	12
9	3	10
10	3	80
11	3	10
\.


--
-- TOC entry 1863 (class 2606 OID 16792)
-- Name: pk_categoria; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT pk_categoria PRIMARY KEY (idcat);


--
-- TOC entry 1861 (class 2606 OID 16784)
-- Name: pk_fornecedor; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT pk_fornecedor PRIMARY KEY (idfor);


--
-- TOC entry 1867 (class 2606 OID 17090)
-- Name: pk_produto; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT pk_produto PRIMARY KEY (idpro);


--
-- TOC entry 1865 (class 2606 OID 16862)
-- Name: pk_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT pk_usuario PRIMARY KEY (iduser);


--
-- TOC entry 1869 (class 2606 OID 17120)
-- Name: pk_usuarioproduto; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.usuarioproduto
    ADD CONSTRAINT pk_usuarioproduto PRIMARY KEY (iduser, idpro);


--
-- TOC entry 1871 (class 2606 OID 17138)
-- Name: pk_venda; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT pk_venda PRIMARY KEY (idvenda);


--
-- TOC entry 1873 (class 2606 OID 17143)
-- Name: pk_vendaproduto; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.vendaproduto
    ADD CONSTRAINT pk_vendaproduto PRIMARY KEY (idvenda, idpro);


--
-- TOC entry 1875 (class 2606 OID 17096)
-- Name: fk_produto_categoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT fk_produto_categoria FOREIGN KEY (idcat) REFERENCES public.categoria(idcat);


--
-- TOC entry 1874 (class 2606 OID 17091)
-- Name: fk_produto_fornecedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT fk_produto_fornecedor FOREIGN KEY (idfor) REFERENCES public.fornecedor(idfor);


--
-- TOC entry 1877 (class 2606 OID 17126)
-- Name: fk_usuarioproduto_produto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarioproduto
    ADD CONSTRAINT fk_usuarioproduto_produto FOREIGN KEY (idpro) REFERENCES public.produto(idpro);


--
-- TOC entry 1876 (class 2606 OID 17121)
-- Name: fk_usuarioproduto_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarioproduto
    ADD CONSTRAINT fk_usuarioproduto_usuario FOREIGN KEY (iduser) REFERENCES public.usuario(iduser);


--
-- TOC entry 1879 (class 2606 OID 17149)
-- Name: fk_vendaproduto_produto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendaproduto
    ADD CONSTRAINT fk_vendaproduto_produto FOREIGN KEY (idpro) REFERENCES public.produto(idpro);


--
-- TOC entry 1878 (class 2606 OID 17144)
-- Name: fk_vendaproduto_venda; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendaproduto
    ADD CONSTRAINT fk_vendaproduto_venda FOREIGN KEY (idvenda) REFERENCES public.venda(idvenda);


--
-- TOC entry 2006 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2021-08-04 20:32:20

--
-- PostgreSQL database dump complete
--

