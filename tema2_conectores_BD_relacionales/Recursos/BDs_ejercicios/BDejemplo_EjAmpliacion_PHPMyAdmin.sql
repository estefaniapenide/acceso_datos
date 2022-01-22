-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Xerado en: 17 de Xan de 2022 ás 19:08
-- Versión do servidor: 5.5.20
-- Versión do PHP: 5.3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `ejemplo`
--

DELIMITER $$
--
-- Procedementos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `datos_dep`(d int, OUT nom VARCHAR(15),
			 OUT locali VARCHAR(15))
BEGIN
         SELECT dnombre,loc INTO nom,locali FROM departamentos 
         WHERE dept_no = d;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getMensaje`(in param_id_mensaje int, OUT param_mensaje VARCHAR(280))
begin
	SELECT mensaje INTO param_mensaje
   FROM mensajes
   WHERE id_mensaje = param_id_mensaje;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `subida_sal`(d int, s float)
BEGIN
             update empleados 
             SET salario=salario+s
             WHERE dept_no = d;
END$$

--
-- Funcións
--
CREATE DEFINER=`root`@`localhost` FUNCTION `ejemploFuncion`() RETURNS varchar(20) CHARSET latin1
BEGIN
    RETURN 'Ejemplo';
end$$

CREATE DEFINER=`root`@`localhost` FUNCTION `nombre_dep`(d int) RETURNS varchar(15) CHARSET latin1
    DETERMINISTIC
BEGIN

   DECLARE dnom VARCHAR(15) DEFAULT "";

   select  dnombre into dnom from departamentos where dept_no = d;

   RETURN dnom;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da táboa `departamentos`
--

CREATE TABLE IF NOT EXISTS `departamentos` (
  `dept_no` tinyint(2) NOT NULL,
  `dnombre` varchar(15) DEFAULT NULL,
  `loc` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- A extraer datos da táboa `departamentos`
--

INSERT INTO `departamentos` (`dept_no`, `dnombre`, `loc`) VALUES
(10, 'CONTABILIDAD', 'SEVILLA'),
(20, 'INVESTIGACIÓN', 'MADRID'),
(30, 'VENTAS', 'BARCELONA'),
(40, 'PRODUCCIÓN', 'BILBAO'),
(97, 'nuevo97', 'verin'),
(98, 'nuevoDepto98', 'porri?o'),
(99, 'nuevoDepto', 'vigo');

-- --------------------------------------------------------

--
-- Estrutura da táboa `empleados`
--

CREATE TABLE IF NOT EXISTS `empleados` (
  `emp_no` smallint(4) NOT NULL,
  `apellido` varchar(10) DEFAULT NULL,
  `oficio` varchar(10) DEFAULT NULL,
  `dir` smallint(6) DEFAULT NULL,
  `fecha_alt` date DEFAULT NULL,
  `salario` float(6,2) DEFAULT NULL,
  `comision` float(6,2) DEFAULT NULL,
  `dept_no` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`emp_no`),
  KEY `empleados_FK` (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- A extraer datos da táboa `empleados`
--

INSERT INTO `empleados` (`emp_no`, `apellido`, `oficio`, `dir`, `fecha_alt`, `salario`, `comision`, `dept_no`) VALUES
(1001, 'nuevo', 'EMPLEADO', NULL, NULL, 3001.00, NULL, 99),
(1002, 'otro', 'EMPLEADO', NULL, NULL, 2000.00, NULL, 10),
(7369, 'SÁNCHEZ', 'EMPLEADO', 7902, '1990-12-17', 1040.00, NULL, 20),
(7499, 'ARROYO', 'VENDEDOR', 7698, '1990-02-20', 1500.00, 390.00, 30),
(7521, 'SALA', 'VENDEDOR', 7698, '1991-02-22', 1625.00, 650.00, 30),
(7566, 'JIMÉNEZ', 'DIRECTOR', 7839, '1991-04-02', 2900.00, NULL, 20),
(7654, 'MARTÍN', 'VENDEDOR', 7698, '1991-09-29', 1600.00, 1020.00, 30),
(7698, 'NEGRO', 'DIRECTOR', 7839, '1991-05-01', 3005.00, NULL, 30),
(7782, 'CEREZO', 'DIRECTOR', 7839, '1991-06-09', 4285.00, NULL, 10),
(7788, 'GIL', 'ANALISTA', 7566, '1991-11-09', 3000.00, NULL, 20),
(7839, 'REY', 'PRESIDENTE', NULL, '1991-11-17', 5500.00, NULL, 10),
(7844, 'TOVAR', 'VENDEDOR', 7698, '1991-09-08', 1350.00, 0.00, 30),
(7876, 'ALONSO', 'EMPLEADO', 7788, '1991-09-23', 1430.00, NULL, 20),
(7900, 'JIMENO', 'EMPLEADO', 7698, '1991-12-03', 1335.00, NULL, 30),
(7902, 'FERNÁNDEZ', 'ANALISTA', 7566, '1991-12-03', 3000.00, NULL, 20),
(7934, 'MUÑOZ', 'EMPLEADO', 7782, '1992-01-23', 3090.00, NULL, 10);

-- --------------------------------------------------------

--
-- Estrutura da táboa `mensajes`
--

CREATE TABLE IF NOT EXISTS `mensajes` (
  `id_mensaje` int(11) NOT NULL AUTO_INCREMENT,
  `mensaje` varchar(100) NOT NULL,
  `autor_mensaje` varchar(100) DEFAULT NULL,
  `fecha_mensaje` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_mensaje`),
  KEY `mensajes_id_mensaje_IDX` (`id_mensaje`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- A extraer datos da táboa `mensajes`
--

INSERT INTO `mensajes` (`id_mensaje`, `mensaje`, `autor_mensaje`, `fecha_mensaje`) VALUES
(1, 'El primer mensaje', 'mrnovoa', '2021-12-12 13:10:36');

-- --------------------------------------------------------

--
-- Estrutura existente para a vista `totales`
--
CREATE TABLE IF NOT EXISTS `totales` (
`dep` tinyint(2)
,`dnombre` varchar(15)
,`nemp` bigint(21)
,`media` double(10,6)
);
-- --------------------------------------------------------

--
-- Estrutura existente para a vista `totales_17enero`
--
CREATE TABLE IF NOT EXISTS `totales_17enero` (
`dep` tinyint(2)
,`dnombre` varchar(15)
,`nemp` bigint(21)
,`media` double(10,6)
);
-- --------------------------------------------------------

--
-- Estrutura para a vista `totales`
--
DROP TABLE IF EXISTS `totales`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `totales` AS select `d`.`dept_no` AS `dep`,`d`.`dnombre` AS `dnombre`,count(`e`.`emp_no`) AS `nemp`,avg(`e`.`salario`) AS `media` from (`departamentos` `d` left join `empleados` `e` on((`e`.`dept_no` = `d`.`dept_no`))) group by `d`.`dept_no`,`d`.`dnombre`;

-- --------------------------------------------------------

--
-- Estrutura para a vista `totales_17enero`
--
DROP TABLE IF EXISTS `totales_17enero`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `totales_17enero` AS select `d`.`dept_no` AS `dep`,`d`.`dnombre` AS `dnombre`,count(`e`.`emp_no`) AS `nemp`,avg(`e`.`salario`) AS `media` from (`departamentos` `d` left join `empleados` `e` on((`e`.`dept_no` = `d`.`dept_no`))) group by `d`.`dept_no`,`d`.`dnombre`;

--
-- Limitacións para os volcados das táboas
--

--
-- Limitacións para a táboa `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_FK` FOREIGN KEY (`dept_no`) REFERENCES `departamentos` (`dept_no`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
