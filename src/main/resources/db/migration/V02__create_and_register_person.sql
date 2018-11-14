begin;

CREATE SEQUENCE public.person_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE public.person (
	id BIGINT NOT NULL,
	name VARCHAR(50) NOT NULL,
	
	street VARCHAR(30), 
	number VARCHAR(30),
	complement VARCHAR(30),
	neighborhood VARCHAR(30),
	zip_code VARCHAR(30),
	city VARCHAR(30),
	state VARCHAR(30),
	
	is_active BOOLEAN NOT NULL,
	
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO public.person (id, name, street, number, complement, neighborhood, zip_code, city, state, is_active) VALUES(nextval('person_seq'), 'Fernando Oliveira', 'Main St.', '1', NULL, 'Mangabeira', '58000000', 'Joao Pessoa', 'Paraiba', true);
INSERT INTO public.person (id, name, street, number, complement, neighborhood, zip_code, city, state, is_active) VALUES(nextval('person_seq'), 'Fabiana Rodrigues', 'Teotonio St.', '2', NULL, 'Mangabeira', '58000001', 'Joao Pessoa', 'Paraiba', true);
INSERT INTO public.person (id, name, street, number, complement, neighborhood, zip_code, city, state, is_active) VALUES(nextval('person_seq'), 'Hudson Meira', 'Inacio St.', '3', '#2', 'Torre', '58000002', 'Joao Pessoa', 'Paraiba', false);
INSERT INTO public.person (id, name, street, number, complement, neighborhood, zip_code, city, state, is_active) VALUES(nextval('person_seq'), 'Zelmano', 'Taveira St.', '4', '#1', 'Bancarios', '58000003', 'Joao Pessoa', 'Paraiba', false);
INSERT INTO public.person (id, name, street, number, complement, neighborhood, zip_code, city, state, is_active) VALUES(nextval('person_seq'), 'Edder', 'Manaira St.', '5', '#1', 'Cabo Branco', '58000004', 'Joao Pessoa', 'Paraiba', false);


commit;