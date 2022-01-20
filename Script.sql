-- This is a single line comment

/*
	multi-line comment(same as Java)
*/

-- DDL

--CREATE DATABASE demos;

DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	hero_name VARCHAR(30),
	hero_power VARCHAR(150),
	real_name VARCHAR(50),
	power_level INTEGER
);


ALTER TABLE avengers ADD COLUMN active BOOLEAN;


ALTER TABLE avengers ADD COLUMN hero_height NUMERIC(4,1);

--DML

INSERT INTO avengers (hero_name, hero_power, real_name, power_level, hero_height)
	VALUES ('capt. america', 'magic disk', 'steve rogers', 5, 2.1),
	('iron man', 'snark', 'tony stark', 85, 1.7);

UPDATE avengers SET active = TRUE WHERE hero_name = 'iron man';
UPDATE avengers SET active = FALSE WHERE hero_name = 'capt. america';

DELETE FROM avengers WHERE power_level < 50;

--DQL

SELECT  * FROM avengers ORDER BY hero_height DESC;

SELECT hero_name, real_name FROM avengers;

--TCL

BEGIN;
INSERT INTO avengers (hero_name, hero_power, real_name, power_level, hero_height)
	VALUES ('spiderman', 'being a good neighbor', 'peter parker', 200, 1.6);
UPDATE avengers SET active = TRUE WHERE hero_name = 'spiderman';
UPDATE avengers SET real_name = 'nobody knows' WHERE hero_name = 'spiderman';
COMMIT;

ROLLBACK;

--Constraints

DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	hero_name VARCHAR(30) NOT NULL,
	hero_power VARCHAR(150) UNIQUE,
	real_name VARCHAR(50),
	power_level INTEGER CHECK (power_level>0)
);

INSERT INTO avengers (hero_name, hero_power, real_name, power_level)
	VALUES ('capt. america', 'shield', 'steve rogers', 5),
	('iron man', 'snark', 'tony stark', 85);

INSERT INTO avengers (hero_name, hero_power, real_name, power_level)
	VALUES ('capt. america', 'frisbee', 'sam wilson', 5)


DROP TABLE IF EXISTS homes;

CREATE TABLE homes (
	home_name VARCHAR(50) PRIMARY KEY,
	home_address VARCHAR(200)
);

INSERT INTO homes (home_name, home_address) 
	VALUES ('stark tower', '123 start st. new york ny'),
	('shield base', 'super secret location');

ALTER TABLE avengers ADD COLUMN home VARCHAR(50) REFERENCES homes(home_name);
--References creates a FK constraint.

UPDATE avengers SET home = 'stark tower';




