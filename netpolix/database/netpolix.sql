-- Creando las tablas
-- @Block
CREATE TABLE Persona(
    id_Persona INT PRIMARY KEY AUTO_INCREMENT,
    cedula INT(10) NOT NULL UNIQUE,
    nombre_completo VARCHAR(50) NOT NULL,
    fecha_nacimiento VARCHAR(50) NULL
);
-- @Block
CREATE TABLE Gerente(
    id_Gerente INT PRIMARY KEY AUTO_INCREMENT,
    persona INT NOT NULL,
    gerenteArea VARCHAR(50) NOT NULL,
    FOREIGN KEY(persona) REFERENCES Persona(id_Persona)
);
-- @Block
CREATE TABLE Empleado(
    id_Empleado INT PRIMARY KEY AUTO_INCREMENT,
    persona INT NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    area VARCHAR(50) NOT NULL,
    FOREIGN KEY(persona) REFERENCES Persona(id_Persona)
);
-- @Block
CREATE TABLE Cliente(
    id_Cliente INT PRIMARY KEY AUTO_INCREMENT,
    persona INT NOT NULL,
    cantidad_Puntos INT(10) NULL,
    fecha_registro VARCHAR(50) NOT NULL,
    fecha_nacimiento VARCHAR(50) NOT NULL,
    FOREIGN KEY(persona) REFERENCES Persona(id_Persona)
);
-- @Block
CREATE TABLE Categoria(
    id_Categoria INT PRIMARY KEY AUTO_INCREMENT,
    tipo_Categoria VARCHAR(20) NOT NULL UNIQUE
);
-- @Block
CREATE TABLE Calificacion(
    id_Calificacion INT PRIMARY KEY AUTO_INCREMENT,
    tipo_Calificacion VARCHAR(20) NOT NULL UNIQUE,
    descripcion VARCHAR(50) NULL
);
-- @Block
CREATE TABLE Idioma(
    id_Idioma INT PRIMARY KEY AUTO_INCREMENT,
    idioma VARCHAR(20) NOT NULL UNIQUE
);
-- @Block
CREATE TABLE Videos (
    id_Video INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(30) NOT NULL,
    duracion VARCHAR(6) NOT NULL,
    categoria INT NOT NULL,
    actores VARCHAR(80) NOT NULL,
    directores VARCHAR(50) NOT NULL,
    isan VARCHAR(6) NOT NULL,
    calificacion INT NOT NULL,
    idioma INT NOT NULL,
    FOREIGN KEY(categoria) REFERENCES Categoria(id_Categoria),
    FOREIGN KEY(calificacion) REFERENCES Calificacion(id_Calificacion),
    FOREIGN KEY(idioma) REFERENCES Idioma(id_Idioma)
);
-- @Block
CREATE TABLE Serie (
    id_Serie INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(30) NOT NULL,
    temporadas INT(10) NOT NULL,
    capitulos INT NOT NULL,
    FOREIGN KEY(capitulos) REFERENCES Videos(id_Video)
);
-- @Block
CREATE TABLE Coleccion (
    id_Coleccion INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(30) NOT NULL,
    volumen INT(10) NOT NULL,
    capitulos INT NOT NULL,
    FOREIGN KEY(capitulos) REFERENCES Videos(id_Video)
);
-- @Block
CREATE TABLE Venta(
    id_Venta INT PRIMARY KEY AUTO_INCREMENT,
    cantidad INT(5) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    fecha_venta VARCHAR(25) NOT NULL,
    persona INT NOT NULL,
    video INT NOT NULL,
    FOREIGN KEY(persona) REFERENCES Persona(id_Persona),
    FOREIGN KEY(video) REFERENCES Videos(id_Video)
);
-- @Block
CREATE TABLE Alquiler(
    id_Alquiler INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(25) NOT NULL,
    cantidad INT(5) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    fecha_alquiler VARCHAR(25) NOT NULL,
    fecha_Vencimiento VARCHAR(25) NOT NULL,
    persona INT NOT NULL,
    video INT NOT NULL,
    FOREIGN KEY(persona) REFERENCES Persona(id_Persona),
    FOREIGN KEY(video) REFERENCES Videos(id_Video)
);
-- @Block
CREATE TABLE pqr(
    id_pqr INT PRIMARY KEY AUTO_INCREMENT,
    comentario VARCHAR(250) NOT NULL,
    persona INT NOT NULL,
    FOREIGN KEY(persona) REFERENCES Persona(id_Persona);
);

-- Insertando datos
--Persona
-- @Block
INSERT INTO Persona(cedula, nombre_completo, fecha_nacimiento) VALUES
(123456789, 'Juan Camilo Novoa Sanchez', '08-08-2001'),
(543218753, 'Maria Camila Arevalo Fajard', ''),
(712587463, 'Diego Peralta Martinez', '01-11-2003'),
(987562869, 'Laura Daniela Estupiñan Caballero', '17-04-2000');

-- Categoria
-- @Block
INSERT INTO Categoria(tipo_Categoria) VALUES
('Drama'),
('Ficcion'),
('Sin categoria'),
('Comedia');

-- Calificacion
-- @Block
INSERT INTO Calificacion(tipo_Calificacion, descripcion) VALUES
('Pesima', 'Deberia ser retirada del sitio'),
('Mala', 'Hay varias cosas que mejorar'),
('Mas o menos', 'Es aceptable en mi opinion'),
('Buena', 'Me mantiene entrenido y me fascina'),
('Perfecta', 'Lo mejor que he visto en la vida');

-- Idioma
-- @Block
INSERT INTO Idioma(idioma) VALUES
('English(Original)'),
('Spanish'),
('English(Subtitles)');

-- Videos
-- @Block
INSERT INTO Videos(titulo, duracion, categoria, actores, directores, isan, calificacion, idioma) VALUES
('Iron man', '1:30', 2, 'Robert Downey jr', 'Jon Favreau', 'PG', 4, 2),
('La vida es bella', '1:40', 1, 'Roberto Benigni', 'Roberto Benigni', 'PG-13', 5, 1),
('La naranja mecanica', '2:16', 8, 'Malcolm McDowell', 'Stanley Kubrick', 'R', 4, 3),
('Gladiador', '2:35', 8, 'Russell Crowe', 'Ridley Scott', 'PG-13', 4, 2),
('Rapidos y furiosos 8', '2:16', 8, 'Vin Diesil', 'F. Gary Gray', 'PG-13', 3, 2),
('Joker', '2:02', 8, 'Joaquin Phoenix', 'Todd Philips', 'NC-17', 5, 1),
('Thor Ragnarok', '2:10', 3, 'Chris Hemworth', 'Taika Watiti', 'PG-13', 4, 2),
('Forrest Gump', '2:22', 1, 'Tom Hanks', 'Robert Zemeckis', 'PG-13', 5, 3),
('La posesion de Daniel', '1:40', 8, 'Miles Robbins', 'Adam Egypt Mortimer', 'PG-13', 2, 1),
('Top gun: Maverick', '2:11', 8, 'Tom Cruise', 'Joseph Kosinski', 'PG-13', 3, 2);

-- Serie
-- @Block
INSERT INTO Serie(titulo, temporadas, capitulos) VALUES
('Free Violence', 2, 13),
('Free Violence', 2, 14),
('Free Violence', 2, 16),
('Marvel', 4, 11),
('Marvel', 4, 17);

-- Alquiler
-- @Block
INSERT INTO Alquiler(nombre, cantidad, precio, fecha_alquiler, fecha_Vencimiento, persona, video) VALUES
('Diego', 1, 50.21, '01-01-2019', '16-01-2019', 3, 12),
('Diego', 2, 70.30, '12-01-2019', '24-01-2019', 3, 11),
('Diego', 1, 17.22, '13-02-2018', '23-02-2018', 3, 13),
('Diego', 3, 41.01, '14-03-2017', '27-03-2017', 3, 12),
('Diego', 6, 91.0, '15-04-2020', '30-04-2020', 3, 20),
('Laura', 12, 100.2, '16-05-2021', '01-06-2021', 4, 11),
('Laura', 2, 150.34, '17-06-2018', '05-07-2018', 4, 12),
('Laura', 22, 68.69, '18-07-2019', '28-07-2019', 4, 13),
('Laura', 10, 22.22, '03-12-2017', '13-12-2017', 4, 11),
('Juan Camilo', 2, 11.11, '22-08-2017', '10-09-2017', 1, 12),
('Juan Camilo', 1, 33.33, '11-07-2019', '22-07-2019', 1, 12),
('Juan Camilo', 2, 44.44, '13-09-2018', '23-09-2018', 1, 12);

-- Ventas
-- @Block
INSERT INTO Venta(cantidad, total, fecha_venta, persona, video) VALUES
(1, 50.21, '01-01-2019',  3, 12),
(2, 70.30, '12-01-2019',  3, 11),
(1, 17.22, '13-02-2018',  3, 13),
(3, 41.01, '14-03-2017',  3, 12),
(6, 91.0, '15-04-2020', 3, 20),
(12, 100.2, '16-05-2021', 4, 11),
(2, 150.34, '17-06-2018', 4, 12),
(22, 68.69, '18-07-2019', 4, 13),
(10, 22.22, '03-12-2017', 4, 11),
(2, 11.11, '22-08-2017', 1, 12),
(1, 33.33, '11-07-2019', 1, 12),
(2, 44.44, '13-09-2018', 1, 12);

-- pqr
-- @Block
INSERT INTO pqr(comentario, persona) VALUES
('¿Podrian agregar la pelicula de Batman?', 1),
('Exigo una devolucion de mi dinero, la pelicula que alquile no es lo que esperaba.', 3),
('La aplicacion se cierra constantemente en mi ¡phone, ayuda.', 4);

-- Consultas
-- RFC1
-- @Block
SELECT * FROM Videos WHERE categoria = 8;

-- RFC2
-- @Block
SELECT * FROM Videos WHERE calificacion > 4;

-- RFC3
-- @Block
SELECT Serie.titulo,Videos.titulo,isan FROM Serie
INNER JOIN Videos
ON Videos.id_Video = Serie.capitulos;

-- RFC4
-- @Block
SELECT isan,titulo FROM Videos WHERE idioma = 2;

-- RFC5 
-- @Block
SELECT isan,Videos.titulo FROM Videos
INNER JOIN Serie
ON Serie.capitulos = Videos.id_Video
WHERE idioma = 2;

-- RFC6
-- @Block
SELECT Videos.isan,Videos.titulo,Videos.calificacion,Alquiler.cantidad FROM Alquiler
INNER JOIN Videos
ON Videos.id_Video = Alquiler.video
ORDER BY Alquiler.cantidad DESC LIMIT 10;

-- RFC7
-- @Block
SELECT Persona.cedula,Persona.nombre_completo, COUNT(cantidad) as cantidad FROM Persona
INNER JOIN Alquiler
ON Alquiler.persona = Persona.id_Persona
GROUP BY Persona.nombre_completo
ORDER BY cantidad DESC LIMIT 10;

-- RFC8
-- @Block
SELECT * FROM Persona
LEFT JOIN Venta
ON Venta.persona = Persona.id_Persona
WHERE Venta.id_Venta IS NULL;

-- RFC9
-- @Block
SELECT * FROM pqr;

