-- ******************************
-- for ORACLE
-- ******************************
-- Create tablespace, user and grant privileges with account sys 
--  Run as script not as SQL command 
CREATE BIGFILE TABLESPACE tallerbd 
DATAFILE 'tallerbd.dat'
SIZE 10M AUTOEXTEND ON;

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER developer PROFILE DEFAULT IDENTIFIED BY t0ps3cr3t
DEFAULT TABLESPACE tallerbd;
 
GRANT CREATE SESSION, CONNECT, CREATE TABLE TO developer;
 
ALTER USER developer QUOTA UNLIMITED ON tallerbd;
 
 -- Connect using account developer
 conn developer/t0ps3cr3t  --  from console 
 -- or create connection from dbeaver using account developer
 CREATE TABLE student (
  nocontrol VARCHAR(15)
 , fullname VARCHAR (100)
 , career VARCHAR (50)
 , curp VARCHAR (18) UNIQUE
 , currentgrade INT 
 , CONSTRAINT pkStudent PRIMARY KEY (nocontrol)
 );

INSERT INTO student(nocontrol, fullname, career, curp, currentgrade)
VALUES ('21920131','Miguel Lopez Oswaldo','Ing. Tics','AAAA000119MOCLNHA7',6);

INSERT INTO student(nocontrol, fullname, career, curp, currentgrade)
VALUES ('22920204','Ruiz Mendoza Yuridia Itzel','Ing. Tics','AAAA031111MOCRRRA0',6);


 -- ******************************
-- for MariaDB
-- ******************************
-- Execute this sentence with account root
CREATE DATABASE tallerbd CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci;

 USE tallerbd;
 
 CREATE TABLE student (
    nocontrol VARCHAR(15) 
 ,  fullname VARCHAR (100)
 , career VARCHAR (50)
 , curp VARCHAR (18) UNIQUE
 , currentgrade INT 
 , CONSTRAINT pkStudent PRIMARY KEY (nocontrol)
 );

INSERT INTO student(nocontrol, fullname, career, curp, currentgrade)
VALUES ('21920133','Hugo Martinez Sosa','Ing. Informatica','AAAA880429MOCMLN03',6);

INSERT INTO student(nocontrol, fullname, career, curp, currentgrade)
VALUES ('22920234','Marisol Lopez Martinez','Ing. Informatica','AAAA980529MOCMRD18',6);


GRANT ALL PRIVILEGES ON tallerbd.*  TO developer@'%' IDENTIFIED BY 't0ps3cr3t';
GRANT ALL PRIVILEGES ON tallerbd.*  TO developer@'localhost' IDENTIFIED BY 't0ps3cr3t';
  
  -- ******************************
-- for postgres
-- ******************************
-- Execute this sentence with account postgres
docker exec -it postgres bash
su postgres
psql

CREATE DATABASE tallerbd;
 \c tallerbd;
 
 CREATE TABLE student (
   nocontrol VARCHAR(15)
 , fullname VARCHAR (100)
 , career VARCHAR (50)
 , curp VARCHAR (18) UNIQUE
 , currentgrade INT 
 , CONSTRAINT pkStudent PRIMARY KEY (nocontrol)
 );

INSERT INTO student(nocontrol, fullname, career, curp, currentgrade)
VALUES ('202020161','Margarita Perez Perez','Ing. Agronomia','CAGK081201MOCBNRA7',2);

INSERT INTO student(nocontrol, fullname, career, curp, currentgrade)
VALUES ('202020162','Gerardo Martinez Martinez','Ing. Agronomia','CEPG080217HOCLRLA8',2);


CREATE USER developer   WITH PASSWORD 't0ps3cr3t';
ALTER USER developer superuser;

GRANT ALL PRIVILEGES ON DATABASE tallerbd TO developer;

 
 
 


