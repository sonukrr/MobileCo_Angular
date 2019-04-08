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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  KEY `fk_customer_address1_idx` (`address_id`),
  CONSTRAINT `fk_customer_address1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'sonu','sk@hdjf','44755','dsfh',NULL),(2,'sonu','sonu@gmail.com','8860757','Pass@1234',NULL),(3,'rishika','rishi@gmail.com','7747457577','Pass@1212',NULL),(4,'jj','jjj@gmail.com','74747858','Pass@1213',NULL),(6,'rishika kiran','rishika@gmail.com','8630211406','Pass@12345',NULL),(7,'arun achyut','arun@gmail.com','787985858','Pass@12!',NULL),(8,'Garvit tyagi','garvit@gmail.com','5241452544','QKv3fpuQuX8nmSPB47zc3w==',NULL),(9,'Selvi Mandali','selvi@gmail.com','844752154','CXk6SFbtdvZhMGF+InDZDw==',NULL),(10,'Shivani malikireddy','shivani@gmail.com','7475214574','Fhhvm4p0ZeY/ouprM3vRjQ==',NULL),(11,'phani','phani@gmail.com','747578844','djcAK9gor7OTcfn18/+4Xg==',NULL),(12,'divya ','divya@gmail.com','7475787877','djcAK9gor7OTcfn18/+4Xg==',NULL),(13,'rishika kiran','rss@gmail.com','787878787','my3tzPPS+/Y9pngNM1aUKA==',NULL),(14,'dibya','db@gmail.com','858585858','my3tzPPS+/Y9pngNM1aUKA==',NULL),(16,'name','email@gmail.com','6878979','my3tzPPS+/Y9pngNM1aUKA==',NULL),(20,'nametr','emjkail@gmail.com','68789795','my3tzPPS+/Y9pngNM1aUKA==',NULL),(21,'divya m','divyuaM@gmail.com','878797979797','my3tzPPS+/Y9pngNM1aUKA==',NULL),(22,'name1','21email@gmail.com','58584554','my3tzPPS+/Y9pngNM1aUKA==',NULL),(23,'divya m','dd@gmail.com','4646464634','hMcygLjUj2ZabwncSApIbA==',NULL),(24,'sonu kumar','sonu235314@gmail.com','868846399','lRa8dLF/oBQHgqtN3TL4qA==',NULL),(25,'abhishek ','abbyy@gmail.com','464646464565655','uyRCromTlt0mM0JPmZSLCw==',NULL),(26,'abhishek','abbby@gmail.com','878878784','my3tzPPS+/Y9pngNM1aUKA==',NULL),(27,'yfyf','yfsdf@gmal.com','665465464','ngdtKgOc2C9YarI5P/PyxA==',NULL),(29,'jghjug','dfds@gmail.com','434634634','PAJKurD7PfIWSKHsgLekPA==',NULL),(30,'jgjhjg','jghjbjH@gnai.com','6456464','uDSZyvhzrYc5VFCQTbgSXA==',NULL),(31,'gfhgfhfgh','gfhfghf','ghgfhfghfg','XM4MPqjNgVABdDaGOIPDLQ==',NULL),(32,'aziz ','aziz@gmail.com','7878787878','my3tzPPS+/Y9pngNM1aUKA==',NULL),(33,'aziz ahmed','aaaziz@gmail.com','5764634646','my3tzPPS+/Y9pngNM1aUKA==',NULL),(34,'selvi','delsvi@gmail.com','3465646464','my3tzPPS+/Y9pngNM1aUKA==',NULL),(35,'garvit tyagi','garvittyagi@gmail.com','7896946946','my3tzPPS+/Y9pngNM1aUKA==',NULL),(36,'gfhgfh','fghgfhgf@gmail.com','4465464654','my3tzPPS+/Y9pngNM1aUKA==',NULL),(38,'fghd','gfdgfdg','4545445454','0ym1V4mfEUX2eL8DJ2ycRA==',NULL),(42,'gfhfgh','fghgfhgfh@gmail.com','5454546546','sjtWIo1SfgWOcRzCa/LHmw==',NULL),(43,'name','email','1212555555','dcguka6iaAxgQk8NtQ6P/w==',NULL),(44,'fgfd','gfdgfd','6466564646','XauuxckLN/V/M03ZTJp14w==',4),(45,'sonu kumar','sonuec12@gmail.com','8986969769','my3tzPPS+/Y9pngNM1aUKA==',5),(46,'Divya M','divyamurali0212@gmail.com','9745176081','zw8weXaGEcAn5Nd7NST/UA==',6),(47,'fdgfd','fdgfdgfd','6564645465','qm5aJ846Lw3jciLBmFWzAg==',7),(48,'fgfdg','aaaaa@gmail.com','4645644646','my3tzPPS+/Y9pngNM1aUKA==',8),(54,'jj','jagjot@gmail.com','7878787825','my3tzPPS+/Y9pngNM1aUKA==',14);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-08 14:36:24
