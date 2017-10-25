-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-06-2014 a las 21:45:53
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tiendaentradas`
--
CREATE DATABASE IF NOT EXISTS `tiendaentradas` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `tiendaentradas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concierto`
--

CREATE TABLE IF NOT EXISTS `concierto` (
  `id_concierto` int(11) NOT NULL AUTO_INCREMENT,
  `nombreGrupo` varchar(45) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `lugar` varchar(45) NOT NULL,
  `fecha` date NOT NULL,
  `precio` float DEFAULT NULL,
  `numEntradas` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_concierto`),
  UNIQUE KEY `nombreGrupo_UNIQUE` (`nombreGrupo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `concierto`
--

INSERT INTO `concierto` (`id_concierto`, `nombreGrupo`, `genero`, `lugar`, `fecha`, `precio`, `numEntradas`) VALUES
(1, 'Love Of Lesbian', 'Indie', 'segovia', '2014-05-28', 17, 9),
(2, 'La Fuga', 'Rock', 'Segovia', '2014-05-28', 18.9, 15),
(3, 'The Gaslight Anthem', 'Rock', 'Madrid', '2014-05-12', 0, 2),
(4, 'Florence & the Machine', 'Indie', 'Nürburg', '2014-05-04', 0, 8),
(5, 'The Cranberries', 'Rock', 'Segovia', '2014-05-22', 0, 9),
(6, 'Vetusta Morla', 'Indie', 'Segovia', '2014-05-14', 0, 20),
(7, 'Imagine Dragons', 'Indie', 'Madrid', '2014-05-05', 0, 30),
(11, 'The Corrs', 'Celtic', 'Segovia', '2014-05-07', 15.5, 14),
(13, 'Foals', 'Rock', 'Madrid', '2014-05-12', 20, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticketscomprados`
--

CREATE TABLE IF NOT EXISTS `ticketscomprados` (
  `id_tickets` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_concierto` int(11) NOT NULL,
  PRIMARY KEY (`id_tickets`),
  KEY `id_usuario_idx` (`id_usuario`),
  KEY `id_concierto_idx` (`id_concierto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Volcado de datos para la tabla `ticketscomprados`
--

INSERT INTO `ticketscomprados` (`id_tickets`, `id_usuario`, `id_concierto`) VALUES
(1, 13, 1),
(3, 13, 2),
(4, 11, 3),
(5, 14, 4),
(6, 11, 5),
(7, 11, 4),
(8, 21, 13),
(9, 21, 13),
(10, 21, 11),
(11, 21, 11),
(22, 24, 2),
(23, 24, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `contrasenia` varchar(400) NOT NULL,
  `email` varchar(45) NOT NULL,
  `saldo` float DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `edad` int(11) NOT NULL,
  `esAdmin` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `contrasenia`, `email`, `saldo`, `telefono`, `edad`, `esAdmin`) VALUES
(10, 'jose', '107d125c183b9cebc75f71f6c225879d17fb6a8edcc551372bccc85b6301ad8b69d8623700f83b78010b96e8e08e819e41f79a949d442b5de468bcc376884df6', 'jose@jose', 53.5, 921425196, 40, 0),
(11, 'admin', 'c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec', 'admin@admin.com', 100, 0, 30, 1),
(13, 'Joselu', 'bbd305363a06e5588e0ac8a830a3bc315b2854a96b06aeb81499cd0d247e2cf4d3d6991cc6556b03b9ded66f0d9d315849e30275a778c9da648d33432cc0708a', 'joselu@joselu', 0, 987456312, 28, 0),
(14, 'admin2', '661bb43140229ad4dc3e762e7bdd68cc14bb9093c158c386bd989fea807acd9bd7f805ca4736b870b6571594d0d8fcfc57b98431143dfb770e083fa9be89bc72', 'admin@admin.es', 0, 921456389, 30, 1),
(17, 'lola', 'c5b283f34d8cc083279d8694846d4089151d6b21c7d77eaad5f90eb10a156231f85f544d1d617004c18e42158677ffe4845cb43db6a40290202dae1a079a4616', 'lola@lola', 200, 921458796, 30, 0),
(18, 'juana', 'f4b7796eb22722d045e31dcf36a64761f2eba310114f357d56d98c93871872c70d38f8490b9e1ab5143a04613cca147eeac2cd9f5f9a63d000a032df954677a8', 'juana@juana', 200, 987456132, 40, 0),
(20, 'admin3', '448d8ca07486257065add370c87e61a3c778c70d4fcb5db89f011ade315e7a942fb3352e6bded66c4f9adef6f3314588ace81aa12096111ee306fa5ed4294182', 'admin3', 0, 98745612, 40, 1),
(21, 'diego', 'd6d3370465fcf929e8fa1c832020d879a781edf2863f409f36f8ba7edb6d849b7388c5339c257a16e23637c60194c841600119213bcb95ac8ac4b70612c89b73', 'diego@diego', 229, 921487891, 10, 0),
(24, 'Kevin', '5dfe55879638e99cc14a1d4730238936207b92050ef3cd24ae64d52d773084485b55b00f835a076bdc8f8c307ab5eb183eaf332867a2b6f47557d913234f2973', 'kevin@kevin', 144.1, 92145879, 30, 0);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ticketscomprados`
--
ALTER TABLE `ticketscomprados`
  ADD CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticketscomprados_ibfk_1` FOREIGN KEY (`id_concierto`) REFERENCES `concierto` (`id_concierto`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
