create database PELICULAS_WEB;

use peliculas_web;

CREATE TABLE USUARIO(
	ID INT NOT NULL AUTO_INCREMENT,
    NOMBRE VARCHAR(255),
    APELLIDO VARCHAR(255),
    EMAIL VARCHAR(255),
    CLAVE VARCHAR(255),
    FECHA_NAC DATE,
    NACIONALIDAD VARCHAR(255),
    PRIMARY KEY(ID)
);

CREATE table director(
	id int NOT NULL auto_increment,
    NOMBRE varchar(255),
    apellido varchar(255),
    edad int,
    nacionalidad varchar(255),
    PRIMARY KEY(ID)
);
CREATE table movie(
	id int NOT NULL auto_increment,
    nombre varchar(255),
    descripcion varchar(1024),
    genero varchar(255),
    calificacion int,
    anio int,
    estrellas tinyint,
    director varchar(255),
    PRIMARY KEY(id)
);

/*insetar peliculas*/
INSERT INTO movie (
nombre, descripcion, genero, calificacion, anio, estrellas, director) values 
("Titanic", "La descripcion", "Romantica", 120 , 1998, 4 , "James Cameron");

INSERT INTO movie (
nombre, descripcion, genero, calificacion, anio, estrellas, director) values 
("Mas barato por docena", "La descripcion", "Comedia", 100 , 1998, 3 , "George Lucas");

INSERT INTO movie (
nombre, descripcion, genero, calificacion, anio, estrellas, director) values 
("Star Wars", "La descripcion", "Ciencia Ficcion", 120 , 1975, 5 , "James Cameron");

INSERT INTO movie (
nombre, descripcion, genero, calificacion, anio, estrellas, director) values 
("The Martian", "La descripcion", "suspenso", 120 , 2015, 5 , "James Cameron");

INSERT INTO movie (
nombre, descripcion, genero, calificacion, anio, estrellas, director) values 
("Intensamente", "La descripcion", "Animada", 120 , 2011, 3 , "Pixar");

INSERT INTO movie (
nombre, descripcion, genero, calificacion, anio, estrellas, director) values 
("Sunshine", "La descripcion", "Ciencia Ficcion", 120 , 2008, 3 , "Tban Quito");

INSERT INTO movie (
nombre, descripcion, genero, calificacion, anio, estrellas, director) values 
("Avatar", "La descripcion", "Ciencia Ficcion", 75 , 2009, 3 , "George Lucas");

/*insertar directores*/
INSERT INTO director (
nombre, apellido, edad, nacionalidad) values 
("James", "Cameron", "72", "Estados Unidos");

INSERT INTO director (
nombre, apellido, edad, nacionalidad) values 
("Jeorge", "Lucas", "40", "Estados Unidos");

INSERT INTO director (
nombre, apellido, edad, nacionalidad) values 
("Juan", "Campanella", "67", "Argentina");

/*insertar usuarios*/
INSERT INTO usuario (
nombre, apellido, email, clave, fecha_nac, nacionalidad) values
("Ivan", "Glaz", "ivang@gmail.com", "1234", "1987-09-09", "Argentino");

INSERT INTO usuario (
nombre, apellido, email, clave, fecha_nac, nacionalidad) values
("Flavia", "Tou", "yanitou@gmail.com", "1234", "1986-09-09", "Argentina");


/*Eliminar Tabla*/
drop table movie;
truncate

/*Eliminar registro*/
DELETE FROM MOVIE where ID = 3;

/*Select para obetener los registros*/
SELECT * FROM movie;
SELECT * FROM director;
SELECT * FROM usuario;movie

INSERT INTO movie (
nombre, descripcion, genero, calificacion, anio, estrellas, director) values 
("Dias de Trueno", "La descripcion nascar", "Accion", 75 , 1997, 4 , "Tom Cruise");

/*Consultas que pide el trabajo*/
select * from movie where anio < 2022 and genero = "Comedia";
select * from movie where estrellas = 5;
select * from movie where genero = "accion" 
and estrellas >= 4;

select * from director where edad between 25 and 72;