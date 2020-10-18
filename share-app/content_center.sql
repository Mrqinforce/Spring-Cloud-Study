-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: 101.201.142.75    Database: content_center
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
-- Table structure for table `mid_user_share`
--

DROP TABLE IF EXISTS `mid_user_share`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mid_user_share` (
  `id` int NOT NULL AUTO_INCREMENT,
  `share_id` int NOT NULL COMMENT 'share.id',
  `user_id` int NOT NULL COMMENT 'user.id',
  PRIMARY KEY (`id`),
  KEY `fk_mid_user_share_share1_idx` (`share_id`),
  KEY `fk_mid_user_share_user1_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户-分享中间表【描述用户购买的分享】';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mid_user_share`
--

LOCK TABLES `mid_user_share` WRITE;
/*!40000 ALTER TABLE `mid_user_share` DISABLE KEYS */;
INSERT INTO `mid_user_share` VALUES (1,1,1),(2,2,2),(3,3,1),(11,2,1),(12,5,1),(13,6,1),(14,11,1);
/*!40000 ALTER TABLE `mid_user_share` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notice` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(255) NOT NULL DEFAULT '' COMMENT '内容',
  `show_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否显示 0:否 1:是',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,'Spring Boot',1,'2020-09-16 23:13:35'),(2,'Vue',1,'2020-09-16 23:13:35');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `share`
--

DROP TABLE IF EXISTS `share`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `share` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int NOT NULL DEFAULT '0' COMMENT '发布人id',
  `title` varchar(80) NOT NULL DEFAULT '' COMMENT '标题',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `is_original` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否原创 0:否 1:是',
  `author` varchar(45) NOT NULL DEFAULT '' COMMENT '作者',
  `cover` varchar(256) NOT NULL DEFAULT '' COMMENT '封面',
  `summary` varchar(256) NOT NULL DEFAULT '' COMMENT '概要信息',
  `price` int NOT NULL DEFAULT '0' COMMENT '价格（需要的积分）',
  `download_url` varchar(256) NOT NULL DEFAULT '' COMMENT '下载地址',
  `buy_count` int NOT NULL DEFAULT '0' COMMENT '下载数 ',
  `show_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否显示 0:否 1:是',
  `audit_status` varchar(10) NOT NULL DEFAULT '0' COMMENT '审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过',
  `reason` varchar(200) NOT NULL DEFAULT '' COMMENT '审核不通过原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='分享表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `share`
--

LOCK TABLES `share` WRITE;
/*!40000 ALTER TABLE `share` DISABLE KEYS */;
INSERT INTO `share` VALUES (1,1,'牛','2020-09-16 23:13:35','2020-09-16 23:13:35',0,'吴煦斌','https://img1.doubanio.com/view/subject/s/public/s33718337.jpg','《牛》1980年由素叶出版社首次出版，收入短篇小说9篇...',30,'https://cover.kancloud.cn/agdholo/tp6-p01!middle',22,1,'PASSED','符合要求'),(2,2,'岸萤','2020-09-16 23:13:35','2020-09-16 23:13:35',1,' 陈传兴','https://img3.doubanio.com/view/subject/s/public/s33729120.jpg','陈传兴亲历了巴黎最后的黄金时代，在时代的尾声中收集并纪录下哲学、艺术、影像的种种刻痕...',40,'https://cover.kancloud.cn/agdholo/tp6-p01!middle',34,1,'PASSED','符合要求'),(3,1,'白色游泳衣','2020-09-16 23:13:35','2020-09-16 23:13:35',0,'徐皓峰','https://img3.doubanio.com/view/subject/s/public/s33727331.jpg','《白色游泳衣》：从电影《老炮儿》，回想起当年穿白色游泳衣的姑娘阮辛基...',50,'https://cover.kancloud.cn/agdholo/tp6-p01!middle',12,1,'PASS',''),(5,2,'凡人之心','2020-10-01 17:19:56','2020-10-01 17:19:58',0,'[英] 威廉·博伊德','https://img9.doubanio.com/view/subject/s/public/s33723465.jpg','“我必须尽快开始真正的生活了，在我死于无聊和沮丧之前。”',60,'链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn',20,1,'NOT_YET',''),(6,1,'Python学习笔记','2020-10-01 17:19:56','2020-10-01 17:19:58',0,'许莫淇','https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Python.jpg','Python学习笔记',50,'链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn',30,1,'PASSED','符合要求符合要求'),(7,1,'Spring Cloud Alibaba实战','2020-10-01 17:19:56','2020-10-01 17:19:58',0,'许莫淇','https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Python.jpg','Spring Cloud Alibaba实战',40,'链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn',20,1,'PASSED','符合要求'),(8,2,'rabbitMQ学习笔记','2020-10-01 17:19:56','2020-10-01 17:19:58',0,'许莫淇','https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Python.jpg','rabbitMQ学习笔记',70,'链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn',40,1,'PASSED','符合要求'),(9,1,'微信小程序实战','2020-10-01 17:19:56','2020-10-01 17:19:58',0,'许莫淇','https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Python.jpg','微信小程序学习笔记',60,'链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn',40,1,'PASSED','符合要求'),(10,1,'程序员的自我修养','2020-10-01 17:19:56','2020-10-01 17:19:58',0,'许莫淇','https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Python.jpg','程序员自我修养',40,'链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn',30,1,'PASSED','符合要求'),(11,1,'价值','2020-10-07 11:14:15','2020-10-07 11:14:15',0,'张磊','https://img3.doubanio.com/view/subject/s/public/s33716660.jpg','高瓴创始人兼首席执行官张磊首部力作,沉淀15年，张磊的投资思想首度...',20,'ddddd',40,1,'PASSED','符合要求'),(12,1,'刑法学讲义','2020-10-08 16:57:29','2020-10-08 16:57:29',0,' 罗翔','https://img3.doubanio.com/view/subject/s/public/s33699210.jpg','全网爆红的“法律男神”罗翔教授为每一位普通读者写的刑法普及讲义...',20,'ddddd',40,1,'PASSED','符合要求'),(14,2,'\"qq\"','2020-10-15 22:05:24','2020-10-15 22:05:24',0,'秦健','“ddd‘','QQ',20,'ddddd',40,1,'NOT_YET','dddd'),(15,1,'\"标题\"','2020-10-16 08:25:55','2020-10-16 08:25:55',0,'秦健','https://img3.doubanio.com/view/subject/s/public/s33718992.jpg','\"WW\"',50,'\"http:dddd\"',40,1,'NOT_YET','dddd'),(16,1,'\"标题1\"','2020-10-16 08:31:48','2020-10-16 08:31:48',0,'秦健','https://img3.doubanio.com/view/subject/s/public/s33718992.jpg','\"WW\"',50,'\"http:dddd\"',40,1,'NOT_YET','dddd'),(31,1,'asdsa','2020-10-18 10:54:08','2020-10-18 10:54:08',0,'adsas','https://img3.doubanio.com/view/subject/s/public/s33718992.jpg','asads',79,'asdsa',40,1,'NOT_YET','dddd');
/*!40000 ALTER TABLE `share` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-18 15:52:30
