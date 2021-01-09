-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: lineclohtes
-- ------------------------------------------------------
-- Server version	5.7.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Ventas`
--

DROP TABLE IF EXISTS `Ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ventas` (
  `num_venta` int(10) NOT NULL AUTO_INCREMENT,
  `fch_venta` varchar(50) NOT NULL,
  `nombre_empleado` varchar(150) NOT NULL,
  `nombre_tienda` varchar(150) NOT NULL,
  `direccion_tienda` varchar(200) NOT NULL,
  `total_venta` double NOT NULL,
  PRIMARY KEY (`num_venta`),
  UNIQUE KEY `num_venta_UNIQUE` (`num_venta`)
) ENGINE=InnoDB AUTO_INCREMENT=87328 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ventas`
--

LOCK TABLES `Ventas` WRITE;
/*!40000 ALTER TABLE `Ventas` DISABLE KEYS */;
INSERT INTO `Ventas` VALUES (9029,'2020-11-20 19:12:19','Jose Antonio Lopez','LineClothes Las Antenas','Iztapala, 2981, Periferico Oeste,20',270),(87323,'2020-09-20 19:12:19','Rene MArtinez M','LineClothes Las Antenas','Iztapala, 2981, Periferico Oeste,20',590),(87324,'2020-12-12 23:50:08','Jose Alfredo','Lineclothes','Iztapalapa 18',192.3),(87325,'2020-12-12 23:50:48','Jose Alfredo','Lineclothes','Iztapalapa 18',192.3),(87326,'2020-12-12 23:51:40','Jose Alfredo','Lineclothes','Iztapalapa 18',192.3),(87327,'2020-12-12 23:52:21','Jose Alfredo','Lineclothes','Iztapalapa 18',192.3);
/*!40000 ALTER TABLE `Ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-13 21:10:55
