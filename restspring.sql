-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-01-2019 a las 22:37:16
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `restspring`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(16),
(16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota`
--

CREATE TABLE `nota` (
  `id_nota` bigint(20) NOT NULL,
  `contenido` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nota`
--

INSERT INTO `nota` (`id_nota`, `contenido`, `nombre`, `titulo`) VALUES
(1, 'contenido nota 0', 'nota 0', 'titulo nota 0'),
(2, 'contenido nota 1', 'nota 1', 'titulo nota 1'),
(3, 'contenido nota 2', 'nota 2', 'titulo nota 2'),
(4, 'contenido nota 3', 'nota 3', 'titulo nota 3'),
(5, 'contenido nota 4', 'nota 4', 'titulo nota 4'),
(6, 'contenido nota 5', 'nota 5', 'titulo nota 5'),
(7, 'contenido nota 6', 'nota 6', 'titulo nota 6'),
(8, 'contenido nota 7', 'nota 7', 'titulo nota 7'),
(9, 'contenido nota 8', 'nota 8', 'titulo nota 8'),
(10, 'contenido nota 9', 'nota 9', 'titulo nota 9'),
(11, 'contenido nota 10', 'nota 10', 'titulo nota 10'),
(12, 'contenido nota 11', 'nota 11', 'titulo nota 11'),
(13, 'contenido nota 12', 'nota 12', 'titulo nota 12'),
(14, 'contenido nota 13', 'nota 13', 'titulo nota 13'),
(15, 'contenido nota 14', 'nota 14', 'titulo nota 14');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `rol` tinyint(4) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `activo`, `contrasena`, `rol`, `usuario`) VALUES
(1, b'1111111111111111111111111111111', '12345', 0, 'jua'),
(2, b'1111111111111111111111111111111', '12345', 1, 'pedro'),
(3, b'1111111111111111111111111111111', '12345', 2, 'lucas');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`id_nota`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_i02kr8ui5pqddyd7pkm3v4jbt` (`usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
