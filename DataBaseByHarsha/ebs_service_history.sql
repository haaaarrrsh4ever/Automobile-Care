-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: ebs
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `service_history`
--

DROP TABLE IF EXISTS `service_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_history` (
  `chassis_no` varchar(15) DEFAULT NULL,
  `activity_performed` varchar(500) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `billing_amount` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_history`
--

LOCK TABLES `service_history` WRITE;
/*!40000 ALTER TABLE `service_history` DISABLE KEYS */;
INSERT INTO `service_history` VALUES ('84259','oiling','2024-02-09','499'),('84259','Brake replacement','2024-02-10','299'),('84259','maintainance','2024-02-10','999'),('84259','wheel','2024-02-10','1999'),('84259','suspension','2024-02-09','1999'),('84259','oil','2024-02-09','499'),('84259','sticker','2024-02-09','499'),('84259','puc','2024-02-09','499'),('12345','c','2024-03-01','249'),('789789','jservice','2025-04-01','5000'),('789789','jservice','2025-04-01','5000'),('123333','fullservice','2025-04-22','6000'),('444555','fullservice','2025-04-22','6000'),('888888','jservice','2025-04-20','2500'),('888888','jservice','2025-04-20','2500'),('405060','fullmodify','2025-04-22','4000'),('121212','service','2025-04-23','3333'),('708090','fullservice','2025-04-22','2222'),('708090','fullservice','2025-04-22','2222'),('jd','fullservice','2025-04-22','4500'),('jd','fullservice','2025-04-22','4500'),('555666','fullservice','2025-04-22','5000'),('1234','oil ','2025-11-17','249');
/*!40000 ALTER TABLE `service_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-28 15:35:22
