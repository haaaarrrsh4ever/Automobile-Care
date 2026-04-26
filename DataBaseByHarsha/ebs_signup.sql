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
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signup` (
  `atype` varchar(20) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `vehicle_type` varchar(20) DEFAULT NULL,
  `chassis_no` varchar(20) DEFAULT NULL,
  `vehicle_no` varchar(15) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup`
--

LOCK TABLES `signup` WRITE;
/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` VALUES ('Customer','Dhiraj','Two Wheeler','84259','MH 04 KT 2735','41829'),('Admin','Aryan',NULL,NULL,NULL,'12345'),('Customer','Niraj','Two Wheeler','72340','MH 04 KT 7076','01236'),('Customer','Example','Two Wheeler','12345','MH 04 AJ 0001','6789'),('Customer','Aman Gupta','Two Wheeler','93212','MH 04 KT 2121','01841'),('Customer','sooraj','Two Wheeler','82599','MH 04 KT 2735','44555'),('Customer','Dhiraj','Two Wheeler','54321','MH 04 TK 1111','12345'),('Customer','Amiir','Two Wheeler','123654','MH 04 KT 1234','amir1234'),('Customer','amir','Two Wheeler','123456','MH 04 KT 1234','1234'),('Customer','ram','Two Wheeler','123654','MH04 AS 3323','786786'),('Customer','zoha','Two Wheeler','151515','MH03 AS 4411','123123'),('Customer','amar','Two Wheeler','445566','mho4 as 1122','123456'),('admin','Amir','','','','654321'),('admin','Amir2','','','','54321'),('Customer','zohan','Two Wheeler','789456','mho2 bs 2233','111222'),('Customer','saim','Two Wheeler','111111','mho4 as 4000','777888'),('Customer','dk','Two Wheeler','405060','mho4 as 8000','999999'),('Customer','alfiya','Two Wheeler','102030','mho2 2222','000000'),('Customer','sana','Two Wheeler','12345','mho2 as 121212','555555'),('Customer','nadeem','Two Wheeler','708090','mho4 as 2030','444555'),('Customer','kd','Two Wheeler','555666','mho4 as 3434','123456'),('Customer','dhiraj','Two Wheeler','12345','4561','123456');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-28 15:35:23
