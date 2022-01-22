-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: ejemplo
-- ------------------------------------------------------
-- Server version	5.5.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `departamentos` (
  `dept_no` tinyint(2) NOT NULL,
  `dnombre` varchar(15) DEFAULT NULL,
  `loc` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (10,'CONTABILIDAD','SEVILLA'),(20,'INVESTIGACIÓN','MADRID'),(30,'VENTAS','BARCELONA'),(40,'PRODUCCIÓN','BILBAO'),(97,'nuevo97','verin'),(98,'nuevoDepto98','porri?o'),(99,'nuevoDepto','vigo');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleados` (
  `emp_no` smallint(4) NOT NULL,
  `apellido` varchar(10) DEFAULT NULL,
  `oficio` varchar(10) DEFAULT NULL,
  `dir` smallint(6) DEFAULT NULL,
  `fecha_alt` date DEFAULT NULL,
  `salario` float(6,2) DEFAULT NULL,
  `comision` float(6,2) DEFAULT NULL,
  `dept_no` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`emp_no`),
  KEY `empleados_FK` (`dept_no`),
  CONSTRAINT `empleados_FK` FOREIGN KEY (`dept_no`) REFERENCES `departamentos` (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1001,'nuevo','EMPLEADO',NULL,NULL,3001.00,NULL,99),(1002,'otro','EMPLEADO',NULL,NULL,2000.00,NULL,10),(7369,'SÁNCHEZ','EMPLEADO',7902,'1990-12-17',1040.00,NULL,20),(7499,'ARROYO','VENDEDOR',7698,'1990-02-20',1500.00,390.00,30),(7521,'SALA','VENDEDOR',7698,'1991-02-22',1625.00,650.00,30),(7566,'JIMÉNEZ','DIRECTOR',7839,'1991-04-02',2900.00,NULL,20),(7654,'MARTÍN','VENDEDOR',7698,'1991-09-29',1600.00,1020.00,30),(7698,'NEGRO','DIRECTOR',7839,'1991-05-01',3005.00,NULL,30),(7782,'CEREZO','DIRECTOR',7839,'1991-06-09',4285.00,NULL,10),(7788,'GIL','ANALISTA',7566,'1991-11-09',3000.00,NULL,20),(7839,'REY','PRESIDENTE',NULL,'1991-11-17',5500.00,NULL,10),(7844,'TOVAR','VENDEDOR',7698,'1991-09-08',1350.00,0.00,30),(7876,'ALONSO','EMPLEADO',7788,'1991-09-23',1430.00,NULL,20),(7900,'JIMENO','EMPLEADO',7698,'1991-12-03',1335.00,NULL,30),(7902,'FERNÁNDEZ','ANALISTA',7566,'1991-12-03',3000.00,NULL,20),(7934,'MUÑOZ','EMPLEADO',7782,'1992-01-23',3090.00,NULL,10);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mensajes` (
  `id_mensaje` int(11) NOT NULL AUTO_INCREMENT,
  `mensaje` varchar(100) NOT NULL,
  `autor_mensaje` varchar(100) DEFAULT NULL,
  `fecha_mensaje` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_mensaje`),
  KEY `mensajes_id_mensaje_IDX` (`id_mensaje`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajes`
--

LOCK TABLES `mensajes` WRITE;
/*!40000 ALTER TABLE `mensajes` DISABLE KEYS */;
INSERT INTO `mensajes` VALUES (1,'El primer mensaje','mrnovoa','2021-12-12 13:10:36');
/*!40000 ALTER TABLE `mensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `totales`
--

DROP TABLE IF EXISTS `totales`;
/*!50001 DROP VIEW IF EXISTS `totales`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `totales` AS SELECT 
 1 AS `dep`,
 1 AS `dnombre`,
 1 AS `nemp`,
 1 AS `media`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'ejemplo'
--
/*!50003 DROP FUNCTION IF EXISTS `ejemploFuncion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `ejemploFuncion`() RETURNS varchar(20) CHARSET latin1
BEGIN
    RETURN 'Ejemplo';
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `nombre_dep` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nombre_dep`(d int) RETURNS varchar(15) CHARSET latin1
    DETERMINISTIC
BEGIN

   DECLARE dnom VARCHAR(15) DEFAULT "";

   select  dnombre into dnom from departamentos where dept_no = d;

   RETURN dnom;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `datos_dep` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `datos_dep`(d int, OUT nom VARCHAR(15),
			 OUT locali VARCHAR(15))
BEGIN
         SELECT dnombre,loc INTO nom,locali FROM departamentos 
         WHERE dept_no = d;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getMensaje` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getMensaje`(in param_id_mensaje int, OUT param_mensaje VARCHAR(280))
begin
	SELECT mensaje INTO param_mensaje
   FROM mensajes
   WHERE id_mensaje = param_id_mensaje;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `subida_sal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `subida_sal`(d int, s float)
BEGIN
             update empleados 
             SET salario=salario+s
             WHERE dept_no = d;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `totales`
--

/*!50001 DROP VIEW IF EXISTS `totales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `totales` AS select `d`.`dept_no` AS `dep`,`d`.`dnombre` AS `dnombre`,count(`e`.`emp_no`) AS `nemp`,avg(`e`.`salario`) AS `media` from (`departamentos` `d` left join `empleados` `e` on((`e`.`dept_no` = `d`.`dept_no`))) group by `d`.`dept_no`,`d`.`dnombre` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-17 12:40:35
