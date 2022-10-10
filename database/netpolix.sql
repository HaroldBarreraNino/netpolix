-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 09-10-2022 a las 03:02:52
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `netpolix`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Alquiler`
--

CREATE TABLE `Alquiler` (
  `id_Alquiler` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `cantidad` int(5) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fecha_alquiler` varchar(25) NOT NULL,
  `fecha_Vencimiento` varchar(25) NOT NULL,
  `persona` int(11) NOT NULL,
  `video` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Alquiler`
--

INSERT INTO `Alquiler` (`id_Alquiler`, `nombre`, `cantidad`, `precio`, `fecha_alquiler`, `fecha_Vencimiento`, `persona`, `video`) VALUES
(1, 'Diego', 1, '50.21', '01-01-2019', '16-01-2019', 3, 22),
(2, 'Diego', 2, '70.30', '12-01-2019', '24-01-2019', 3, 21),
(3, 'Diego', 1, '17.22', '13-02-2018', '23-02-2018', 3, 23),
(4, 'Diego', 3, '41.01', '14-03-2017', '27-03-2017', 3, 22),
(5, 'Diego', 6, '91.00', '15-04-2020', '30-04-2020', 3, 41),
(6, 'Laura', 12, '100.20', '16-05-2021', '01-06-2021', 4, 21),
(7, 'Laura', 2, '150.34', '17-06-2018', '05-07-2018', 4, 22),
(8, 'Laura', 22, '68.69', '18-07-2019', '28-07-2019', 4, 23),
(9, 'Laura', 10, '22.22', '03-12-2017', '13-12-2017', 4, 21),
(10, 'Juan Camilo', 2, '11.11', '22-08-2017', '10-09-2017', 1, 22),
(11, 'Juan Camilo', 1, '33.33', '11-07-2019', '22-07-2019', 1, 22),
(12, 'Juan Camilo', 2, '44.44', '13-09-2018', '23-09-2018', 1, 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Calificacion`
--

CREATE TABLE `Calificacion` (
  `id_Calificacion` int(11) NOT NULL,
  `tipo_Calificacion` varchar(20) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Calificacion`
--

INSERT INTO `Calificacion` (`id_Calificacion`, `tipo_Calificacion`, `descripcion`) VALUES
(1, 'Pesima', 'Deberia ser retirada del sitio'),
(2, 'Mala', 'Hay varias cosas que mejorar'),
(3, 'Mas o menos', 'Es aceptable en mi opinion'),
(4, 'Buena', 'Me mantiene entrenido y me fascina'),
(5, 'Perfecta', 'Lo mejor que he visto en la vida');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Categoria`
--

CREATE TABLE `Categoria` (
  `id_Categoria` int(11) NOT NULL,
  `tipo_Categoria` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Categoria`
--

INSERT INTO `Categoria` (`id_Categoria`, `tipo_Categoria`) VALUES
(4, 'Comedia'),
(1, 'Drama'),
(2, 'Ficcion'),
(3, 'Sin categoria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cliente`
--

CREATE TABLE `Cliente` (
  `id_Cliente` int(11) NOT NULL,
  `persona` int(11) NOT NULL,
  `cantidad_Puntos` int(10) DEFAULT NULL,
  `fecha_registro` varchar(50) NOT NULL,
  `fecha_nacimiento` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coleccion`
--

CREATE TABLE `coleccion` (
  `id_Coleccion` int(11) NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `volumen` int(10) NOT NULL,
  `capitulos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `coleccion`
--

INSERT INTO `coleccion` (`id_Coleccion`, `titulo`, `volumen`, `capitulos`) VALUES
(1, 'Destarrado', 3, 24),
(2, 'Destarrado2', 1, 24);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Empleado`
--

CREATE TABLE `Empleado` (
  `id_Empleado` int(11) NOT NULL,
  `persona` int(11) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `salario` decimal(10,2) NOT NULL,
  `area` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Gerente`
--

CREATE TABLE `Gerente` (
  `id_Gerente` int(11) NOT NULL,
  `persona` int(11) NOT NULL,
  `gerenteArea` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Idioma`
--

CREATE TABLE `Idioma` (
  `id_Idioma` int(11) NOT NULL,
  `idioma` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Idioma`
--

INSERT INTO `Idioma` (`id_Idioma`, `idioma`) VALUES
(1, 'English(Original)'),
(3, 'English(Subtitles)'),
(2, 'Spanish');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Persona`
--

CREATE TABLE `Persona` (
  `id_Persona` int(11) NOT NULL,
  `cedula` int(10) NOT NULL,
  `nombre_completo` varchar(50) NOT NULL,
  `fecha_nacimiento` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Persona`
--

INSERT INTO `Persona` (`id_Persona`, `cedula`, `nombre_completo`, `fecha_nacimiento`) VALUES
(1, 123456789, 'admin', '08-08-2001'),
(2, 543218753, 'Maria Camila Arevalo Fajard', ''),
(3, 712587463, 'Diego Peralta Martinez', '01-11-2003'),
(4, 987562869, 'Laura Daniela Estupinan Caballero', '17-04-2000'),
(5, 45623179, 'Stephany Gutierrez Alonso', '14-09-2004'),
(6, 456138, 'Perez Garcia', '06-05-2001');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pqr`
--

CREATE TABLE `pqr` (
  `id_pqr` int(11) NOT NULL,
  `comentario` varchar(250) NOT NULL,
  `persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pqr`
--

INSERT INTO `pqr` (`id_pqr`, `comentario`, `persona`) VALUES
(1, '¿Podrian agregar la pelicula de Batman?', 1),
(2, 'Exigo una devolucion de mi dinero, la pelicula que alquile no es lo que esperaba.', 3),
(3, 'La aplicacion se cierra constantemente en mi iphone, ayuda.', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serie`
--

CREATE TABLE `serie` (
  `id_Serie` int(11) NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `temporadas` int(10) NOT NULL,
  `capitulos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `serie`
--

INSERT INTO `serie` (`id_Serie`, `titulo`, `temporadas`, `capitulos`) VALUES
(6, 'Free Violence', 2, 23),
(7, 'Free Violence', 2, 24),
(8, 'Free Violence', 2, 26),
(9, 'Marvel', 4, 21),
(10, 'Marvel', 4, 27),
(11, 'masacre', 1, 24),
(12, 'Desde android', 7, 22),
(13, 'Desde android', 4, 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Venta`
--

CREATE TABLE `Venta` (
  `id_Venta` int(11) NOT NULL,
  `cantidad` int(5) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `fecha_venta` varchar(25) NOT NULL,
  `persona` int(11) NOT NULL,
  `video` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Venta`
--

INSERT INTO `Venta` (`id_Venta`, `cantidad`, `total`, `fecha_venta`, `persona`, `video`) VALUES
(1, 1, '50.21', '01-01-2019', 3, 22),
(2, 2, '70.30', '12-01-2019', 3, 21),
(3, 1, '17.22', '13-02-2018', 3, 23),
(4, 3, '41.01', '14-03-2017', 3, 22),
(5, 6, '91.00', '15-04-2020', 3, 41),
(6, 12, '100.20', '16-05-2021', 4, 21),
(7, 2, '150.34', '17-06-2018', 4, 22),
(8, 22, '68.69', '18-07-2019', 4, 23),
(9, 10, '22.22', '03-12-2017', 4, 21),
(10, 2, '11.11', '22-08-2017', 1, 22),
(11, 1, '33.33', '11-07-2019', 1, 22),
(12, 2, '44.44', '13-09-2018', 1, 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `videos`
--

CREATE TABLE `videos` (
  `id_Video` int(11) NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `duracion` varchar(6) NOT NULL,
  `categoria` int(11) NOT NULL,
  `actores` varchar(80) NOT NULL,
  `directores` varchar(50) NOT NULL,
  `isan` varchar(6) NOT NULL,
  `calificacion` int(11) NOT NULL,
  `idioma` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `videos`
--

INSERT INTO `videos` (`id_Video`, `titulo`, `duracion`, `categoria`, `actores`, `directores`, `isan`, `calificacion`, `idioma`) VALUES
(21, 'Iron man', '1:30', 2, 'Robert Downey jr', 'Jon Favreau', 'PG', 4, 2),
(22, 'La vida es bella', '1:40', 1, 'Roberto Benigni', 'Roberto Benigni', 'PG-13', 5, 1),
(23, 'La naranja mecanica', '2:16', 3, 'Malcolm McDowell', 'Stanley Kubrick', 'R', 4, 3),
(24, 'Gladiador', '2:35', 3, 'Russell Crowe', 'Ridley Scott', 'PG-13', 4, 2),
(25, 'Rapidos y furiosos 8', '2:16', 3, 'Vin Diesil', 'F. Gary Gray', 'PG-13', 3, 2),
(26, 'Joker', '2:02', 3, 'Joaquin Phoenix', 'Todd Philips', 'NC-17', 5, 1),
(27, 'Thor Ragnarok', '2:10', 4, 'Chris Hemworth', 'Taika Watiti', 'PG-13', 4, 2),
(28, 'Forrest Gump', '2:22', 1, 'Tom Hanks', 'Robert Zemeckis', 'PG-13', 5, 3),
(29, 'La posesion de Daniel', '1:40', 3, 'Miles Robbins', 'Adam Egypt Mortimer', 'PG-13', 2, 1),
(41, 'Top gun: Maverick', '2:11', 3, 'Tom Cruise', 'Joseph Kosinski', 'PG-13', 3, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Alquiler`
--
ALTER TABLE `Alquiler`
  ADD PRIMARY KEY (`id_Alquiler`),
  ADD KEY `persona` (`persona`),
  ADD KEY `video` (`video`);

--
-- Indices de la tabla `Calificacion`
--
ALTER TABLE `Calificacion`
  ADD PRIMARY KEY (`id_Calificacion`),
  ADD UNIQUE KEY `tipo_Calificacion` (`tipo_Calificacion`);

--
-- Indices de la tabla `Categoria`
--
ALTER TABLE `Categoria`
  ADD PRIMARY KEY (`id_Categoria`),
  ADD UNIQUE KEY `tipo_Categoria` (`tipo_Categoria`);

--
-- Indices de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`id_Cliente`),
  ADD KEY `persona` (`persona`);

--
-- Indices de la tabla `coleccion`
--
ALTER TABLE `coleccion`
  ADD PRIMARY KEY (`id_Coleccion`),
  ADD KEY `capitulos` (`capitulos`);

--
-- Indices de la tabla `Empleado`
--
ALTER TABLE `Empleado`
  ADD PRIMARY KEY (`id_Empleado`),
  ADD KEY `persona` (`persona`);

--
-- Indices de la tabla `Gerente`
--
ALTER TABLE `Gerente`
  ADD PRIMARY KEY (`id_Gerente`),
  ADD KEY `persona` (`persona`);

--
-- Indices de la tabla `Idioma`
--
ALTER TABLE `Idioma`
  ADD PRIMARY KEY (`id_Idioma`),
  ADD UNIQUE KEY `idioma` (`idioma`);

--
-- Indices de la tabla `Persona`
--
ALTER TABLE `Persona`
  ADD PRIMARY KEY (`id_Persona`),
  ADD UNIQUE KEY `cedula` (`cedula`);

--
-- Indices de la tabla `pqr`
--
ALTER TABLE `pqr`
  ADD PRIMARY KEY (`id_pqr`),
  ADD KEY `persona` (`persona`);

--
-- Indices de la tabla `serie`
--
ALTER TABLE `serie`
  ADD PRIMARY KEY (`id_Serie`),
  ADD KEY `capitulos` (`capitulos`);

--
-- Indices de la tabla `Venta`
--
ALTER TABLE `Venta`
  ADD PRIMARY KEY (`id_Venta`),
  ADD KEY `persona` (`persona`),
  ADD KEY `video` (`video`);

--
-- Indices de la tabla `videos`
--
ALTER TABLE `videos`
  ADD PRIMARY KEY (`id_Video`),
  ADD KEY `categoria` (`categoria`),
  ADD KEY `calificacion` (`calificacion`),
  ADD KEY `idioma` (`idioma`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Alquiler`
--
ALTER TABLE `Alquiler`
  MODIFY `id_Alquiler` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `Calificacion`
--
ALTER TABLE `Calificacion`
  MODIFY `id_Calificacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `Categoria`
--
ALTER TABLE `Categoria`
  MODIFY `id_Categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  MODIFY `id_Cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `coleccion`
--
ALTER TABLE `coleccion`
  MODIFY `id_Coleccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `Empleado`
--
ALTER TABLE `Empleado`
  MODIFY `id_Empleado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Gerente`
--
ALTER TABLE `Gerente`
  MODIFY `id_Gerente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Idioma`
--
ALTER TABLE `Idioma`
  MODIFY `id_Idioma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `Persona`
--
ALTER TABLE `Persona`
  MODIFY `id_Persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `pqr`
--
ALTER TABLE `pqr`
  MODIFY `id_pqr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `serie`
--
ALTER TABLE `serie`
  MODIFY `id_Serie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `Venta`
--
ALTER TABLE `Venta`
  MODIFY `id_Venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `videos`
--
ALTER TABLE `videos`
  MODIFY `id_Video` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7782;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Alquiler`
--
ALTER TABLE `Alquiler`
  ADD CONSTRAINT `Alquiler_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `Persona` (`id_Persona`),
  ADD CONSTRAINT `Alquiler_ibfk_2` FOREIGN KEY (`video`) REFERENCES `videos` (`id_Video`);

--
-- Filtros para la tabla `Cliente`
--
ALTER TABLE `Cliente`
  ADD CONSTRAINT `Cliente_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `Persona` (`id_Persona`);

--
-- Filtros para la tabla `coleccion`
--
ALTER TABLE `coleccion`
  ADD CONSTRAINT `coleccion_ibfk_1` FOREIGN KEY (`capitulos`) REFERENCES `videos` (`id_Video`);

--
-- Filtros para la tabla `Empleado`
--
ALTER TABLE `Empleado`
  ADD CONSTRAINT `Empleado_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `Persona` (`id_Persona`);

--
-- Filtros para la tabla `Gerente`
--
ALTER TABLE `Gerente`
  ADD CONSTRAINT `Gerente_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `Persona` (`id_Persona`);

--
-- Filtros para la tabla `pqr`
--
ALTER TABLE `pqr`
  ADD CONSTRAINT `pqr_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `Persona` (`id_Persona`);

--
-- Filtros para la tabla `serie`
--
ALTER TABLE `serie`
  ADD CONSTRAINT `serie_ibfk_1` FOREIGN KEY (`capitulos`) REFERENCES `videos` (`id_Video`);

--
-- Filtros para la tabla `Venta`
--
ALTER TABLE `Venta`
  ADD CONSTRAINT `Venta_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `Persona` (`id_Persona`),
  ADD CONSTRAINT `Venta_ibfk_2` FOREIGN KEY (`video`) REFERENCES `videos` (`id_Video`);

--
-- Filtros para la tabla `videos`
--
ALTER TABLE `videos`
  ADD CONSTRAINT `videos_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `Categoria` (`id_Categoria`),
  ADD CONSTRAINT `videos_ibfk_2` FOREIGN KEY (`calificacion`) REFERENCES `Calificacion` (`id_Calificacion`),
  ADD CONSTRAINT `videos_ibfk_3` FOREIGN KEY (`idioma`) REFERENCES `Idioma` (`id_Idioma`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
