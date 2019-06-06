-- Drop table

-- DROP TABLE public.person;

CREATE TABLE public.person (
	id numeric(19) NOT NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	address varchar(255) NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO public.person
(id, first_name, last_name, address)
VALUES(0, 'CAMILO', 'CONTRERAS', 'FRAYCAMILO190');

INSERT INTO public.person
(id, first_name, last_name, address)
VALUES(1, 'BERNARDO', 'CACERES', 'FRAYCAMILO190');

INSERT INTO public.person
(id, first_name, last_name, address)
VALUES(2, 'JOSE', 'CONTRERAS', 'ANDES4165');
