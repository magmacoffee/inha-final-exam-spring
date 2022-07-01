CREATE DATABASE  IF NOT EXISTS `wgcloud` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `wgcloud`;
-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: wgcloud
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `directory`
--

DROP TABLE IF EXISTS `directory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directory` (
  `dirId` int NOT NULL AUTO_INCREMENT,
  `groupId` int DEFAULT NULL,
  `empId` int NOT NULL,
  `rootDirId` int DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  `orgFileName` varchar(200) NOT NULL,
  `ext` varchar(200) DEFAULT NULL,
  `fileSize` double(20,3) NOT NULL DEFAULT '0.000',
  `filePath` text,
  `sharedEmpId` int DEFAULT NULL,
  `isFile` tinyint(1) NOT NULL DEFAULT '0',
  `downCount` int NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `createDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDateTime` datetime DEFAULT NULL,
  `shareDateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`dirId`),
  KEY `empId` (`empId`),
  KEY `rootDirId` (`rootDirId`),
  KEY `sharedEmpId` (`sharedEmpId`),
  KEY `directory_ibfk_1` (`groupId`),
  CONSTRAINT `directory_ibfk_1` FOREIGN KEY (`groupId`) REFERENCES `workgroup` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `directory_ibfk_2` FOREIGN KEY (`empId`) REFERENCES `emp` (`empId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `directory_ibfk_3` FOREIGN KEY (`rootDirId`) REFERENCES `directory` (`dirId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `directory_ibfk_4` FOREIGN KEY (`sharedEmpId`) REFERENCES `emp` (`empId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directory`
--

LOCK TABLES `directory` WRITE;
/*!40000 ALTER TABLE `directory` DISABLE KEYS */;
INSERT INTO `directory` VALUES (32,NULL,1,NULL,'30ab0b6b-87d7-4a14-8ece-18a945a071eb','이산수학 보고서 제출현황','pdf',51496.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/30ab0b6b-87d7-4a14-8ece-18a945a071eb',1,1,0,0,'2022-06-18 17:42:37',NULL,NULL),(33,NULL,1,NULL,'5a815389-2f9b-4a9e-bee7-6e19ab997dbd','asdfsaf','pdf',1519132.000,'Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/5a815389-2f9b-4a9e-bee7-6e19ab997dbd',3,1,0,0,'2022-06-18 17:44:00','2022-06-19 04:00:28','2022-06-19 04:00:28'),(34,NULL,1,NULL,'4307c767-4420-4abb-9e33-acbf014ba7ff','10_Broadcast_and_Service (5)','pdf',2373563.000,'Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/4307c767-4420-4abb-9e33-acbf014ba7ff',6,1,0,0,'2022-06-18 17:45:18','2022-06-19 23:11:54','2022-06-19 23:11:54'),(35,NULL,1,NULL,'8a320329-5615-480d-8233-da7f305cee3f','inha-final-exam-spring-main','zip',20137.000,'Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files8a320329-5615-480d-8233-da7f305cee3f',3,1,0,0,'2022-06-18 17:53:06','2022-06-19 04:00:44','2022-06-19 04:00:44'),(36,NULL,1,NULL,'3234039f-ef64-4253-a8dd-bd929b267814','C언어응용_중간고사안내 (1)','txt',1326.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/3234039f-ef64-4253-a8dd-bd929b267814',6,1,0,0,'2022-06-18 17:54:36','2022-06-19 23:12:10','2022-06-19 23:12:10'),(37,NULL,1,NULL,'xzcvxzcv','xzcvxzcv',NULL,0.000,'/xzcvxzcv',6,0,0,0,'2022-06-18 20:15:42','2022-06-19 23:12:01','2022-06-19 23:12:01'),(38,NULL,1,NULL,'3e5b570a-707e-4908-afa4-59c440230ab2','11_Network (3)','pdf',1893332.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/3e5b570a-707e-4908-afa4-59c440230ab2',NULL,1,0,0,'2022-06-19 04:01:05',NULL,NULL),(39,NULL,1,NULL,'동휘안녕','동휘안녕',NULL,0.000,'/동휘안녕',NULL,0,0,0,'2022-06-19 04:01:11',NULL,NULL),(40,NULL,1,39,'동휘동휘동동','동휘동휘동동',NULL,0.000,'/동휘안녕/동휘동휘동동',NULL,0,0,0,'2022-06-19 04:01:17',NULL,NULL),(41,NULL,1,40,'f1eca13a-4b7c-43bd-a4af-2806442f5589','ㅁㄴㅇㄹㅁㄴㅇㄹㅁㄴㅇㄹ','pdf',51496.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/f1eca13a-4b7c-43bd-a4af-2806442f5589',NULL,1,0,0,'2022-06-19 04:01:24',NULL,NULL),(42,NULL,1,37,'d7d33a2f-6698-4a51-8eef-2e7662a39ce5','board (2) (1)','zip',25450194.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/d7d33a2f-6698-4a51-8eef-2e7662a39ce5',NULL,1,0,0,'2022-06-19 13:54:51',NULL,NULL),(43,NULL,1,37,'a26e9adb-0347-4c20-b453-61d4ca30d5d0','C언어응용_중간고사안내+(1) (3)','',1326.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/a26e9adb-0347-4c20-b453-61d4ca30d5d0',NULL,1,0,0,'2022-06-19 13:55:00',NULL,NULL),(44,6,3,NULL,'ㄴㅁㅇㄹㄴㅁㅇㄹ','ㄴㅁㅇㄹㄴㅁㅇㄹ',NULL,0.000,'/ㄴㅁㅇㄹㄴㅁㅇㄹ',NULL,0,0,0,'2022-06-19 17:51:51',NULL,NULL),(45,6,3,NULL,'sadfasdf','asdfsdf',NULL,0.000,'/sadfasdf',NULL,0,0,0,'2022-06-19 17:53:18','2022-06-19 18:14:53',NULL),(47,NULL,3,NULL,'0e163ead-312a-4e5a-8d9b-1ea715d3b989','C언어응용_중간고사안내+(1) (3)','',1326.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/0e163ead-312a-4e5a-8d9b-1ea715d3b989',NULL,1,0,0,'2022-06-19 18:06:20',NULL,NULL),(48,6,3,NULL,'02726371-0afe-4c04-b46b-745d256b6450','C언어응용_중간고사안내+(1) (3)','',1326.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/02726371-0afe-4c04-b46b-745d256b6450',NULL,1,0,1,'2022-06-19 18:07:09','2022-06-19 18:14:48',NULL),(49,6,3,45,'asdf','asdf',NULL,0.000,'/sadfasdf/asdf',NULL,0,0,0,'2022-06-19 18:14:37',NULL,NULL),(52,NULL,3,NULL,'daa68e24-3309-4057-913e-325e20949a19','이산수학+보고서+제출현황','',51496.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/daa68e24-3309-4057-913e-325e20949a19',NULL,1,0,0,'2022-06-19 18:50:31',NULL,NULL),(53,8,1,NULL,'0bb68bdf-f6bf-472c-90cd-92035333f20d','이산수학+보고서+제출현황','',51496.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/0bb68bdf-f6bf-472c-90cd-92035333f20d',NULL,1,0,0,'2022-06-19 22:18:49',NULL,NULL),(54,NULL,6,NULL,'데이터베이스','데이터베이스',NULL,0.000,'/데이터베이스',NULL,0,0,0,'2022-06-19 22:42:45',NULL,NULL),(55,NULL,6,NULL,'3ab9ab3b-ebf3-42ed-bc04-cfaf7818026e','히히','pptx',184193.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/3ab9ab3b-ebf3-42ed-bc04-cfaf7818026e',NULL,1,0,0,'2022-06-19 22:42:52','2022-06-19 23:07:46',NULL),(56,NULL,6,54,'6240e01c-d4b0-4989-904c-a05743b359aa','test.txt','',51496.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/6240e01c-d4b0-4989-904c-a05743b359aa',NULL,1,0,1,'2022-06-19 22:44:41','2022-06-19 22:44:54',NULL),(57,NULL,6,54,'b7d8366c-5f69-4b31-948d-0d3a00d288be','샘플 (1)','pdf',1957772.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/b7d8366c-5f69-4b31-948d-0d3a00d288be',NULL,1,0,0,'2022-06-19 22:45:03',NULL,NULL),(58,NULL,6,54,'e053e106-2f9c-4526-882b-54445d4da8f6','공유샘플','java',2021.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/e053e106-2f9c-4526-882b-54445d4da8f6',3,1,0,0,'2022-06-19 22:45:31','2022-06-19 22:45:42','2022-06-19 22:45:42'),(59,NULL,6,54,'공유 폴더 샘플','공유 폴더 샘플',NULL,0.000,'/데이터베이스/공유 폴더 샘플',3,0,0,0,'2022-06-19 22:45:50','2022-06-19 22:45:57','2022-06-19 22:45:57'),(60,NULL,6,54,'그냥 폴더','그냥 폴더',NULL,0.000,'/데이터베이스/그냥 폴더',NULL,0,0,0,'2022-06-19 22:46:04',NULL,NULL),(61,NULL,6,54,'그냥 폴더 2','그냥 폴더 2',NULL,0.000,'/데이터베이스/그냥 폴더 2',NULL,0,0,0,'2022-06-19 22:46:09',NULL,NULL),(62,9,6,NULL,'36787987-c192-4b1d-b9d1-5ac60837651e','동북아9-1_일본의 안보외교 (1)','pptx',57030859.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/36787987-c192-4b1d-b9d1-5ac60837651e',NULL,1,0,0,'2022-06-19 22:55:54',NULL,NULL),(63,9,6,NULL,'d63fbd05-bc0b-443a-af2a-fa90755ce96b','6장 보고서 2','pdf',591010.000,'/Users/nwbs/Desktop/Private/Univ/inha_final_exam_wgcloud/files/d63fbd05-bc0b-443a-af2a-fa90755ce96b',NULL,1,0,0,'2022-06-19 22:56:03',NULL,NULL),(64,9,6,NULL,'동북아 정세','동북아 정세',NULL,0.000,'/동북아 정세',NULL,0,0,0,'2022-06-19 22:56:15',NULL,NULL);
/*!40000 ALTER TABLE `directory` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tg_history_insert` AFTER INSERT ON `directory` FOR EACH ROW BEGIN
		INSERT INTO fileHistory VALUES (
			NULL,
            new.empId,
            new.dirId,
            new.orgFileName,
            concat('업로드(', new.orgFileName, ')'),
            NOW(),
            NULL
        );
	END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tg_history_update` AFTER UPDATE ON `directory` FOR EACH ROW BEGIN
		IF old.isDeleted <> new.isDeleted THEN
			INSERT INTO fileHistory VALUES (
				NULL,
				new.empId,
				new.dirId,
                new.orgFileName,
                concat('삭제 (', new.orgFileName, ')'),
				NOW(),
				NULL
			);
        ELSEIF old.name <> new.name THEN
			INSERT INTO fileHistory VALUES (
				NULL,
				new.empId,
				new.dirId,
				new.orgFileName, 
                concat('이름 변경 (', old.orgFileName, '->', new.orgFileName, ')'),
				NOW(),
				NULL
			);
        END IF;
	END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `empId` int NOT NULL AUTO_INCREMENT,
  `id` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nickname` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `gender` tinyint(1) NOT NULL DEFAULT '0',
  `createDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (1,'jjs','jjs','정정손','jjs@jjs.com','asdf',1,'2022-05-29 23:30:57',NULL),(2,'wjddmlths','wjddmlths','wjddmlths','wjddmlths','wjddmlths',1,'2022-06-04 09:49:03',NULL),(3,'asdf','asdf','김기환','kkh@naver.com','asdf',1,'2022-06-06 14:10:31',NULL),(4,'dkssud','dkssud','안녕하세요','dkssud','dkssud',1,'2022-06-06 14:11:37',NULL),(5,'dkssud1','dkssud2','dkssud2','ckssud','dkssud',1,'2022-06-19 22:38:42',NULL),(6,'kihwan','1234','12214035_남기환','magmacoffees@gmail.com','010-1234-5678',1,'2022-06-19 22:40:59',NULL);
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fileHistory`
--

DROP TABLE IF EXISTS `fileHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fileHistory` (
  `historyId` int NOT NULL AUTO_INCREMENT,
  `empId` int NOT NULL,
  `dirId` int NOT NULL,
  `summary` varchar(200) NOT NULL,
  `description` text NOT NULL,
  `createDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`historyId`),
  KEY `empId` (`empId`),
  KEY `dirId` (`dirId`),
  CONSTRAINT `filehistory_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `emp` (`empId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `filehistory_ibfk_2` FOREIGN KEY (`dirId`) REFERENCES `directory` (`dirId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fileHistory`
--

LOCK TABLES `fileHistory` WRITE;
/*!40000 ALTER TABLE `fileHistory` DISABLE KEYS */;
INSERT INTO `fileHistory` VALUES (1,3,52,'이산수학+보고서+제출현황','업로드(이산수학+보고서+제출현황)','2022-06-19 18:50:31',NULL),(2,1,53,'이산수학+보고서+제출현황','업로드(이산수학+보고서+제출현황)','2022-06-19 22:18:49',NULL),(3,6,54,'데이터베이스','업로드(데이터베이스)','2022-06-19 22:42:45',NULL),(4,6,55,'과제 제출 및 평가방법 (1)','업로드(과제 제출 및 평가방법 (1))','2022-06-19 22:42:52',NULL),(5,6,56,'이산수학+보고서+제출현황 (1)','업로드(이산수학+보고서+제출현황 (1))','2022-06-19 22:44:41',NULL),(6,6,57,'샘플 (1)','업로드(샘플 (1))','2022-06-19 22:45:03',NULL),(7,6,58,'EmpMvcController','업로드(EmpMvcController)','2022-06-19 22:45:31',NULL),(8,6,59,'공유 폴더 샘플','업로드(공유 폴더 샘플)','2022-06-19 22:45:50',NULL),(9,6,60,'그냥 폴더','업로드(그냥 폴더)','2022-06-19 22:46:04',NULL),(10,6,61,'그냥 폴더 2','업로드(그냥 폴더 2)','2022-06-19 22:46:09',NULL),(11,6,62,'동북아9-1_일본의 안보외교 (1)','업로드(동북아9-1_일본의 안보외교 (1))','2022-06-19 22:55:54',NULL),(12,6,63,'6장 보고서 2','업로드(6장 보고서 2)','2022-06-19 22:56:03',NULL),(13,6,64,'동북아 정세','업로드(동북아 정세)','2022-06-19 22:56:15',NULL);
/*!40000 ALTER TABLE `fileHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workgroup`
--

DROP TABLE IF EXISTS `workgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workgroup` (
  `groupId` int NOT NULL AUTO_INCREMENT,
  `empId` int NOT NULL,
  `name` varchar(200) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `isPrivate` tinyint(1) NOT NULL DEFAULT '0',
  `createDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`groupId`),
  KEY `empId` (`empId`),
  CONSTRAINT `workgroup_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `emp` (`empId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workgroup`
--

LOCK TABLES `workgroup` WRITE;
/*!40000 ALTER TABLE `workgroup` DISABLE KEYS */;
INSERT INTO `workgroup` VALUES (5,1,'asdf',0,0,'2022-06-19 17:02:44',NULL),(6,1,'asdf1',0,0,'2022-06-19 17:08:05',NULL),(7,1,'ㅌㅋㅊㅍㅋㅌㅊㅍ',0,0,'2022-06-19 17:11:26',NULL),(8,1,'123asdf',0,0,'2022-06-19 22:18:34',NULL),(9,6,'동북아와 한일관계',0,0,'2022-06-19 22:55:12',NULL),(10,6,'C++',0,0,'2022-06-19 22:55:28',NULL);
/*!40000 ALTER TABLE `workgroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workgroupMember`
--

DROP TABLE IF EXISTS `workgroupMember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workgroupMember` (
  `groupId` int NOT NULL,
  `empId` int NOT NULL,
  `createDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`groupId`,`empId`),
  KEY `empId` (`empId`),
  CONSTRAINT `workgroupmember_ibfk_1` FOREIGN KEY (`groupId`) REFERENCES `workgroup` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `workgroupmember_ibfk_2` FOREIGN KEY (`empId`) REFERENCES `emp` (`empId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workgroupMember`
--

LOCK TABLES `workgroupMember` WRITE;
/*!40000 ALTER TABLE `workgroupMember` DISABLE KEYS */;
INSERT INTO `workgroupMember` VALUES (6,3,'2022-06-19 17:08:05',NULL),(7,3,'2022-06-19 17:11:26',NULL),(8,1,'2022-06-19 22:18:34',NULL),(8,3,'2022-06-19 22:18:34',NULL),(9,3,'2022-06-19 22:55:12',NULL),(9,6,'2022-06-19 22:55:12',NULL),(10,3,'2022-06-19 22:55:28',NULL),(10,6,'2022-06-19 22:55:28',NULL);
/*!40000 ALTER TABLE `workgroupMember` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-19 23:23:15
