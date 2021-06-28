drop table if exists strt;
CREATE TABLE strt
(
  idno integer 					NOT NULL,
  tail integer 					NOT NULL,
  head integer					,
  name character varying(255) 	DEFAULT NULL,
  leng double precision 		default 50		CHECK (leng >= 0),
  sped double precision			DEFAULT 50 		CHECK (sped >= 0),
  PRIMARY KEY (idno, tail)
);


INSERT INTO public.strt
(idno, tail, "name")
values
(550049426, 105226076, 'street1'),
(2, 2, 'street2')
;


