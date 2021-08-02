CREATE DATABASE  IF NOT EXISTS `db_programming_project` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_programming_project`;
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
-- Table structure for table `audit`
--

DROP TABLE IF EXISTS `audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `userId` int(5) NOT NULL,
  `operation` varchar(10) NOT NULL,
  `tableName` varchar(30) NOT NULL,
  `tableId` int(20) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit`
--

LOCK TABLES `audit` WRITE;
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goalscorer`
--

DROP TABLE IF EXISTS `goalscorer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goalscorer` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(50) NOT NULL,
  `team` varchar(35) NOT NULL,
  `photo` varchar(60) NOT NULL,
  `goals` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goalscorer`
--

LOCK TABLES `goalscorer` WRITE;
/*!40000 ALTER TABLE `goalscorer` DISABLE KEYS */;
/*!40000 ALTER TABLE `goalscorer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `userType` enum('A','N','F') DEFAULT NULL,
  `state` varchar(1) NOT NULL,
  `url` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Equipos',NULL,'1','usuario/equipos.xhtml'),(2,'Calendario',NULL,'1','usuario/calendario.xhtml'),(3,'Goleadores',NULL,'1','usuario/jugadores.xhtml'),(4,'Noticias',NULL,'1','usuario/noticias.xhtml'),(5,'Equipos','N','1','usuario/equipos.xhtml'),(6,'Calendario','N','1','usuario/calendario.xhtml'),(7,'Goleadores','N','1','usuario/jugadores.xhtml'),(8,'Noticias','N','1','usuario/noticias.xhtml'),(9,'Foro','N','1','usuario/foro.xhtml'),(10,'Cuenta','N','1','usuario/cuenta.xhtml'),(11,'Usuarios','A','1','admin/usuarios.xhtml'),(12,'Auditoria','A','1','admin/auditoria.xhtml'),(13,'Foro','A','1','admin/foro.xhtml');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `dateNews` datetime NOT NULL,
  `shortDescription` varchar(60) NOT NULL,
  `largeDescription` varchar(120) NOT NULL,
  `idUser` int(5) NOT NULL,
  `state` varchar(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cnxl4pr6t2gnelwa5ibifjnwd` (`idUser`),
  CONSTRAINT `FK_cnxl4pr6t2gnelwa5ibifjnwd` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter`
--

DROP TABLE IF EXISTS `parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameter` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `parameterType` varchar(1) NOT NULL,
  `parameterCode` varchar(10) NOT NULL,
  `descriptionParameter` varchar(60) NOT NULL,
  `textValue` varchar(10) NOT NULL,
  `numberValue` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter`
--

LOCK TABLES `parameter` WRITE;
/*!40000 ALTER TABLE `parameter` DISABLE KEYS */;
/*!40000 ALTER TABLE `parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referee`
--

DROP TABLE IF EXISTS `referee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referee` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(50) NOT NULL,
  `nationality` varchar(50) NOT NULL,
  `state` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referee`
--

LOCK TABLES `referee` WRITE;
/*!40000 ALTER TABLE `referee` DISABLE KEYS */;
/*!40000 ALTER TABLE `referee` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `stadium`
--

DROP TABLE IF EXISTS `stadium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stadium` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `city` varchar(25) NOT NULL,
  `capacity` varchar(50) NOT NULL,
  `photo` varchar(60) NOT NULL,
  `temperature` varchar(60) NOT NULL,
  `population` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stadium`
--

LOCK TABLES `stadium` WRITE;
/*!40000 ALTER TABLE `stadium` DISABLE KEYS */;
/*!40000 ALTER TABLE `stadium` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `country` varchar(30) NOT NULL,
  `flag` varchar(60) NOT NULL,
  `group` varchar(1) NOT NULL,
  `playedGames` int(1) NOT NULL,
  `wonMatches` int(1) NOT NULL,
  `tiedMatches` int(1) NOT NULL,
  `lostMatches` int(1) NOT NULL,
  `goalsFavor` int(1) NOT NULL,
  `goalsAgainst` int(1) NOT NULL,
  `state` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `userName` varchar(16) NOT NULL,
  `password` varchar(256) NOT NULL,
  `emailAddress` varchar(75) DEFAULT NULL,
  `dateLastPassword` datetime NOT NULL,
  `active` varchar(1) NOT NULL,
  `userType` enum('A','F','N') NOT NULL,
  `changePassword` varchar(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  UNIQUE KEY `emailAddress_UNIQUE` (`emailAddress`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','202cb962ac59075b964b07152d234b70','admin@gmail.com','2018-01-01 00:00:00','A','A','0'),(2,'funcional','202cb962ac59075b964b07152d234b70','funcion@gmail.com','2018-01-01 00:00:00','A','F','0'),(16,'jsebastian96','202cb962ac59075b964b07152d234b70','sebastian24-@hotmail.com','2018-05-02 03:09:48','A','N','0'),(22,'ejemplo','202cb962ac59075b964b07152d234b70','ejemplo@gmail.com','2018-05-08 02:38:27','A','N','0'),(23,'ejemplo2','6dcafb9203a87c0813c5196f0022cc82','ejemplo2@gmail.com','2018-05-08 19:04:36','I','N','1'),(24,'ejemplo3','d1c085e67bde175e7f9ee59e89a18292','ejemplo3@gmail.com','2018-05-08 19:15:28','A','N','1'),(25,'ejemplo4','29aa1bc095c93d1cdeac60fa89d74613','ejemplo4@gmail.com','2018-05-08 21:05:13','A','N','1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-09 23:25:34
