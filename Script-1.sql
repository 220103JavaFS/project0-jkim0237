DROP TABLE IF EXISTS avengers;
DROP TABLE IF EXISTS homes;

--0NF

CREATE TABLE avengers (
	hero_name VARCHAR(30) NOT NULL,
	hero_power VARCHAR(150),
	real_name VARCHAR(50),
	home_name VARCHAR(50),
	home_address VARCHAR(200)
);

INSERT INTO avengers (	
	hero_name,
	hero_power,
	real_name, 
	home_name,
	home_address) 
	VALUES ('captain america', 'ultimate frisbee champion, level 25', 'steve rogers', 'shield apartment', ' 435 somestree apt b Brooklyn NY'),
('iron man', 'more money than the queen, level 246', 'tony stark', 'stark tower', ' 1 tony stree, Manhattan NY'),
('hulk', 'anger issues, level 8001', 'bruce banner', 'stark tower', ' 1 tony stree, Manhattan NY');

--1NF

DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	hero_name VARCHAR(30) NOT NULL,
	power_description VARCHAR(150),
	power_level INTEGER,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	home_name VARCHAR(50),
	home_str_num VARCHAR(10),
	home_str VARCHAR(30),
	home_city VARCHAR(30),
	home_region VARCHAR(30),
	home_zip VARCHAR(10),
	home_country VARCHAR(20)
);

ALTER TABLE avengers ADD PRIMARY KEY (hero_name, first_name, last_name);

INSERT INTO avengers (
	hero_name,
	power_description,
	power_level,
	first_name,
	last_name,
	home_name,
	home_str_num,
	home_str,
	home_city,
	home_region,
	home_zip,
	home_country)
	VALUES ('captain america', 'ultimate frisbee champion', '25', 'steve', 'rogers', 'shield apartment', '435', 'somestree apt b', 'Brooklyn', 'NY', '20117', 'USA'),
	('iron man', 'more money than the queen', '246', 'tony', 'stark', 'stark tower', '1', 'tony street', 'Manhattan', 'NY', '10877', 'USA'),
	('hulk', 'anger issues', '8001', 'bruce', 'banner', 'stark tower', '1', 'tony street', 'Manhattan', 'NY', '10877', 'USA'),
	('captin america', 'ultimate frisbee champion', '35', 'sam', 'wilson', 'stark tower', ' 1', 'tony street', 'Manhattan', 'NY', '10877', 'USA');

--INSERT INTO avengers (
--	hero_name,
--	power_description,
--	power_level,
--	first_name,
--	last_name,
--	home_name,
--	home_str_num,
--	home_str,
--	home_city,
--	home_region,
--	home_zip,
--	home_country) 
--	VALUES ('captain america', 'ah ha attitude', '555', 'steve', 'rogers', 'shield apartment', '435', 'somestree apt b', 'Brooklyn', 'NY', '20117', 'USA');

--2NF
DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	hero_id SERIAL PRIMARY KEY, --SERIAL IS postgres SPECIFIC DATATYPE that assign an integer value
	hero_name VARCHAR(30) NOT NULL,
	power_description VARCHAR(150),
	power_level INTEGER,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	home_name VARCHAR(50),
	home_str_num VARCHAR(10),
	home_str VARCHAR(30),
	home_city VARCHAR(30),
	home_region VARCHAR(30),
	home_zip VARCHAR(10),
	home_country VARCHAR(20)
);

INSERT INTO avengers (
	hero_name,
	power_description,
	power_level,
	first_name,
	last_name,
	home_name,
	home_str_num,
	home_str,
	home_city,
	home_region,
	home_zip,
	home_country)
	VALUES ('captain america', 'ultimate frisbee champion', '25', 'steve', 'rogers', 'shield apartment', '435', 'somestree apt b', 'Brooklyn', 'NY', '20117', 'USA'),
	('iron man', 'more money than the queen', '246', 'tony', 'stark', 'stark tower', '1', 'tony street', 'Manhattan', 'NY', '10877', 'USA'),
	('hulk', 'anger issues', '8001', 'bruce', 'banner', 'stark tower', '1', 'tony street', 'Manhattan', 'NY', '10877', 'USA'),
	('captain america', 'ultimate frisbee champion', '35', 'sam', 'wilson', 'stark tower', ' 1', 'tony street', 'Manhattan', 'NY', '10877', 'USA');

--3NF
DROP TABLE IF EXISTS hero_names;
CREATE TABLE hero_names(
	hero_name VARCHAR(30) PRIMARY KEY,
	power_description VARCHAR(150)
);

CREATE TABLE homes(
	home_name VARCHAR(50) PRIMARY KEY,
	home_str_num VARCHAR(10),
	home_str VARCHAR(30),
	home_city VARCHAR(30),
	home_region VARCHAR(30),
	home_zip VARCHAR(10),
	home_country VARCHAR(20)
);


CREATE TABLE avengers (
	hero_id SERIAL PRIMARY KEY, --SERIAL IS postgres SPECIFIC DATATYPE that assign an integer value
	hero_name VARCHAR(30) NOT NULL REFERENCES hero_names(hero_name),
	power_level INTEGER,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	hero_home VARCHAR(50) REFERENCES homes(home_name)
);

INSERT INTO hero_names (hero_name, power_description)
	VALUES('captain america', 'ultimate frisbee champion'),
	('iron man', 'more money than the queen'),
	('hulk', 'anger issues');

INSERT INTO homes (home_name,
	home_str_num,
	home_str,
	home_city,
	home_region,
	home_zip,
	home_country) VALUES ('shield apartment', '435', 'somestree apt b', 'Brooklyn', 'NY', '20117', 'USA'),
	('stark tower', '1', 'tony street', 'Manhattan', 'NY', '10877', 'USA');
	

INSERT INTO avengers (
	hero_name,
	power_level,
	first_name,
	last_name,
	hero_home)
	VALUES ('captain america', 25, 'steve', 'rogers', 'shield apartment'),
	('iron man', 256, 'tony', 'stark', 'stark tower'),
	('hulk', 8001, 'bruce', 'banner', 'stark tower'),
	('captain america', 35, 'sam', 'wilson', null);

--Joins

SELECT * FROM avengers INNER JOIN homes ON homes.home_name = avengers.hero_home;

SELECT * FROM avengers LEFT JOIN homes ON homes.home_name = avengers.hero_home;

INSERT INTO hero_names (hero_name, power_description)
	VALUES ('hawkeye', 'impressive biceps');

SELECT * FROM avengers RIGHT JOIN hero_names ON hero_names.hero_name = avengers.hero_name;

INSERT INTO homes (home_name,
	home_str_num,
	home_str,
	home_city,
	home_region,
	home_zip,
	home_country) VALUES ('helicarrier', NULL, 'bottom of the potomac', 'washinton', 'dc', NULL, 'USA');

SELECT  * FROM avengers FULL JOIN homes ON homes.home_name = avengers.hero_home;


--Scalar and AGGREGATE FUNCTIONS 

SELECT UPPER (hero_name) FROM avengers;

SELECT AVG (power_level) FROM avengers;

--GROUP BY/ORDER BY 

SELECT hero_name, SUM(power_level) FROM avengers GROUP BY hero_name;

SELECT UPPER (hero_name) FROM avengers ORDER BY hero_name ASC;

--UNION (this is silly example)

SELECT hero_name, first_name FROM avengers UNION SELECT home_name, home_str FROM homes;

-- TRIGGER FUNCTION

ALTER TABLE homes ADD COLUMN residents INTEGER;

CREATE OR REPLACE FUNCTION increase_resident() RETURNS TRIGGER AS
$$
BEGIN 
	UPDATE homes SET residents = (SELECT residents FROM homes WHERE NEW.hero_home = homes.home_name)+1
	WHERE homes.home_name = NEW.hero_home;
	RETURN NEW;
END 
$$
LANGUAGE plpgsql;

CREATE TRIGGER increment_residents AFTER INSERT ON avengers FOR EACH ROW EXECUTE PROCEDURE increase_resident();

DROP TABLE IF EXISTS homes CASCADE;

CREATE TABLE homes(
	home_name VARCHAR(50) PRIMARY KEY,
	home_str_num VARCHAR(10),
	home_str VARCHAR(30),
	home_city VARCHAR(30),
	home_region VARCHAR(30),
	home_zip VARCHAR(10),
	home_country VARCHAR(20),
	residents INTEGER DEFAULT 0
);

INSERT INTO homes (home_name,
	home_str_num,
	home_str,
	home_city,
	home_region,
	home_zip,
	home_country) VALUES ('shield apartment', '435', 'somestree apt b', 'Brooklyn', 'NY', '20117', 'USA'),
	('stark tower', '1', 'tony street', 'Manhattan', 'NY', '10877', 'USA');

DROP TABLE IF EXISTS avengers;

CREATE TABLE avengers (
	hero_id SERIAL PRIMARY KEY, --SERIAL IS postgres SPECIFIC DATATYPE that assign an integer value
	hero_name VARCHAR(30) NOT NULL REFERENCES hero_names(hero_name),
	power_level INTEGER,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	hero_home VARCHAR(50) REFERENCES homes(home_name)
);

CREATE TRIGGER increment_residents AFTER INSERT ON avengers FOR EACH ROW EXECUTE PROCEDURE increase_resident();

INSERT INTO avengers (
	hero_name,
	power_level,
	first_name,
	last_name,
	hero_home)
	VALUES ('captain america', 25, 'steve', 'rogers', 'shield apartment'),
	('iron man', 256, 'tony', 'stark', 'stark tower'),
	('hulk', 8001, 'bruce', 'banner', 'stark tower'),
	('captain america', 35, 'sam', 'wilson', null);












	


