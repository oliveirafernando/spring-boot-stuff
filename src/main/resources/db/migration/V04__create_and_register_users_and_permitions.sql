begin;

CREATE SEQUENCE user_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE TABLE public.user_tbl (
	id BIGINT NOT NULL,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(150) NOT NULL,
	
	PRIMARY KEY (id)
);

CREATE SEQUENCE permission_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE TABLE public.permission (
	id BIGINT NOT NULL,
	description VARCHAR(50) NOT NULL,
	
	PRIMARY KEY (id)
);

CREATE TABLE public.user_permission (
	user_id BIGINT NOT NULL,
	permission_id BIGINT NOT NULL,
	
	PRIMARY KEY (user_id, permission_id),
	
	FOREIGN KEY (user_id) REFERENCES user_tbl(id),
	FOREIGN KEY (permission_id) REFERENCES permission(id)
);

INSERT INTO public.user_tbl (id, name, email, password) values (nextval('user_seq'), 'Administrator', 'admin@oliveirafernando.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO public.user_tbl (id, name, email, password) values (nextval('user_seq'), 'Fernando Oliveira', 'fernando@oliveirafernando.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');

INSERT INTO public.permission (id, description) values (nextval('permission_seq'), 'ROLE_CREATE_CATEGORY');
INSERT INTO public.permission (id, description) values (nextval('permission_seq'), 'ROLE_SEARCH_CATEGORY');

INSERT INTO public.permission (id, description) values (nextval('permission_seq'), 'ROLE_CREATE_PERSON');
INSERT INTO public.permission (id, description) values (nextval('permission_seq'), 'ROLE_REMOVE_PERSON');
INSERT INTO public.permission (id, description) values (nextval('permission_seq'), 'ROLE_SEARCH_PERSON');

INSERT INTO public.permission (id, description) values (nextval('permission_seq'), 'ROLE_CREATE_RELEASE');
INSERT INTO public.permission (id, description) values (nextval('permission_seq'), 'ROLE_REMOVER_RELEASE');
INSERT INTO public.permission (id, description) values (nextval('permission_seq'), 'ROLE_SEARCH_RELEASE');

-- admin
INSERT INTO public.user_permission (user_id, permission_id) values (1, 1);
INSERT INTO public.user_permission (user_id, permission_id) values (1, 2);
INSERT INTO public.user_permission (user_id, permission_id) values (1, 3);
INSERT INTO public.user_permission (user_id, permission_id) values (1, 4);
INSERT INTO public.user_permission (user_id, permission_id) values (1, 5);
INSERT INTO public.user_permission (user_id, permission_id) values (1, 6);
INSERT INTO public.user_permission (user_id, permission_id) values (1, 7);
INSERT INTO public.user_permission (user_id, permission_id) values (1, 8);

-- maria
INSERT INTO public.user_permission (user_id, permission_id) values (2, 2);
INSERT INTO public.user_permission (user_id, permission_id) values (2, 5);
INSERT INTO public.user_permission (user_id, permission_id) values (2, 8);

commit;