-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 23-02-2022 a las 14:27:54
-- Versión del servidor: 5.5.20
-- Versión de PHP: 5.3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `institutostalleresciclos_exam`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciclos`
--

CREATE TABLE IF NOT EXISTS `ciclos` (
  `IdCiclo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdCiclo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `ciclos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciclos_institutos`
--

CREATE TABLE IF NOT EXISTS `ciclos_institutos` (
  `IdCiclo` int(11) NOT NULL,
  `IdInstituto` int(11) NOT NULL,
  PRIMARY KEY (`IdCiclo`,`IdInstituto`),
  KEY `FKfoe3d6m78991i12oi2jujqsd1` (`IdInstituto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciclos_institutos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `institutos`
--

CREATE TABLE IF NOT EXISTS `institutos` (
  `IdInstituto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdInstituto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `institutos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `talleres`
--

CREATE TABLE IF NOT EXISTS `talleres` (
  `IdTaller` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `IdInstituto` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdTaller`),
  KEY `FKppv7bhkqk98js4kq41daja7cm` (`IdInstituto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `talleres`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usos`
--

CREATE TABLE IF NOT EXISTS `usos` (
  `IdTaller` int(11) NOT NULL,
  `IdCiclo` int(11) NOT NULL,
  `hora` time NOT NULL,
  `fecha` datetime NOT NULL,
  `fecha_new` date DEFAULT NULL,
  `hora_new` time DEFAULT NULL,
  PRIMARY KEY (`IdTaller`,`hora`,`fecha`,`IdCiclo`),
  KEY `IdCiclo` (`IdCiclo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usos`
--


--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ciclos_institutos`
--
ALTER TABLE `ciclos_institutos`
  ADD CONSTRAINT `FKr85np6lwwkdelc5xgi8eegvc8` FOREIGN KEY (`IdCiclo`) REFERENCES `institutos` (`IdInstituto`),
  ADD CONSTRAINT `FKfoe3d6m78991i12oi2jujqsd1` FOREIGN KEY (`IdInstituto`) REFERENCES `ciclos` (`IdCiclo`);

--
-- Filtros para la tabla `talleres`
--
ALTER TABLE `talleres`
  ADD CONSTRAINT `FKppv7bhkqk98js4kq41daja7cm` FOREIGN KEY (`IdInstituto`) REFERENCES `institutos` (`IdInstituto`);

--
-- Filtros para la tabla `usos`
--
ALTER TABLE `usos`
  ADD CONSTRAINT `usos_ibfk_1` FOREIGN KEY (`IdCiclo`) REFERENCES `ciclos` (`IdCiclo`),
  ADD CONSTRAINT `usos_ibfk_2` FOREIGN KEY (`IdTaller`) REFERENCES `talleres` (`IdTaller`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
