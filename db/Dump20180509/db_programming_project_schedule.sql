-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db_programming_project
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `localTeam` int(5) NOT NULL,
  `localGoals` int(2) NOT NULL,
  `visitTeam` int(5) NOT NULL,
  `visitGoals` int(2) NOT NULL,
  `gameDate` datetime NOT NULL,
  `idStadium` int(5) NOT NULL,
  `idReferee` int(5) NOT NULL,
  `state` varchar(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5npteykkjmo8ydj1v6gvwgrnb` (`idReferee`),
  KEY `FK_i5e23dsghn0l0nl9ry32muhgg` (`idStadium`),
  KEY `FK_bkqysguo6a7vdppn9e4cj87ct` (`localTeam`),
  KEY `FK_5rfnqt3amaibx65rjjfxu0n6x` (`visitTeam`),
  CONSTRAINT `FK_5npteykkjmo8ydj1v6gvwgrnb` FOREIGN KEY (`idReferee`) REFERENCES `referee` (`id`),
  CONSTRAINT `FK_5rfnqt3amaibx65rjjfxu0n6x` FOREIGN KEY (`visitTeam`) REFERENCES `team` (`id`),
  CONSTRAINT `FK_bkqysguo6a7vdppn9e4cj87ct` FOREIGN KEY (`localTeam`) REFERENCES `team` (`id`),
  CONSTRAINT `FK_i5e23dsghn0l0nl9ry32muhgg` FOREIGN KEY (`idStadium`) REFERENCES `stadium` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-09 23:18:49
