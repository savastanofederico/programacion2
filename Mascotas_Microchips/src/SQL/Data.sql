/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Faby
 * Created: Nov 5, 2025
 */

USE mascotas_chips;


INSERT INTO Microchip (Codigo, FechaImplantacion, Veterinaria, Observaciones)
VALUES
('CHIP-0001', '2018-04-01', 'Vet Center', 'Sin observaciones'),
('CHIP-0002', '2020-07-10', 'Clínica Felina', 'Control anual'),
('CHIP-0003', '2019-12-05', 'Veterinaria Los Andes', 'Revisión general');


INSERT INTO Mascota (Nombre, Especie, Raza, FechaNacimiento, Duenio, Id_microchip)
VALUES
('Rocky', 'PERRO', 'Labrador', '2018-03-12', 'Juan Pérez', 1),
('Luna', 'GATO', 'Persa', '2020-07-01', 'María Gómez', 2),
('Milo', 'PERRO', 'Chihuahua', '2019-11-20', 'Carlos López', 3);

