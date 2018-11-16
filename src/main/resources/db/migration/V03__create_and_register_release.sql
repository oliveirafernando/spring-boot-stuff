begin;

CREATE SEQUENCE public.release_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE public.release (
	id 				BIGINT 			NOT NULL,
	description 	VARCHAR(50) 	NOT NULL,
	due_date		DATE 			NOT NULL,
	payment_date 	DATE,
	value			NUMERIC(13,2) 	NOT NULL,
	note			VARCHAR(100),
	type			VARCHAR(20) 	NOT NULL,
	category_fk		BIGINT			NOT NULL,
	person_fk		BIGINT			NOT NULL,
	
	
	CONSTRAINT release_pkey PRIMARY KEY (id),
	CONSTRAINT FK_RELEASE_CATEGORY FOREIGN KEY (category_fk) REFERENCES category (id),
	CONSTRAINT FK_RELEASE_PERSON FOREIGN KEY (person_fk) REFERENCES person (id)
);

INSERT INTO public.release (
	id, 
	description, 
	due_date, 
	payment_date, 
	"value", 
	note, 
	"type", 
	category_fk, 
	person_fk
) VALUES(
	nextval('release_seq'), 
	'Description 1', 
	now(), 
	null, 
	1500, 
	'Note 1', 
	'RECIPE', 
	1, 
	1
);

INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 2', now(), now(), 1600, 'Note 2', 'EXPENSE', 2, 2);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 3', now(), null, 1700, 'NOTE 3', 'RECIPE', 3, 3);

commit;