SET search_path = oblig3;

DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS klasse;

CREATE TABLE deltagere 
(
   mobil INTEGER (8) UNIQUE NOT NULL,
   password TEXT NOT NULL,
   fornavn TEXT (25) NOT NULL,
   etternavn TEXT (25) NOT NULL,
   kjonn CHAR (1) NOT NULL
   PRIMARY KEY (mobil)
);

CREATE TABLE salt
(
   id SERIAL,
   salt TEXT NOT NULL
   PRIMARY KEY (id)
);

INSERT INTO deltagere VALUES 
	(12345678, 'BLAH', 'John', 'Smith', 'm');

INSERT INTO salt VALUES 
	('bf');