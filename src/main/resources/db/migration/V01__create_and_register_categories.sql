begin;

CREATE SEQUENCE public.category_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE public.category (
	id BIGINT NOT NULL,
	name VARCHAR(50) NOT NULL,
	
	CONSTRAINT category_pkey PRIMARY KEY (id)
);

INSERT INTO public.category (id, name) VALUES(nextval('category_seq'), 'Category 1');
INSERT INTO public.category (id, name) VALUES(nextval('category_seq'), 'Category 2');
INSERT INTO public.category (id, name) VALUES(nextval('category_seq'), 'Category 3');

commit;