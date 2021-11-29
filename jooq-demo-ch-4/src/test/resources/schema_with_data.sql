-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: edens_car
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Temporary view structure for view `complete_car_listing`
--

DROP TABLE IF EXISTS `complete_car_listing`;
/*!50001 DROP VIEW IF EXISTS `complete_car_listing`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `complete_car_listing` AS SELECT 
 1 AS `vehicle_id`,
 1 AS `brand`,
 1 AS `model`,
 1 AS `trim`,
 1 AS `price`,
 1 AS `color`,
 1 AS `style`,
 1 AS `year`,
 1 AS `featured`*/;
SET character_set_client = @saved_cs_client;


--
-- Table structure for table `vehicle_style`
--

--DROP TABLE IF EXISTS `vehicle_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_style` (
  `vehicle_style_id` bigint NOT NULL AUTO_INCREMENT,
  `vehicle_style_name` varchar(35) NOT NULL,
  `vehicle_style_status` varchar(10) NOT NULL DEFAULT 'INACTIVE',
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`vehicle_style_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vehicle_manufacturer`
--

--DROP TABLE IF EXISTS `vehicle_manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_manufacturer` (
  `manufacturer_id` bigint NOT NULL AUTO_INCREMENT,
  `manufacturer_name` varchar(250) NOT NULL,
  `status` varchar(15) NOT NULL DEFAULT 'ACTIVE',
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`manufacturer_id`),
  UNIQUE KEY `manufacturer_name_UNIQUE` (`manufacturer_name`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vehicle_trim`
--

--DROP TABLE IF EXISTS `vehicle_trim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_trim` (
  `trim_id` bigint NOT NULL AUTO_INCREMENT,
  `trim_name` varchar(35) NOT NULL,
  `vehicle_manufacturer_id` bigint NOT NULL,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`trim_id`),
  KEY `trim_vehicle_man_idx` (`vehicle_manufacturer_id`),
  CONSTRAINT `trim_vehicle_man` FOREIGN KEY (`vehicle_manufacturer_id`) REFERENCES `vehicle_manufacturer` (`manufacturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vehicle_model`
--

DROP TABLE IF EXISTS `vehicle_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_model`(
  `vehicle_model_id` bigint NOT NULL AUTO_INCREMENT,
  `vehicle_model_name` varchar(250) NOT NULL,
  `vehicle_style_id` bigint NOT NULL,
  `vehicle_man_id` bigint NOT NULL,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`vehicle_model_id`),
  UNIQUE KEY `vehicle_model_name_UNIQUE` (`vehicle_model_name`),
  KEY `model_style_id_idx` (`vehicle_style_id`),
  KEY `manufacturer_id_idx` (`vehicle_man_id`),
  CONSTRAINT `manufacturer_id` FOREIGN KEY (`vehicle_man_id`) REFERENCES `vehicle_manufacturer` (`manufacturer_id`),
  CONSTRAINT `model_style_id` FOREIGN KEY (`vehicle_style_id`) REFERENCES `vehicle_style` (`vehicle_style_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Dumping data for table `vehicle_style`
--

LOCK TABLES `vehicle_style` WRITE;
/*!40000 ALTER TABLE `vehicle_style` DISABLE KEYS */;
INSERT INTO `vehicle_style` VALUES (1,'Car','ACTIVE',NULL),(2,'SUV','ACTIVE',NULL),(3,'Truck','ACTIVE',NULL),(4,'Van','ACTIVE',NULL),(5,'Minivan','ACTIVE',NULL);
/*!40000 ALTER TABLE `vehicle_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vehicle_manufacturer`
--

LOCK TABLES `vehicle_manufacturer` WRITE;
/*!40000 ALTER TABLE `vehicle_manufacturer` DISABLE KEYS */;
INSERT INTO `vehicle_manufacturer` VALUES (1,'Lexus','ACTIVE',NULL),(2,'Toyota','ACTIVE',NULL),(3,'Honda','ACTIVE',NULL),(4,'Acura','ACTIVE',NULL),(5,'Nissan','ACTIVE',NULL),(6,'Infiniti','ACTIVE',NULL),(7,'Kia','ACTIVE',NULL),(8,'Hyundai','ACTIVE',NULL),(9,'Mercedes-Benz','ACTIVE',NULL),(10,'BMW','ACTIVE',NULL),(11,'Audi','ACTIVE',NULL),(12,'Volkswagen','ACTIVE',NULL),(13,'Equus','ACTIVE',NULL),(14,'Ford','ACTIVE',NULL),(15,'Chrysler','ACTIVE',NULL),(16,'GMC','ACTIVE',NULL),(17,'Tesla','ACTIVE',NULL),(18,'Subaru','ACTIVE',NULL),(19,'Mazda','ACTIVE',NULL),(20,'Jaguar','ACTIVE',NULL),(21,'Jeep','ACTIVE',NULL),(22,'Land Rover','ACTIVE',NULL),(23,'Buick','ACTIVE',NULL),(24,'RAM','ACTIVE',NULL),(25,'Porsche','ACTIVE',NULL),(26,'Volvo','ACTIVE',NULL);
/*!40000 ALTER TABLE `vehicle_manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vehicle_model`
--

LOCK TABLES `vehicle_model` WRITE;
/*!40000 ALTER TABLE `vehicle_model` DISABLE KEYS */;
INSERT INTO `vehicle_model` VALUES (1,'ES 350',2,1,NULL),(2,'GS 350',1,1,NULL),(3,'LS 460',1,1,NULL),(4,'LS 460F ',1,1,NULL),(5,'RX 350',1,1,NULL),(6,'Camry',1,2,NULL),(7,'Corolla',1,2,NULL),(8,'Highlander',2,2,NULL),(9,'RAV4',2,2,NULL),(10,'Avalon',1,2,NULL),(11,'FJ Cruiser',2,2,NULL),(12,'Prius',1,2,NULL),(13,'MDX',2,4,NULL),(18,'TSX',1,4,NULL),(19,'RSX',2,4,NULL),(20,'S500',1,9,NULL),(21,'E500',1,9,NULL),(22,'E350',1,9,NULL),(23,'C300',1,9,NULL),(24,'Tacoma',3,2,NULL);
/*!40000 ALTER TABLE `vehicle_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vehicle_trim`
--

LOCK TABLES `vehicle_trim` WRITE;
/*!40000 ALTER TABLE `vehicle_trim` DISABLE KEYS */;
INSERT INTO `vehicle_trim` VALUES (1,'BASE',1,NULL),(2,'SPORT',4,NULL),(3,'BASE',4,NULL),(4,'XLE',2,NULL),(5,'CE',2,NULL),(6,'LE',2,NULL),(8,'AMG',9,NULL),(9,'BASE',9,NULL),(10,'DIESEL',9,NULL);
/*!40000 ALTER TABLE `vehicle_trim` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `vehicle`
--

--DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `vehicle_id` bigint NOT NULL AUTO_INCREMENT,
  `vehicle_manufacturer` bigint NOT NULL,
  `vehicle_curr_price` decimal(15,4) NOT NULL,
  `vehicle_model_year` date DEFAULT NULL,
  `vehicle_status` varchar(45) NOT NULL DEFAULT 'INACTIVE',
  `vehicle_color` varchar(35) DEFAULT NULL,
  `vehicle_model_id` bigint NOT NULL,
  `vehicle_trim` bigint NOT NULL,
  `vehicle_style` bigint DEFAULT NULL,
  `featured` tinyint DEFAULT '0',
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  `options` bigint DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`),
  KEY `veh_manufacturer_id_idx` (`vehicle_manufacturer`),
  KEY `veh_model_id_idx` (`vehicle_model_id`),
  KEY `veh_style_idx` (`vehicle_style`),
  CONSTRAINT `veh_manufacturer_id` FOREIGN KEY (`vehicle_manufacturer`) REFERENCES `vehicle_manufacturer` (`manufacturer_id`),
  CONSTRAINT `veh_model_id` FOREIGN KEY (`vehicle_model_id`) REFERENCES `vehicle_model` (`vehicle_model_id`),
  CONSTRAINT `veh_style` FOREIGN KEY (`vehicle_style`) REFERENCES `vehicle_style` (`vehicle_style_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,1,35000.0000,2010,'ACTIVE','RED',1,1,1,0,'2021-07-05 17:22:11',NULL,NULL,NULL,NULL),(2,1,49000.0000,2017,'ACTIVE','GREY',1,1,1,0,'2021-07-05 17:22:11',NULL,NULL,NULL,NULL),(3,1,36000.0000,2018,'ACTIVE','BLUE',1,1,1,0,'2021-07-05 17:22:11',NULL,NULL,NULL,NULL),(4,4,50000.0000,2018,'ACTIVE','BLUE',13,2,1,0,'2021-07-05 17:22:11',NULL,NULL,NULL,NULL),(5,4,55020.0000,2017,'ACTIVE','WHITE',13,2,1,0,'2021-07-05 17:22:11',NULL,NULL,NULL,NULL),(6,4,45000.0000,2013,'ACTIVE','WHITE',13,2,1,0,'2021-07-05 17:22:11',NULL,NULL,NULL,NULL),(7,2,18550.0000,2020,'ACTIVE','BLUE',7,5,1,1,'2021-07-05 17:22:11',NULL,NULL,NULL,NULL),(8,2,24000.0000,2019,'ACTIVE','RED',7,5,1,0,'2021-07-05 17:22:11',NULL,NULL,NULL,NULL),(9,2,30000.0000,2021,'ACTIVE','BLUE',6,4,1,1,'2021-07-05 17:22:11',NULL,NULL,NULL,NULL),(10,4,46350.0000,2021,'ACTIVE','BLUE',13,2,1,1,'2021-07-05 17:22:11',NULL,NULL,NULL,NULL),(11,9,83000.0000,2021,'ACTIVE','GREY',20,9,1,1,'2021-07-05 17:23:14',NULL,NULL,NULL,NULL),(12,9,77000.0000,2016,'ACTIVE','WHITE',20,9,1,1,'2021-07-05 17:23:14',NULL,NULL,NULL,NULL),(13,4,46350.0000,NULL,'ACTIVE','BLUE',13,2,1,0,'2021-07-19 22:23:51',NULL,NULL,NULL,NULL),(14,9,83000.0000,NULL,'ACTIVE','GREY',9,7,1,0,'2021-07-19 22:23:51',NULL,NULL,NULL,NULL),(15,9,77000.0000,NULL,'ACTIVE','WHITE',9,7,1,0,'2021-07-19 22:23:51',NULL,NULL,NULL,NULL),(16,4,46350.0000,NULL,'ACTIVE','BLUE',13,2,1,0,'2021-07-19 22:30:19',NULL,NULL,NULL,NULL),(17,9,83000.0000,NULL,'ACTIVE','GREY',9,7,1,0,'2021-07-19 22:30:19',NULL,NULL,NULL,NULL),(19,4,46350.0000,NULL,'ACTIVE','BLUE',13,2,1,0,'2021-07-19 22:30:48',NULL,NULL,NULL,NULL),(20,9,83000.0000,NULL,'ACTIVE','GREY',9,7,1,0,'2021-07-19 22:30:48',NULL,NULL,NULL,NULL),(21,9,77000.0000,NULL,'ACTIVE',NULL,9,7,1,0,'2021-07-19 22:30:48',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_archive`
--

--DROP TABLE IF EXISTS `vehicle_archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

CREATE TABLE `vehicle_archive` (
  `vehicle_id` bigint NOT NULL AUTO_INCREMENT,
  `vehicle_manufacturer` bigint NOT NULL,
  `vehicle_curr_price` decimal(15,4) NOT NULL,
  `vehicle_model_year` date NOT NULL,
  `vehicle_status` varchar(45) NOT NULL DEFAULT 'INACTIVE',
  `vehicle_color` varchar(35) DEFAULT NULL,
  `vehicle_model_id` bigint NOT NULL,
  `vehicle_trim` bigint NOT NULL,
  `vehicle_style` bigint DEFAULT NULL,
  `featured` tinyint DEFAULT '0',
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  `options` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`),
  KEY `veh_manufacturer_id_idx` (`vehicle_manufacturer`),
  KEY `veh_model_id_idx` (`vehicle_model_id`),
  KEY `veh_style_idx` (`vehicle_style`),
  CONSTRAINT `veh_arch_manufacturer_id` FOREIGN KEY (`vehicle_manufacturer`) REFERENCES `vehicle_manufacturer` (`manufacturer_id`),
  CONSTRAINT `veh_arch_model_id` FOREIGN KEY (`vehicle_model_id`) REFERENCES `vehicle_model` (`vehicle_model_id`),
  CONSTRAINT `veh_arch_style` FOREIGN KEY (`vehicle_style`) REFERENCES `vehicle_style` (`vehicle_style_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_archive`
--

LOCK TABLES `vehicle_archive` WRITE;
/*!40000 ALTER TABLE `vehicle_archive` DISABLE KEYS */;
INSERT INTO `vehicle_archive` VALUES (1,1,35000.0000,2010,'ARCHIVED','RED',1,1,1,1,'2021-07-05 17:22:11',NULL),(2,1,49000.0000,2017,'ARCHIVED','GREY',1,1,1,1,'2021-07-05 17:22:11',NULL),(3,1,36000.0000,2018,'ARCHIVED','BLUE',1,1,1,1,'2021-07-05 17:22:11',NULL),(4,4,50000.0000,2018,'ARCHIVED','BLUE',13,2,1,1,'2021-07-05 17:22:11',NULL),(5,4,55020.0000,2017,'ARCHIVED','WHITE',13,2,1,1,'2021-07-05 17:22:11',NULL),(6,4,45000.0000,2013,'ARCHIVED','WHITE',13,2,1,1,'2021-07-05 17:22:11',NULL),(7,2,18550.0000,2020,'ARCHIVED','BLUE',7,5,1,1,'2021-07-05 17:22:11',NULL),(8,2,24000.0000,2019,'ARCHIVED','RED',7,5,1,1,'2021-07-05 17:22:11',NULL),(9,2,30000.0000,2021,'ARCHIVED','BLUE',6,4,1,1,'2021-07-05 17:22:11',NULL),(10,4,46350.0000,2021,'ARCHIVED','BLUE',13,2,1,1,'2021-07-05 17:22:11',NULL),(11,9,83000.0000,2021,'ARCHIVED','GREY',20,9,1,1,'2021-07-05 17:23:14',NULL),(12,9,77000.0000,2016,'ARCHIVED','WHITE',20,9,1,1,'2021-07-05 17:23:14',NULL);
/*!40000 ALTER TABLE `vehicle_archive` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Table structure for table `vehicle_price_change`
--

--DROP TABLE IF EXISTS `vehicle_price_change`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_price_change` (
  `price_change_id` bigint NOT NULL AUTO_INCREMENT,
  `vehicle_id` bigint NOT NULL,
  `current_price` decimal(10,4) NOT NULL,
  `revised_price` decimal(10,4) NOT NULL,
  `last_changed` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`price_change_id`),
  KEY `vehicle_id_changed_idx` (`vehicle_id`),
  CONSTRAINT `vehicle_id_changed` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_price_change`
--

LOCK TABLES `vehicle_price_change` WRITE;
/*!40000 ALTER TABLE `vehicle_price_change` DISABLE KEYS */;
INSERT INTO `vehicle_price_change` VALUES (1,3,37565.0000,36000.0000,'2021-07-03 15:43:42',NULL),(2,3,36000.0000,35500.0000,'2021-07-03 15:43:42',NULL),(3,3,35500.0000,34550.0000,'2021-07-03 15:43:42',NULL),(4,3,34550.0000,34000.0000,'2021-07-03 15:43:42',NULL),(5,2,45000.0000,46400.0000,'2021-07-03 15:43:42',NULL),(6,2,46400.0000,48000.0000,'2021-07-03 15:43:42',NULL),(7,2,48000.0000,47380.0000,'2021-07-03 15:43:42',NULL),(8,9,29500.0000,30000.0000,'2021-07-04 13:22:36',NULL),(9,2,47380.0000,49000.0000,'2021-07-04 13:25:17',NULL),(10,4,55342.0000,50000.0000,'2021-07-04 17:16:04',NULL);
/*!40000 ALTER TABLE `vehicle_price_change` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Final view structure for view `complete_car_listing`
--

CREATE VIEW `complete_car_listing` AS select `v`.`vehicle_id` AS `vehicle_id`,`v_man`.`manufacturer_name` AS `brand`,`v_mod`.`vehicle_model_name` AS `model`,`v_trim`.`trim_name` AS `trim`,`v`.`vehicle_curr_price` AS `price`,`v`.`vehicle_color` AS `color`,`v_style`.`vehicle_style_name` AS `style`,`v`.`vehicle_model_year` AS `year`,`v`.`featured` AS `featured` from ((((`vehicle` `v` join `vehicle_manufacturer` `v_man` on((`v`.`vehicle_manufacturer` = `v_man`.`manufacturer_id`))) join `vehicle_model` `v_mod` on((`v_mod`.`vehicle_model_id` = `v`.`vehicle_model_id`))) join `vehicle_trim` `v_trim` on((`v_trim`.`trim_id` = `v`.`vehicle_trim`))) join `vehicle_style` `v_style` on((`v_style`.`vehicle_style_id` = `v`.`vehicle_style`))) ;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-22 17:06:40
