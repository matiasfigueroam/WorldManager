-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: worldmanager
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partido` (
  `id_partido` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `estadio` varchar(40) DEFAULT NULL,
  `goles_lo` int DEFAULT NULL,
  `goles_vi` int DEFAULT NULL,
  `id_torneo1` int DEFAULT NULL,
  `id_equipo1` int DEFAULT NULL,
  `id_equipo2` int DEFAULT NULL,
  PRIMARY KEY (`id_partido`),
  KEY `PARTIDOS_TORNEOS` (`id_torneo1`),
  KEY `PARTIDOS_EQUIPOS` (`id_equipo1`),
  KEY `PARTIDOS_EQUIPOS2` (`id_equipo2`),
  CONSTRAINT `PARTIDOS_EQUIPOS` FOREIGN KEY (`id_equipo1`) REFERENCES `equipo` (`id_equipo`),
  CONSTRAINT `PARTIDOS_EQUIPOS2` FOREIGN KEY (`id_equipo2`) REFERENCES `equipo` (`id_equipo`),
  CONSTRAINT `PARTIDOS_TORNEOS` FOREIGN KEY (`id_torneo1`) REFERENCES `torneo` (`id_torneo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-18 11:45:00
