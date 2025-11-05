/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Faby
 * Created: Nov 5, 2025
 */

USE mascotas_chips;

INSERT INTO Mascota (Nombre, Especie, Raza, FechaNacimiento, Duenio)
VALUES
('Rocky','PERRO','Labrador','2018-03-12','Juan Perez'),
('Luna','GATO','Persa','2020-07-01','María Gómez'),
('Milo','PERRO','Chihuahua','2019-11-20','Carlos López');

INSERT INTO Microchip (Codigo, FechaImplantacion, Veterinaria, Observaciones, Id_mascota)
VALUES
('CHIP-0001','2018-04-01','Vet Center','Sin observaciones', 1),
('CHIP-0002','2020-07-10','Clínica Felina','Control anual', 2);

