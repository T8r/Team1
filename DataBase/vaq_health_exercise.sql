-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: vaq_health
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise` (
  `ID` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `difficulty` enum('HARD','MEDIUM','EASY') DEFAULT NULL,
  `type` enum('CARDIO','BALANCE','STRENGTH') DEFAULT NULL,
  `met` int(11) DEFAULT NULL,
  `equipmentID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `equipmentFK_idx` (`equipmentID`),
  CONSTRAINT `equipmentFK` FOREIGN KEY (`equipmentID`) REFERENCES `equipment` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'Push Ups','Keep a tight core throughout the entire push up. Inhale as you slowly bend your elbows and lower yourself until your elbows are at a 90 degree angle. Exhale as you begin contracting your chest muscles and pushing back up through your hands to the start position. Don\'t lock out the elbows; keep them slightly bent.','EASY','CARDIO',1,NULL),(2,'Pull Ups','Hang from a bar with a pronated (palms facing away) grip. Place your hands about shoulder-width apart. Pull up and raise your body until your chin reaches the same height as the bar. Avoid swinging or kipping as you pull. Lower yourself back to the starting position.','EASY','CARDIO',1,3),(3,'Inch Worm','Stand with feet hip width and core tight. Bend from the waist, place hands on the ground, and walk hands forward, keeping legs straight. When you arrive in a high plank, quickly walk hands back toward feet and stand.','EASY','CARDIO',1,NULL),(4,'Tuck Jump','It\'s time to catch some air. Stand with knees slightly bent and jump up, bringing knees to chest and extending arms out straight in front of chest. Lower arms as you land lightly on the floor','MEDIUM','CARDIO',1,NULL),(6,'Bicycling- Moderate',NULL,'EASY','CARDIO',8,1),(7,'Bicycling- Mountain',NULL,'MEDIUM','CARDIO',14,1),(8,'Jumping rope',NULL,'MEDIUM','CARDIO',12,4),(9,'Running – 6 mph ','10m/mi','MEDIUM','CARDIO',10,NULL),(10,'Running – 14 mph',' 4.3 min./mile','MEDIUM','CARDIO',16,NULL),(11,'Weight Lifting - Light',NULL,'EASY','STRENGTH',NULL,NULL);
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-15 13:49:00
