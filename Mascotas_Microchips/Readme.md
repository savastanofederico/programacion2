# TFI - Programación 2 (Mascota -> Microchip)

#Autores
**Federico Savastano** — Diseño UML y entidades
**Fabiana Rossetto** — Base de datos y DAO
**Gianina Azcurra** — Service y AppMenu

**Dominio Elegido:** Mascota → Microchip (Relación 1:1 Unidireccional)

# Descripción del dominio

El sistema gestiona mascotas y sus microchips identificadores.
Cada mascota cuenta con un único microchip que almacena información como el código de registro, la fecha de implantación y la veterinaria responsable.
El dominio fue elegido porque representa un caso real y sencillo para modelar una relación 1→1 en bases de datos relacionales, permitiendo aplicar conceptos de POO, JDBC, transacciones y arquitectura por capas.

# Requisitos y Ejecución
**Lenguaje:** Java 17 o superior
**Gestor de Base de Datos:** MySQL 8.x
**IDE recomendado:** Apache NetBeans / IntelliJ IDEA / Eclipse
**Conector JDBC:** mysql-connector-j-8.x
**Driver y credenciales:** configurados en config/DatabaseConnection.java o en resources/db.properties

# Base de Datos
**Crear BD:** Ejecutar `db/schema.sql`
**Cargar datos:** Ejecutar `db/data.sql `

# Ejecución
- Compilar el proyecto.
- Ejecutar la clase `AppMenu` en el paquete `main/`
- **Credenciales de prueba:** *(A completar: ej., Usuario: admin / Clave: 123)*

# Informe
https://docs.google.com/document/d/1p4wA3T74iVRAmqdSllbjBEu7E7OCeQNyhWXocw0kmVw/edit?usp=sharing

# Video
https://www.youtube.com/watch?v=SCbkbGIXrUs
