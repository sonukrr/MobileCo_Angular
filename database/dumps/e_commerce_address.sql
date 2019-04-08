CREATE DATABASE  IF NOT EXISTS `e_commerce` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `e_commerce`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: e_commerce
-- ------------------------------------------------------
-- Server version	5.1.45-community

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `pincode` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'fdgfd','Chamba','Himachal Pradesh','INDIA',555254),(2,'fdgfd','Chamba','Himachal Pradesh','INDIA',555254),(3,'jhh','Jamnagar','Gujarat','INDIA',545454),(4,'kpop','Kottayam','Kerala','INDIA',545645),(5,'mountrose street,Lillyfurtoz ','Agra','Uttar Pradesh','INDIA',457545),(6,'Ampadiyil,Haripaddsh','Alappuzha','Kerala','INDIA',14),(7,'','','','INDIA',0),(8,'street','Godda','Jharkhand','INDIA',545454),(9,'street1','Amethi (Chatrapati Sahuji Mahraj Nagar)','Uttar Pradesh','INDIA',545454),(10,'street1','Amethi (Chatrapati Sahuji Mahraj Nagar)','Uttar Pradesh','INDIA',545454),(11,'street1','Amethi (Chatrapati Sahuji Mahraj Nagar)','Uttar Pradesh','INDIA',545454),(12,'street1','Amethi (Chatrapati Sahuji Mahraj Nagar)','Uttar Pradesh','INDIA',545454),(13,'street1','Amethi (Chatrapati Sahuji Mahraj Nagar)','Uttar Pradesh','INDIA',545454),(14,'sghaj','Dadra & Nagar Haveli','Dadra and Nagar Haveli (UT)','INDIA',565656),(15,'hgsgd','Chhota Udepur','Gujarat','INDIA',888898);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-08 14:36:33
