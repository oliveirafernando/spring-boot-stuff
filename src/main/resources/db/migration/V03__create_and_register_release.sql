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

INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 1', now(), null, 1500, 'Note 1', 'RECIPE', 1, 1);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 2', now(), null, 1600, 'Note 2', 'EXPENSE', 1, 2);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 3', now(), null, 1700, 'NOTE 3', 'RECIPE', 1, 3);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 4', now(), null, 1800, 'NOTE 4', 'EXPENSE', 2, 1);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 5', now(), null, 1900, 'NOTE 5', 'RECIPE', 2, 2);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 6', now(), null, 2000, 'NOTE 6', 'EXPENSE', 3, 3);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 7', now(), null, 2100, 'NOTE 7', 'RECIPE', 1, 1);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 8', now(), null, 2200, 'NOTE 8', 'EXPENSE', 1, 2);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 9', now(), null, 2300, 'NOTE 9', 'RECIPE', 1, 3);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 10', now(), null, 2400, 'NOTE 10', 'EXPENSE', 2, 1);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 11', now(), null, 2500, 'NOTE 11', 'RECIPE', 2, 2);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 12', now(), null, 2600, 'NOTE 12', 'EXPENSE', 2, 3);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 13', now(), null, 2700, 'NOTE 13', 'RECIPE', 3, 1);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 14', now(), null, 2800, 'NOTE 14', 'EXPENSE', 3, 2);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 15', now(), null, 2900, 'NOTE 15', 'RECIPE', 3, 3);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 16', now(), null, 3000, 'NOTE 16', 'EXPENSE', 1, 1);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 17', now(), null, 3100, 'NOTE 17', 'RECIPE', 1, 2);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 18', now(), null, 3200, 'NOTE 18', 'EXPENSE', 1, 3);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 19', now(), null, 3300, 'NOTE 19', 'RECIPE', 2, 1);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 20', now(), null, 3400, 'NOTE 20', 'EXPENSE', 2, 2);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 21', now(), null, 3500, 'NOTE 21', 'RECIPE', 2, 3);
INSERT INTO public.release (id, description, due_date, payment_date, value, note, "type", category_fk, person_fk) VALUES(nextval('release_seq'), 'Description 22', now(), null, 3600, 'NOTE 22', 'EXPENSE', 3, 1);

commit;