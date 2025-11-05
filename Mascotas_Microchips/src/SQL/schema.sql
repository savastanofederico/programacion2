/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Faby
 * Created: Nov 5, 2025
 */

DROP DATABASE IF EXISTS mascotas_chips;
CREATE DATABASE mascotas_chips
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_general_ci;
USE mascotas_chips;

CREATE TABLE Mascota (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(60) NOT NULL,
    Especie ENUM('PERRO','GATO','AVE','REPTIL','OTRO') NOT NULL,
    Raza VARCHAR(60) NOT NULL,
    FechaNacimiento DATE,
    Duenio VARCHAR(120) NOT NULL,
    Eliminado TINYINT(1) DEFAULT 0 NOT NULL,
    CONSTRAINT chk_longitud CHECK (CHAR_LENGTH(Duenio) > 2),
    CONSTRAINT registro_oculto_mascota CHECK (Eliminado IN (0,1))
) ENGINE=InnoDB;

CREATE TABLE Microchip (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Codigo VARCHAR(25) NOT NULL UNIQUE,
    FechaImplantacion DATE NOT NULL,
    Veterinaria VARCHAR(120),
    Observaciones VARCHAR(255),
    Id_mascota INT NOT NULL UNIQUE,          
    Eliminado TINYINT(1) DEFAULT 0 NOT NULL,
    CONSTRAINT registro_oculto_chip CHECK (Eliminado IN (0,1)),
    CONSTRAINT fk_microchip_mascota FOREIGN KEY (Id_mascota)
        REFERENCES Mascota(Id) ON DELETE CASCADE
) ENGINE=InnoDB;


CREATE TABLE nombres (nombre VARCHAR(60) PRIMARY KEY);
CREATE TABLE especies (especie ENUM('PERRO','GATO','AVE','REPTIL','OTRO') PRIMARY KEY);
CREATE TABLE raza_por_especie (
  id INT PRIMARY KEY AUTO_INCREMENT,
  especie ENUM('PERRO','GATO','AVE','REPTIL','OTRO') NOT NULL,
  raza VARCHAR(60) NOT NULL,
  UNIQUE (especie, raza)
);
CREATE TABLE nombres_duenio (nombre VARCHAR(60) PRIMARY KEY);
CREATE TABLE apellidos_duenio (apellido VARCHAR(60) PRIMARY KEY);


