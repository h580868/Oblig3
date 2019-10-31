SET search_path = oblig3;

DROP TABLE IF EXISTS guest;
DROP TABLE IF EXISTS salt;

CREATE TABLE guest 
(
   mobil varchar (8) UNIQUE NOT NULL,
   passord varchar NOT NULL,
   fornavn varchar (25) NOT NULL,
   etternavn varchar (25) NOT NULL,
   kjonn CHAR (1) NOT NULL,
   PRIMARY KEY (mobil)
);

--CREATE TABLE salt
--(
--   id SERIAL,
--   salt varchar NOT NULL
--   PRIMARY KEY (id)
--);

INSERT INTO guest VALUES 
	(12345678, 'BLAH', 'John', 'Smith', 'm');

--INSERT INTO salt VALUES 
--	('bf');