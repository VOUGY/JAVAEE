/*
    $Id: sample.sql,v 1.5 2005/05/02 15:07:27 unsaved Exp $
    Examplifies use of SqlTool.
    PCTASK Table creation
*/

/* Ignore error for these two statements */

/*
\c true
DROP TABLE COMPTE;
DROP TABLE CLIENT;
DROP TABLE WAR;
DROP TABLE COUNTRY;
DROP TABLE WEAPON;
\c false

\p Creating table COUNTRY
CREATE TABLE COUNTRY (
    ID integer identity PRIMARY KEY ,
    ABBREVIATION varchar(4) not null,
    DESCRIPTION varchar(40) not null,
	LOCATION varchar(40) not null,
	NAME varchar(40) not null,
	UNIQUE (ID)
);

\p Creating table WEAPON
CREATE TABLE WEAPON (
	ID integer identity PRIMARY KEY,
	DESCRIPTION varchar(40) not null,
	NAME varchar(40) not null,
	QUANTITY integer not null,
	STRENGTH integer not null,
	UNIQUE (ID)
);

\p Creating table WAR
CREATE TABLE WAR (
    ID integer identity PRIMARY KEY ,
    DESCRIPTION varchar(40) not null,
	NAME varchar(40) not null,
    STARTDATE date not null,
	ENDDATE date not null,
	COUNTRYONE_ID integer,
	COUNTRYTWO_ID integer,
    FOREIGN KEY (COUNTRYONE_ID) REFERENCES COUNTRY,
	FOREIGN KEY (COUNTRYTWO_ID) REFERENCES COUNTRY,
    UNIQUE (ID)
);
*/


\p Inserting test records
/* COUNTRY */
INSERT INTO COUNTRY (ID, ABBREVIATION, DESCRIPTION, LOCATION, NAME) VALUES (
    '1', 'FRA', 'Leaded by Emmanuel Macron', 'Europe', 'France');
	
INSERT INTO COUNTRY (ID, ABBREVIATION, DESCRIPTION, LOCATION, NAME) VALUES (
    '2', 'CH', 'Leaded by the Federal Counsel', 'Europe', 'Switzerland');
	
INSERT INTO COUNTRY (ID, ABBREVIATION, DESCRIPTION, LOCATION, NAME) VALUES (
    '3', 'USA', 'Leaded by Donald J Trump', 'Amérique du Nord', 'United States');
	
INSERT INTO COUNTRY (ID, ABBREVIATION, DESCRIPTION, LOCATION, NAME) VALUES (
    '4', 'RUS', 'Leaded by Vladimir Putin', 'Eurasie', 'Russia');
	
/* WEAPON */
INSERT INTO WEAPON (ID, DESCRIPTION, NAME, QUANTITY, STRENGTH) VALUES (
	'1', 'Fast firing machine gun', 'AK-47', 10000, 50);
	
INSERT INTO WEAPON (ID, DESCRIPTION, NAME, QUANTITY, STRENGTH) VALUES (
	'2', 'Hand held, practical pistol', 'P90', 5000, 15);
	
INSERT INTO WEAPON (ID, DESCRIPTION, NAME, QUANTITY, STRENGTH) VALUES (
	'3', 'Not very mobile best powerful', 'Tigershark Tank', 40, 300);
	
INSERT INTO WEAPON (ID, DESCRIPTION, NAME, QUANTITY, STRENGTH) VALUES (
	'4', 'Mobile but vunerable', 'Spearbike', 200, 60);
	
/* WAR */
INSERT INTO WAR (ID, DESCRIPTION, STARTDATE, ENDDATE, NAME, COUNTRYONE_ID, COUNTRYTWO_ID) VALUES (
	'1', 'France vs Switzerland', '2015-02-15', '2017-07-04', 'The Great Cheese War', 1, 2);
	
INSERT INTO WAR (ID, DESCRIPTION, STARTDATE, NAME, COUNTRYONE_ID, COUNTRYTWO_ID) VALUES (
	'2', 'Russia vs United States', '1881-06-27', 'These Two Have Always Fighted', 3, 4);
	
/* WEAPON - COUNTRY */
INSERT INTO WEAPON_COUNTRY(WEAPONS_ID, COUNTRIES_ID) VALUES (
	1,4);

	INSERT INTO WEAPON_COUNTRY(WEAPONS_ID, COUNTRIES_ID) VALUES (
	2,3);
	
INSERT INTO WEAPON_COUNTRY(WEAPONS_ID, COUNTRIES_ID) VALUES (
	3,2);
	
INSERT INTO WEAPON_COUNTRY(WEAPONS_ID, COUNTRIES_ID) VALUES (
	4,1);
	
commit;
