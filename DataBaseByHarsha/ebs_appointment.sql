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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `name` varchar(40) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `chassis_no` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES ('Dhiraj','2024-03-07','12 pm','Two Wheeler','84259'),('Dhiraj','2024-03-08','12 pm','Two Wheeler','84259'),('Dhiraj','2024-04-01','1 pm','Two Wheeler','84259'),('Dhiraj','2024-03-17','12 pm','Two Wheeler','54321'),('Aamir','2024-10-13','10 Am','Two Wheeler','98745'),('amir','2025-04-21','12 pm','Two Wheeler','123456'),('ram','2025-04-21','1pm','Two Wheeler','225588'),('ram','2025-04-21','1pm','Two Wheeler','225588'),('ram','2025-04-22','1pm','Two Wheeler','225588'),('zoha','2025-04-30','2pm','Two Wheeler','123456'),('zoha','2025-04-30','2pm','Two Wheeler','123456'),('amar','2025-04-30','2pm','Two Wheeler','445566'),('zohan','2025-04-22','4pm','Two Wheeler','789456'),('dk','2025-04-22','2pm','Two Wheeler','405060'),('alfiya','2025-04-20','12pm','Two Wheeler','102030'),('sana','2025-04-26','3pm','Two Wheeler','12345'),('nadeem','2025-04-24','2pm','Two Wheeler','708090'),('jd','2025-04-23','12pm','Two Wheeler','555666'),('dhiraj','2025-11-23','12 pm','Two Wheeler','1234');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
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
