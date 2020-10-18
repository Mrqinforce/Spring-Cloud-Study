-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: 101.201.142.75    Database: user_center2
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bonus_event_log`
--

DROP TABLE IF EXISTS `bonus_event_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bonus_event_log` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `user_id` int DEFAULT NULL COMMENT 'user.id',
  `value` int DEFAULT NULL COMMENT '积分操作值',
  `event` varchar(20) DEFAULT NULL COMMENT '发生的事件',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  KEY `fk_bonus_event_log_user1_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='积分变更记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bonus_event_log`
--

LOCK TABLES `bonus_event_log` WRITE;
/*!40000 ALTER TABLE `bonus_event_log` DISABLE KEYS */;
INSERT INTO `bonus_event_log` VALUES (1,1,1,'CONTRIBUTE','2020-10-08 04:46:42','投稿加积分'),(2,1,50,'CONTRIBUTE','2020-10-08 05:06:54','投稿加积分'),(3,2,50,'CONTRIBUTE','2020-10-08 05:32:06','投稿加积分'),(4,1,50,'CONTRIBUTE','2020-10-08 05:32:10','投稿加积分'),(5,1,50,'CONTRIBUTE','2020-10-08 05:34:10','投稿加积分'),(6,1,50,'CONTRIBUTE','2020-10-08 05:39:09','投稿加积分'),(7,2,50,'CONTRIBUTE','2020-10-08 05:46:33','投稿加积分'),(8,1,50,'CONTRIBUTE','2020-10-08 06:06:17','投稿加积分'),(9,1,50,'CONTRIBUTE','2020-10-08 06:08:10','投稿加积分'),(10,1,50,'CONTRIBUTE','2020-10-08 06:12:28','投稿加积分'),(11,1,50,'CONTRIBUTE','2020-10-08 06:14:58','投稿加积分'),(12,1,50,'CONTRIBUTE','2020-10-08 06:18:06','投稿加积分'),(13,1,50,'CONTRIBUTE','2020-10-08 06:20:28','投稿加积分'),(14,1,200,'CONTRIBUTE','2020-10-15 18:38:51','投稿加积分'),(15,1,200,'CONTRIBUTE','2020-10-15 18:39:46','投稿加积分'),(16,1,200,'CONTRIBUTE','2020-10-15 18:57:22','投稿加积分'),(17,1,-40,'BUY','2020-10-15 20:06:17','兑换分享'),(18,1,-60,'BUY','2020-10-15 20:07:59','兑换分享'),(19,1,-50,'BUY','2020-10-15 20:20:59','兑换分享'),(20,1,-20,'BUY','2020-10-15 22:03:52','兑换分享'),(21,1,20,'SIGN_IN','2020-10-17 22:02:40','签到加积分'),(104,1,20,'SIGN_IN','2020-10-18 14:08:36','签到加积分');
/*!40000 ALTER TABLE `bonus_event_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `wx_id` varchar(64) NOT NULL DEFAULT '' COMMENT '微信id',
  `wx_nickname` varchar(64) NOT NULL DEFAULT '' COMMENT '微信昵称',
  `roles` varchar(100) NOT NULL DEFAULT '' COMMENT '角色',
  `avatar_url` varchar(255) NOT NULL DEFAULT '' COMMENT '头像地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `bonus` int NOT NULL DEFAULT '300' COMMENT '积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='分享';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ol4Ax5VGeXLjS651PZgJU2BpQ5d8','N','user','https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKzP4cria19hZcfialVpyNhE22KZWm3iccrRLLYgTGiclw4YYXZAr8834j8l2v4OT4PYP4HCLdAvLPBCw/132','2020-10-14 00:18:04','2020-10-14 00:18:04',160),(2,'','健','1','https://niit-soft.oss-cn-hangzhou.aliyuncs.com/cover/1.jpg','2020-09-16 23:13:35','2020-09-16 23:13:35',130),(5,'hh','hhhh','user','rdtfyjgukh','2020-10-14 00:04:27','2020-10-14 00:04:27',100),(7,'1','1','user','1','2020-10-14 18:24:34','2020-10-14 18:24:34',100),(8,'demoData','demoData','user','demoData','2020-10-14 22:24:49','2020-10-14 22:24:49',100);
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

-- Dump completed on 2020-10-18 15:53:36
