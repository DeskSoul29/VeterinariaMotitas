-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-12-2021 a las 17:36:19
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_veterinaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_clien` int(12) NOT NULL,
  `nombre_clien` varchar(30) NOT NULL,
  `telefono` bigint(12) NOT NULL,
  `direccion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_clien`, `nombre_clien`, `telefono`, `direccion`) VALUES
(1004802, 'Angela', 0, 'Av 0 '),
(100480235, 'Jhan', 320269137, 'Av 0 Cll 0'),
(1234557890, 'Camilo', 1234567890, 'Av 0'),
(1234567894, 'Kevin', 2564782169, 'Centro'),
(1345678945, 'Kevin', 6489756895, 'No se');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta`
--

CREATE TABLE `consulta` (
  `id_cons` int(10) NOT NULL,
  `fecha_cons` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `valoracion_cons` varchar(100) NOT NULL,
  `diagnostico_cons` varchar(100) NOT NULL,
  `id_masc_cons` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `consulta`
--

INSERT INTO `consulta` (`id_cons`, `fecha_cons`, `valoracion_cons`, `diagnostico_cons`, `id_masc_cons`) VALUES
(1, '2021-12-16 16:18:00', 'Perro caido', 'Perro muerto', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturacion`
--

CREATE TABLE `facturacion` (
  `id_fact` int(10) NOT NULL,
  `id_cliente` int(12) NOT NULL,
  `tipo_fact` varchar(20) NOT NULL,
  `descripcion_fact` varchar(50) NOT NULL,
  `tipo_valor_fact` int(10) NOT NULL,
  `fecha_fact` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `facturacion`
--

INSERT INTO `facturacion` (`id_fact`, `id_cliente`, `tipo_fact`, `descripcion_fact`, `tipo_valor_fact`, `fecha_fact`) VALUES
(5, 1004802, 'Producto', 'Muchacha con Sueño', 1, '2021-12-16 03:28:06'),
(6, 100480235, 'Servicio', 'Se llevo mucha comida', 2, '2021-12-16 16:06:57'),
(7, 1234557890, 'Servicio', 'Paca de purina', 1, '2021-12-16 16:13:03'),
(8, 1234567894, 'Producto', 'Se cayo ', 1, '2021-12-16 16:32:48'),
(9, 1234557890, 'Servicio', 'No se', 1, '2021-12-16 16:35:03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `id_hist` int(10) NOT NULL,
  `id_mascota_hist` int(10) NOT NULL,
  `turno_hist` int(10) NOT NULL,
  `fecha_hist` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`id_hist`, `id_mascota_hist`, `turno_hist`, `fecha_hist`) VALUES
(1, 1, 37, '2021-12-16 03:28:06'),
(2, 2, 130, '2021-12-16 16:30:13'),
(3, 2, 183, '2021-12-16 16:30:44'),
(4, 1, 27, '2021-12-16 16:32:07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

CREATE TABLE `mascota` (
  `id_masc` int(10) NOT NULL,
  `nombre_masc` varchar(30) NOT NULL,
  `especie` varchar(30) NOT NULL,
  `raza` varchar(30) NOT NULL,
  `id_prop` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mascota`
--

INSERT INTO `mascota` (`id_masc`, `nombre_masc`, `especie`, `raza`, `id_prop`) VALUES
(1, 'Lukas', 'Perro', 'Pitbull', 100480235),
(2, 'Firulais', 'Muerta', 'Estincion', 1345678945);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_prod` int(10) NOT NULL,
  `nombre_prod` varchar(30) NOT NULL,
  `precio_prod` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_prod`, `nombre_prod`, `precio_prod`) VALUES
(1, 'Alimento Canino de 2Kg', 60000),
(2, 'Alimento Canino de 5kg', 80000),
(3, 'Alimento Canino de 10kg', 120000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id_serv` int(10) NOT NULL,
  `nombre_serv` varchar(30) NOT NULL,
  `precio_serv` bigint(20) NOT NULL,
  `area_serv` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`id_serv`, `nombre_serv`, `precio_serv`, `area_serv`) VALUES
(1, 'Consulta General', 120000, 'Area Médica'),
(2, 'Consulta Especializada', 250000, 'Area Médica'),
(3, 'Cirugia Veterinaria General', 1000000, 'Area Médica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_valor`
--

CREATE TABLE `tipo_valor` (
  `id_tiva` int(10) NOT NULL,
  `valor_tiva` int(10) NOT NULL,
  `tipo` int(11) NOT NULL,
  `descripcion_tiva` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_valor`
--

INSERT INTO `tipo_valor` (`id_tiva`, `valor_tiva`, `tipo`, `descripcion_tiva`) VALUES
(1, 19, 1, 'IVA'),
(2, 19, 2, 'BLACK FRIDAY');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_clien`);

--
-- Indices de la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`id_cons`),
  ADD KEY `id_masc_cons` (`id_masc_cons`);

--
-- Indices de la tabla `facturacion`
--
ALTER TABLE `facturacion`
  ADD PRIMARY KEY (`id_fact`),
  ADD KEY `tipo_valor_fact` (`tipo_valor_fact`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`id_hist`),
  ADD KEY `id_mascota_hist` (`id_mascota_hist`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`id_masc`),
  ADD KEY `id_prop` (`id_prop`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_prod`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id_serv`);

--
-- Indices de la tabla `tipo_valor`
--
ALTER TABLE `tipo_valor`
  ADD PRIMARY KEY (`id_tiva`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `consulta`
--
ALTER TABLE `consulta`
  MODIFY `id_cons` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `facturacion`
--
ALTER TABLE `facturacion`
  MODIFY `id_fact` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `id_hist` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `id_masc` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_prod` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id_serv` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_valor`
--
ALTER TABLE `tipo_valor`
  MODIFY `id_tiva` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`id_masc_cons`) REFERENCES `mascota` (`id_masc`);

--
-- Filtros para la tabla `facturacion`
--
ALTER TABLE `facturacion`
  ADD CONSTRAINT `facturacion_ibfk_1` FOREIGN KEY (`tipo_valor_fact`) REFERENCES `tipo_valor` (`id_tiva`),
  ADD CONSTRAINT `facturacion_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_clien`);

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`id_mascota_hist`) REFERENCES `mascota` (`id_masc`);

--
-- Filtros para la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`id_prop`) REFERENCES `cliente` (`id_clien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
